package zest;

public class Main {
    public static void main(String[] args) {
        ExcelSheet converter = new ExcelSheet();
        
        // Test examples
        String[] columnTitles = {"A", "AB", "ZY"};
        for (String title : columnTitles) {
            int columnNumber = converter.titleToNumber(title);
            System.out.println("Column Title: " + title + " -> Column Number: " + columnNumber);
        }
    }
}
