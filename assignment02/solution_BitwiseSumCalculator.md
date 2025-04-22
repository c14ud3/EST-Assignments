# BitwiseSumCalculator

## Task 1: Code Coverage

With the test functions `testInstantiate` and `testSimpleExamples`, we already received full line coverage.


## Task 2: Designing Contracts
Identified preconditions:
- a is within the 32-bit signed integer range
- b is within the 32-bit signed integer range

Identified postconditions:
- Output = a + b

We wanted to implement the preconditionsthe following way:

```java
if (a > Integer.MAX_VALUE || a < Integer.MIN_VALUE)
	throw new IllegalArgumentException("a is out of bound");

if (b > Integer.MAX_VALUE || b < Integer.MIN_VALUE)
	throw new IllegalArgumentException("b is out of bound");
```
However, this doesn't really makes sense, since integers in Java are per default 32 bit signed integers (see [here](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/lang/Integer.html)) Thus, we didn't do this implementation.

We didn't implement the postcondition, since this would require to calculate the sum again by `int sum = a + b;` and thus, we would do the whole work twice, which just doesn't make sense.


## Task 3: Testing Contracts

There is no need to test the preconditions, since only signed integers can be given as an input for `a` and `b`. Regarding the postcondition, we do this later in a property-based test, since this is more suitable.


## Task 4: Property-Based Testing
We test the property that `output = a + b`:

`testOutputSum`:
```text
timestamp = 2025-04-17T10:15:24.821328, BitwiseSumCalculatorTest:testOutputSum = 
                              |-----------------------jqwik-----------------------
tries = 1000                  | # of calls to property
checks = 1000                 | # of not rejected calls
generation = RANDOMIZED       | parameters are randomly generated
after-failure = SAMPLE_FIRST  | try previously failed sample, then previous seed
when-fixed-seed = ALLOW       | fixing the random seed is allowed
edge-cases#mode = MIXIN       | edge cases are mixed in
edge-cases#total = 25         | # of all combined edge cases
edge-cases#tried = 25         | # of edge cases tried in current run
seed = 450095078041592200     | random seed to reproduce generated values
```