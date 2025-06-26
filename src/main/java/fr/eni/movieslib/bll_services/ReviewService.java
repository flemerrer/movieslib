package fr.eni.movieslib.bll_services;

import fr.eni.movieslib.bo.movies.Review;
import fr.eni.movieslib.dal.CastMemberDAO;
import fr.eni.movieslib.dal.ReviewDAO;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Profile("prod")
public class ReviewService {

    ReviewDAO reviewDAO;

    public ReviewService(ReviewDAO reviewDAO) {
        this.reviewDAO = reviewDAO;
    }

    public void add(Review review, long movieId) {
        reviewDAO.add(review, movieId);
    }

    public List<Review> getMovieReviews(long movieId) {
        return reviewDAO.findByMovieId(movieId);
    }
}
