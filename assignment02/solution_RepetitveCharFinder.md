# RepetitiveCharFinder

## Task 1: Code Coverage

With the test function `testSimpleExamples`, we already received full line coverage.


## Task 2: Designing Contracts
Identified preconditions:
- The input string can include any ASCII character
- If null is passed, an IllegalArgumentException should be thrown

Identified postconditions:
- Empty string input should give an empty list output

Invariant:
- Characters should be treated case-sensitively.

These pre- and post- conditions then have been implemented:

```java
...
if (input == null) { throw new IllegalArgumentException("Input string cannot be null");}
```

## Task 3: Testing Contracts

For the preconditions, we created the following test cases: `testNullInput`, `testEmptyInput`.

## Task 4: Property-Based Testing
To test the properties that are based on the defined contracts, we came up with the following test cases with the jqwik outputs:

`testPropertyNonUniqueCharacters`:
In this property test, non unique characters are created by using the `@ForAll` annotation. It generates atleast one non-unique character pair and then runs the tests.

```text
timestamp = 2025-04-28T00:50:59.193061800, RepetitiveCharFinderTest:testPropertyNonUniqueCharacters = 
                              |-----------------------jqwik-----------------------
tries = 1000                  | # of calls to property
checks = 1000                 | # of not rejected calls
generation = RANDOMIZED       | parameters are randomly generated
after-failure = SAMPLE_FIRST  | try previously failed sample, then previous seed
when-fixed-seed = ALLOW       | fixing the random seed is allowed
edge-cases#mode = MIXIN       | edge cases are mixed in
edge-cases#total = 2          | # of all combined edge cases
edge-cases#tried = 2          | # of edge cases tried in current run
seed = -8433870175939083284   | random seed to reproduce generated values
```


`testPropertyUniqueCharacters`:
Using distinct characters it creates strings where there are no chars who repeat themselves to test the property of the Unique characters.

```text
timestamp = 2025-04-28T00:51:27.341700900, RepetitiveCharFinderTest:testPropertyUniqueCharacters = 
                              |-----------------------jqwik-----------------------
tries = 1000                  | # of calls to property
checks = 1000                 | # of not rejected calls
generation = RANDOMIZED       | parameters are randomly generated
after-failure = SAMPLE_FIRST  | try previously failed sample, then previous seed
when-fixed-seed = ALLOW       | fixing the random seed is allowed
edge-cases#mode = MIXIN       | edge cases are mixed in
edge-cases#total = 2          | # of all combined edge cases
edge-cases#tried = 2          | # of edge cases tried in current run
seed = -5852207192480690661   | random seed to reproduce generated values
```

