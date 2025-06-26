package fr.eni.movieslib.dal;

import fr.eni.movieslib.bo.movies.Review;
import org.springframework.context.annotation.Profile;

import java.util.List;

@Profile("prod")
public class ReviewDAO {

    public void add(Review review, long movie_id){

    }

    public List<Review> findByMovieId(long movie_id) {
        return null;
    }
}
