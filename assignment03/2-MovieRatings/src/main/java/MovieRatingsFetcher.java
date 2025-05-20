import java.util.List;

public class MovieRatingsFetcher {
    private DatabaseConnection dbConnection;

    public MovieRatingsFetcher(DatabaseConnection dbConnection) {
        this.dbConnection = dbConnection;
    }

    public List<Movie> all() {
        // This would normally fetch data from a database...The implementation is skipped.
        return null;
    }

    public void close() {
        dbConnection.close();
    }
}

