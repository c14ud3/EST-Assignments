package zest;


import java.util.Arrays;

public class ArrayRotator {

    public static int[] rotate(int[] originalArray, int rotationCount) {
        if (originalArray == null) throw new IllegalArgumentException("Input array cannot be null");
        if (originalArray.length == 0) throw new IllegalArgumentException("Input array cannot be empty");
        if (rotationCount < 0) throw new IllegalArgumentException("Rotation count cannot be negative");

        // Create copies of the original array for sorting
        int[] originalArrayCopy = Arrays.copyOf(originalArray, originalArray.length);

        int arrayLength = originalArray.length;
        int[] rotatedArray = new int[arrayLength];

        // Normalize the rotation count
        rotationCount = rotationCount % arrayLength;

        // Rotate the array
        for (int i = 0; i < arrayLength; i++) {
            rotatedArray[(i + rotationCount) % arrayLength] = originalArray[i];
        }

        // Sort the copy of original and rotated arrays
        int[] rotatedArrayCopy = Arrays.copyOf(rotatedArray, rotatedArray.length);
        Arrays.sort(originalArrayCopy);
        Arrays.sort(rotatedArrayCopy);

        // check if the sorted arrays are equal
        if (!Arrays.equals(originalArrayCopy, rotatedArrayCopy)) {
            throw new IllegalStateException("The rotated array does not contain the same elements as the original array");
        }

        return rotatedArray;
    }
}
