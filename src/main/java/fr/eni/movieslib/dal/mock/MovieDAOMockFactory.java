package fr.eni.movieslib.dal.mock;

import org.springframework.context.annotation.Profile;

@Profile("dev")
public class MovieDAOMockFactory {

    private static MovieDAOMock movieDAOMock;

    public static MovieDAOMock getMovieDAO() {
        if(movieDAOMock == null)
            movieDAOMock = new MovieDAOMock();
        return movieDAOMock;
    }

}
