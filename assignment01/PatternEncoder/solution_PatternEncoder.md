# Solution PatternEncoder
## Part 1: Requirements Testing
### Step 1: Understanding the requirements, inputs and outputs
#### The inputs:
The input consists of a string input that consists of any combination of lowercase letters and may include spaces. No other character types are permitted in the input.
#### What the method should do:
The method must identify and compress consecutive repeated substrings. If a substring is repeated consecutively, it should be replaced by the number of repetitions followed by the substring enclosed in square brackets. Non-repeated substrings or characters should remain unchanged.
#### The output:
The output is a string representing the encoded version of the input string according to the rules above.

### Step 2: Explore what the program does for various inputs
We have tested some examples to understand the behavior of the program. Once we were confident, we moved to the next step.

### Step 3: Explore possible inputs and outputs, and identify partitions
A first partition is the input with an empty string. This should return an empty string as well:
- Partition 1: The input string is empty.
Then, we thought of loop testing, so in addition to an empty string, one partition could be with one character and other partitions with many characters:
- Partition 2: The input string contains one character.
However, regarding many characters, we also have to decide which compressions we want to include. We decided for the following:
- Partition 3: The input string contains a sequence of characters, where no character is repeated.
- Partition 4: The input string contains a sequence of characters, where one character is repeated once.
- Partition 5: The input string contains a sequence of characters, where multiple characters are repeated once.
But characters could be repeated more than once, so we also have to consider this:
- Partition 6: The input string contains a sequence of characters, where one character is repeated more than once.
- Partition 7: The input string contains a sequence of characters, where multiple characters are repeated more than once, but not the same number of times.
Now we not only have single characters that could repeat, but also substrings consisting of multiple characters:
- Partition 8: The input string contains a sequence of characters, where one substring is repeated once.
- Partition 9: The input string contains a sequence of characters, where one substring is repeated more than once.
- Partition 10: The input string contains a sequence of characters, where multiple substrings are repeated more than once, but not the same number of times.
We also thought about how the method should behave if repeated substrings appear in a nested manner:
Example: "ababcababc" should be encoded as"2[2[ab]c]".
Note that "ababc" appears twice and should be compressed, but "ab" also appears twice in one single "ababc".
- Partition 11: The input string contains a sequence of characters, where one substring is repeated more than once in a nested manner.
- Partition 12: The input string contains a sequence of characters, where multiple substrings are repeated more than once in a nested manner, but not the same number of times.

### Step 4: Analyze the boundaries
We don't have the classical on-point scenarios in this case, because we don't have operators such as ">=", "<" or "==" or an output that is either true or false. So as mentioned in step 3, we rely on the principle "zero - one - multiple" which applies to number of occurrences of compressible substrings, number of characters within those substrings and levels of nesting.

### Step 5: Devise test cases
We want to include one test case for each partition. We have devised the following test cases:
- Test case 1: The input string is empty.
- Test case 2: The input string contains one character.
- Test case 3: The input string contains a sequence of characters, where no character is repeated.
- Test case 4: The input string contains a sequence of characters, where one character is repeated once.
- Test case 5: The input string contains a sequence of characters, where multiple characters are repeated once.
- Test case 6: The input string contains a sequence of characters, where one character is repeated more than once.
- Test case 7: The input string contains a sequence of characters, where multiple characters are repeated more than once, but not the same number of times.
- Test case 8: The input string contains a sequence of characters, where one substring is repeated once.
- Test case 9: The input string contains a sequence of characters, where one substring is repeated more than once.
- Test case 10: The input string contains a sequence of characters, where multiple substrings are repeated more than once, but not the same number of times.
- Test case 11: The input string contains a sequence of characters, where one substring is repeated more than once in a nested manner.
- Test case 12: The input string contains a sequence of characters, where multiple substrings are repeated more than once in a nested manner, but not the same number of times.

### Step 6: Automate the test cases

Look into the test file for the implementation of the 12 test cases.

### Step 7: Augment the test suite with creativity and experience

We already have 13 test cases, which feels already enough to us. We decide to continue with structural testing to see if some test cases are missing and it's not forbidden to come back to this step if needed.
