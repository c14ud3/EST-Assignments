# Solution SortedArray2BST

## Task 1
We have written the following test cases:
- `testValidSortedArray()`: This test case checks the conversion of a sorted array to a height-balanced BST given a valid input according to the README.md file.
- `testSingleElementArray()`: This test case checks the behavior of the function when a single-element array is provided as input.
- `testTwoElementArray()`: This test case checks the behavior of the function when a two-element array is provided as input.
- `testEvenLengthArray()`: This test case checks the behavior of the function when an even-length array is provided as input.

When performing the tests, the test case `testEvenLengthArray()` failed. We got the following output:
```
org.opentest4j.AssertionFailedError:
Expected :[2, 1, 3, null, null, null, 4]
Actual   :[1, null, 3, null, null, 2, 4]
```
You can see that the actual output does not follow the specification, because it is not height-balanced.
It turned out that there was an unnecessary piece of code which set the `mid` index to the very left index of the array (the last index of the array), which resulted in an unbalanced BST:
```java
if ((right - left + 1) % 2 == 0) {
    mid = Math.max(left, mid - 1);  // Ensure mid does not fall below left
}
```
So we outcommented this piece of code and the test case passed.
The output of the `sortedArray2BST()` method is a TreeNode object which represents the root. To convert it to the desired array, we also call the `levelOrder()` method in each test to convert it to a list.

We got 100% JaCoCo line coverage.

## Task 2
We defined the following preconditions that are taken directly from the README.md file:
- The input array contains only integers and no null elements.
- The input array is sorted in a strictly increasing order.
- The input array cannot be null or empty.



Then we defined the following postconditions:
- The output array contains only distinct integers and (not always) null elements.
- For every integer at index i in the output array, the element at index 2*i+1 is not allowed to be an integer larger than or equal the integer at index i.
- For every integer at index i in the output array, the element at index 2*i+2 is not allowed to be an integer smaller than or equal the integer at index i.
- For every null value at index i in the output array, the index 2*i+1 must be greater than the size of the array. This ensures that null values only appear on the bottom level of the BST.
- The output array has a length of 2^k-1 for any integer k > 0.

We also found two invariants:
- Disregarding any null values, the input and the output arrays must contain the same integers.

We created four methods: `checkPreconditions()` (called inside `sortedArray2BST()`) and `checkPostconditions()` (called inside `levelOrder()`, because this is the final method that produces the result) in the SortedArray2BST.java file. The `checkPreconditions()` method checks if all preconditions listed above are met and returns an InvalidArgumentError with a fitting message otherwise. The `checkPostconditions()` method checks if the output meets the postconditions. If not, it throws an IllegalStateException (we have chosen this error because the application is in an illegal state when a postcondition is not met) with a fitting message.
We then created the methods `checkInvariantsPre()` and `checkInvariantsPost()`, while the first method returns the integers in an array (saved in the `storage` variable), while the latter one checks if those (and only those) integers are in the output array.

## Task 3

For the preconditions, we have added the following tests:
- `testPreconditions_NullArray()`: This test case checks the behavior of the function when a null array is provided as input.
- `testPreconditions_EmptyArray()`: This test case checks the behavior of the function when an empty array is provided as input.
- `testPreconditions_DuplicateElements()`: This test case checks the behavior of the function when an array with duplicate elements is provided as input.
- `testPreconditions_UnsortedArray()`: This test case checks the behavior of the function when an unsorted array is provided as input.

For the postconditions, we have added the following tests:
- `testPostconditions_LevelBalancedTree()`: This test case checks the behavior of the function when a level-balanced tree is provided as input.
- `testPostconditions_CompleteTree()`: This test case checks the behavior of the function when a complete tree is provided as input.

We have also added two tests for the invariants:
- `testInvariants_InputArrayPreserved()`
- `testInvariants_NoExtraElementsInTree()`
Those tests check if the invariant holds. For the postcondition and the invariant tests, we cannot achieve 100% line coverage, because it's not possible to trigger all the errors that could happen.

## Task 4

We defined the following properties:
1) The returned list contains all integers from the input array and only them.

We created a property test called `testSortedArrayToBST_AllElementsContained` to check this. We used a provider method to generate a sorted array of distinct integers. We then called the `sortedArray2BST()` method and the `levelOrder()` methods and checked if the output list contains all integers from the input array and only them.

2) The returned list is a level-order representation of the BST.

We created a property test called `testSortedArrayToBST_BSTProperty` to verify this. We used the same provider method as above. We created an external method that check that of any node, the left child is smaller and the right child is larger (if exists and not null).

3) The BST represented in the list is height-balanced.

We created a property test called `testSortedArrayToBST_Balanced` to check this. Again, we used the same provider method as above. We created an external method that checks if there are no null values within the first half of the output list (which corresponds to all the non-leaf nodes).
```
timestamp = 2025-04-27T11:02:44.169547, SortedArray2BSTPropertyTest:testSortedArrayToBST BSTProperty = 
                              |-----------------------jqwik-----------------------
tries = 1000                  | # of calls to property
checks = 1000                 | # of not rejected calls
generation = RANDOMIZED       | parameters are randomly generated
after-failure = SAMPLE_FIRST  | try previously failed sample, then previous seed
when-fixed-seed = ALLOW       | fixing the random seed is allowed
edge-cases#mode = MIXIN       | edge cases are mixed in
edge-cases#total = 9          | # of all combined edge cases
edge-cases#tried = 9          | # of edge cases tried in current run
seed = 2016560431997019328    | random seed to reproduce generated values


timestamp = 2025-04-27T11:02:44.250071500, SortedArray2BSTPropertyTest:testSortedArrayToBST AllElementsContained = 
                              |-----------------------jqwik-----------------------
tries = 1000                  | # of calls to property
checks = 1000                 | # of not rejected calls
generation = RANDOMIZED       | parameters are randomly generated
after-failure = SAMPLE_FIRST  | try previously failed sample, then previous seed
when-fixed-seed = ALLOW       | fixing the random seed is allowed
edge-cases#mode = MIXIN       | edge cases are mixed in
edge-cases#total = 9          | # of all combined edge cases
edge-cases#tried = 9          | # of edge cases tried in current run
seed = -3923392400926425813   | random seed to reproduce generated values


timestamp = 2025-04-27T11:02:44.317391600, SortedArray2BSTPropertyTest:testSortedArrayToBST Balanced = 
                              |-----------------------jqwik-----------------------
tries = 1000                  | # of calls to property
checks = 1000                 | # of not rejected calls
generation = RANDOMIZED       | parameters are randomly generated
after-failure = SAMPLE_FIRST  | try previously failed sample, then previous seed
when-fixed-seed = ALLOW       | fixing the random seed is allowed
edge-cases#mode = MIXIN       | edge cases are mixed in
edge-cases#total = 9          | # of all combined edge cases
edge-cases#tried = 9          | # of edge cases tried in current run
seed = 228839306571112709     | random seed to reproduce generated values
```