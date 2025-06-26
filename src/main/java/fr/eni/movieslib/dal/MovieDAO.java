package fr.eni.movieslib.dal;

import fr.eni.movieslib.bo.movies.Movie;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Profile("prod")
@Repository
public class MovieDAO {

    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public void setJDBCTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public void add(Movie movie) {}

    public Movie findById(long id) {
        return null;
    }

    public List<Movie> findAll() {
        return null;
    }

    public String getTitle(long id){
        return null;
    }

    public void delete(long id) {
    }

    public void update(Movie movie) {
    }
}
