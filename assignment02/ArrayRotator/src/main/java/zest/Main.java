package zest;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] originalArray = {1, 2, 3, 4, 5};
        int rotationCount = 3;

        int[] rotatedArray = ArrayRotator.rotate(originalArray, rotationCount);


        System.out.print("Rotated Array: " + Arrays.toString(rotatedArray));
    }
}

