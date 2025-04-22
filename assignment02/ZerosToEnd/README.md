## Problem: Zeros To End

# Description

The method receives an array of random numbers and returns an array with the same values in the same
order but with all zeroes moved to the end of the array. If the given array is empty or has more than
10 elements, an empty array is returned.


Inputs:

**array (int[]): An array of integers where the size of the array is between 0 and 10


Output:

**int[]: An array where all non-zero elements retain their original order followed by all zeros, if any.



Constraints:

**0 <= n <= 10 with n, length of the input array

#Example

**Input:  {1, 2, 0, 4, 3, 0, 5, 0} 
**Output: {1, 2, 4, 3, 5, 0, 0, 0} 


