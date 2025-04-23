# Solution ZerosToEnd

## Task 1
We added the following test cases:
- `testBasicCase`
- `testAllZeros`
- `testNoZeros`
- `testEmptyArray`
- `testArrayExceedingSizeConstraint`
- `testArrayWithExactly10Elements`

The last test case (`testArrayWithExactly10Elements`) has failed, because the code contained the following bug:
```java
if(arr.length == 0 || arr.length >= 10){
    return new int[0];
}
```
You can see that the condition `arr.length >= 10` is wrong, because it should be `arr.length > 10`, since array lengths of 10 are allowed according to the specification. So we changed the code to:
```java
if(arr.length == 0 || arr.length > 10){
    return new int[0];
}
```
We achieved 100% line coverage in the ZerosToEnd.java file when checking coverage with JaCoCo.

## Task 2
We defined the following preconditions based on the README.md file:
- The input array cannot be null.
- The input array contains integers and must have a size between 0 and 10.

We defined the following postconditions:
- The output array is not null.
- The output array contains integers and must have a size between 0 and 10.

We also found the following invariants:
- The length of the input and output arrays must be the same.
- The input and output arrays must contain the same integers in the same order (except for zeros).
- The output array must contain the same number of zeros as the input array.

## Task 3
We added the following tests for the preconditions:
- `testPreconditions_NullArray`
- `testPreconditions_ArrayExceedingSize`

We added the following tests for the postconditions:
- `testPostconditions_ResultNotNull`
- `testPostconditions_ResultSizeWithinBounds`

We added the following tests for the invariants:
- `testInvariants_LengthUnchanged`
- `testInvariants_SameNonZeroElements`
- `testInvariants_SameNumberOfZeros`

## Task 4
We defined 3 properties:
1) In the result array, if there are zeros, they all must be moved to the end of the array.

For this property, we needed to provide an array with a maximum length of 10 that is guaranteed to include some zeros. We created a provider method for that. After running the the `moveZerosToEnd()` method, we check the result array in a for loop and as soon as the first zero appears, a flag variable is set to true and if a non-zero element appears while the flag is already true, the test fails, because this means that a non-zero element follows a zero element, violating the property.

2) The order of the non-zero elements must be preserved.

For this property, we provide an array with random integers of a maximum length of 10. We then execute the `moveZerosToEnd()` method. Then we remove all the zero elements from the result array and the input array. Then we compare them if they are equal. If yes, the order is preserved and the test passes.

3) The number of zeros in the result array must be equal to the number of zeros in the input array.

To test this property, we decided to provide an array of a maximum length of 10 that includes only 0s and 1s to increase the likelyhood that several 0s are included. We then call the `moveZerosToEnd()` method and check if the number of zeros in the result array is equal to the number of zeros in the input array. If yes, the test passes.

