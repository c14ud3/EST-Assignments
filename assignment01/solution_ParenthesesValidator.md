# Solution ParenthesesValidator
## Part 1: Requirements Testing
### Step 1: Understanding the requirements, inputs and outputs
#### The inputs:
The input consists of a string containing only the characters: '(', ')', '{', '}', '[' and ']'. No other character types are permitted in the input.
#### What the method should do:
The method checks if for every opening bracket, there is a closing bracket of the same type. Furthermore, the brackets must be closed in the correct order. If we imagine an opening bracket adds one unit of depth and a closing bracket removes one unit of depth, if an opening bracket increases for example the depth from 2 to 3, its corresponding closing bracket must decrease the depth from 3 to 2.
#### The output:
The output is a boolean value: true if the string is valid as per the rules above, otherwise false.

### Step 2: Explore what the program does for various inputs
We have tested some examples to understand the behavior of the program. Once we were confident, we moved to the next step.

### Step 3: Explore possible inputs and outputs, and identify partitions
We first focus on the so-called "good weather" scenarios, where we expect the program to return true. In this case, we can consider the following partitions:
- Partition 1: The input string is empty.
- Partition 2: The input string contains a valid sequence of brackets with only one type of bracket.

With partition 2, it shouldn't matter which type of bracket we use, as long as we only use one type. This should be regarded as equivalent. Testing every single type of bracket would not be efficient. (Well, in this case, it obviously isn't too much additional work, but we want to demonstrate that we should be somewhat efficient at this point and pretend to be lazy (and good) software testers.) We then found more partitions:
- Partition 3: The input string contains a valid sequence of brackets, where no nested brackets are present.
- Partition 4: The input string contains a valid sequence of brackets, where the first half only are opening brackets and the second half only closing brackets.
- Partition 5: The input string contains a valid sequence of brackets, without any further restrictions.

Since we don't have multiple input variables, we can't combine partitions of multiple input variables. However, it makes sense to combine partitions 2 and 3, e.g. a string that includes only one type of brackets and no nested brackets. Furthermore, it also makes sense to combine partitions 2 and 4, e.g. a string that includes only one type of brackets and the first half only opening brackets and the second half only closing brackets. So we add the following partitions:
- Partition 6: The input string contains a valid sequence of brackets with only one type of bracket and no nested brackets.
- Partition 7: The input string contains a valid sequence of brackets with only one type of bracket, where the first half only opening brackets and the second half only closing brackets.

Now we focus on the "bad weather" scenarios, where we expect the program to fail. In this case, we can consider the following partitions:
- Partition 8: The input string contains an invalid sequence of brackets, that contains more opening brackets than closing brackets, but the order of brackets is correct.
- Partition 9: The input string contains an invalid sequence of brackets, that contains more closing brackets than opening brackets, but the order of brackets is correct.
- Partition 10: The input string contains an invalid sequence of brackets, where the number of opening and closing brackets is equal, but the order is incorrect.

### Step 4: Analyze the boundaries
We don't have the classical on-point scenarios in this case, because we don't have operators such as ">=", "<" or "==". Basically every case of a partition from step 3 can be considered an on-point test, since the addition, removal or change of one single character from the input string should turn the result to false. However, we can still consider those cases as off-point tests, where the method returns false, but only one bracket needs to be added, changed or removed to make the string valid. We can consider the following boundaries:
- Boundary 1: One opening bracket is missing.
- Boundary 2: One closing bracket is missing.
- Boundary 3: There is one opening bracket too many. (this is the same as if one closing bracket is missing)
- Boundary 4: There is one closing bracket too many. (this is the same as if one opening bracket is missing)
- Boundary 5: One opening bracket has been changed to a closing bracket or vice versa.
- Boundary 6: One bracket of one type has been changed to another type.

### Step 5: Devise test cases
We want to include one test case for each partition and boundary. We have devised the following test cases:

The following test cases should return true:
- Test case 1: The input string is empty.
- Test case 2: The input string contains only one type of bracket.
- Test case 3: No nested brackets are present.
- Test case 4: The first half only contains opening brackets and the second half only closing brackets.
- Test case 5: The input string contains only one type of bracket and no nested brackets.
- Test case 6: The input string contains only one type of bracket, where the first half only contains opening brackets and the second half only closing brackets.
- Test case 7: The input string contains a valid sequence without any restrictions mentioned above.

The following test cases should return false:
- Test case 8: One opening bracket is missing.
- Test case 9: One closing bracket is missing.
- Test case 10: One opening bracket has been changed to a closing bracket.
- Test case 11: One closing bracket has been changed to an opening bracket.
- Test case 12: One opening bracket has been changed to a different type of opening bracket.
- Test case 13: One closing bracket has been changed to a different type of closing bracket.

### Step 6: Automate the test cases

Look into the test file for the implementation of the 13 test cases.

### Step 7: Augment the test suite with creativity and experience

We already have 13 test cases, which feels already enough to us. We decide to continue with structural testing to see if some test cases are missing and it's not forbidden to come back to this step if needed.

## Part 2: Structural Testing

### Step 1: Perform specification based testing
We have already done this.
### Step 2: Read the implementation and understand the main coding decisions made by the developer
It's not very hard to understand this code so there isn't much to say. We also didn't spot any error first-hand.
### Step 3: Run the devised test cases with a code coverage tool
Using Jacoco, we got 100% line and path coverage.
### Step 4: For each piece of code that is not covered, understand the issue and decide if it deserves a test
Since we have 100% line and path coverage, we don't have to do this.
### Step 5: Look for other interesting pieces of the code
We think that we don't have to do this either, because the method is relatively simple. Of course we could test it with a string that includes other characters than parentheses, but it's obvious to us by looking at the code that it will just return "false" in that case. Moreover, the specification explicitly states that the input string will only contain parentheses. Even if this is structural testing, it makes no sense to test things that are obviously excluded by the specification, and it just wastes time (keep efficiency in mind).

## Part 3: Mutation Testing

We ran Pitest and got the following report:
>> Line Coverage (for mutated classes only): 7/8 (88%)
>> Generated 8 mutations Killed 8 (100%)
>> Mutations with no coverage 0. Test strength 100%
>> Ran 15 tests (1.88 tests per mutation)

We can see that we got 100% of mutants killed. Line coverage is only 88%, however a quick investigation in the "index.html" file in the "target" folder shows that the uncovered line is line 5, which is the class definition.
We are happy with the results and don't see the need to add more tests.

