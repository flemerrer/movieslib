package fr.eni.movieslib.bll_services;

import fr.eni.movieslib.bo.movies.Genre;
import fr.eni.movieslib.bo.movies.Movie;
import fr.eni.movieslib.bo.movies.Review;
import fr.eni.movieslib.bo.users.CastMember;

import java.util.List;

public interface MovieService {
    List<Movie> getAllMovies();

    Movie getMovieById(long id);

    String[] getGenresList();

    List<CastMember> getCastMembers();

    Genre getGenreById(long id);

    CastMember GetCastMemberById(long id);

    void addMovie(Movie movie);

    String getMovieTitle(long id);

    void removeMovie(long id);

    void updateMovie(Movie movie);

    void addReview(Review review);

    List<Review> getMovieReviews(long id);
}
