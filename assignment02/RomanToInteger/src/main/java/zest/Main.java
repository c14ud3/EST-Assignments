package zest;

public class Main {
    public static void main(String[] args) {
        RomanToInteger converter = new RomanToInteger();
        String romanNumeral = "III";
        int result = converter.romanToInt(romanNumeral);
        System.out.println("The integer value of " + romanNumeral + " is " + result);
    }
}


