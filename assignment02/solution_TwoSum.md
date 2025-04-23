# Solution TwoSum

## Task 1
We implemented the following test cases:
- `testBasicCase()`
- `testNegativeNumbers1()`
- `testNegativeNumbers2()`
- `testDontUseTwice()`
- `testNoSolution()`

With those test cases, we already got 100% line coverage according to JaCoCo.

## Task 2
We defined the following preconditions after reading the README.md file:
- The input array cannot be empty or null.
- The input array must have a length of at least 2.
- The input array must contain distinct integers.
- The target must not be null.

The fact that the input array must contain integers and the target value is also an integer is already restricted by the Java language, so it makes no sense to test this.

Then we defined the following postconditions:
- The method may raise an IllegalArgumentException. This is coered in the test suite from Task 1 and we don't assert this within the source code.
- The output array is not null.
- The output array must contain exactly two integers.
- The two integers must be distinct.
- None of the integers is allowed to be bigger or equal to the size of the input array.

We could not find any decent invariant for this method.
We created two methods: `checkPreconditions()` and `checkPostconditions()` in the TwoSum.java file.

## Task 3

We added the following tests for the preconditions:
- `testPreconditions_NullArray`
- `testPreconditions_EmptyArray`
- `testPreconditions_DuplicateElements`

And the following tests for the postconditions:
- `testPostconditions_ResultNotNull`
- `testPostconditions_ResultHasTwoElements`
- `testPostconditions_ResultIndicesDistinct`
- `testPostconditions_ResultIndicesWithinBounds`

We basically added one test for every pre- and postcondition. For the postcondition tests, we cannot achieve 100% line coverage, because it's not possible to trigger all the errors that could happen.

## Task 4

We defined the following properties:
1) The method returns either an integer array or throws an IllegalArgumentException with the message "No solution found".

To check this, we added a Try-Catch block to assert different things depending on whether an error or a result is returned.
If an error is returned, we check if the error type is correct and if the message is "No solution found". Otherwise, we continue investigating the returned result.

2) The method returns an integer array with exactly two elements.

This is easy to check using a simple assert statement.

3) The two values of the output array must be distinct.

This is also easy to check using a simple assert statement.

4) The two elements of the output array must correspond to indices of two values in the input array that add up to the target value.

This can also be checked using a simple assert statement.

We created a provider method that provides an array of integers of a maximum size of 100 and which contains distinct integers between -50 and 50. To create the distinct integers, we applied a trick to let Jqwik generate a set first (that naturally contains distinct values) and then convert it to the array. We also provide the target value such that it ranges from -50 to 50. We made this decision to limit the integer values, because it is more likely that an input array and target value are randomly generated that actually lead to a result and not always trigger the error message that no result is found.


