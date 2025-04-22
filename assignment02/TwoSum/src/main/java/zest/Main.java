package zest;

public class Main {
    public static void main(String[] args) {
        TwoSum solver = new TwoSum();
        int[] nums = {2, 7, 11, 15};
        int target = 100;
        try {
            int[] indices = solver.findTwoSum(nums, target);
            System.out.println("Indices: [" + indices[0] + ", " + indices[1] + "]");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
