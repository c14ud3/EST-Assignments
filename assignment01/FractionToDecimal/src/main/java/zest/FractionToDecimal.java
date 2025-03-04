package zest;

public class FractionToDecimal {
    /**
     * Converts a fraction given by numerator and denominator into a decimal string.
     * If the decimal is repeating, encloses the repeating part in parentheses.
     * @param numerator the numerator of the fraction.
     * @param denominator the denominator of the fraction.
     * @return the string representation of the fraction as a decimal.
     */
    public static String fractionToDecimal(int numerator, int denominator) {
        if (denominator == 0) {
            return null;
        }
        StringBuilder result = new StringBuilder();
        // Handle negative numbers
        if (numerator < 0 ^ denominator < 0) {
            result.append("-");
        }
        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);

        // Append the integer part
        result.append(num / den);
        long remainder = num % den;
        if (remainder == 0) {
            return result.toString();
        }

        // Append the decimal part
        result.append(".");
        Map<Long, Integer> map = new HashMap<>();
        while (remainder != 0) {
            if (map.containsKey(remainder)) {
                result.insert(map.get(remainder), "(");
                result.append(")");
                break;
            }
            map.put(remainder, result.length());
            remainder *= 10;
            result.append(remainder / den);
            remainder %= den;
        }
        return result.toString();
    }
}

