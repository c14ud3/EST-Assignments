package zest;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    // Map to store Roman numerals and their corresponding integer values
    private static final Map<Character, Integer> romanMap = new HashMap<>();

    static {
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);
    }

    public int romanToInt(String s) {

        // Check preconditions
        checkPreconditions(s);

        // ADDED: check for empty string which represents number 0:
        if (s.isEmpty()) {return 0;}

        int result = romanMap.get(s.charAt(s.length() - 1));

        for (int i = s.length() - 2; i >= 0; i--) {
            if (romanMap.get(s.charAt(i)) < romanMap.get(s.charAt(i + 1))) {
                result -= romanMap.get(s.charAt(i));
            } else {
                result += romanMap.get(s.charAt(i));
            }
        }

        // Check postconditions
        checkPostconditions(result);

        return result;
    }

    private void checkPreconditions(String s) {
        // Check if input is null
        if (s == null) {
            throw new IllegalArgumentException("Input string cannot be null");
        }
        // Check if string contains only valid characters
        for (char c : s.toCharArray()) {
            if (!romanMap.containsKey(c)) {
                throw new IllegalArgumentException("Invalid Roman numeral: " + c);
            }
        }

        if (s.length() >= 2) {
            for (int i = 0; i < s.length() - 1; i++) {
                char current = s.charAt(i);
                char next = s.charAt(i + 1);

                // Check that V, L and D are not repeated
                if ((current == 'V' || current == 'L' || current == 'D') && next == current) {
                    throw new IllegalArgumentException("Invalid repetition of numeral: " + current + " can not be repeated.");
                }

                // Check if not sorted largest to smallest
                if (romanMap.get(current) < romanMap.get(next)) {
                    // If it is sorted the wrong way, and it is not one of the six subtraction cases, throw an error.
                    if (!((current == 'I' && (next == 'V' || next == 'X')) ||
                            (current == 'X' && (next == 'L' || next == 'C')) ||
                            (current == 'C' && (next == 'D' || next == 'M')))) {
                        throw new IllegalArgumentException("Invalid order of numerals: " + current + next);
                    }
                }
            }
        }
        // Check that numerail I, X, C and M are not repeated more than 3 times
        if (s.length() >= 4) {
            for (int i = 0; i < s.length() - 3; i++) {
                char current = s.charAt(i);
                char next = s.charAt(i + 1);
                char next2 = s.charAt(i + 2);
                char next3 = s.charAt(i + 3);

                // Check if I, X, C and M are repeated more than 3 times
                if ((current == 'I' || current == 'X' || current == 'C' || current == 'M') &&
                        (current == next && current == next2 && current == next3)) {
                    throw new IllegalArgumentException("Invalid repetition of numeral: " + current + " repeated more than 3 times.");
                }
            }
        }
    }

    private void checkPostconditions(int result) {
        // Check if the result is an integer within the range of 0 to 3999
        if (result < 0) {
            throw new IllegalStateException("Result is out of range and not between 0 and 3999: " + result);
        }
    }
}
