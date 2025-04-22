# ClimbingStairs

## Task 1: Code Coverage

To test the implementation, we go a working recursive approach from [GeeksForGeeks](https://www.geeksforgeeks.org/count-ways-reach-nth-stair/) in `ClimbingStairsTest.climbStairs()` and tested the real implementation with the test functions `testSimpleExamples`, we already received full line coverage.


## Task 2: Designing Contracts
Identified preconditions:
- n needs to be a positive integer

Identified postconditions:
- The output is the number of steps

We wanted to implement the preconditionsthe following way:

We implemented a precondition check:

```java
if (n <= 0) throw new IllegalArgumentException("The number of stairs must be a positive integer.");
```
It is, however, not clear how the function should behave with input 0. We assume that 0 is not a positive integer and the function, thus, throws an error.


## Task 3: Testing Contracts

To thest the precondition, we implemented `testNegativeInput` and `testZeroInput`.
Regarding the postcondition, we do this later in a property-based test, since this is more suitable.


## Task 4: Property-Based Testing
We implemented the following tests:

`testPropertyNegativeOrZeroInputs`:
```text
timestamp = 2025-04-17T11:24:03.311859, ClimbingStairsTest:testPropertyNegativeOrZeroInputs = 
                              |-----------------------jqwik-----------------------
tries = 1000                  | # of calls to property
checks = 1000                 | # of not rejected calls
generation = RANDOMIZED       | parameters are randomly generated
after-failure = SAMPLE_FIRST  | try previously failed sample, then previous seed
when-fixed-seed = ALLOW       | fixing the random seed is allowed
edge-cases#mode = MIXIN       | edge cases are mixed in
edge-cases#total = 5          | # of all combined edge cases
edge-cases#tried = 5          | # of edge cases tried in current run
seed = -6087338161732748667   | random seed to reproduce generated values
```

`testPropertyPositiveInputs`:
```text
timestamp = 2025-04-17T11:24:29.081714, ClimbingStairsTest:testPropertyPositiveInputs = 
                              |-----------------------jqwik-----------------------
tries = 40                    | # of calls to property
checks = 40                   | # of not rejected calls
generation = EXHAUSTIVE       | parameters are exhaustively generated
after-failure = SAMPLE_FIRST  | try previously failed sample, then previous seed
when-fixed-seed = ALLOW       | fixing the random seed is allowed
edge-cases#mode = MIXIN       | edge cases are mixed in
edge-cases#total = 0          | # of all combined edge cases
edge-cases#tried = 0          | # of edge cases tried in current run
seed = -2573881483852771947   | random seed to reproduce generated values
```

Due to the hardness of the problem and to prevent integer overflows in the implementation from GeeksForGeeks, we limited the input in `testPropertyPositiveInputs` to maximum 40.