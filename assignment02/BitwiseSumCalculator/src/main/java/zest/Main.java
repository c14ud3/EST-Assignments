package zest;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int a = 4, b = 5;
        System.out.println("Sum of " + a + " and " + b + " is: " + BitwiseSumCalculator.getSum(a, b));

        a = -1; b = 1;
        System.out.println("Sum of " + a + " and " + b + " is: " + BitwiseSumCalculator.getSum(a, b));
    }


}

