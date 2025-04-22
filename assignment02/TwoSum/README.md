## Problem: TwoSum

# Description

Given an array of integers `nums` and an integer `target`, return the indices of the two numbers such that they add up to `target`. 
You may assume that each input would have exactly one solution, and you may not use the same element twice. The answer can be returned in any order.


Inputs:

**nums (int[])**: An array of integers.
 **target (int)**: The target integer to achieved by summing two distinct elements from `nums`.


Output:

**int[]**: An array of two integers representing the indices of the two numbers in `nums` that add up to `target`.


Constraints:

**nums must contain at least two elements. It cannot be empty or null.
**Values in nums can be positive, zero, or negative integers.
**Target can be any integer.
**Each input will have exactly one solution.
**You may not use the same element of the array twice.


#Example

**Input:  nums = [2, 7, 11, 15], target = 9 
**Output: [0, 1]  
**Explanation:** Because nums[0] + nums[1] == 9, we return [0, 1].

