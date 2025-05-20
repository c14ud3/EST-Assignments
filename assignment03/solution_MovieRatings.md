# Solution Movie Ratings

## Task A
### About the tests

### Questions
#### 1. What are the external dependencies? Which of these dependencies should be tested using doubles and which should not? Explain your rationale.
We have the following external dependencies:
- `MovieRatingsFetcher` is the main dependency.
    - The method `all()` retrieves all movies.
    - The method `close()` is called in finally block.

-> This dependency should be tested using doubles. For the `all()` method, we use a mock that returns a hard-coded answer like a stub does, but also checks how many times the method is called. For the `close()`method, we also use a mock, because it's a void method and we can only test it by checking if it's called.

- `DatabaseConnection` is used inside `MovieRatingsFetcher`.
    - The method `close()` is used to close the database connection.
  
-> We don't need to create test doubles of this dependency. It is only used by the `MovieRatingsFetcher` class, however the `MovieRatings` class is used to transfer the data to the `MovieRatingsFetcher` class (this needs refactoring).

#### 2. For the dependencies that should be tested using doubles, should the production code be refactored to make it possible? If so, do the refactoring and implement the tests.
The `MovieRatingsFetcher` dependency doesn't need to be refactored, because it's already provided using Dependency Injection, which is considered to be a good practice. However, the `MovieRatings` class has two constructors, one using dependency injection and a second one without dependency injection that creates the `DatabaseConnection` and the `MovieRatingsFetcher` object itself. This is not a good practice. We refactor the code by deleting the second constructor to enhance testability.
#### 3. What are the disadvantages of using doubles in your tests? Answer with examples from the MovieRatings class.
They do not test real integration. For example, a test double for `MovieRatingsFetcher` might always return a list of movies successfully, but in production, `fetcher.all()` could fail due to network issues or database errors. This means tests could pass even though the real system would fail.
Additionally, doubles can become outdated. If the real `MovieRatingsFetcher` is later modified to throw a new exception, such as a `DataFetchException`, the test doubles would not reflect this change unless manually updated. As a result, tests may miss important behavior changes, creating a false sense of confidence.

## Task B

#### Step 1:
We have written the following tests:
- `testNotUniqueDirectors_returnsUniqueDirectors()`
- `testUniqueDirectors_returnsUniqueDirectors()`
- `testNoMovies_returnsNoDirectors()`
- `testUniqueDirectors_callsClose()`

The first test tests if the method returns only unique directors if two movies are from the same director.
The second test tests if the method returns all directors if two movies are from distinct directors.
The third test tests if the method returns an empty list if there are no movies.
The fourth test tests if the method `close()` is called exactly once to properly close the database.

#### Step 2:
We implemented the `uniqueDirectors()` method. The method first calls the `all()` method of the `MovieRatingsFetcher` class to retrieve all movies. It then iterates through the list of movies and adds each director to a set to ensure uniqueness. Finally, it returns the set as a list.  It looks as follows:
```java
public List<String> uniqueDirectors() {
        try {
            List<Movie> allMovies = fetcher.all();
            return allMovies.stream()
                    .map(Movie::getDirector)
                    .distinct()
                    .collect(Collectors.toList());
        } finally {
            fetcher.close();
        }
    }
```
All tests passed.

#### Step 3:
The whole class looks like follows:
```java
public class MovieRatings {
    private final MovieRatingsFetcher fetcher;

    public MovieRatings(MovieRatingsFetcher fetcher) {
        this.fetcher = fetcher;
    }

    public List<Movie> topRatedMovies() {
        try {
            List<Movie> allMovies = fetcher.all();
            return allMovies.stream()
                    .filter(movie -> movie.getRating() >= 4)
                    .collect(Collectors.toList());
        } finally {
            fetcher.close();
        }
    }

    public List<String> uniqueDirectors() {
        try {
            List<Movie> allMovies = fetcher.all();
            return allMovies.stream()
                    .map(Movie::getDirector)
                    .distinct()
                    .collect(Collectors.toList());
        } finally {
            fetcher.close();
        }
    }
}
```
You can easily see that there is duplicate code that both methods use. We can refactor the code by creating a private method `allMovies()` that retrieves all movies and closes the database connection. We refactor the code as follows:

```java
public class MovieRatings {
    private final MovieRatingsFetcher fetcher;

    public MovieRatings(MovieRatingsFetcher fetcher) {
        this.fetcher = fetcher;
    }

    public List<Movie> topRatedMovies() {
        return getMovies(true);
    }

    public List<String> uniqueDirectors() {
        List<Movie> movies= getMovies(true);
        return movies.stream()
                .map(Movie::getDirector)
                .distinct()
                .collect(Collectors.toList());
    }
    private List<Movie> getMovies(boolean topRated) {
        try {
            List<Movie> allMovies = fetcher.all();
            if (topRated) {
                return allMovies.stream()
                        .filter(movie -> movie.getRating() >= 4)
                        .collect(Collectors.toList());
            } else {
                return allMovies;
            }
        } finally {
            fetcher.close();
        }
    }
}
```
We implemented a private `getMovies()` function to reduce the amount of duplicated code.

#### Steps 1 and 2 again
The tests still pass and we don't need to adjust them to the refactoring.

### Questions from part A again
#### 1. What are the external dependencies? Which of these dependencies should be tested using doubles and which should not? Explain your rationale.
The answer is the same as in part A:

We have the following external dependencies:
- `MovieRatingsFetcher` is the main dependency.
  - The method `all()` retrieves all movies.
  - The method `close()` is called in finally block.

-> This dependency should be tested using doubles. For the `all()` method, we use a mock that returns a hard-coded answer like a stub does, but also checks how many times the method is called. For the `close()`method, we also use a mock, because it's a void method and we can only test it by checking if it's called.

- `DatabaseConnection` is used inside `MovieRatingsFetcher`.
  - The method `close()` is used to close the database connection.

-> We don't need to create test doubles of this dependency. It is only used by the `MovieRatingsFetcher` class..

#### 2. For the dependencies that should be tested using doubles, should the production code be refactored to make it possible? If so, do the refactoring and implement the tests.
The `MovieRatingsFetcher` dependency doesn't need to be refactored, because it's already provided using Dependency Injection, which is considered to be a good practice. 
#### 3. What are the disadvantages of using doubles in your tests? Answer with examples from the MovieRatings class.
The answer is still the same: They do not test real integration. For example, a test double for `MovieRatingsFetcher` might always return a list of movies successfully, but in production, `fetcher.all()` could fail due to network issues or database errors. This means tests could pass even though the real system would fail.
Additionally, doubles can become outdated. If the real `MovieRatingsFetcher` is later modified to throw a new exception, such as a `DataFetchException`, the test doubles would not reflect this change unless manually updated. As a result, tests may miss important behavior changes, creating a false sense of confidence.
