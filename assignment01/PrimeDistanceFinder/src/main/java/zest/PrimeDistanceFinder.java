package zest;

public class PrimeDistanceFinder {
    /**
     * Finds the smallest difference between any two prime numbers in an array.
     * @param nums the array of integers to examine.
     * @return the smallest prime distance, or -1 if there are fewer than two primes.
     */
    public static int findSmallestPrimeDistance(int[] nums) {
        List<Integer> primes = new ArrayList<>();
        for (int num : nums) {
            if (isPrime(num)) {
                primes.add(num);
            }
        }

        if (primes.size() < 2) {
            return -1;
        }

        Collections.sort(primes);
        int smallestDiff = Integer.MAX_VALUE;
        for (int i = 0; i < primes.size() - 1; i++) {
            int diff = primes.get(i + 1) - primes.get(i);
            if (diff < smallestDiff) {
                smallestDiff = diff;
            }
        }
        return smallestDiff;
    }

    /**
     * Checks if a number is prime.
     * @param number the number to check.
     * @return true if the number is prime, false otherwise.
     */
    private static boolean isPrime(int number) {
        if (number <= 1) return false;
        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) return false;
        }
        return true;
    }
}

