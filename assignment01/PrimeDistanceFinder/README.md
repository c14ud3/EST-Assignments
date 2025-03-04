## Problem:  Prime Distance Finder

# Description

The goal is to find the smallest positive difference between any two prime numbers in an unsorted array of integers.

Inputs:

**An array of integers nums, which may include both prime and non-prime numbers.

Output:

**An integer representing the smallest difference between any two prime numbers found in the array. If there are fewer than two prime numbers in the array, return -1.

Behavior:

**The method must efficiently determine which numbers in the array are prime.

**Once prime numbers are identified, calculate the differences between each pair of prime numbers to find the smallest difference.

**The function should handle edge cases such as arrays containing only one prime number or no prime numbers at all.


#Example

**Input: nums = [12, 17, 4, 7, 30, 13]

**Output: 4 (The smallest distance is between primes 13 and 17.)
