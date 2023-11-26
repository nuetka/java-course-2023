package edu.hw3;

import java.util.TreeMap;

@SuppressWarnings("MagicNumber")
public class Task4 {

    private Task4() {

    }

    private static final TreeMap<Integer, String> ROMAN_NUMERALS = new TreeMap<>();

    static {
        ROMAN_NUMERALS.put(1, "I");
        ROMAN_NUMERALS.put(4, "IV");
        ROMAN_NUMERALS.put(5, "V");
        ROMAN_NUMERALS.put(9, "IX");
        ROMAN_NUMERALS.put(10, "X");
        ROMAN_NUMERALS.put(40, "XL");
        ROMAN_NUMERALS.put(50, "L");
        ROMAN_NUMERALS.put(90, "XC");
        ROMAN_NUMERALS.put(100, "C");
        ROMAN_NUMERALS.put(400, "CD");
        ROMAN_NUMERALS.put(500, "D");
        ROMAN_NUMERALS.put(900, "CM");
        ROMAN_NUMERALS.put(1000, "M");
    }

    public static String convertToRoman(int number) {
        int floorKey = ROMAN_NUMERALS.floorKey(number);
        if (number == floorKey) {
            return ROMAN_NUMERALS.get(number);
        }
        return ROMAN_NUMERALS.get(floorKey) + convertToRoman(number - floorKey);
    }
}
