# Array Element Swapper

## 1. Specification-based testing

### 1.1 Understand the requirement
Inputs are intervals which may or may not overlap. If they overlap, the ones that do should be merged into one with the lowest start and highest end.

### 1.2, 1.3 Explore the program, in-/outputs and identify partitions
The program was explored with different inputs and checking the outputs. Following partitions were identified:
- Input array is empty
- One interval 
- Two or more intervals which one interval overlaps
- Two or more intervals which all intervals overlap
- Two or more intervals which no interval overlaps
- Two or more intervals are the same interval.
- Intervals where the start is greater than the end.
- Intervals where the start is equal to the end.
- Negative numbers in the intervals.

### 1.4 Analyze the boundaries
There are multiple different cases in which it is either true or false that the intervals overlap. There also is no boundary on how many intervals overlap, since there can be infinitely many intervals. Edge case is the empty array. 

### 1.5, 1.6 Devise & automate test cases
We came up with the following test cases: `testEmptyList`

### 1.7 Augment
During augmentation, we realized that the function can not handle multiple empty intervals. We added the test case `testEmptyListMultiple` which now checks that an Exception is thrown when multiple empty intervals are given.

## 2. Structural testing
During structural testing we achieved a line coverage of 100% and a branch coverage of 100%. We therefore added no tests to achieve a higher coverage.

## 3. Mutation testing
We performed mutation testing and got a mutation coverage of 89% with a Test Strength of 89%. The survived mutation was found on line `if (intervals.length <= 1)` where the boundary was changed. However, the behavior of the program did not change and therefore no test has to be written.