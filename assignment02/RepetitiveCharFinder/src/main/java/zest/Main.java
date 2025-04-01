package zest;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        // Example usage
        String testString = "Hello";
        List<Character> result = RepetitiveCharFinder.findNonUniqueCharacters(testString);
        System.out.println("Non-unique characters: " + result);
    }
}

