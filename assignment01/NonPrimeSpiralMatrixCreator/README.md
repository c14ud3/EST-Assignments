## Problem: NonPrimeSpiralMatrixCreator


# Description

This problem involves developing a function to create an n*n matrix filled with integers from 1 up to n^2 , placed in a spiral order, with the added condition that no cell should contain a prime number. If a number to be placed is prime, it should be incremented by one (and continually checked and incremented until it is no longer a prime). After the matrix is created, the function should output the matrix in a flattened format, where the matrix rows are concatenated into a single array, starting from the first row to the last.

Inputs:

**int n - the size of the matrix (where n is a non-negative integer).

Output:

**int[] - an array representing the matrix in row-major order (from the first row concatenated to the last row).

Behavior:

**The function should handle the case where n=0 by returning an empty array.

**The function should correctly populate the matrix in spiral order, avoiding placing any prime numbers.


#Example

**Input: n = 4

**Output: [4, 6, 8, 9, 21, 22, 24, 10, 20, 26, 25, 12, 18, 16, 15, 14]
