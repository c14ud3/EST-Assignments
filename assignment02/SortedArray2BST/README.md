## Problem: SortedArray2BST

# Description

Given an integer array `nums` where the elements are sorted in ascending order, convert it to a height-balanced binary search tree (BST). A height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differs by more than one. 


Inputs:

 **nums (int[]): A sorted array of integers.


Output: 

**Level-wise representation of the tree.  For nodes at each level, list node values from left to right. If a node does not have a child, that position should be represented as `null`.


### Constraints:

**nums is sorted in a strictly increasing order.

**nums cannot be null or empty.

**nums cannot have null element in it.

**For any array or subarray with an even number of elements, the selected root is the middle element at the position (length/2) - 1`.

**In output array, absent nodes should be represented as null. 



# Example

**Input: nums = [-10, -3, 0, 5, 9]  

**Output: [0, -10, 5, null, -3, null, 9]

The process of constructing a height-balanced binary search tree (BST) from a sorted array involves selecting a central element from the array as the root of the tree. The elements to the left of 0 are the elements in the array[-10, -3]. Again, choose the middle of this subrange as the root for the left subtree. Here, -10 becomes the root of the left subtree and -3 then becomes the right child of -10.  The elements to the right of 0 in the array are [5, 9]. The middle of this subrange is 5 and 9 then becomes the right child of 5. 




