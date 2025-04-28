# LCP

## Task 1: Code Coverage

With the test function `testSimpleExamples`, we already received full line coverage.


## Task 2: Designing Contracts
Identified preconditions:
- The array strs has atlast 1 string
- Each string in the array can only be lowercase english letters
- If one of the input strings is empty, an exception should be thrown, that a non-empty string should be passed.


Identified postconditions:
- If one of the input strings is empty, an exception should be thrown, that a non-empty string should be passed.


These pre- and post- conditions then have been implemented:

```java
...
if (strs[0] == null) throw new IllegalArgumentException("Please enter a non-empty string");      
...        
if (strs.length == 0) throw new IllegalArgumentException("Please enter atleast 1 string");
for (int i = 0; i < strs.length; i++) {
    if (strs[i] == null) throw new IllegalArgumentException("Please enter a non-empty string");
        }
```

## Task 3: Testing Contracts

For the pre- and post-conditions, we created the following test cases: `testSingleString`, and used further fron `testSimpleExamples`.

## Task 4: Property-Based Testing
To test the properties that are based on the defined contracts, we came up with the following test cases with the jqwik outputs:

`testPropertyLCPPass`:
We tested for valid strings where common prefixes exist. Using a helper function the property test first generates the random string, and then using a helper function computes the longest common prefix. The test then checks if the output of the function is equal to the computed longest common prefix.
```text
timestamp = 2025-04-27T08:30:51.340009, LongestCommonPrefixTest:testPropertyLCP = 
                              |-----------------------jqwik-----------------------
tries = 1000                  | # of calls to property
checks = 1000                 | # of not rejected calls
generation = RANDOMIZED       | parameters are randomly generated
after-failure = SAMPLE_FIRST  | try previously failed sample, then previous seed
when-fixed-seed = ALLOW       | fixing the random seed is allowed
edge-cases#mode = MIXIN       | edge cases are mixed in
edge-cases#total = 4          | # of all combined edge cases
edge-cases#tried = 4          | # of edge cases tried in current run
seed = 1448473376273348398    | random seed to reproduce generated values
```


`testPropertyLCPFail`:
We tested for invalid strings where atleast one is an empty string giving an exception. The test checks if the exception is thrown when the input is an empty string.
```text
timestamp = 2025-04-27T08:32:58.393161300, LongestCommonPrefixTest:testPropertyLCPFail = 
                              |-----------------------jqwik-----------------------
tries = 1000                  | # of calls to property
checks = 1000                 | # of not rejected calls
generation = RANDOMIZED       | parameters are randomly generated
after-failure = SAMPLE_FIRST  | try previously failed sample, then previous seed
when-fixed-seed = ALLOW       | fixing the random seed is allowed
edge-cases#mode = MIXIN       | edge cases are mixed in
edge-cases#total = 2          | # of all combined edge cases
edge-cases#tried = 2          | # of edge cases tried in current run
seed = -8198457025535822187   | random seed to reproduce generated values
```
