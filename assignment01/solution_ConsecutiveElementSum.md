# Consecutive Element Sum

## 1. Specification-based testing

### 1.1 Understand the requirement
Done.

### 1.2, 1.3 Explore the program, in-/outputs and identify partitions
To explore the program, `testSimpleNumbers` has been created and further extended.

### 1.4 Analyze the boundaries
We identified the following boundaries:
- Empty array: the sum should be 0
- Array contains exactly one (positive or negative) element: sum should be element
- Array contains multiple positive elements: sum should be the sum of all elements
- Array contains multiple negative elements: sum should be nearest element to 0
- Array contains multiple positive & negative elements: sum should be consecutive elements sum

### 1.5, 1.6 Devise & automate test cases
We came up with the following test cases: `testEmptyArray`, `testNullArray`, `testSinglePositiveElement`, `testSingleNegativeElement`, `testMultiplePositiveElements`, `testMultipleNegativeElements`, `testMultiplePositiveAndNegativeElements`.

### 1.7 Augment
During augmentation, we realized that we could also test for the input `[0]`, so we created `testSingleZeroElement`. Also, we created a test, where there is a large number far away from the others to test whether this works aswell: `testLargeNumberFarAway`.


## 2. Structural testing
Here, we especially lookd at the `if` statement and the `for` loop. For the `if`, already all branches are tested (`numbers == null`, `numbers.length == 0` and none of both). For the `for` loop, we want to check zero, one and multiple iterations. Zero iteration is not possible, since `numbers.length == 0` is already catched before. Mutliple iterations is already checked aswell with more than two inputs. However, we need to add a test case for exactly one loop iteration, which happens when the input array contains exactly two elements: `testTwoElements`. Also, we want to test the instantiation of the class: `testInstantiation`. We now have zero missed instructions or branches.


## 3. Mutation testing
We performed mutation testing and got a mutation coverage of 100%.