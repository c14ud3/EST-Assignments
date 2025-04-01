package zest;

public class Main {
    public static void main(String[] args) {
        ZeroesToEnd zeroMover = new ZeroesToEnd();
        
        // Example test cases
        int[] test1 = {1, 0, 2, 0, 3, 4};
        int[] test2 = {0, 0, 0, 0};
        int[] test3 = {1, 2, 3, 4, 5};
        int[] test4 = {};

        // Applying the method and printing the results
        printArray(zeroMover.pushZeroesToEnd(test1)); // Expected: [1, 2, 3, 4, 0, 0]
        printArray(zeroMover.pushZeroesToEnd(test2)); // Expected: [0, 0, 0, 0]
        printArray(zeroMover.pushZeroesToEnd(test3)); // Expected: [1, 2, 3, 4, 5]
        printArray(zeroMover.pushZeroesToEnd(test4)); // Expected: []
    }

    private static void printArray(int[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}

