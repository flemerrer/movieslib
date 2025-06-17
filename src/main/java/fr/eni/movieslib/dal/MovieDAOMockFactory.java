package fr.eni.movieslib.dal;

public class MovieDAOMockFactory {

    private static MovieDAOMock movieDAOMock;

    public static MovieDAOMock getMovieDAO() {
        if(movieDAOMock == null)
            movieDAOMock = new MovieDAOMock();
        return movieDAOMock;
    }

}
