package edu.hw1;

public class Task5 {

    private Task5() {

    }

    public static boolean isPalindromeDescendant(int number) {

        if (number > 0) {

            if (isPalindrome(number)) {
                return true;
            }

            String numStr = String.valueOf(number);
            while (numStr.length() > 1) {
                numStr = createDescendant(numStr);
                if (numStr.length() == 1) {
                    return false;
                }
                if (isPalindrome(Integer.parseInt(numStr))) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean isPalindrome(int number) {

        String numStr = String.valueOf(number);
        int left = 0;
        int right = numStr.length() - 1;
        while (left < right) {
            if (numStr.charAt(left) != numStr.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static String createDescendant(String numStr) {
        StringBuilder descendant = new StringBuilder();
        for (int i = 0; i < numStr.length(); i += 2) {
            int digit1 = Character.getNumericValue(numStr.charAt(i));
            if (i + 1 < numStr.length()) {
                int digit2 = Character.getNumericValue(numStr.charAt(i + 1));
                descendant.append(digit1 + digit2);
            } else {
                descendant.append(digit1);
            }
        }
        return descendant.toString();
    }
}



