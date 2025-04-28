package zest;
import java.util.Arrays;



public class LongestCommonPrefix {

    public String lcp(String[] strs) {
        if (strs.length == 1) {
            if (strs[0] == null) throw new IllegalArgumentException("Please enter a non-empty string");
            return strs[0];
        }

        if (strs.length == 0) throw new IllegalArgumentException("Please enter atleast 1 string");
        for (int i = 0; i < strs.length; i++) {
            if (strs[i] == null) throw new IllegalArgumentException("Please enter a non-empty string");
        }

        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return ""; // If no prefix left, valid output as empty string
                }
            }
        }

        
        return prefix;
    }
}
