package fr.eni.movieslib.controllers;

import fr.eni.movieslib.bll_services.MovieService;
import fr.eni.movieslib.bll_services.mock.Mock;
import fr.eni.movieslib.bo.movies.Movie;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Component
public class MovieController {

    public Mock service;

    public MovieController(Mock service) {
        this.service = service;
    }

    @GetMapping({"/", "app"})
    public String getAppIndex(){
        return "index";
    }

    @GetMapping("/movies")
    public String getallMovies() {
        ArrayList<Movie> allMovies = (ArrayList<Movie>) service.getAllMovies();
        return "movies";
    }

    @GetMapping("/movie/{id]}")
    public String getMovieById(long id) {
        Movie movie = service.getMovieById(id);
        return "detail";
    }
}
