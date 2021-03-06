package com.ultreon.commons.util;

import com.ultreon.commons.exceptions.InvalidValueException;

import java.awt.*;
import java.util.ArrayList;
import java.util.regex.Pattern;

public final class ColorUtils {
    /**************************************************************************
     * Converts a color hex code (e.g. "#FFFFFF ) to a color instance.
     *
     * @param hex e.g. "#FFFFFF" or with alpha "#FFFFFF00"
     * @return a new Color instance based on the color hex code
     * @see Color
     * @see #unpackHex(String)
     * @deprecated use {@link #unpackHex(String)} instead.
     */
    @Deprecated
    public static Color hex2Rgb(String hex) {
        return unpackHex(hex);
    }

    /**************************************************************************
     * Converts a color hex code (e.g. "#FFFFFF ) to a color instance.
     *
     * @param hex e.g. "#FFFFFF" or with alpha "#FFFFFF00"
     * @return a new Color instance based on the color hex code
     * @see Color
     */
    public static Color unpackHex(String hex) {
        if (Pattern.matches("#[0-9a-fA-F]{6}", hex)) {
            int rgb = Integer.valueOf(hex.substring(1), 16);
            return new Color(rgb, false);
        } else if (Pattern.matches("#[0-9a-fA-F]{8}", hex)) {
            int rgb = Integer.valueOf(hex.substring(1), 16);
            return new Color(rgb, true);
        } else if (Pattern.matches("#[0-9a-fA-F]{3}", hex)) {
            int rgb = Integer.valueOf(new String(new char[]{
                    hex.charAt(1), hex.charAt(1),
                    hex.charAt(2), hex.charAt(2),
                    hex.charAt(3), hex.charAt(3)}), 16);
            return new Color(rgb, false);
        } else if (Pattern.matches("#[0-9a-fA-F]{4}", hex)) {
            int rgb = Integer.valueOf(new String(new char[]{
                    hex.charAt(1), hex.charAt(1),
                    hex.charAt(2), hex.charAt(2),
                    hex.charAt(3), hex.charAt(3),
                    hex.charAt(4), hex.charAt(4)}), 16);
            return new Color(rgb, true);
        } else {
            if (hex.length() >= 1) {
                if (hex.charAt(0) != '#') {
                    throw new InvalidValueException("First character of color code isn't '#'.");
                } else if (hex.length() != 3 && hex.length() != 4 && hex.length() != 6 && hex.length() != 8) {
                    throw new InvalidValueException("Invalid hex length, should be 3, 4, 6 or 8 in length.");
                } else {
                    throw new InvalidValueException("Invalid hex value. Hex values may only contain numbers and letters a to f.");
                }
            } else {
                throw new InvalidValueException("The color hex is empty, it should start with a hex, and then 3, 4, 6 or 8 hexadecimal digits.");
            }
        }
    }

    public static Color[] multiConvertHexToRgb(String... colorStrings) {
        ArrayList<Color> colors = new ArrayList<>();

        for (String colorStr : colorStrings) {
            colors.add(unpackHex(colorStr));
        }

        return colors.toArray(new Color[]{});
    }

    /**
     * Parse a color string into a color array.<br>
     * <b>Note: <i>this doesn't add the ???#??? prefixes, so use only hex digits for the colors.</i></b><br>
     * <br>
     * Same as <code>parseColorString(colorString, false)</code>.<br>
     *
     * @param colorString the color string, hex colors separated by a comma.
     * @return an array of colors parsed from the color string.
     */
    public static Color[] parseColorString(String colorString) {
        return parseColorString(colorString, false);
    }

    /**
     * Parse a color string into a color array.<br>
     *
     * @param colorString the color string, hex colors separated by a comma.
     * @param addPrefix   add the ???#??? for every item in the color string.
     * @return an array of colors parsed from the color string.
     */
    public static Color[] parseColorString(String colorString, boolean addPrefix) {
        String[] strings = colorString.split(",");
        if (addPrefix) {
            for (int i = 0; i < strings.length; i++) {
                strings[i] = "#" + strings[i];
            }
        }

        return multiConvertHexToRgb(strings);
    }
}
