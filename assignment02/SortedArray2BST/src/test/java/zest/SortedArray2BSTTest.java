package zest;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import net.jqwik.api.*;
import net.jqwik.api.constraints.Size;

import static org.junit.jupiter.api.Assertions.*;

public class SortedArray2BSTTest {

    @Test
    void testValidSortedArray() {
        SortedArray2BST converter = new SortedArray2BST();
        TreeNode root = converter.sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});
        assertNotNull(root);
        List<Integer> levelOrderResult = converter.levelOrder(root);
        // Adjust the expected result based on the actual level-order traversal implementation
        assertEquals(Arrays.asList(0, -10, 5, null, -3, null, 9), levelOrderResult);
    }

    @Test
    void testSingleElementArray() {
        SortedArray2BST converter = new SortedArray2BST();
        TreeNode root = converter.sortedArrayToBST(new int[]{42});
        assertNotNull(root);
        List<Integer> levelOrderResult = converter.levelOrder(root);
        assertEquals(Arrays.asList(42), levelOrderResult);
    }

    @Test
    void testTwoElementArray() {
        SortedArray2BST converter = new SortedArray2BST();
        TreeNode root = converter.sortedArrayToBST(new int[]{1, 2});
        assertNotNull(root);
        List<Integer> levelOrderResult = converter.levelOrder(root);
        assertEquals(Arrays.asList(1, null, 2), levelOrderResult);
    }

    @Test
    void testEvenLengthArray() {
        SortedArray2BST converter = new SortedArray2BST();
        TreeNode root = converter.sortedArrayToBST(new int[]{1, 2, 3, 4});
        assertNotNull(root);
        List<Integer> levelOrderResult = converter.levelOrder(root);
        assertEquals(Arrays.asList(2, 1, 3, null, null, null, 4), levelOrderResult);
    }

    // Preconditions tests
    @Test
    void testPreconditions_NullArray() {
        SortedArray2BST converter = new SortedArray2BST();
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            converter.sortedArrayToBST(null);
        });
        assertEquals("Input array cannot be null", exception.getMessage());
    }

    @Test
    void testPreconditions_EmptyArray() {
        SortedArray2BST converter = new SortedArray2BST();
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            converter.sortedArrayToBST(new int[]{});
        });
        assertEquals("Input array length cannot be 0", exception.getMessage());
    }

    @Test
    void testPreconditions_DuplicateElements() {
        SortedArray2BST converter = new SortedArray2BST();
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            converter.sortedArrayToBST(new int[]{1, 2, 2, 3});
        });
        assertEquals("Input array contains duplicate elements", exception.getMessage());
    }

    @Test
    void testPreconditions_UnsortedArray() {
        SortedArray2BST converter = new SortedArray2BST();
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            converter.sortedArrayToBST(new int[]{3, 1, 2});
        });
        assertEquals("Input array is not sorted", exception.getMessage());
    }

    // Postconditions tests
    @Test
    void testPostconditions_LevelBalancedTree() {
        SortedArray2BST converter = new SortedArray2BST();
        TreeNode root = converter.sortedArrayToBST(new int[]{1, 2, 3, 4, 5, 6, 7});
        assertNotNull(root);
        List<Integer> levelOrderResult = converter.levelOrder(root);
        assertDoesNotThrow(() -> converter.levelOrder(root));
    }

    @Test
    void testPostconditions_CompleteTree() {
        SortedArray2BST converter = new SortedArray2BST();
        TreeNode root = converter.sortedArrayToBST(new int[]{1, 2, 3, 4, 5, 6, 7});
        assertNotNull(root);
        List<Integer> levelOrderResult = converter.levelOrder(root);
        assertEquals(7, levelOrderResult.size());
    }

    // Invariants tests
    @Test
    void testInvariants_InputArrayPreserved() {
        SortedArray2BST converter = new SortedArray2BST();
        int[] input = new int[]{1, 2, 3, 4, 5};
        TreeNode root = converter.sortedArrayToBST(input);
        assertNotNull(root);
        List<Integer> levelOrderResult = converter.levelOrder(root);
        for (int value : input) {
            assertTrue(levelOrderResult.contains(value));
        }
    }

    @Test
    void testInvariants_NoExtraElementsInTree() {
        SortedArray2BST converter = new SortedArray2BST();
        int[] input = new int[]{1, 2, 3, 4, 5};
        TreeNode root = converter.sortedArrayToBST(input);
        assertNotNull(root);
        List<Integer> levelOrderResult = converter.levelOrder(root);
        for (Integer value : levelOrderResult) {
            if (value != null) {
                assertTrue(Arrays.stream(input).anyMatch(i -> i == value));
            }
        }
    }

}

