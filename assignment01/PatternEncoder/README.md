## Problem: Pattern Encoder

# Description

The goal is to encode a string by replacing each substring that appears more than once with a special notation that indicates the number of times the substring appears consecutively, followed by the substring itself, compressing the string in a lossless manner. Compressing refers to the process of reducing the length of the string by encoding parts of it using a specific pattern.

Inputs:

**A string input that consists of any combination of lowercase letters and may include spaces.


Output:

**A string representing the encoded version of the input string.

Behavior:

**The method must identify and compress consecutive repeated substrings. If a substring is repeated consecutively, it should be replaced by the number of repetitions followed by the substring enclosed in brackets.

**Non-repeated substrings or characters should remain unchanged.

**The method should optimize for the shortest possible length of the encoded string.


#Example

**Input: "aaabbaaccabcabc"

**Output:  "3[a]2[b]2[c]abcabc" (Here, "aaa", "bb", and "cc" are compressed, while "abcabc" is left as is because compressing it wouldn't reduce its length.)
