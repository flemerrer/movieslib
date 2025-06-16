package fr.eni.movieslib.controllers;

import fr.eni.movieslib.bll_services.mock.Mock;
import fr.eni.movieslib.bo.movies.Movie;
import fr.eni.movieslib.bo.users.CastMember;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class MovieController {

    public Mock service;

    public MovieController(Mock service) {
        this.service = service;
    }

    @GetMapping({"/", "/movies"})
    public String getAllMovies(Model model) {
        ArrayList<Movie> allMovies = (ArrayList<Movie>) service.getAllMovies();
        model.addAttribute("movies", allMovies);
        return "movies";
    }

    @GetMapping("/movie/{id}")
    public String getMovieById(Model model, @PathVariable long id) {
        try {
            Movie selectedMovie = service.getMovieById(id);
            if(selectedMovie == null) {
                return "notFound";
            }
            model.addAttribute("movie", selectedMovie);
        } catch (Exception e) {
        }
        return "detail";
    }

    @PostMapping("/movie/{id}")
    public String updateMovie(Movie movie, @PathVariable long id) {
/*        Movie toUpdate = service.getMovieById(id);
        service.removeMovie(toUpdate);
        toUpdate = new Movie(movie.getTitle(), movie.getReleaseDate(), movie.getDuration(), movie.getSynopsis());
        String[] myArray = movie.getDirector().toString().split(" ");
        toUpdate.setDirector(new CastMember(myArray[0], myArray[1]));
        myArray = movie.getActors().toString().split("- ");
        ArrayList<CastMember> actors = new ArrayList<>();
        for (String actor : myArray) {
            String[] a = actor.split(" ");
            CastMember b = new CastMember(a[0], a[1]);
            actors.add(b);
        }
        toUpdate.setActors(actors);
        service.addMovie(toUpdate);*/
        return "redirect:/";
    }

}