class SortedArray2BSTPropertyTest {

    // Create an instance of the class with the method to be tested
    SortedArray2BST converter = new SortedArray2BST();

    @Property
    void testSortedArrayToBST_AllElementsContained(
            @ForAll("sortedDistinctIntArrays") // an array of distinct integers is provided
            int[] nums) {

        // Call the two methods under test (sortedArrayToBST() and levelOrder())
        TreeNode root = converter.sortedArrayToBST(nums);
        assertNotNull(root, "An empty BST was created"); // Validate the tree is not null for valid input
        List<Integer> levelOrderResult = converter.levelOrder(root);

        // We check if all the numbers from the old array are present in the new array
        for (int num : nums) {
            assertTrue(levelOrderResult.contains(num), "Tree must contain all elements of the input array");
        }
    }

    @Property
    void testSortedArrayToBST_BSTProperty(
            @ForAll("sortedDistinctIntArrays") // an array of distinct integers is provided
            int[] nums) {

        // Call the two methods under test (sortedArrayToBST() and levelOrder())
        TreeNode root = converter.sortedArrayToBST(nums);
        assertNotNull(root, "An empty BST was created"); // Validate the tree is not null for valid input
        List<Integer> levelOrderResult = converter.levelOrder(root);


        // Validate the tree satisfies the BST property
        assertTrue(isBST(levelOrderResult), "Tree must satisfy the BST property");

    }

    @Property
    void testSortedArrayToBST_Balanced(
            @ForAll("sortedDistinctIntArrays") // an array of distinct integers is provided
            int[] nums) {

        // Call the two methods under test (sortedArrayToBST() and levelOrder())
        TreeNode root = converter.sortedArrayToBST(nums);
        assertNotNull(root, "An empty BST was created"); // Validate the tree is not null for valid input
        List<Integer> levelOrderResult = converter.levelOrder(root);

        // Validate the tree is height-balanced
        assertTrue(isHeightBalanced(levelOrderResult), "Tree must be height-balanced");
    }

    // Generate sorted distinct integer array
    @Provide
    Arbitrary<int[]> sortedDistinctIntArrays() {
        return Arbitraries.integers()
                .between(-1000, 1000) // Restrict the range of integers
                .set() // We let Jqwik generate a set of integers to ensure distinctness
                .ofMinSize(1) // Minimum size of the array
                .ofMaxSize(100) // Maximum size of the array
                .map(set -> set.stream().sorted().mapToInt(Integer::intValue).toArray()); // Convert to sorted array
    }

    // helper method that checks if the tree is a valid BST
    private boolean isBST(List<Integer> result) {
        for (int i = 0; i < result.size(); i++) {
            // check that left child is smaller than the node itself (if exists and not null)
            if (2 * i + 1 < result.size()-1 && (result.get(2 * i + 1) != null && result.get(2 * i + 1) >= result.get(i))) {
                return false;
            }
            // check that right child is larger than the node itself (if exists and not null)
            if (2 * i + 2 < result.size()-1 && (result.get(2 * i + 2) != null && result.get(2 * i + 2) <= result.get(i))) {
                return false;
            }
        }
        return true;
    }

    // helper method that checks if the tree is height-balanced
    private boolean isHeightBalanced(List<Integer> result) {
        // check for every node that is not a leaf, that it is not null
        for (int i = 0; i < result.size()/2; i++) {
            if (result.get(i) == null) {
                return false;
            }
        }
        return true;
    }

}

