# BinaryTreeMaxPath

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

`testLeftChildTree`: In this test, a tree in the following form is built:

```text
   x
  x 0
 x 0 0
x 0 0 0
```

Here, x are arbitrary positive integers. Thus, we can check that the max path sum is the sum of all 4 x-values.

```text
timestamp = 2025-04-15T16:21:54.869943, BinaryTreeMaxPathTest:testLeftChildTree = 
                              |-----------------------jqwik-----------------------
tries = 1000                  | # of calls to property
checks = 1000                 | # of not rejected calls
generation = RANDOMIZED       | parameters are randomly generated
after-failure = SAMPLE_FIRST  | try previously failed sample, then previous seed
when-fixed-seed = ALLOW       | fixing the random seed is allowed
edge-cases#mode = MIXIN       | edge cases are mixed in
edge-cases#total = 256        | # of all combined edge cases
edge-cases#tried = 167        | # of edge cases tried in current run
seed = -655690806288155911    | random seed to reproduce generated values
```

`maxPathSumAtLeastMaxNodeValue`: Here, we check that the path sum of a tree (that contains at least 1 positive integer) is at least as large as the largest integer in this tree.

```text
timestamp = 2025-04-27T22:34:41.528624, BinaryTreeMaxPathTest:maxPathSumAtLeastMaxNodeValue = 
                              |-----------------------jqwik-----------------------
tries = 1000                  | # of calls to property
checks = 1000                 | # of not rejected calls
generation = RANDOMIZED       | parameters are randomly generated
after-failure = SAMPLE_FIRST  | try previously failed sample, then previous seed
when-fixed-seed = ALLOW       | fixing the random seed is allowed
edge-cases#mode = MIXIN       | edge cases are mixed in
edge-cases#total = 10         | # of all combined edge cases
edge-cases#tried = 10         | # of edge cases tried in current run
seed = 6850868096951147165    | random seed to reproduce generated values
```