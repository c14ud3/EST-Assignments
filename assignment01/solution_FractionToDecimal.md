# Event Scheduler

## 1. Specification-based testing

### 1.1 Understand the requirement
Done.

### 1.2, 1.3 Explore the program, in-/outputs and identify partitions
To explore the program, `testSimpleDivisions` has been created and further extended.

### 1.4 Analyze the boundaries
We identified the following boundaries:
- numerator is 0
- denominator is 0
- numerator is positive/negative
- denominator is positive/negative
- division results in integer number
- division results in simple floating point
- division results in floating point with repeating decimal

### 1.5, 1.6 Devise & automate test cases
We came up with the following test cases: `testNumeratorZero`, `testDenominatorZero`, `testNumeratorNegative`, `testDenominatorNegative`, `testIntegerResult`, `testFloatingResult`, `testRepeatingResult`. Since all tests failed, we added the `java.utils` to the `FractionToDecimal` class.

### 1.7 Augment
Nothing new here.


## 2. Structural testing
We added the test of the instantiation of the class: `testInstantiation`. We now have zero missed instructions or branches.


## 3. Mutation testing
We performed mutation testing and only got a mutation coverage of 94%. This is due to the fact, that a mutation in `if (numerator < 0 ^ denominator < 0)` to `if (numerator < 0 ^ denominator <= 0)` can't be detected by our test suite, since we return `null` if `if (denominator == 0)` in advance.