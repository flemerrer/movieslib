package fr.eni.movieslib.bll_services;

import fr.eni.movieslib.bo.movies.Genre;
import fr.eni.movieslib.bo.movies.Movie;
import fr.eni.movieslib.bo.users.CastMember;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Profile("prod")
public class MovieServiceImpl implements MovieService {

    public MovieServiceImpl() {
    }

    @Override
    public List<Movie> getAllMovies() {
        return null;
    }

    @Override
    public Movie getMovieById(long id) {
        return null;
    }

    @Override
    public String[] getGenresList() {
        return null;
    }

    @Override
    public List<CastMember> getCastMembers() {
        return null;
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
    public void removeMovie(Movie movie) {

    }
}
