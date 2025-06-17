package fr.eni.movieslib.bll_services.mock;

import java.util.List;


import fr.eni.movieslib.bll_services.MovieService;
import fr.eni.movieslib.bo.movies.Movie;
import fr.eni.movieslib.bo.movies.Genre;
import fr.eni.movieslib.bo.users.CastMember;
import fr.eni.movieslib.dal.MovieDAOMock;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("dev")
public class MovieServiceMock implements MovieService {

    MovieDAOMock movieDAOMock;

    public MovieServiceMock() {
        this.movieDAOMock = new MovieDAOMock();
    }

    @Override
    public List<Movie> getAllMovies() {
        return movieDAOMock.getAll();
    }

    @Override
    public Movie getMovieById(long id) {
        return movieDAOMock.get(id);
    }

    @Override
    public String[] getGenresList() {
        return movieDAOMock.getGenres();
    }

    @Override
    public List<CastMember> getCastMembers() {
        return movieDAOMock.getCastMembers();
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
    public void addMovie(Movie movie) {
        movieDAOMock.addMovie(movie);
    }

    @Override
    public void removeMovie(Movie movie) {
        movieDAOMock.removeMovie(movie);
    }

    public void init(){
        movieDAOMock.mockDALandDB();
    }

}
