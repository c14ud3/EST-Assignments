## Problem: Validate Parentheses Sequence


# Description

Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid based on the balancing of the parentheses. An input string is considered valid if:

1- Open brackets must be closed by the same type of brackets.

2- Open brackets must be closed in the correct order.

#
Inputs:

**A string s containing characters: '(', ')', '{', '}', '[' and ']'.

Output:

**A boolean value: true if the string is valid as per the rules above, otherwise false.

Behavior:

**If the string is empty, it should be considered valid.

**The method should efficiently handle strings up to the maximum expected length. 

#Example 1

**Input: s = "()"

**Output: true

#Example 2

**Input: s = "()[]{}"

**Output: true

#Example 3

**Input: s = "(]"

**Output: false

#Example 4

**Input: s = "([)]"

**Output: false

#Example 5

**Input: s = "{[]}"

**Output: true