package zest;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class SortedArray2BST {

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return constructBST(nums, 0, nums.length - 1);
    }

    private TreeNode constructBST(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = left + (right - left) / 2;
        if ((right - left + 1) % 2 == 0) {
            mid = Math.max(left, mid - 1);  // Ensure mid does not fall below left
        }
        TreeNode node = new TreeNode(nums[mid]);
        node.left = constructBST(nums, left, mid - 1);
        node.right = constructBST(nums, mid + 1, right);
        return node;
    }

    public List<Integer> levelOrder(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean allNulls;

        while (!queue.isEmpty()) {
            int size = queue.size();
            allNulls = true;  // To check if all elements in the current level are null

            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                if (current != null) {
                    result.add(current.val);
                    queue.offer(current.left);
                    queue.offer(current.right);
                    if (current.left != null || current.right != null) {
                        allNulls = false;
                    }
                } else {
                    result.add(null);
                    queue.offer(null);
                    queue.offer(null);
                }
            }
            // Clean up all trailing nulls if only nulls are in the queue
            if (allNulls) {
                break;
            }
        }

        // Remove trailing nulls from result list to match expected format
        while (result.size() > 0 && result.get(result.size() - 1) == null) {
            result.remove(result.size() - 1);
        }

        return result;
    }
}

