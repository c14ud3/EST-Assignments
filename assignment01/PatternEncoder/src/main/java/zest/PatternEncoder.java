package zest;

public class PatternEncoder {
    /**
     * Encodes the input string by compressing consecutive repeated substrings.
     * @param input the string to encode.
     * @return the encoded string.
     */
    public static String encodeString(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }

        StringBuilder encoded = new StringBuilder();
        int i = 0;
        while (i < input.length()) {
            int runLength = 1;

            // Find the length of the current run of identical characters
            while (i + runLength < input.length() && input.charAt(i) == input.charAt(i + runLength)) {
                runLength++;
            }

            // If the run is long enough to compress, encode it
            if (runLength > 1) {
                encoded.append(runLength).append('[').append(input.charAt(i)).append(']');
                i += runLength; // Move past this run of characters
            } else {
                // Otherwise, just add the current character
                encoded.append(input.charAt(i));
                i++;
            }
        }
        return encoded.toString();
    }
}
