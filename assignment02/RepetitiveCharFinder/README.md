## Problem: RepetitiveCharFinder

# Description

Design a Java class named RepetitiveCharFinder that identifies and returns all non-unique characters from a given string. Each character that appears more than once in the string should be returned in a list, without duplicates.


Inputs:

**input (String): A string to be checked for character repetitions.



Output:

**List<Character>: A list of characters that are not unique in the input string. The characters in the list should be unique (no duplicates of the same character) and sorted in the order of their first appearance.


Constraints:

**The input string can include any characters from the ASCII character set.

**The method should treat characters case-sensitively; thus, 'a' and 'A' are considered distinct.

**An empty string returns an empty list, as there are no characters to repeat.

**The method must handle null inputs by throwing IllegalArgumentException.


#Example

**Input: "Hello"

**Output:  [l]



