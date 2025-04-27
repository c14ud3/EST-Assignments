# ArrayRotator

## Task 1: Code Coverage

With the test function `testSimpleExamples`, we already received full line coverage (except of the function call `public static int[] rotate(int[] originalArray, int rotationCount)`).


## Task 2: Designing Contracts
Identified preconditions:
- originalArray is not null
- originalArray is not empty
- rotationCount is either 0 or > 0

Identified postconditions:
- rotatedArray contains the same elements as originalArray

These pre- & post-conditions then have been implemented:

```java
if (originalArray == null) throw new IllegalArgumentException("Input array cannot be null");
if (originalArray.length == 0) throw new IllegalArgumentException("Input array cannot be empty");
if (rotationCount < 0) throw new IllegalArgumentException("Rotation count cannot be negative");

[...]

if (!Arrays.equals(originalArrayCopy, rotatedArrayCopy)) {
	throw new IllegalStateException("The rotated array does not contain the same elements as the original array");
}
```


## Task 3: Testing Contracts

For the preconditions, we created the following test cases: `testEmptyArray`, `testNullArray`, `testNegativeRotationCount`. For the postcondition, we didn't know how to test it, since it tests on a postcondition that shouldn't be validated in a working implementation. Further, the line coverage declined, since the throw line isn't tested.


## Task 4: Property-Based Testing
To test the properties that are based on the defined contracts, we came up with the following test cases with the jqwik outputs:

`testPropertyRotationCountPass`: Here, we are testing the rotated array using a random integer.
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


`testPropertyRotationCountFail`: Here, we use a invalid rotation count.
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

`testPropertyOriginalArrayPass`: Here, we create an array with 3 arbitrary integers and rotate it by 1.
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
