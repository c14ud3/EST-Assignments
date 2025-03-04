package zest;

public class PalindromeNumber {
    /**
     * Checks if an integer is a palindrome.
     * @param x the integer to check.
     * @return true if x is a palindrome, false otherwise.
     */
    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false; // Negative numbers cannot be palindromes
        }
        String str = Integer.toString(x);
        int left = 0;
        int right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}

