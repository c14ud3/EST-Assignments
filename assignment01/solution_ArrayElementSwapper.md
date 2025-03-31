# Array Element Swapper

## 1. Specification-based testing

### 1.1 Understand the requirement
Done.

### 1.2 Explore the program, in-/outputs
To explore the program, `testMultipleMixedNumbers` (renamed in later progress) has been created and further extended.

### 1.3 Identify partitions
We identified the following partitions:
- Empty array: return empty array
- Array contains exactly one (positive or negative) element: return array
- Array contains multiple positive elements: return array
- Array contains multiple negative elements: return array
- Array contains multiple positive & negative elements: return ordered array

### 1.4 Analyze the boundaries
The boundary condition is the following: `input[index] >= 0`. 

### 1.5, 1.6 Devise & automate test cases
We came up with the following test cases: `testEmptyArray`, `testSinglePositiveElementArray`, `testSingleNegativeElementArray`, `testSingleZeroInElementArray`, `testOnlyPositiveNumbers`, `testOnlyNegativeNumbers`, `testMultipleMixedNumbers`.
The boundary is tested in `testSingleZeroInElementArray`.

### 1.7 Augment
During augmentation, we realized that the function did create a new array, what was clearly not wished in the README, so we have re-written the function.


## 2. Structural testing
Here, we realized that we did not check on the null array (`testNullArray`) and the instantiation (`testInstantiation`) of the swapper. After extension, we got 100% instruction & branch coverage.


## 3. Mutation testing
We performed mutation testing and got a mutation coverage of 93%. The survived mutation was found on line `if (numbers == null || numbers.length <= 1) {` where the `<= 1` is changed to `< 1`. However, we can't really fix this, since in this case just nothing happens and there can't be a proper assertion in `testEmptyArray`, since the funcition doesn't return anything.