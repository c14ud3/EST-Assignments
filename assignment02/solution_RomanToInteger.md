# Solution RomanToInteger

## Task 1
We added testValidRomanNumeral() method to test the valid Roman numeral. We also added testZero to check if an empty string results in the number 0. This was not the case, so we added a line in the RomanToInteger.java file to check if the string is empty and return 0. We achieved 100% line coverage when checking coverage with JaCoCo.

## Task 2
We read the README.md file and the code in the RomanToInteger.java file.
We defined the following preconditions:
- The input string must not be null.
- The input string is either empty or must contain the characters I, V, X, L, C, D, and M only.
- The characters must be ordered in descending order (M, D, C, L, X, V, I), except for the six subtraction cases (IV, IX, XL, XC, CD, CM).
- The characters I, X, C, and M must not appear more than three times in a row.
- The characters V, L, and D must not appear more than once.

We defined the following postcondition:
- The output is an integer and must be greater than or equal to 0 and less than or equal to 3999.

We didn't find any invariant that is suitable for this problem, because there is nothing that stays the same before and after the method is called.
We created two methods: `checkPreconditions()` and `checkPostconditions()` in the RomanToInteger.java file. The `checkPreconditions()` method checks if all preconditions listed above are met and returns an InvalidArgumentError with a fitting message otherwise. The `checkPostconditions()` method checks if the output is an integer and is greater than or equal to 0 and less than or equal to 3999. If not, it throws an IllegalStateException (we have chosen this error because the application is in an illegal state when a postcondition is not met) with a fitting message.

## Task 3
We have added a test that checks a case with valid preconditions. In this case, no error should be thrown.
Then we have added one test for each precondition where it is not met and the corresponding error is thrown.
We have added three tests for valid post conditions, where one checks the minimum post condition (0), one checks the maximum post condition (3999), and one checks a random number in between.
It was not possible to us to write a test case where the post condition is not met, because it is not possible to get a number smaller than 0 or greater than 3999 with the given preconditions.

## Task 4
We defined the following properties:

1) The method returns an integer between 0 and 3999.

To test this property, we created a provider function that creates a valid roman number between 0 and 3999. (For implementation details look at the test file.) We then check if the result is between 0 and 3999.

2) If the input roman digit is larger, the resulting integer must also be larger.

We test this property inside the `testRomanToIntegerProportionality()` test case. We use another provider method to generate a valid roman number, but in this case in the range [1, 3999], meaning that it containst at least one roman digit. We call the `romanToInteger()` twice: Once with the provided roman number as input, and once with the same roman number, but with the last roman digit removed, which guarantees that this resulting roman number is smaller than the previous one. We then check that the integer result of the first call is greater than the integer result of the second call. If this is not the case, the test fails.

```
timestamp = 2025-04-27T11:03:57.490066100, RomanToIntegerPropertyTest:testRomanToIntegerValidInputValidOutputRange = 
                              |-----------------------jqwik-----------------------
tries = 1000                  | # of calls to property
checks = 1000                 | # of not rejected calls
generation = RANDOMIZED       | parameters are randomly generated
after-failure = SAMPLE_FIRST  | try previously failed sample, then previous seed
when-fixed-seed = ALLOW       | fixing the random seed is allowed
edge-cases#mode = MIXIN       | edge cases are mixed in
edge-cases#total = 16         | # of all combined edge cases
edge-cases#tried = 16         | # of edge cases tried in current run
seed = -4325609074230945382   | random seed to reproduce generated values


timestamp = 2025-04-27T11:03:57.543605300, RomanToIntegerPropertyTest:testRomanToIntegerProportionality = 
                              |-----------------------jqwik-----------------------
tries = 1000                  | # of calls to property
checks = 1000                 | # of not rejected calls
generation = RANDOMIZED       | parameters are randomly generated
after-failure = SAMPLE_FIRST  | try previously failed sample, then previous seed
when-fixed-seed = ALLOW       | fixing the random seed is allowed
edge-cases#mode = MIXIN       | edge cases are mixed in
edge-cases#total = 15         | # of all combined edge cases
edge-cases#tried = 15         | # of edge cases tried in current run
seed = -5270124281404116480   | random seed to reproduce generated values
```
