package zest;

public class NonPrimeSpiralMatrixCreator {

    private static boolean isPrime(int num) {
        if (num <= 1) return false; // Correctly recognize 1 as not prime
        if (num == 2) return true;  // 2 is the only even prime number
        if (num % 2 == 0) return false; // Exclude even numbers
        for (int i = 3; i * i <= num; i += 2) {
            if (num % i == 0) return false;
        }
        return true;
    }

    public static int[] createSpiralMatrix(int n) {
        if (n == 0) {
            return new int[0];
        }

        int[][] matrix = new int[n][n];
        int val = 4; // Start with the first non-prime number greater than 1
        int left = 0, right = n - 1, top = 0, bottom = n - 1;

        while (left <= right && top <= bottom) {
            for (int i = left; i <= right; i++) {
                while (isPrime(val)) val++;
                matrix[top][i] = val++;
            }
            top++;

            for (int i = top; i <= bottom; i++) {
                while (isPrime(val)) val++;
                matrix[i][right] = val++;
            }
            right--;

            if (bottom >= top) {
                for (int i = right; i >= left; i--) {
                    while (isPrime(val)) val++;
                    matrix[bottom][i] = val++;
                }
                bottom--;
            }

            if (right >= left) {
                for (int i = bottom; i >= top; i--) {
                    while (isPrime(val)) val++;
                    matrix[i][left] = val++;
                }
                left++;
            }
        }

        // Flatten the matrix into a single array
        int[] flatMatrix = new int[n * n];
        int k = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                flatMatrix[k++] = matrix[i][j];
            }
        }
        return flatMatrix;
    }

//    public static void main(String[] args) {
//        int n = 3;  // Change this value to see different sizes of matrix outputs
//        int[] output = createSpiralMatrix(n);
//        System.out.println("Output for n = " + n + ":");
//        for (int i = 0; i < output.length; i++) {
//            System.out.print(output[i] + (i % n == n - 1 ? "\n" : " "));
//        }
//    }

}
