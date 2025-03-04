## Problem: Number Encoder

# Description
The Number Encoder is designed to transform a sequence of numerical digits into a sequence of characters based on a specific mapping rule. Each digit from 0 to 9 is mapped to a unique character from a provided set. 

Inputs:

**A String called number that represents a series of digits.

**An array of characters char[] mapping where each element is a character that corresponds to a digit from 0 to 9. The index of each character in the array corresponds directly to the digit it represents. For example, if mapping[0] is 'a', then all '0's in the number string should be replaced by 'a'.

Output:

**A String where each digit in the input number has been replaced by its corresponding character from the mapping array.

Behavior:

** The method should iterate through each character in the number string, convert it to its corresponding digit, and then replace it with the character from the mapping array at that index.

** If the input string contains any characters that are not numeric or negative digits, the method should throw an IllegalArgumentException indicating "Input contains invalid characters."

** If the mapping array does not have a character for every digit from 0 to 9 (i.e., it is shorter than 10 elements), the method should throw an ArrayIndexOutOfBoundsException.



Example

**Input: number = "4815162342", mapping = ['q','w','e','r','t','y','u','i','o','p']

**Output: "towywuerte"
