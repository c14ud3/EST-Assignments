## Problem: Fraction to Decimal Representation

# Description

Given two integers representing the numerator and denominator of a fraction, convert this fraction to its decimal format as a **string**. If the fraction has a repeating decimal part, enclose the repeating sequence in parentheses.

Inputs:

**numerator: an integer representing the numerator of the fraction.

**denominator: an integer representing the denominator of the fraction.


Output:

**A string representing the decimal format of the fraction. If the decimal part is repeating, the repeating part should be enclosed in parentheses.

Behavior:

**If the denominator is 0, the function should return null to indicate an undefined result.

**If the result is a whole number (i.e., no fractional part), return it as a simple integer string without any decimal point.

**For fractions that result in a repeating decimal, identify the repeating sequence and enclose it in parentheses.

**The function should efficiently handle large numerators and denominators and ensure precision in detecting repeating sequences.


#Example

**Input: numerator=22, denominator=7

**Output: "3.(142857)" (The fraction 22/7 results in a repeating decimal.)