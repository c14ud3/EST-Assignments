# Number Encoder

## 1. Specification-based testing

### 1.1 Understand the requirement
The requirement was understood. The input may be a random string of digits (0s to 9s) and an Array with 10 characters. Each digit in the string input correspond to the character at the corresponding index in the mapping arary.

### 1.2, 1.3 Explore the program, in-/outputs and identify partitions
The program was explored with different inputs and checking the outputs.
Partitions for the number string:
- Negative digits in number string 
- Non-numeric characters in number string 
- Number string is empty
- Number string is a random string of digits

Partitions for the Mapping array: 
- Shorter than 10 elements
- longer than 10 elements
- exactly 10 elements
- Characters that are not character (the function prohibits this due to the type of the array)
- Characters that are not unique

Combinations of both these inputs: 
- Random digit string with valid mapping array
- Random digit string with invalid mapping array
- negative digit string with valid mapping array
- Non-numeric character string with valid mapping array
- Empty string with valid mapping array

It is not necessary to test with an invalid string and an invalid array, since the function checks the string first and throws an exception if the string is invalid. 

### 1.4 Analyze the boundaries
There are no boundaries for the number string, since it can be any length. The mapping array has one boundary where the length is 10. So the on-point-test is to test the function with a mapping array of length 10 and the off-point-test with a length of 9. 

### 1.5, 1.6 Devise & automate test cases
We came up with the following test cases: `testOneDigit`, `TestTwoDigits` `TestNegativeDigit`, `TestNonNumericDigit`, `TestSpecialCharacter`, `TestDoubleNegativeSign`, `TestShortMappingArray`, `TestWord`, `TestEmptyString`, `TestIntMappingArray`, `TestNonUniqueMappingArray`.

### 1.7 Augment
During testing we found that if the number string had invalid input (e.g. negative digits or non-numeric characters), the program would not throw the correct Exception . We fixed the bug by checking the number string first and throwing the IllegalArgumentException if the input is invalid.
We also found that if the mapping array was shorter than 10 elements, the program would not throw the correct Exception. We fixed the bug by checking the mapping array first and throwing the ArrayIndexOutOfBoundsException if the mapping array is invalid.
It is also possible to insert a number and not a char like this 'a'. The number is then correctly converted to its ASCII value and the corresponding character is returned. This is not a bug, but a feature.

## 2. Structural testing
During structural testing we achieved a line coverage of 100% and a branch coverage of 100%. 

## 3. Mutation testing
We performed mutation testing and got a mutation coverage of 100% with a Test Strength of 100%. We therefore did not need to add any additional tests.