package fr.eni.movieslib.controllers;

import fr.eni.movieslib.bll_services.UserContextService;
import fr.eni.movieslib.bll_services.mock.MovieServiceMock;
import fr.eni.movieslib.bo.context.UserContext;
import fr.eni.movieslib.bo.movies.Movie;
import fr.eni.movieslib.bo.movies.Review;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@SessionAttributes({"genresList, userSession"})
public class MovieController {

    public MovieServiceMock serviceMovie;
    public UserContextService userService;

    public MovieController(MovieServiceMock movieService,  UserContextService userService) {
        this.serviceMovie = movieService;
        this.userService = userService;
    }

    @ModelAttribute("userSession")
    public UserContext setUserSession() {
        return userService.getUserContext();
    }

    @ModelAttribute("genresList")
    public String[] GetGenresList() {
        return serviceMovie.getGenresList();
    }

    @ModelAttribute("userSession")
    public UserContext GetSession(@ModelAttribute("userSession") UserContext userContext) {
        return userService.getUserContext();
    }

    //FIXME: doesn't work because it flushes the attribute after rendering ; need to find another way to implement it.
    /*
    @GetMapping("/invalidate")
    public String invalidate(SessionStatus status) {
        status.setComplete();
        return "redirect:/";
    }*/

    @GetMapping({"/", "/movies"})
    public String getAllMovies(Model model, @ModelAttribute("genresList") String[] genresList, @ModelAttribute("userSession") UserContext userContext) {
        ArrayList<Movie> allMovies = (ArrayList<Movie>) serviceMovie.getAllMovies();
        model.addAttribute("movies", allMovies);
        model.addAttribute("userSession", userContext);
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
            System.out.println(e.getMessage());
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

    @GetMapping("/movie/review/add/{id}")
    public String createReview(Model model, @PathVariable long id) {
        System.out.println(id);
        try {
            Movie movie = serviceMovie.getMovieById(id);
            if(movie == null) {
                return "notFound";
            }
            model.addAttribute("movie", movie);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "addReview";
    }

    @PostMapping("/movie/review/add/{id}")
    public String addReview(@PathVariable long id, @ModelAttribute("review") Review review, @RequestParam("rating") int rating, @RequestParam("comment") String comment) {
        serviceMovie.getMovieById(id).addReview(new Review(rating, comment));
        return "redirect:/movie/"+id;
    }

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
