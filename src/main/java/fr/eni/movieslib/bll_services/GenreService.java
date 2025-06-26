package fr.eni.movieslib.bll_services;

import fr.eni.movieslib.bo.movies.Genre;
import fr.eni.movieslib.dal.CastMemberDAO;
import fr.eni.movieslib.dal.GenreDAO;
import jakarta.servlet.ServletConfig;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Profile("prod")
public class GenreService {

    private final ServletConfig servletConfig;
    GenreDAO genreDAO;

    public GenreService(GenreDAO genreDAO, ServletConfig servletConfig) {
        this.genreDAO = genreDAO;
        this.servletConfig = servletConfig;
    }

    public List<String> findAll() {
        List <String> genres = new ArrayList<>();
        for  (Genre genre : genreDAO.findAll()) {
            genres.add(genre.getName());
        }
        return genres;
    }

    public Genre findById(long id) {
        return genreDAO.findById(id);
    }

}
