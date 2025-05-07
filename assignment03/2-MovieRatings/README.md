# MovieRatings

### A. Get top-ranked movies

The class `MovieRatings` communicates with an SQL database in production, which contains movie metadata (title, director, and rating).
The `topRatedMovies` method of the `MovieRatings` class returns only the movies with a high rating (defined as >= 4 out of 5).

Write *unit tests* for the `topRatedMovies` method of the `MovieRatings` class.

Answer the following questions:
1. What are the external dependencies? Which of these dependencies should be tested using doubles and which should not? Explain your rationale.
2. For the dependencies that should be tested using doubles, should the production code be refactored to make it possible? If so, do the refactoring and implement the tests.
3. What are the disadvantages of using doubles in your tests? Answer with examples from the `MovieRatings` class.

### B. Get the list of all unique directors

Implement a `uniqueDirectors` method in the `MovieRatings` class that will return the directors of all the movies in our SQL database. You must implement and test the method starting with Test-Driven Development (TDD). Document every step of your TDD iterative process in your `solution_[problem name].md` file, including:

 - Each test you wrote
 - Each small feature or code change you made to make the test pass.
 - Refactorings, if any.

Afterwards, answer the questions from part A for this part as well.

Automate the test cases using the **JUnit5** plugin.




