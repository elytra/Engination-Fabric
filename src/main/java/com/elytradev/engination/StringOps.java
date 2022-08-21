package com.elytradev.engination;

import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.function.IntUnaryOperator;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.util.Language;

public class StringOps {
	private static final Language EMPTY_LANGUAGE = Language.getInstance();
	
	public static String localize(String s) {
		Language preferred = Language.getInstance();
		try {
			return preferred.get(s);
		} catch (Throwable t) {
			try {
				return EMPTY_LANGUAGE.get(s);
			} catch (Throwable t2) {
				return s;
			}
		}
	}
	
	
	@Environment(EnvType.CLIENT)
	public static List<String> wordWrapClient(String str, int wrapWidth) {
		IntUnaryOperator charWidthGetter = (int ch)->(int)MinecraftClient.getInstance().textRenderer.getWidth(""+(char)ch);
		
		String languageCode = MinecraftClient.getInstance().getLanguageManager().getLanguage().getCode();
		Locale currentLocale = Locale.forLanguageTag(languageCode);
		
		return wrapToWidth3TUSK(str, wrapWidth, charWidthGetter, (currentLocale==null) ? Locale.getDefault() : currentLocale);
	}
	
	/**
	 * Wraps str to wrapWidth, in *characters*. This method is only for use as a last resort on servers. Servers have no
	 * idea how wide a character is, and as far as I can tell are always set to en_US. It's almost always better to use
	 * {@link #wordWrapClient(String, int)}
	 */
	public static List<String> wordWrap(String str, int wrapWidth) {
		return wrapToWidth3TUSK(str, wrapWidth, (ch)->1, Locale.getDefault());
	}
	
	/* What follows comes to us by way of the generous modder 3TUSK.
	 * 
	 * The gist of it is, Minecraft's word wrapping doesn't honor the right line break locations for some languages,
	 * such as Chinese. 3TUSK's code uses Java's built-in locale knowledge to cut lines in much better places.
	 * 
	 * See https://github.com/3TUSK/PanI18n/blob/exp/18w50a/docs/line_break/method_1728-en_us.markdown
	 */
	
	
	/**
	 * Valid color format code used by Minecraft.
	 */
	private static final String COLOR_CODE = "123456789abcdef";
	/**
	 * Valid special format code used by Minecraft, excluding {@code §r} which resets format.
	 */
	private static final String FORMATTING_CODE = "klmno";

	/**
	 * Split given {@link String} ({@code str}) into a list of strings, each string has
	 * length that does not exceed the length given by {@code wrapWidth}, in terms of
	 * character width, which is defined by {@code charWidthGetter}. The splitting
	 * result will respects line breaking rules of the given {@link Locale}
	 * ({@code currentLocale}).
	 *
	 * @implNote
	 * {@link BreakIterator} provides the per-locale line breaking rules support.
	 *
	 * @param str String
	 * @param wrapWidth maximum length of one line, based on character width
	 * @param charWidthGetter an int (char) to int function that returns width of character
	 * @param currentLocale target locale
	 *
	 * @return A list of String, each occupies one line
	 */
	private static List<String> wrapToWidth3TUSK(final String str, final int wrapWidth, final IntUnaryOperator charWidthGetter, final Locale currentLocale) {
		BreakIterator lineBreakEngine = BreakIterator.getLineInstance(currentLocale);
		lineBreakEngine.setText(str);
		ArrayList<String> lines = new ArrayList<>(8);
		String cachedFormat = "";
		char color = (char)-1, format = 'r'; // **changed from original PanI18n code**
		int start = 0; // Position of first character of each line, in terms of source string, i.e. 1st param of substring call
		int width = 0; // Width tracker
		boolean boldMode = false; // Bold font occupies extra width of one unit. Set up a tracker to track it
		for (int index = 0; index < str.length(); index++) {
			char c = str.charAt(index);

			if (c == '\n') { // Unconditionally cut string when there is new line
				lines.add(cachedFormat + str.substring(start, index));
				// Set start to appropriate position before next String::substring call
				start = index + 1;
				width = 0; // Clear width counter
				// And now, cache the current format for next line
				if (format != 'r') {
					cachedFormat = new String(new char[] {'\u00A7', color, '\u00A7', format});
				} else {
					cachedFormat = new String(new char[] {'\u00A7', color});
				}
				continue;
			} else if (c == '\u00A7') { // a.k.a. '§'. Used by Minecraft to denote special format, don't count it
				// TODO §r sometimes doesn't work correctly
				index++;
				char f = Character.toLowerCase(str.charAt(index));
				if (f == 'r' || f == 'R') {
					color = '0';
					format = 'r';
				} else if (FORMATTING_CODE.indexOf(f) != -1) {
					format = f;
					boldMode = f == 'l';
				} else if (COLOR_CODE.indexOf(f) != -1) {
					color = f;
					format = 'r'; // Reset format when new color code appears
					boldMode = false; // Reset special format anyway, so we turn bold mode off
				}/* else {
				    width += charWidthGetter.applyAsInt('\u00A7');
				    width += charWidthGetter.applyAsInt(str.charAt(index));
				}*/ // Vanilla seems to ignore invalid format code. We follow vanilla's logic.
				continue;
			} else {
				// Regular content, add its width to the tracker
				width += charWidthGetter.applyAsInt(c);
				if (boldMode) {
					width++; // If we are bold font, occupy one more unit
				}
			}

			if (width > wrapWidth) {
				int end = lineBreakEngine.preceding(index);
				if (lineBreakEngine.isBoundary(index)) {
					// Greedy approach: try to include as many characters as possible in one line,
					// while not violating the rules set by BreakIterator
					end = Math.max(end, index);
				}
				String result;
				if (end <= start) {
					// If the closest valid line break is before the starting point,
					// we just take the line as it is, in order to avoid infinite loop.
					result = cachedFormat + str.substring(start, index);
					start = index;
				} else {
					// If the closest valid line break is after the starting point,
					// we will insert line break there.
					result = cachedFormat + str.substring(start, end);
					start = end; // substring call excludes the char at position of `end', we need to track it
					index = start;
				}
				lines.add(result);
				index--; // Shift 1 left, so that we don't forget to count any character's width.
				width = 0; // Reset width tracker
				// And now, cache the current format for next line
				if (format != 'r') {
					cachedFormat = new String(new char[] {'\u00A7', color, '\u00A7', format});
				} else {
					cachedFormat = new String(new char[] {'\u00A7', color});
				}
			}
		}

		// Add the last piece, if exists
		String lastPiece = str.substring(start);
		if (!lastPiece.isEmpty()) {
			lines.add(cachedFormat + str.substring(start));
		}

		lines.trimToSize(); // Consider omit this call?
		return lines;
	}
}
