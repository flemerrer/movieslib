package fr.eni.movieslib.dal;

import fr.eni.movieslib.bo.movies.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Profile("prod")
public class ReviewDAO {

    @Autowired
    private NamedParameterJdbcTemplate JdbcTemplate;

    public void add(Review review, long movie_id){
        String request = "INSERT INTO REVIEWS VALUES (:movie_id, :user_id, :rating, :comment)";
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("movie_id", movie_id);
        namedParameters.addValue("rating", review.getRating());
        namedParameters.addValue("comment", review.getComment());
        namedParameters.addValue("user_id", review.getMember().getId());
        JdbcTemplate.update(request, namedParameters);
    }

    public List<Review> findByMovieId(long movie_id) {
        String request = "SELECT rating, comment, user_id  FROM REVIEWS WHERE movie_id = :movie_id ";
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("movie_id", movie_id);
        return JdbcTemplate.query(request, namedParameters, new BeanPropertyRowMapper<>(Review.class));
    }
}
