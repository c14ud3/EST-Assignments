public class Movie {
    private String title;
    private String director;
    private int rating; // Rating on a scale from 1 to 5

    public Movie(String title, String director, int rating) {
        this.title = title;
        this.director = director;
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public String getDirector() {
        return director;
    }

    public int getRating() {
        return rating;
    }
}
