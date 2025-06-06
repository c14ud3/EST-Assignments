# Event Scheduler

## 1. Specification-based testing

### 1.1 Understand the requirement
Done.

### 1.2 Explore the program, in-/outputs
To explore the program, `testSimpleEvents` has been created and further extended.

### 1.3 Identify partitions
We identified the following partitions:
- Empty array on dimension 1 or 2: no conflict
- Null array on dimension 2: no conflict
- Only one event: no conflict
- Multiple events, not overlapping: no conflict
- Multiple events, touching but not overlapping: no conflict
- Multiple events, overlapping: conflict
- Exception: event-array has not exactly 2 integers

### 1.4 Analyze the boundaries
The found boundary is here, given events a and b the following: `a.startTime() < b.endTime() || b.startTime() < a.endTime()`.
The off-point condition is thereby `a.startTime() == b.endTime()`, while the on-point condition is if there is an overlapping of exactly 1.

### 1.5, 1.6 Devise & automate test cases
We came up with the following test cases: `testEmptyEvents1`, `testEmptyEvents2`, `testNullArray`, `testOnlyOneEvent`, `testMultipleEventsNotOverlapping`, `testMultipleEventsOverlapping`, `testTooFewIntegers`, `testTooManyIntegers`. We realized that the tests `testTooFewIntegers` and `testTooManyIntegers` failed, since there was a check missing. We added it: `if (events[i].length != 2) return false;`.
The boundaries are checked in `testMultipleEventsTouching` (off-point) and `testMultipleEventsOverlapping` (on-point).

### 1.7 Augment
Nothing new here.


## 2. Structural testing
We added the test of the instantiation of the class: `testInstantiation`. We now have zero missed instructions or branches.


## 3. Mutation testing
We performed mutation testing and realized that we might check whether or not the `events` array really is sorted after the call to `Arrays.sort`. Even if this new test `testArraySorting` is heavily dependent on the implementation, we think it is still worth it. After that, we got a mutation coverage of 100%.