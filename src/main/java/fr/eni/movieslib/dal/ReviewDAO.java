package fr.eni.movieslib.dal;

import fr.eni.movieslib.bo.movies.Review;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Profile("prod")
public class ReviewDAO {

    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public ReviewDAO(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public void add(Review review, long movie_id){

    }

    public List<Review> findByMovieId(long movie_id) {
        return null;
    }
}
