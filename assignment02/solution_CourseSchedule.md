# ArrayRotator

## Task 1: Code Coverage

With the test function `testSimpleExamples`, we already received full line coverage.


## Task 2: Designing Contracts
Identified preconditions:
- numCourses is not null
- numCourses is an int between 1 and 64
- prerequisites is between 0 and 64 in length
- prerequisites consists of pairs with [i,j], where i and j are smaller than numCourses but atleast 0

Identified postconditions:
- None that are not already implemented by java types

These pre-conditions then have been implemented:

```java
if (numCourses>65 || numCourses<1) throw new IllegalArgumentException("NumCourses has to be between 1 and 64");
if (prerequisites.length > 64 || prerequisites.length<0) throw new IllegalArgumentException("Prerequisite length has to be between 0 and 64");
for (int i = 0; i<prerequisites.length; i++) {
    if (prerequisites[i].length != 2 || prerequisites[i][0] > numCourses-1 || prerequisites[i][0]<0 || prerequisites[i][1] > numCourses-1 || prerequisites[i][1]<0 ) throw new IllegalArgumentException("Prerequisite elements have to be pairs with each entry being atleast 0 and at the most numCourses -1");
    }
```


## Task 3: Testing Contracts

For the preconditions, we created the following test cases: `testEmptyArray`, `testNullArray`, `testNegativeRotationCount`.

## Task 4: Property-Based Testing
To test the properties that are based on the defined contracts, we came up with the following test cases with the jqwik outputs:

`testPropertyRotationCountPass`:
```text
timestamp = 2025-04-15T12:14:32.197641, ArrayRotatorTest:testPropertyRotationCountPass = 
                              |-----------------------jqwik-----------------------
tries = 1000                  | # of calls to property
checks = 1000                 | # of not rejected calls
generation = RANDOMIZED       | parameters are randomly generated
after-failure = SAMPLE_FIRST  | try previously failed sample, then previous seed
when-fixed-seed = ALLOW       | fixing the random seed is allowed
edge-cases#mode = MIXIN       | edge cases are mixed in
edge-cases#total = 5          | # of all combined edge cases
edge-cases#tried = 5          | # of edge cases tried in current run
seed = 326612050322462684     | random seed to reproduce generated values
```


`testPropertyRotationCountFail`:
```text
timestamp = 2025-04-15T12:14:32.179961, ArrayRotatorTest:testPropertyRotationCountFail = 
                              |-----------------------jqwik-----------------------
tries = 1000                  | # of calls to property
checks = 1000                 | # of not rejected calls
generation = RANDOMIZED       | parameters are randomly generated
after-failure = SAMPLE_FIRST  | try previously failed sample, then previous seed
when-fixed-seed = ALLOW       | fixing the random seed is allowed
edge-cases#mode = MIXIN       | edge cases are mixed in
edge-cases#total = 4          | # of all combined edge cases
edge-cases#tried = 4          | # of edge cases tried in current run
seed = 3040600388700866025    | random seed to reproduce generated values
```

`testPropertyOriginalArrayPass`.
```text
timestamp = 2025-04-15T12:14:32.219001, ArrayRotatorTest:testPropertyOriginalArrayPass = 
                              |-----------------------jqwik-----------------------
tries = 1000                  | # of calls to property
checks = 1000                 | # of not rejected calls
generation = RANDOMIZED       | parameters are randomly generated
after-failure = SAMPLE_FIRST  | try previously failed sample, then previous seed
when-fixed-seed = ALLOW       | fixing the random seed is allowed
edge-cases#mode = MIXIN       | edge cases are mixed in
edge-cases#total = 125        | # of all combined edge cases
edge-cases#tried = 123        | # of edge cases tried in current run
seed = 3895997453398465285    | random seed to reproduce generated values
```
