package zest;
import zest.BinaryTreeMaxPath.TreeNode;


public class Main {
    public static void main(String[] args) {
        Integer[] treeArray1 = {1, 2, 3};
        TreeNode root = BinaryTreeMaxPath.TreeNode.constructTree(treeArray1);
        BinaryTreeMaxPath calculator = new BinaryTreeMaxPath();
        System.out.println("Maximum Path Sum for treeArray1: " + calculator.maxPathSum(root));  // Expected output should be 6 for the input [1, 2, 3]


        Integer[] TreeArray2 = {-10, 9, 20, null, null, 15, 7};
        root = BinaryTreeMaxPath.TreeNode.constructTree(TreeArray2);
        System.out.println("Maximum Path Sum for TreeArray2: " + calculator.maxPathSum(root));  // Expected output is 42 for the input [-10, 9, 20, null, null, 15, 7]
    }
}
