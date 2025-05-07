import java.util.List;
import java.util.stream.Collectors;

public class MovieRatings {
    private final MovieRatingsFetcher fetcher;

    public MovieRatings(MovieRatingsFetcher fetcher) {
        this.fetcher = fetcher;
    }

    public MovieRatings() {
        DatabaseConnection dbConnection = new DatabaseConnection();
        this.fetcher = new MovieRatingsFetcher(dbConnection);
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
}
