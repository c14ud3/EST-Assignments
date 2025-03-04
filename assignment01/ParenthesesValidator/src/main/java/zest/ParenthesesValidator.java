package zest;

public class ParenthesesValidator {
    /**
     * Validates a string of parentheses.
     * @param s the string containing parentheses.
     * @return true if the string is valid, false otherwise.
     */
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') stack.push(')');
            else if (c == '{') stack.push('}');
            else if (c == '[') stack.push(']');
            else {
                if (stack.isEmpty() || stack.pop() != c) return false;
            }
        }
        return stack.isEmpty();
    }
}

