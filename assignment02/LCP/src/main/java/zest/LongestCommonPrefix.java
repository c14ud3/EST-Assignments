package zest;
import java.util.Arrays;



public class LongestCommonPrefix {

    public String lcp(String[] strs) {

        if (strs.length == 1) {
            return strs[0];
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
