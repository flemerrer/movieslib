package fr.eni.movieslib.dal;

import fr.eni.movieslib.bo.movies.Genre;
import org.springframework.context.annotation.Profile;

import java.util.List;

@Profile("prod")
public class GenreDAO {
    public Genre findById(long id) {
        return null;
    }

    public List<Genre> findAll(){
        return null;
    }
}
