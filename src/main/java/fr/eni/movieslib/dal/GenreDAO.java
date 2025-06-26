package fr.eni.movieslib.dal;

import fr.eni.movieslib.bo.movies.Genre;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Profile("prod")
public class GenreDAO {

    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public GenreDAO(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public Genre findById(long id) {
        return null;
    }

    public List<Genre> findAll(){
        return null;
    }
}
