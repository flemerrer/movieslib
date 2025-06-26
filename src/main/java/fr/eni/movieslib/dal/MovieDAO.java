package fr.eni.movieslib.dal;

import fr.eni.movieslib.bo.movies.Movie;
import org.springframework.context.annotation.Profile;

import java.util.List;

@Profile("prod")
public class MovieDAO {
    public void add(Movie movie) {}

    public Movie findById(long id) {
        return null;
    }

    public List<Movie> findAll() {
        return null;
    }

    public String getTitle(long id){
        return null;
    }
}
