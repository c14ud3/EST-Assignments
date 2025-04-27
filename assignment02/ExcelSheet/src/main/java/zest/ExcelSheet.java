package zest;

public class ExcelSheet {

    /**
     * Converts a column title from an Excel sheet to its corresponding column number.
     *
     * @param columnTitle A string representing the column title (e.g., "A", "AB", "ZY").
     * @return The corresponding column number.
     */
    public long titleToNumber(String columnTitle) {
        long result = 0;
        int length = columnTitle.length();
        if (length > 7 || length == 0) throw new IllegalArgumentException("Column titel must be atleast 1 and at most 7 characters long");
        if (!columnTitle.matches("[A-Z]+")) throw new IllegalArgumentException("Column title must contain only english uppercase letters");

        for (int i = 0; i < length; i++) {
            char currentChar = columnTitle.charAt(i);
            long value = currentChar - 'A' + 1;
            result = result * 26 + value;
            //if (result > Integer.MAX_VALUE) throw new IllegalArgumentException("Result exceeds maximum int supported");
        }
        return result;
    }
}
