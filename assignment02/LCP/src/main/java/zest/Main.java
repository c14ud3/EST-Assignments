package zest;

public class Main {
    public static void main(String[] args) {
        LongestCommonPrefix lcpSolver = new LongestCommonPrefix();
        String[] strs = {"a", "a", "a"};
        String result = lcpSolver.lcp(strs);
        System.out.println("Longest Common Prefix: " + result);

    }
}
