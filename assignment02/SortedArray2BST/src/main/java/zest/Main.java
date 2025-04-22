package zest;
import java.util.List;
public class Main {
    public static void main(String[] args) {
        SortedArray2BST converter = new SortedArray2BST();
        int[] nums = {-10, -3, 0, 5, 9};
        TreeNode bstRoot = converter.sortedArrayToBST(nums);
        List<Integer> levelOrderResult = converter.levelOrder(bstRoot);
        System.out.println(levelOrderResult);
    }
}

