package fr.eni.movieslib.controllers;

import fr.eni.movieslib.bll_services.MovieService;
import fr.eni.movieslib.bll_services.UserContextServiceImpl;
import fr.eni.movieslib.bo.context.UserContext;
import fr.eni.movieslib.bo.movies.Movie;
import fr.eni.movieslib.bo.movies.Review;
import fr.eni.movieslib.bo.users.RegisteredUser;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@SessionAttributes({"genresList, userSession"})
public class MovieController {

    public MovieService serviceMovie;
    public UserContextServiceImpl userService;

    public MovieController(MovieService movieService,  UserContextServiceImpl userService) {
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
        ArrayList<Movie> allMovies = (ArrayList<Movie>) serviceMovie.findAll();
        model.addAttribute("movies", allMovies);
        model.addAttribute("userSession", userContext);
        return "movies";
    }

    @GetMapping("/movie/{id}")
    public String getMovieById(Model model, @PathVariable long id) {
        try {
            Movie movie = serviceMovie.findById(id);
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
        serviceMovie.update(movie);
        return "redirect:/";
    }

/*    @PostMapping("/movie/{id}/actor/add")
    public String addActor(CastMember castMember, @PathVariable long id) {
        serviceMovie.getMovieById(id).addActor(castMember);
        return "redirect:/movie/" + id;
    }*/

    @GetMapping("/movie/review/add/{id}")
    public String createReview(Model model, @PathVariable long id, @ModelAttribute("review") Review review) {
        model.addAttribute("review", review);
        try {
            Movie movie = serviceMovie.findById(id);
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
    public String addReview(@Valid @ModelAttribute("review") Review review, BindingResult bindingResult, @PathVariable long id, @ModelAttribute("userSession") UserContext userContext) {
        if (bindingResult.hasErrors()) {
            return "redirect:/movie/review/add/"+id;
        }
        serviceMovie.findById(id).addReview(new Review(review.getRating(), review.getComment(), new RegisteredUser(null, null, userContext.getUsername(), null)));
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
        serviceMovie.add(movie);
        return "redirect:/movies";
    }

}
