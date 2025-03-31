# Solution StringTransformer
## Part 1: Requirements Testing
### Step 1: Understanding the requirements, inputs and outputs
#### The input:
The input consists of two string arguments that each consist of any combination of characters.
#### What the method should do:
The method should perform the "Edit Distance" DP algorithm on the two input strings. The algorithm should calculate the minimum number of operations required to transform one string into the other, while valid operations are the addition, deletion or replacement of a single character.
#### The output:
The output is an integer representing the minimum number of operations required to transform the start string into the target string using the aforementioned operations.

### Step 2: Explore what the program does for various inputs
We have tested some examples to understand the behavior of the program. Once we were confident, we moved to the next step.

### Step 3: Explore possible inputs and outputs, and identify partitions
We first focus on partitions of the first input string. Here are some obvious partitions we identified:
- Partition 1: The start string is empty.
- Partition 2: The start string contains one character.
- Partition 3: The start string contains multiple characters.
- Partition 4: The start string contains a sequence of characters including some special characters.

We also thought about including some characters which may be recognized as escape characters in some circumstances, such as "\n" or "\t". Unfortunately, the specification tells nothing about how these characters are handled, but we define a partition anyway:
- Partition 5: The start string contains a sequence of characters including some escape characters, such as "\n" or "\t".

Then we focus on partitions of the second input string. Its partitions are similar to the first input string:
- Partition 6: The target string is empty.
- Partition 7: The target string contains one character.
- Partition 8: The target string contains multiple characters.
- Partition 9: The target string contains a sequence of characters including some special characters.
- Partition 10: The target string contains a sequence of characters including some escape characters, such as "\n" or "\t".

Now we go to the next step.

### Step 4: Analyze the boundaries

There are no boundaries here in a classic sense. However, we could consider a boundary whether the two input strings are equal (off-point) or differ in one single operation (on-point) giving a result of 1. We can consider the following additional partitions:
- Partition 11: The start string is equal to the target string.
- Partition 12: The start string is one insert operation away from the target string.
- Partition 13: The start string is one replace operation away from the target string.
- Partition 14: The start string is one delete operation away from the target string.

### Step 5: Devise test cases

Now we want to create test cases. First, we want to focus on combinations of partitions 1 to 3 and 6 to 8. If we combine everything, we would end up with 9 test cases. However, we feel that we could eliminate the combinations 2-8 and 3-7, since it feels similar to 3-8. Additionally, the combination 1-8 feels very similar to 1-7 and 2-7 feels similar to 2-6. We have devised the following 5 test cases:
- Test case 1: The start string is empty and the target string is empty.
- Test case 2: The start string is empty and the target string contains one character.
- Test case 3: The start string contains one character and the target string is empty.
- Test case 4: The start string contains one character and the target string contains one character (which are not identical).
- Test case 5: The start string contains multiple characters and the target string contains multiple characters (but not equal length)

Now we want to consider partitions 4, 5, 9 and 10. We think that it's enough to consider the combinations 4-9 and 5-10 to not overshoot with too many test cases:
- Test case 6: The start string contains a sequence of characters including some special characters and the target string contains a sequence of characters including some special characters.
- Test case 7: The start string contains a sequence of characters including some escape characters and the target string contains a sequence of characters including some escape characters.

From our boundary analysis, we want to devise test cases directly from partitions 11 to 14:
- Test case 8: The start string is equal to the target string.
- Test case 9: The start string is one insert operation away from the target string.
- Test case 10: The start string is one replace operation away from the target string.
- Test case 11: The start string is one delete operation away from the target string.

We have now devised 11 test cases. We think that this is enough for now.

### Step 6: Automate the test cases

Look into the test file for the implementation of the 11 test cases.
We run all the 11 test cases and they all pass.

### Step 7: Augment the test suite with creativity and experience

We decided to continue with structural testing, since we feel it's often more effective to find missing test cases instead of continuing with this sort of "black box" style requirements testing.

## Part 2: Structural Testing

### Step 1: Perform specification based testing

We have already performed specification-based testing in Part 1. We will now continue with structural testing.

### Step 2: Read the implementation and understand the main coding decisions made by the developer

The implementation of the "StringTransformer" class is based on the "Edit Distance" dynamic programming algorithm. The algorithm calculates the minimum number of operations required to transform one string into the other, while valid operations are the addition, deletion or replacement of a single character. The algorithm is implemented in the "editDistance" method, which takes two strings as input and returns an integer representing the minimum number of operations required to transform the start string into the target string.

### Step 3: Run the devised test cases with a code coverage tool

We have run the devised test cases with the Jacoco code coverage tool. We have achieved 100% line and path coverage with only 11 test cases! Isn't that efficient? But we first need to find out if those 11 test cases can stand the mutation testing.

### Step 4: For each piece of code that is not covered, understand the issue and decide if it deserves a test

We can skip this.

### Step 5: Look for other interesting pieces of the code

We didn't come up with particularly interesting test cases so we went to mutation testing.

## Part 3: Mutation Testing

We did mutation testing using Pitest and got the following result:
>> Line Coverage (for mutated classes only): 14/15 (93%)
>> 2 tests examined
>> Generated 21 mutations Killed 21 (100%)
>> Mutations with no coverage 0. Test strength 100%
>> Ran 34 tests (1.62 tests per mutation)

As you can see, we got all the mutants killed. The only line that was not covered is the class header, hence the 93% line coverage. But this line is not important to us. So we are confident that the test suite is strong enough.