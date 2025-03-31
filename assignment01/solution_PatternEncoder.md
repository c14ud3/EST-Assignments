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
We have tested some examples to understand the behavior of the program. We must admit that the specification was a bit unclear to us, since in the example given, the encoded string was even longer than the original one, and nested substrings also are not mentioned in the requirements, despite being an obvious pattern. However, we peeked into the implementation code to really find out what the method is supposed to do exactly. And indeed, nesting should not be considered and the method only considers substrings consisting of identical characters to compress, and it actually may be possible that encoded strings are longer than their respective input string. Once we were confident, we moved to the next step.

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
Now we not only have single characters that could repeat, but also substrings consisting of multiple characters may repeat. However, those shouldn't be compressed:
- Partition 8: The input string contains a sequence of characters, where one substring of multiple different characters is repeated.
Now we also want to consider mixing characters that should be compressed and characters that shouldn't. We want to consider the compressible substring to appear at the beginning, somewhere in the middle and at the end. We also consider what happens if multiple compressible substrings appear:
- Partition 9: The input string contains a sequence of characters, where one substring appears at the beginning, followed by some other characters.
- Partition 10: The input string contains a sequence of characters, where one substring appears in the middle, surrounded by some other characters.
- Partition 11: The input string contains a sequence of characters, where one substring appears at the end, preceded by some other characters.
- Partition 12: The input string contains a sequence of characters, where multiple substrings appear at different positions.

### Step 4: Analyze the boundaries
We don't have the classical on-point scenarios in this case, because we don't have operators such as ">=", "<" or "==" or an output that is either true or false. So as mentioned in step 3, we rely on the principle "zero - one - multiple" which applies to number of occurrences of compressible substrings and the number of characters within those substrings.

### Step 5: Devise test cases
We want to include one test case for each partition. We have devised the following test cases:
- Test case 1: The input string is empty.
- Test case 2: The input string contains one character.
- Test case 3: The input string contains a sequence of characters, where no character is repeated.
- Test case 4: The input string contains a sequence of characters, where one character is repeated once.
- Test case 5: The input string contains a sequence of characters, where multiple characters are repeated once.
- Test case 6: The input string contains a sequence of characters, where one character is repeated more than once.
- Test case 7: The input string contains a sequence of characters, where multiple characters are repeated more than once, but not the same number of times.
- Test case 8: The input string contains a sequence of characters, where one substring of multiple different characters is repeated.
- Test case 9: The input string contains a sequence of characters, where one substring appears at the beginning, followed by some other characters.
- Test case 10: The input string contains a sequence of characters, where one substring appears in the middle, surrounded by some other characters.
- Test case 11: The input string contains a sequence of characters, where one substring appears at the end, preceded by some other characters.
- Test case 12: The input string contains a sequence of characters, where multiple substrings appear at different positions.

### Step 6: Automate the test cases

Look into the test file for the implementation of the 12 test cases. We ran them and they all succeeded.

### Step 7: Augment the test suite with creativity and experience

We already have 12 test cases, which feels already enough to us. We decide to continue with structural testing to see if some test cases are missing and it's not forbidden to come back to this step if needed.

## Part 2: Structural Testing

### Step 1: Perform specification based testing
We have already done this.
### Step 2: Read the implementation and understand the main coding decisions made by the developer
It's not very hard to understand this code. However, we found that the code also checks whether the input string is null, so we add a test case for that:
- Test case 13: The input string is null. The output should also be null.
### Step 3: Run the devised test cases with a code coverage tool
Using Jacoco, we got 100% line and path coverage.
### Step 4: For each piece of code that is not covered, understand the issue and decide if it deserves a test
Since we have 100% line and path coverage, we don't have to do this.
### Step 5: Look for other interesting pieces of the code
We believe that those 13 tests are already enough. But mutation testing will show.

## Part 3: Mutation Testing

We ran Pitest and got the following report:
>> Line Coverage (for mutated classes only): 15/16 (94%)
>> 2 tests examined
>> Generated 16 mutations Killed 16 (100%)
>> Mutations with no coverage 0. Test strength 100%
>> Ran 20 tests (1.25 tests per mutation)

The mutation testing was successful. The one line not tested regarding line coverage is the class header, which doesn't include functionality we want to test. We are confident that the method is well-tested and works as expected.