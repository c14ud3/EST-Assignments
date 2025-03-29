# Array Element Swapper

## 1. Specification-based testing

### 1.1 Understand the requirement
The requirement was understood. The inputs are non-negative integer. The output is the spiralized matrix but in flattenend form. 

### 1.2, 1.3 Explore the program, in-/outputs and identify partitions
The program was explored with different inputs (without negative integers) and checking the outputs. Following partitions were identified:
- Positive integers
- Edge case 0
- Edge case 1
- Edge case 2 (since 2 is the only even prime number)
- Negative integers (not valid input)

For every input larger than 1, a matrix of size n x n is created. 

### 1.4 Analyze the boundaries


### 1.5, 1.6 Devise & automate test cases
We came up with the following test cases: `testEmptyList`

### 1.7 Augment
During testing we realised, that it wrongly populated the Matrix. It always started with 4 which is not the first nonprime number. So we fixed the bug by starting with 1 as the first number getting populated into the matrix. 
Further, we realised that the function could not handle the invalid input of negative value. We fixed the implementation by letting it throw an exception if the input is negative.

## 2. Structural testing
During structural testing we achieved a line coverage of 100% and a branch coverage of 96%. 

## 3. Mutation testing
We performed mutation testing and got a mutation coverage of 95% with a Test Strength of 95%. 

One survived mutation was found on line `if (n < 0)` and was not worth writing a test for, since it is a simple check for negative values.
Second and Third survived mutations were found on line `if (bottom >= top)` and `if (right >= left)`. We cannot write a test for these since the input is always valid and the check is necessary to avoid an infinite loop.