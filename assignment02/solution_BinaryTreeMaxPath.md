# ArrayRotator

## Task 1: Code Coverage

With the test functions `testSimpleExamples`, `testNullRoot` and `testNullNodes`, we already received full line coverage.


## Task 2: Designing Contracts

We identified the following preconditions:
- The length of `Integer[] array` given to `constructTree` shall be between 0 and 1023
  - If its length is 0, the maximum path sum is 0
- Values are between $-10^4$ and $10^4$

We identified the following invariants:
- For an empty array, the maximum path sum is 0
- A node may be missing (= null)

To check these, we implemented some checks in the code of the function:
```java
if (array.length == 0) return new TreeNode(0);
if (array.length > 1023) throw new IllegalArgumentException("The tree is too large.");

[...]

if (array[i] > 10000) throw new IllegalArgumentException("One value is too large: " + array[i]);
if (array[i] < -10000) throw new IllegalArgumentException("One value is too small: " + array[i]);
```

## Task 3: Testing Contracts

We came up with the following tests: `testEmptyArray`, `testSingleNode`, `tooManyNodes`, `tooLargeNodeValue`, `tooSmallNodeValue`, `testImbalancedTree`. By doing so, we kept our full line coverage.


## Task 4: Property-Based Testing
We came up with the following property based test:

`testPropertyRotationCountFail`

```text
timestamp = 2025-04-15T16:21:54.869943, BinaryTreeMaxPathTest:testPropertyRotationCountFail = 
                              |-----------------------jqwik-----------------------
tries = 1000                  | # of calls to property
checks = 1000                 | # of not rejected calls
generation = RANDOMIZED       | parameters are randomly generated
after-failure = SAMPLE_FIRST  | try previously failed sample, then previous seed
when-fixed-seed = ALLOW       | fixing the random seed is allowed
edge-cases#mode = MIXIN       | edge cases are mixed in
edge-cases#total = 256        | # of all combined edge cases
edge-cases#tried = 155        | # of edge cases tried in current run
seed = 324004137298207710     | random seed to reproduce generated values
```