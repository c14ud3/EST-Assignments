import java.util.List;
import java.util.stream.Collectors;

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
