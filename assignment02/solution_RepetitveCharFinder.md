# RepetitiveCharFinder

## Task 1: Code Coverage

With the test function `testSimpleExamples`, we already received full line coverage.


## Task 2: Designing Contracts
Identified preconditions:
- The array strs has atlast 1 string
- Each string in the array can only be lowercase english letters
- If one of the input strings is empty, an exception should be thrown, that a non-empty string should be passed.


Identified postconditions:
- None that java has not already implemented with types.

These pre- and post- conditions then have been implemented:

```java
...
if (strs[0] == null) throw new IllegalArgumentException("Please enter a non-empty string");      
...        
if (strs.length == 0) throw new IllegalArgumentException("Please enter atleast 1 string");
for (int i = 0; i < strs.length; i++) {
    if (strs[i] == null) throw new IllegalArgumentException("Please enter a non-empty string");
        }
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
