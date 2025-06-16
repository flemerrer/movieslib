package fr.eni.movieslib.controllers;

import fr.eni.movieslib.bll_services.mock.Mock;
import fr.eni.movieslib.bo.movies.Movie;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class MovieController {

    public Mock service;

    public MovieController(Mock service) {
        this.service = service;
    }

    @RequestMapping({"/", "/movies"})
    public String getAllMovies(Model model) {
        ArrayList<Movie> allMovies = (ArrayList<Movie>) service.getAllMovies();
        model.addAttribute("movies", allMovies);
        return "movies";
    }

    @GetMapping("/movie/{id}")
    public String getMovieById(Model model, @PathVariable long id) {
        Movie selectedMovie = service.getMovieById(id);
        model.addAttribute("movie", selectedMovie);
        return "detail";
    }

}
