package zest;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class SortedArray2BST {

    int[] storage;

    public TreeNode sortedArrayToBST(int[] nums) {
        // Check preconditions
        checkPreconditions(nums);
        // Check invariants
        storage = checkInvariantsPre(nums);

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

        // The following code is outcommented because it caused a bug where the BST was not height-balanced if even number of elements.
        //if ((right - left + 1) % 2 == 0) {
        //    mid = Math.max(left, mid - 1);  // Ensure mid does not fall below left
        //}
        //

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

        // Check postconditions
        checkPostconditions(result);
        // Check invariants
        checkInvariantsPost(result, storage);

        return result;
    }

    private void checkPreconditions(int[] nums) {
        if (nums == null) {
            throw new IllegalArgumentException("Input array cannot be null");
        }
        if (nums.length == 0) {
            throw new IllegalArgumentException("Input array length cannot be 0");
        }
        // check for duplicates
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] == nums[j] && i != j) {
                    throw new IllegalArgumentException("Input array contains duplicate elements");
                }
            }
        }
        // check for sorted order
        if (nums.length > 1) {
            for (int i = 0; i < nums.length - 1; i++) {
                if (nums[i] > nums[i + 1]) {
                    throw new IllegalArgumentException("Input array is not sorted");
                }
            }
        }

    }

    private void checkPostconditions(List<Integer> result) {
        if (result == null) {
            throw new IllegalStateException("Result list cannot be null");
        }
        if (result.isEmpty()) {
            throw new IllegalStateException("Result list cannot be empty");
        }
        // check for duplicates
        for (int i = 0; i < result.size(); i++) {
            for (int j = 0; j < result.size(); j++) {
                if (i != j && result.get(i) == result.get(j) && result.get(i) != null) {
                    throw new IllegalStateException("Input array contains duplicate elements");
                }
            }
        }
        for (int i = 0; i < result.size(); i++) {
            // check that null values only appear on the bottom level of the tree
            if (result.get(i) == null && result.size() > 2*i+1) {
                throw new IllegalStateException("The BST is not level-balanced");
            }
            // check that the left child is smaller than the node itself
            else if (result.get(i) != null && result.size() > 2*i+1 && result.get(2*i+1) != null && result.get(2*i+1) > result.get(i)) {
                throw new IllegalStateException("The BST contains a node whose left child is bigger than the node itself");
            }
            // check that the right child is bigger than the node itself
            else if (result.get(i) != null && result.size() > 2*i+2 && result.get(2*i+2) != null && result.get(2*i+2) < result.get(i)) {
                throw new IllegalStateException("The BST contains a node whose right child is smaller than the node itself");
            }
        }
        // check that the length of the output array is 2^k-1 for some positive integer k (=> complete BST)
        float x = (float)result.size()+1;
        // we check if x is a power of 2
        while (x >= 2) {
            x = x / 2;
        }
        // now we should have exactly 1. If the float is lower than that, x was not a power of 2.
        if (x != (float)1) {
            throw new IllegalStateException("The BST is not complete");
        }

    }

    int[] checkInvariantsPre(int[] nums) {

        // copy nums array to storage
        int[] storage = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            storage[i] = nums[i];
        }
        return storage;

    }

    void checkInvariantsPost(List<Integer> output, int[] storage) {

        // check that the input array is equal to the storage array
        for (int i = 0; i < output.size(); i++) {
            if (output.get(i) != null) {
                boolean flag = false;
                for (int j = 0; j < storage.length; j++) {
                    if (output.get(i) == storage[j]) {
                        flag = true;
                    }
                }
                if (flag == false) {
                    throw new IllegalStateException("The BST does not contain the same integers as the input array");
                }
            }
        }
    }
}

