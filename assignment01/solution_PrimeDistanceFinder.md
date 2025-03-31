# Solution PrimeDistanceFinder
## Part 1: Requirements Testing
### Step 1: Understanding the requirements, inputs and outputs
#### The input:
The input consists of an array of integer numbers.
#### What the method should do:
The method should find the smallest positive difference between any two prime numbers in the array.
#### The output:
The output is an integer representing the smallest difference between any two prime numbers found in the array. If there are fewer than two prime numbers in the array, return -1.

### Step 2: Explore what the program does for various inputs
We have tested some examples to understand the behavior of the program. Once we were confident, we moved to the next step.

### Step 3: Explore possible inputs and outputs, and identify partitions
A first partition would be an empty array, which should return -1:
- Partition 1: The input array is empty.
A next partition would be an array that contains one integer that is prime:
- Partition 2: The input array contains one integer that is prime.
Another partition with an array of only one integer would be:
- Partition 3: The input array contains one integer that is not prime.
Then, it's also interesting what happens if the array only has one prime number. We want to make 3 partitions here, where the prime number is at the first position of the array, at the last position of the array and at a random position in the array:
- Partition 4: The input array contains multiple integers, where only the first one is prime.
- Partition 5: The input array contains multiple integers, where only the last one is prime.
- Partition 6: The input array contains multiple integers, where a random one is prime which isn't the first or the last one.
There also needs to be a test with an array of multiple integers where none is a prime number:
- Partition 7: The input array contains multiple integers, where none is a prime number.
In those cases, the method should return -1.
Now we need partitions where exactly two prime numbers are in the array and the prime numbers are in ascending order:
- Partition 8: The input array contains two prime numbers in ascending order.
- Partition 9: The input array contains more than two numbers, two of which are prime and the smaller one comes first in the array.
And the same for descending order:
- Partition 10: The input array contains two prime numbers in descending order.
- Partition 11: The input array contains more than two numbers, two of which are prime and the smaller one comes last in the array.
Now how about the case where there are two identical prime numbers?
- Partition 12: The input array contains two identical prime numbers.
Finally, we need to consider the case where there are more than two prime numbers in the array:
- Partition 13: The input array contains more than two prime numbers in ascending order.
- Partition 14: The input array contains more than two prime numbers in descending order.
- Partition 15: The input array contains more than two prime numbers in random order where the smallest difference is between the first and the second prime number.
- Partition 16: The input array contains more than two prime numbers in random order where the smallest difference is between the last and the second last prime number.
- Partition 17: The input array contains more than two prime numbers in random order where the smallest difference is between the first and the last prime number.
We think that those are enough partitions to cover the requirements for now.

### Step 4: Analyze the boundaries
The boundaries occur between cases where -1 is returned and cases where a distance is returned. As an on-point test we could consider an array where a distance is returned and we delete just one prime number, a -1 is returned. This should be the case with input arrays containing two prime numbers. We already have partitions 8 through 12 to cover those cases.

### Step 5: Devise test cases
We want to include one test case for each partition. We have devised the following test cases:
- Test case 1: The input array is empty.
- Test case 2: The input array contains one integer that is prime.
- Test case 3: The input array contains one integer that is not prime.
- Test case 4: The input array contains multiple integers, where only the first one is prime.
- Test case 5: The input array contains multiple integers, where only the last one is prime.
- Test case 6: The input array contains multiple integers, where a random one is prime which isn't the first or the last one.
- Test case 7: The input array contains multiple integers, where none is a prime number.
- Test case 8: The input array contains two prime numbers in ascending order.
- Test case 9: The input array contains more than two numbers, two of which are prime and the smaller one comes first in the array.
- Test case 10: The input array contains two prime numbers in descending order.
- Test case 11: The input array contains more than two numbers, two of which are prime and the smaller one comes last in the array.
- Test case 12: The input array contains two identical prime numbers.
- Test case 13: The input array contains more than two prime numbers in ascending order.
- Test case 14: The input array contains more than two prime numbers in descending order.
- Test case 15: The input array contains more than two prime numbers in random order where the smallest difference is between the first and the second prime number.
- Test case 16: The input array contains more than two prime numbers in random order where the smallest difference is between the last and the second last prime number.
- Test case 17: The input array contains more than two prime numbers in random order where the smallest difference is between the first and the last prime number.

### Step 6: Automate the test cases

See the test file for the implementation of the 17 test cases. Before running the test cases, we had to add some import statements on the PrimeDistanceFinder file. Then we were able to run the tests and all the tests passed.

### Step 7: Augment the test suite with creativity and experience

It would be an interesting idea to have an array with many prime numbers which all have the same distance to each other. This would be a good test case to see if the method can handle this case correctly. We will add this test case to the test suite.
- Test case 18: The input array contains many prime numbers with the same distance of 2 to each other.
This test has passed as well. We are confident that the method works as expected.

## Part 2: Structural Testing

### Step 1: Perform specification based testing

We have already performed specification based testing in the previous part. We have covered all the partitions and boundaries we could think of.

### Step 2: Read the implementation and understand the main coding decisions made by the developer
It's not very hard to understand this code so there isn't much to say. We also didn't spot any error first-hand.

### Step 3: Run the devised test cases with a code coverage tool
We run the Jacoco coverage tool and it reports that we have achieved 100% line coverage, but only 93% branch coverage. There seems to be one branch that isn't covered yet (15/16).

### Step 4: For each piece of code that is not covered, understand the issue and decide if it deserves a test
A short investigation reveals that the condition in line 42 is only partially covered. More specifically, the isPrime() helper method first checks if a number is smaller than 1 or larger. In fact, we have missed to include any 0s or negative numbers within an array, even if it's allowed by the specification. We add a test to cover this:
- Test case 19: The input array contains a negative number.
The test succeeds and we have now achieved 100% branch coverage as well.

### Step 5: Look for other interesting pieces of the code
We think that we don't have to do this either, because the method is relatively simple.

## Part 3: Mutation Testing

We ran Pitest and got the following report:
> Line Coverage (for mutated classes only): 17/18 (94%)
>> 2 tests examined
>> Generated 23 mutations Killed 20 (87%)
>> Mutations with no coverage 0. Test strength 87%
>> Ran 82 tests (3.57 tests per mutation)

We can see that 3 mutants survived. We will investigate them further:
- The first mutant is a change of the condition on line 29 from "diff < smallestDiff" to "diff <= smallestDiff". This change is not covered by our tests, but we think that it's not necessary to add a test for this case. The difference between two prime numbers can never be 0, so the condition "diff < smallestDiff" is correct.
- The second mutant is a change of the condition on line 42 from "number <= 1" to "number < 1". This change is also not covered by our tests, but we think that it's not necessary to add a test for this case. The condition "number <= 1" is correct, because 1 is not a prime number. So we need to add another test case here where the number 1 appears in the array as a non-prime number:
  - Test case 20: The input array contains the number 1.
- The third mutant changed the return value on line 42 from false to true. We need a test case that consists of an array that contains only negative numbers and expect a -1 as return value:
  - Test case 21: The input array contains only negative numbers.
We run those two tests and both tests pass.
We also run the mutant testing again and get the following report:
>> Line Coverage (for mutated classes only): 17/18 (94%)
>> 2 tests examined
>> Generated 23 mutations Killed 22 (96%)
>> Mutations with no coverage 0. Test strength 96%
>> Ran 68 tests (2.96 tests per mutation)

We see that one mutant is not killed. This is the one from above where we didn't write a test for. We are now happy with the results and don't see the need to add more tests.


