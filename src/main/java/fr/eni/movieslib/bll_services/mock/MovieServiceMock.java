package fr.eni.movieslib.bll_services.mock;

import java.util.List;

import fr.eni.movieslib.bll_services.MovieService;
import fr.eni.movieslib.bo.movies.Movie;
import fr.eni.movieslib.bo.movies.Genre;
import fr.eni.movieslib.bo.movies.Review;
import fr.eni.movieslib.bo.users.CastMember;
import fr.eni.movieslib.dal.mock.MovieDAOMock;
import fr.eni.movieslib.dal.mock.MovieDAOMockFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("dev")
public class MovieServiceMock implements MovieService {

    MovieDAOMock movieDAOMock;

    public MovieServiceMock() {
        this.movieDAOMock = MovieDAOMockFactory.getMovieDAO();
    }

    @Override
    public List<Movie> findAll() {
        return movieDAOMock.getAll();
    }

    @Override
    public Movie findById(long id) {
        return movieDAOMock.get(id);
    }

    @Override
    public String[] getGenresList() {
        return MovieDAOMock.getGenres();
    }

    @Override
    public List<CastMember> getCastMembers() {
        return MovieDAOMock.getCastMembers();
    }

    @Override
    public Genre getGenreById(long id) {
        return movieDAOMock.getGenreById(id);
    }

    @Override
    public CastMember GetCastMemberById(long id) {
        return movieDAOMock.GetCastMemberById(id);
    }

    @Override
    public void add(Movie movie) {
        movieDAOMock.addMovie(movie);
    }

    @Override
    public String getTitleById(long id) {
        return "";
    }

    @Override
    public void delete(long id) {
        movieDAOMock.removeMovie(id);
    }

    @Override
    public void update(Movie movie) {
        movieDAOMock.updateMovie(movie);
    }

    @Override
    public void addReview(Review review) {

    }

    @Override
    public List<Review> getMovieReviews(long id) {
        return List.of();
    }
}
