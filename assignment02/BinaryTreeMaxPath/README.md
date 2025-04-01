## Problem: BinaryTreeMaxPath

# Description

Given a binary tree represented as an array of integers where each element corresponds to a node in the tree, implement a function to find the maximum path sum. 
The maximum path sum in a binary tree is the highest sum of values found along any path from one node to another (starting node cannot be null).
The path must contain at least one node and does not necessarily need to pass through the tree root (can be any path between any two nodes).


Inputs:

**tree (int[]): An array of integers where each element represents a node's value in a binary tree. The structure of the tree is defined by the order of the elements, which represent a level-order traversal of the tree. null values in the array represent absent nodes.
For any node at index i, its left child is located at 2*i + 1 and its right child at 2*i + 2, if within bounds of the array length.



Output:

**int: Maximum path sum in the tree.


Constraints:

**The tree represented by the array can have between 0 and 1023 nodes.

**Node values are between -10^4 and 10^4.

**Null in the array indicates that a node is absent, which can lead to unbalanced trees or trees with missing nodes at any level.

**For an empty array, the maximum path sum is 0 



#Example

**Input: [1, 2, 3]

**Output: 6


