## Problem: Array Element Swapper

# Description

The Array Element Swapper is designed to swap elements within an array to achieve a specific order. The task is to reorder the array such that all negative numbers appear before all positive numbers, maintaining the order of appearance for negative and positive numbers within their respective groups. Zeroes (0s) should be treated as positive numbers.


Inputs:

**An integer array numbers that can contain positive numbers, negative numbers, and zeroes.


Output:

**The transformed array where all negative numbers appear before any positive number or zero, with the original relative order preserved within the negative and non-negative groups.

Behavior:

**The method should iterate through the numbers array and rearrange the elements without using any additional arrays for storage (in-place swapping is preferred).

**The method should handle edge cases like an array filled with only negative numbers, only positive numbers, multiple zeros,  or an empty array.


#Example

**Input: numbers = [3, -1, 0, -3, 5, -2]

**Output:  [-1, -3, -2, 3, 0, 5]
