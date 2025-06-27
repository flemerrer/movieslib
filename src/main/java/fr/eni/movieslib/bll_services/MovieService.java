package fr.eni.movieslib.bll_services;

import fr.eni.movieslib.bo.movies.Movie;

import java.util.List;

public interface MovieService {
    List<Movie> findAll();

    List<Movie> getDetailedList();

    Movie findById(long id);

    Movie getMovieDetails(long id);

    void add(Movie movie);

    String getTitleById(long id);

    void delete(long id);

    void update(Movie movie);

}
