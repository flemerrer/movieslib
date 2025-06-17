package fr.eni.movieslib.controllers;

import fr.eni.movieslib.bll_services.mock.MovieServiceMock;
import fr.eni.movieslib.bo.movies.Movie;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.util.ArrayList;

@Controller
@SessionAttributes({"genresList"})
public class MovieController {

    public MovieServiceMock service;

    public MovieController(MovieServiceMock service) {
        this.service = service;
    }

    @ModelAttribute("genresList")
    public String[] GetGenresList() {
        return service.getGenresList();
    }

    //FIXME: doesn't work because it flushes the attribute after rendering ; need to find another way to implement it.
    /*
    @GetMapping("/invalidate")
    public String invalidate(SessionStatus status) {
        status.setComplete();
        return "redirect:/";
    }*/

    @GetMapping({"/", "/movies"})
    public String getAllMovies(Model model) {
        ArrayList<Movie> allMovies = (ArrayList<Movie>) service.getAllMovies();
        model.addAttribute("movies", allMovies);
        return "movies";
    }

    @GetMapping("/movie/{id}")
    public String getMovieById(Model model, @PathVariable long id) {
        try {
            Movie movie = service.getMovieById(id);
            if(movie == null) {
                return "notFound";
            }
            model.addAttribute("movie", movie);
        } catch (Exception e) {
        }
        return "detail";
    }

    @PostMapping("/movie/{id}")
    public String updateMovie(Movie movie) {
        service.updateMovie(movie);
        return "redirect:/";
    }

}
