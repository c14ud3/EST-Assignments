## Problem: RomanToInteger

# Description
The task is to convert a string representing a Roman numeral into its integer equivalent. Roman numerals are based on seven symbols: 

| Symbol | Value |
| ------ | ----- |
| I       | 1     |
| V      | 5     |
| X      | 10    |
| L      | 50    |
| C      | 100   |
| D      | 500   |
| M      | 1000  |

For example, 2 is written as II in Roman numeral, just two ones added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

I can be placed before V (5) and X (10) to make 4 and 9. 
X can be placed before L (50) and C (100) to make 40 and 90. 
C can be placed before D (500) and M (1000) to make 400 and 900.


Inputs:
**A string `s` representing a Roman numeral, which is guaranteed to be a valid Roman numeral between 1 and 3999.

Output:
**An integer representing the decimal value of the Roman numeral.

Constraints:
**The input must be a non-empty string.

**The input string will only contain valid Roman numerals that represent numbers from 1 to 3999.

# Example

**Input: "LVIII"

**Output: 58

Explanation: L = 50, V= 5, III = 3.



