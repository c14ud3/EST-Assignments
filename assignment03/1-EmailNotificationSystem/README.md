# EmailNotificationSystem

### A.  Sending email notifications to users

The `EmailNotificationSystem` class is responsible for sending email notifications to users.
It uses an external dependency: the `EmailService` class to send the emails (e.g., using SMTP or an external API).
The `notifyUser` method of the `EmailNotificationSystem` takes a user's email address and a message and passes the task of sending the email to the `EmailService`.

Write *unit tests* for the `notifyUser` method of the `EmailNotificationSystem` class.

Answer the following questions:
1. What are the external dependencies? Which of these dependencies should be tested using doubles and which should not? Explain your rationale.
2. For the dependencies that should be tested using doubles, should the production code be refactored to make it possible? If so, do the refactoring and implement the tests.
3. What are the disadvantages of using doubles in your tests? Answer with examples from the `EmailNotificationSystem` class.


### B. Batch Email Notifications

Extend the `EmailNotificationSystem` to add a new method called `notifyUsersBatch(List<String> emails, String message)`. This method should attempt to send the same message to a list of users. 
You must implement and test the `notifyUsersBatch` feature starting with Test-Driven Development (TDD). Document every step of your TDD iterative process in your `solution_[problem name].md` file, including:

 - Each test you wrote
 - Each small feature or code change you made to make the test pass.
 - Refactorings, if any.

Afterwards, answer the questions from part A for this part as well.

Automate the test cases using the **JUnit5** plugin.


