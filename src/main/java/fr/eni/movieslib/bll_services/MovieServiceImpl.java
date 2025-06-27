package fr.eni.movieslib.bll_services;

import fr.eni.movieslib.bo.movies.Movie;
import fr.eni.movieslib.dal.MovieDAO;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Profile("prod")
public class MovieServiceImpl  implements MovieService {

    MovieDAO movieDAO;

    public MovieServiceImpl(MovieDAO movieDAO) {
        this.movieDAO = movieDAO;
    }

    @Override
    public List<Movie> findAll() {
        return movieDAO.findAll();
    }

    @Override
    public Movie findById(long id) {
        return movieDAO.findById(id);
    }

    @Override
    public void add(Movie movie) {
        movieDAO.add(movie);
    }

    @Override
    public String getTitleById(long id) {
        return movieDAO.getTitle(id);
    }

    @Override
    public void delete(long id) {
        movieDAO.delete(id);
    }

    @Override
    public void update(Movie movie) {
        movieDAO.update(movie);
    }

}
