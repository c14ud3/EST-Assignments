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
While testing, we found a bug, where numbers larger than the MAX_INTEGER are not handled correctly. We fixed this by adapting the function to long type instead of an int.

`testPropertyColumnTitlePass`:
We tested for valid inputs containing A, B, C and Z and no longer than 7 characters.
```text
timestamp = 2025-04-27T08:23:13.352869400, ExcelSheetTest:testPropertyColumnTitlePass = 
                              |-----------------------jqwik-----------------------
tries = 1000                  | # of calls to property
checks = 1000                 | # of not rejected calls
generation = RANDOMIZED       | parameters are randomly generated
after-failure = SAMPLE_FIRST  | try previously failed sample, then previous seed
when-fixed-seed = ALLOW       | fixing the random seed is allowed
edge-cases#mode = MIXIN       | edge cases are mixed in
edge-cases#total = 2          | # of all combined edge cases
edge-cases#tried = 2          | # of edge cases tried in current run
seed = 9212502069760161830    | random seed to reproduce generated values
```


`testPropertyColumnTitleFail`:
We tested for invalid inputs containing integers
```text
timestamp = 2025-04-27T08:24:05.845411600, ExcelSheetTest:testPropertyColumnTitleFail = 
                              |-----------------------jqwik-----------------------
tries = 1000                  | # of calls to property
checks = 1000                 | # of not rejected calls
generation = RANDOMIZED       | parameters are randomly generated
after-failure = SAMPLE_FIRST  | try previously failed sample, then previous seed
when-fixed-seed = ALLOW       | fixing the random seed is allowed
edge-cases#mode = MIXIN       | edge cases are mixed in
edge-cases#total = 2          | # of all combined edge cases
edge-cases#tried = 2          | # of edge cases tried in current run
seed = -5182476950027947055   | random seed to reproduce generated values
```
