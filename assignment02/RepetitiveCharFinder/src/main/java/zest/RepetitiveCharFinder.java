package zest;
import java.util.*;

public class RepetitiveCharFinder {

    /**
     * Finds and returns a list of non-unique characters from the given string.
     * Each character that appears more than once is included in the list, without duplicates,
     * and in the order of their first appearance.
     *
     * @param input the string to check for repeated characters
     * @return a list of repeated characters
     */
    public static List<Character> findNonUniqueCharacters(String input) {

        Map<Character, Integer> characterCounts = new LinkedHashMap<>(); // Preserves insertion order
        List<Character> nonUniqueCharacters = new ArrayList<>();

        for (char c : input.toCharArray()) {
            characterCounts.put(c, characterCounts.getOrDefault(c, 0) + 1);
        }

        for (Map.Entry<Character, Integer> entry : characterCounts.entrySet()) {
            if (entry.getValue() > 1) {
                nonUniqueCharacters.add(entry.getKey());
            }
        }

        return nonUniqueCharacters;
    }


}


