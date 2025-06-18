package fr.eni.movieslib.controllers;

import fr.eni.movieslib.bll_services.mock.MovieServiceMock;
import fr.eni.movieslib.bo.movies.Movie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@SessionAttributes({"genresList"})
public class MovieController {

    public MovieServiceMock serviceMovie;

    public MovieController(MovieServiceMock service) {
        this.serviceMovie = service;
    }

    @ModelAttribute("genresList")
    public String[] GetGenresList() {
        return serviceMovie.getGenresList();
    }

    //FIXME: doesn't work because it flushes the attribute after rendering ; need to find another way to implement it.
    /*
    @GetMapping("/invalidate")
    public String invalidate(SessionStatus status) {
        status.setComplete();
        return "redirect:/";
    }*/

    @GetMapping({"/", "/movies"})
    public String getAllMovies(Model model, @ModelAttribute("genresList") String[] genresList) {
        ArrayList<Movie> allMovies = (ArrayList<Movie>) serviceMovie.getAllMovies();
        model.addAttribute("movies", allMovies);
        return "movies";
    }

    @GetMapping("/movie/{id}")
    public String getMovieById(Model model, @PathVariable long id) {
        try {
            Movie movie = serviceMovie.getMovieById(id);
            if(movie == null) {
                return "notFound";
            }
            String actors = "";
            model.addAttribute("movie", movie);
            model.addAttribute("actors", actors);
        } catch (Exception e) {
        }
        return "detail";
    }

    @PostMapping("/movie/{id}")
    public String updateMovie(@Valid @ModelAttribute("movie") Movie movie, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "detail";
        }
        serviceMovie.updateMovie(movie);
        return "redirect:/";
    }

/*    @PostMapping("/movie/{id}/actor/add")
    public String addActor(CastMember castMember, @PathVariable long id) {
        serviceMovie.getMovieById(id).addActor(castMember);
        return "redirect:/movie/" + id;
    }*/

    @GetMapping("/movie/add")
    public String addMovie(Model model, @ModelAttribute("genresList") String[] genresList) {
        model.addAttribute("movie", new Movie());
        return "addMovie";
    }

    @PostMapping("/movie/add")
    public String createMovie(@Valid @ModelAttribute("movie") Movie movie, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "addMovie";
        }
        serviceMovie.addMovie(movie);
        return "redirect:/movies";
    }

}
