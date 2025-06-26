package fr.eni.movieslib.bll_services;

import fr.eni.movieslib.bo.movies.Genre;
import fr.eni.movieslib.bo.movies.Movie;
import fr.eni.movieslib.bo.movies.Review;
import fr.eni.movieslib.bo.users.CastMember;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Profile("prod")
public class MovieServiceImpl  implements MovieService {
    @Override
    public List<Movie> getAllMovies() {
        return List.of();
    }

    @Override
    public Movie getMovieById(long id) {
        return null;
    }

    @Override
    public String[] getGenresList() {
        return new String[0];
    }

    @Override
    public List<CastMember> getCastMembers() {
        return List.of();
    }

    @Override
    public Genre getGenreById(long id) {
        return null;
    }

    @Override
    public CastMember GetCastMemberById(long id) {
        return null;
    }

    @Override
    public void addMovie(Movie movie) {

    }

    @Override
    public String getMovieTitle(long id) {
        return "";
    }

    @Override
    public void removeMovie(long id) {

    }

    @Override
    public void updateMovie(Movie movie) {

    }

    @Override
    public void addReview(Review review) {

    }

    @Override
    public List<Review> getMovieReviews(long id) {
        return List.of();
    }
}
