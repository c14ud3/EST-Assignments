package zest;


import java.util.Arrays;

public class ArrayRotator {

    public static int[] rotate(int[] originalArray, int rotationCount) {

        int arrayLength = originalArray.length;
        int[] rotatedArray = new int[arrayLength];

        // Normalize the rotation count
        rotationCount = rotationCount % arrayLength;

        // Rotate the array
        for (int i = 0; i < arrayLength; i++) {
            rotatedArray[(i + rotationCount) % arrayLength] = originalArray[i];
        }

        return rotatedArray;
    }
}
