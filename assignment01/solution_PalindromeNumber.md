# Palindrome Number

## 1. Specification-based testing

### 1.1 Understand the requirement
The requirement was understood. The input is a random integer and the method checks if the number is a palindrome and returns True or False. 

### 1.2, 1.3 Explore the program, in-/outputs and identify partitions
The program was explored with different inputs and checking the outputs. Following partitions were identified:
- Positive palindrome of even length -> true
- Positive palindrome of odd length -> true
- Negative numbers, which is a negated positive palindrome -> false
- Single digit positive number -> true
- Non-palindrome number -> false

### 1.4 Analyze the boundaries
There are boundaries at every palindrome number before and after. One specific boundary is a 0, since every negative numbers throws an error and the digits up to 9 are palindromes. From there on, the first palindrome number is 11. As on-point-test we can choose a correct palindrome (121) and as off-point-test one number below or above (120 or 122). 

### 1.5, 1.6 Devise & automate test cases
For Testing we opted for Parameterized tests, since it was easier to write many tests like this. We came up with the following test cases: For output true `0, 1, 5, 11, 121, 111, 122222221, 214747412, 2147447412` For output false: `-1, -11, -121, -11111, INTEGER.MIN_VALUE, 10, 87, 178, 214747413, INTEGER.MAX_VALUE, 1711`

### 1.7 Augment
During testing we found that if the number string had invalid input (e.g. negative digits or non-numeric characters), the program would not throw the correct Exception . We fixed the bug by checking the number string first and throwing the IllegalArgumentException if the input is invalid.
We also found that if the mapping array was shorter than 10 elements, the program would not throw the correct Exception. We fixed the bug by checking the mapping array first and throwing the ArrayIndexOutOfBoundsException if the mapping array is invalid.
It is also possible to insert a number and not a char like this 'a'. The number is then correctly converted to its ASCII value and the corresponding character is returned. This is not a bug, but a feature.

## 2. Structural testing
During structural testing we achieved a line coverage of 100% and a branch coverage of 100%. 

## 3. Mutation testing
We performed mutation testing and got a mutation coverage of 91% with a Test Strength of 91%. We therefore did not need to add any additional tests. The "bug" introduced by the mutation testing was not worth writing a test for since it doesn't change the behavior of the code. The bug that survived was in line `while (left < right)` where the boundary was changed. With this bug in place the while loop just goes on for one more iteration and compares the numbers at index left and right which should be the same. The if statement should then not be true and it goes out of the loop and returns true. 