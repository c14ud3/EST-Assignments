## Problem: Array Rotator

# Description

Design a Java class ArrayRotator that rotates an array of integers to the right by a given number of rotations. 
The rotation should be circular, meaning that elements shifted out of the array on the right should reappear at the start.
If number of rotations is zero, the method returns the original array unchanged.


Inputs:

**originalArray (int[]): A non-null array of integers.

**rotationCount (int): A non-negative integer indicating the number of times to rotate the array to the right.


Output:

**rotated array (int[]): A new array of integers representing the rotated array.


Constraints:

**originalArray must not be null or empty.

**rotationCount may be zero or any positive integer.


#Example

**Input: originalArray = [1, 2, 3, 4, 5], rotationCount = 2

**Output:  [4, 5, 1, 2, 3]



