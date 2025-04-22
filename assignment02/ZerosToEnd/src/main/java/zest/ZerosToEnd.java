package zest;

class ZeroesToEnd {

    public int[] pushZeroesToEnd(int arr[]) {
        if(arr.length == 0 || arr.length >= 10){
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
        return temp;
    }
}
