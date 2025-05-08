# Solution Email Notification System

## Task A
### About the tests
Since the method we should test is a void method, we can't check any return values for correctness. This is why we decided to mock the `EmailService` class and assert how many times the `sendEmail()` method was called. It should be called exactly once if the parameters are valid.
So we created a first test case called `notifyUser_validEmail_sendsEmail()` which tests with valid parameters and uses a mock to check that the method is called exactly once.
We also created two additional test cases to test if the method returns the error with the correct message if the email address is either empty or null.
We use a setup and a teardown method to be called for each test to keep the test environment clean and ensure that tests are independent of each other. The setup method creates a mock object of the `EmailService` class and creates the `EmailNotificationSystem`class, and the teardown method resets them to null again.
### Questions
#### 1. What are the external dependencies? Which of these dependencies should be tested using doubles and which should not? Explain your rationale.
The external dependency is the `EmailService` class that contains the method `sendEmail()`. This class connects to a real email server (in this exercise it obviously doesn't, but we pretend that it does). This adds a lot of complexity and causes why tests may fail, such as the email server not being online or working correctly, which has nothing to do with what we want to test. Moreover, test execution may be slow because of the communication through the internet.
This is why we decided to mock this external dependency, so we can count how often the `sendEmail()` method is called from the `notifyUser()` method. It should be called exactly once if the parameters are valid. We don't need to test the `EmailService` class, because it is not part of our implementation. We only want to test the `EmailNotificationSystem` class and its method `notifyUser()`.

#### 2. For the dependencies that should be tested using doubles, should the production code be refactored to make it possible? If so, do the refactoring and implement the tests.
No, the production code doesn't need to be refactored. The `EmailNotificationSystem` class already has a constructor that takes an `EmailService` object as a parameter. This allows us to inject a mock object when we create an instance of the `EmailNotificationSystem` class in our test class. The class already fulfills the 'Dependency Injection' principle.

#### 3. What are the disadvantages of using doubles in your tests? Answer with examples from the `EmailNotificationSystem` class.
Test doubles aren't the real implementation of the class, so the pre-conditions of the real implementation may differ. In this case, we don't know what happens if the email address is missing the '@' character or the domain name. The mock object doesn't check this, so we don't know if the `EmailService` class would throw an error in this case. In the real world, you could probably look it up, but still, you might miss something.
Another disadvantage is that the tests are more coupled to the implementation of both the `EmailNotificationSystem` and the `EmailService` class. If the implementation of the `EmailService` class changes, we may need to change our tests as well, even if the behavior of the `EmailNotificationSystem` class remains the same. Also, if we modify the `EmailNotificationSystem` class to, for example, check if the address is not missing the '@' character, we need to change the test as well, because the behavior of the `EmailNotificationSystem` class changed. In our case, no test would fail if we implemented this check, which is a problem.

## Task B
#### Step 1:
First, we created the following six test cases:
- `notifyUsersBatch_validEmails_sendsEmails()`
- `notifyUsersBatch_oneValidEmail_sendsEmail()`
- `notifyUsersBatch_noEmail_throwsException()`
- `notifyUsersBatch_nullList_throwsException()`
- `notifyUsersBatch_nullEmail_throwsException()`
- `notifyUsersBatch_emptyEmail_throwsException()`

The first two tests check valid inputs for multiple addresses and one single address. The first test expects the `sendEmail()` method to be called for each address in the list, while the second test checks if it is called once for a single address.
The third test checks if an exception is thrown if the list of addresses is empty.
The fourth test checks if an exception is thrown if the list of addresses is null.
The fifth test checks if an exception is thrown if at least one address is null.
The sixth test checks if an exception is thrown if at least one address is empty.
The tests all fail because the `notifyUsersBatch()` method is not implemented yet.

#### Step 2:
We then implemented the `notifyUsersBatch()` method. The method first checks if the list isn't empty or null and throws an `IllegalArgumentException` otherwise. It then iterates through the list of email addresses and calls the `notifyUser()` method for each address. If an individual address is null or empty, an `IllegalArgumentException` is thrown inside the `notifyUser()` method.
The tests all passed after we have written the code.

#### Step 3:
Since our tests and our code fulfills the requirements, we didn't need to write more tests.
We think that there is no need for refactoring, because the code is already clean and easy to read. The method `notifyUsersBatch()` is simple and doesn't contain any complex logic. The method `notifyUser()` is also simple and doesn't need to be refactored. Moreover, we don't have any additional dependencies, so the dependency injection can stay as it is.

### Questions from part A again
#### 1. What are the external dependencies? Which of these dependencies should be tested using doubles and which should not? Explain your rationale.
The answer for this question stays the same, since we don't have any additional dependency. The external dependency is the `EmailService` class that contains the method `sendEmail()`. This class connects to a real email server (in this exercise it obviously doesn't, but we pretend that it does). This adds a lot of complexity and causes why tests may fail, such as the email server not being online or working correctly, which has nothing to do with what we want to test. Moreover, test execution may be slow because of the communication through the internet.
This is why we decided to mock this external dependency, so we can count how often the `sendEmail()` method is called from the `notifyUsersBatch()` method. It should be called exactly as many times as there are valid addresses in the list, given that the list is valid and all elements in the list are valid addresses.. We don't need to test the `EmailService` class, because it is not part of our implementation. We only want to test the `EmailNotificationSystem` class and its method `notifyUsersBatch()`.
#### 2. For the dependencies that should be tested using doubles, should the production code be refactored to make it possible? If so, do the refactoring and implement the tests.
Again, no, since we don't have any new dependencies. The `EmailNotificationSystem` class already has a constructor that takes an `EmailService` object as a parameter. This allows us to inject a mock object when we create an instance of the `EmailNotificationSystem` class in our test class. The class already fulfills the 'Dependency Injection' principle.
#### 3. What are the disadvantages of using doubles in your tests? Answer with examples from the `EmailNotificationSystem` class.
Again, the answer remains the same. Test doubles aren't the real implementation of the class, so the pre-conditions of the real implementation may differ. In this case, we don't know what happens if the email address is missing the '@' character or the domain name. The mock object doesn't check this, so we don't know if the `EmailService` class would throw an error in this case. In the real world, you could probably look it up, but still, you might miss something.
Another disadvantage is that the tests are more coupled to the implementation of both the `EmailNotificationSystem` and the `EmailService` class. If the implementation of the `EmailService` class changes, we may need to change our tests as well, even if the behavior of the `EmailNotificationSystem` class remains the same. Also, if we modify the `EmailNotificationSystem` class to, for example, check if the address is not missing the '@' character, we need to change the test as well, because the behavior of the `EmailNotificationSystem` class changed. In our case, no test would fail if we implemented this check, which is a problem.