package zest;

class ZeroesToEnd {

    public int[] pushZeroesToEnd(int arr[]) {
        // check preconditions
        checkPreconditions(arr);
        // check invariants pre
        int[] input = checkInvariantsPre(arr);

        if(arr.length == 0 || arr.length > 10){
            return new int[0];
        }
        int temp[] = new int[arr.length];
        int t = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                temp[t] = arr[i];
                t += 1;
            }
        }
        while (t < arr.length){
            temp[t] = 0;
            t += 1;
        }
        // check postconditions
        checkPostconditions(temp);
        // check invariants post
        checkInvariantsPost(temp, input);

        return temp;
    }

    void checkPreconditions(int[] arr) {
        if (arr == null) {
            throw new IllegalArgumentException("Input array cannot be null");
        }
        if (arr.length > 10) {
            throw new IllegalArgumentException("Input array must have at most 10 elements");
        }
    }

    void checkPostconditions(int[] result) {
        if (result == null) {
            throw new IllegalStateException("Result array cannot be null");
        }
        if (result.length > 10) {
            throw new IllegalStateException("Result array must have at most 10 elements");
        }
    }

    int[] checkInvariantsPre(int[] arr) {
        int[] input = new int[arr.length];
        // copy the input array
        for (int i = 0; i < arr.length; i++) {
            input[i] = arr[i];
        }
        return input;
    }

    void checkInvariantsPost(int[] result, int[] input) {
        // check if the result array has the same length as the input array
        if (result.length != input.length) {
            throw new IllegalStateException("Result array length does not match input array length");
        }
        // check if the non-zero elements in the result array all exist and are in the same order as in the input array
        int pos = 0;
        int zeroCounterInput = 0;
        int zeroCounterResult = 0;

        // Count all zeroes in input array first
        for (int num : input) {
            if (num == 0) zeroCounterInput++;
        }
        // for every non-zero element in the result array...
        for (int i = 0; i < result.length; i++) {
            if (result[i] != 0) {
                // ...check if it exists in the input array
                boolean found = false;
                while (pos < input.length) {
                    if (result[i] == input[pos]) {
                        found = true;
                        pos++;
                        break;
                    }
                    pos++;
                }
                if (!found) {
                    throw new IllegalStateException("Non-zero element in result array does not exist in input array or is in wrong order");
                }
            }
            else {
                zeroCounterResult++;
            }
        }
        // check if the number of zeroes in the result array is equal to the number of zeroes in the input array
        if (zeroCounterInput != zeroCounterResult) {
            throw new IllegalStateException("Number of zeroes in result array does not match input array (" + zeroCounterInput + " != " + zeroCounterResult + ")");
        }

    }
}
