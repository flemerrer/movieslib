package fr.eni.movieslib.dal;

import org.springframework.context.annotation.Profile;

@Profile("dev")
public class MovieDAOFactory {

    private static MovieDAO movieDAO;

    public static MovieDAO getMovieDAO() {
        if(movieDAO == null)
            movieDAO = new MovieDAO();
        return movieDAO;
    }

}
