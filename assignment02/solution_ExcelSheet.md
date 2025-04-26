# ExcelSheet

## Task 1: Code Coverage

With the test function `testSimpleExamples`, we already received full line coverage.


## Task 2: Designing Contracts
Identified preconditions:
- The length of the columnTitle string is between 1 and 7
- The columnTitle string consists only of uppercase English letters

Identified postconditions:
- None that are not already implemented by java types

These pre-conditions then have been implemented:

```java
if (length > 7 || length == 0) throw new IllegalArgumentException("Column titel must be atleast 1 and at most 7 characters long");
if (!columnTitle.matches("[A-Z]+")) throw new IllegalArgumentException("Column title must contain only english uppercase letters");
```

## Task 3: Testing Contracts

For the preconditions, we created the following test cases: `testColumnTitleEmpty`, `testColumnTitleTooLong`, `TestColumnTitleInt`.

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
