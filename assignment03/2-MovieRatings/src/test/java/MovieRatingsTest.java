import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class MovieRatingsTest {
    private MovieRatingsFetcher fetcherMock;
    private MovieRatings movieRatings;

    @BeforeEach
    void setUp() {
        fetcherMock = mock(MovieRatingsFetcher.class);
        movieRatings = new MovieRatings(fetcherMock);
    }

    @AfterEach
    void tearDown() {
        fetcherMock = null;
        movieRatings = null;
    }

    // Tests from Part A

    @Test
    void testTopRatedMovies_returnsOnlyTopRatedMovies() {
        List<Movie> movies = Arrays.asList(
                new Movie("Movie1", "d1", 5),
                new Movie("Movie2", "d2", 2),
                new Movie("Movie3", "d3", 4)
        );

        when(fetcherMock.all()).thenReturn(movies);

        List<Movie> topRated = movieRatings.topRatedMovies();

        // Verify that the returned list contains only those movies with a rating of 4 or higher (two movies)
        assertEquals(2, topRated.size());
        assertTrue(topRated.stream().anyMatch(m -> m.getTitle().equals("Movie1")));
        assertTrue(topRated.stream().anyMatch(m -> m.getTitle().equals("Movie3")));
    }

    @Test
    void testTopRatedMovies_noTopRatedMovies() {
        List<Movie> movies = Arrays.asList(
                new Movie("Movie1", "d1", 2),
                new Movie("Movie2", "d2", 1)
        );

        when(fetcherMock.all()).thenReturn(movies);

        List<Movie> topRated = movieRatings.topRatedMovies();
        // Verify that the returned list is empty if there are no top-rated movies
        assertTrue(topRated.isEmpty());
    }

    @Test
    void testTopRatedMovies_noMovies() {
        // Create empty list of movies
        List<Movie> movies = List.of();

        when(fetcherMock.all()).thenReturn(movies);

        List<Movie> topRated = movieRatings.topRatedMovies();
        // Verify that the returned list is empty if there are no movies at all
        assertTrue(topRated.isEmpty());
    }

    @Test
    void testTopRatedMovies_callsClose() {
        when(fetcherMock.all()).thenReturn(List.of());

        movieRatings.topRatedMovies();
        // Verify that the close method is called
        verify(fetcherMock).close();
    }

    // Tests from Part B (TDD)

    @Test
    void testNotUniqueDirectors_returnsUniqueDirectors() {
        List<Movie> movies = Arrays.asList(
                new Movie("Movie1", "d1", 5),
                new Movie("Movie2", "d1", 4),
                new Movie("Movie3", "d3", 5)
        );

        when(fetcherMock.all()).thenReturn(movies);

        List<String> directors = movieRatings.uniqueDirectors();

        assertEquals(2, directors.size());
        assertTrue(directors.contains("d1"));
        assertTrue(directors.contains("d3"));
    }

    @Test
    void testUniqueDirectors_returnsUniqueDirectors() {
        List<Movie> movies = Arrays.asList(
                new Movie("Movie1", "d1", 5),
                new Movie("Movie2", "d2", 4),
                new Movie("Movie3", "d3", 5)
        );

        when(fetcherMock.all()).thenReturn(movies);

        List<String> directors = movieRatings.uniqueDirectors();

        assertEquals(3, directors.size());
        assertTrue(directors.contains("d1"));
        assertTrue(directors.contains("d2"));
        assertTrue(directors.contains("d3"));
    }

    @Test
    void testNoMovies_returnsNoDirectors() {
        // Create empty list of movies
        List<Movie> movies = List.of();

        when(fetcherMock.all()).thenReturn(movies);

        List<String> directors = movieRatings.uniqueDirectors();

        // Verify that the returned list is empty if there are no movies at all
        assertEquals(0, directors.size());

    }

    @Test
    void testUniqueDirectors_callsClose() {
        when(fetcherMock.all()).thenReturn(List.of());

        movieRatings.uniqueDirectors();

        // Verify that the close method is called
        verify(fetcherMock).close();
    }
}
