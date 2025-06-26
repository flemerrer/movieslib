package fr.eni.movieslib.dal;

import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@Profile("prod")
public class MovieDAOFactory {

    private static MovieDAO movieDAO;

    private static NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public MovieDAOFactory(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        MovieDAOFactory.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public static MovieDAO getMovieDAO() {
        if(movieDAO == null) {
            movieDAO = new MovieDAO();
            movieDAO.setJDBCTemplate(namedParameterJdbcTemplate);
        }
        return movieDAO;
    }

}
