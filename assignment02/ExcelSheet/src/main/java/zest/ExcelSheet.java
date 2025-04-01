package zest;

public class ExcelSheet {

    /**
     * Converts a column title from an Excel sheet to its corresponding column number.
     *
     * @param columnTitle A string representing the column title (e.g., "A", "AB", "ZY").
     * @return The corresponding column number.
     */
    public int titleToNumber(String columnTitle) {
        int result = 0;
        int length = columnTitle.length();

        for (int i = 0; i < length; i++) {
            char currentChar = columnTitle.charAt(i);
            int value = currentChar - 'A' + 1; // Convert character to number (A=1, B=2, ..., Z=26)
            result = result * 26 + value; // Multiply current result by 26 (base) and add the current value
        }

        return result;
    }
}
