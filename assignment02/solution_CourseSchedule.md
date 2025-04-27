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

`testPropertyNumCoursesPass`:
```text
timestamp = 2025-04-26T22:35:27.117552600, CourseScheduleTest:testPropertyNumCoursesPass = 
                              |-----------------------jqwik-----------------------
tries = 64                    | # of calls to property
checks = 64                   | # of not rejected calls
generation = EXHAUSTIVE       | parameters are exhaustively generated
after-failure = SAMPLE_FIRST  | try previously failed sample, then previous seed
when-fixed-seed = ALLOW       | fixing the random seed is allowed
edge-cases#mode = MIXIN       | edge cases are mixed in
edge-cases#total = 0          | # of all combined edge cases
edge-cases#tried = 0          | # of edge cases tried in current run
seed = -4564189970503427436   | random seed to reproduce generated values
```


`testPropertyNumCoursesFail`:
```text
tries = 1000                  | # of calls to property
checks = 1000                 | # of not rejected calls
generation = RANDOMIZED       | parameters are randomly generated
after-failure = SAMPLE_FIRST  | try previously failed sample, then previous seed
when-fixed-seed = ALLOW       | fixing the random seed is allowed
edge-cases#mode = MIXIN       | edge cases are mixed in
edge-cases#total = 4          | # of all combined edge cases
edge-cases#tried = 4          | # of edge cases tried in current run
seed = 1675367955210159867    | random seed to reproduce generated values
```

`testPropertyPrerequisitesPass`.
```text
timestamp = 2025-04-26T22:54:28.530039600, CourseScheduleTest:testPropertyPrerequisitesPass = 
                              |-----------------------jqwik-----------------------
tries = 64                    | # of calls to property
checks = 64                   | # of not rejected calls
generation = EXHAUSTIVE       | parameters are exhaustively generated
after-failure = SAMPLE_FIRST  | try previously failed sample, then previous seed
when-fixed-seed = ALLOW       | fixing the random seed is allowed
edge-cases#mode = MIXIN       | edge cases are mixed in
edge-cases#total = 0          | # of all combined edge cases
edge-cases#tried = 0          | # of edge cases tried in current run
seed = 7186578156850836365    | random seed to reproduce generated values
```

`testPropertyPrerequisitesFail`:
```text
timestamp = 2025-04-26T23:06:13.388781500, CourseScheduleTest:testPropertyPrerequisitesFail = 
                              |-----------------------jqwik-----------------------
tries = 64                    | # of calls to property
checks = 64                   | # of not rejected calls
generation = EXHAUSTIVE       | parameters are exhaustively generated
after-failure = SAMPLE_FIRST  | try previously failed sample, then previous seed
when-fixed-seed = ALLOW       | fixing the random seed is allowed
edge-cases#mode = MIXIN       | edge cases are mixed in
edge-cases#total = 0          | # of all combined edge cases
edge-cases#tried = 0          | # of edge cases tried in current run
seed = -4076156215522254136   | random seed to reproduce generated values
```
