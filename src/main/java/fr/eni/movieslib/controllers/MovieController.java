package fr.eni.movieslib.controllers;

import fr.eni.movieslib.bll_services.MovieService;
import fr.eni.movieslib.bll_services.mock.Mock;
import fr.eni.movieslib.bo.movies.Movie;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;

@Component
public class MovieController {

    public Mock service;

    public MovieController(Mock service) {
        this.service = service;
    }

    public ArrayList<Movie> getallMovies() {
        return (ArrayList<Movie>) service.getAllMovies();
    }

    public Movie getMovieById(long id) {
        return service.getMovieById(id);
    }
}
