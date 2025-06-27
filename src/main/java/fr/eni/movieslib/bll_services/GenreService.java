package fr.eni.movieslib.bll_services;

import fr.eni.movieslib.bo.movies.Genre;
import fr.eni.movieslib.dal.CastMemberDAO;
import fr.eni.movieslib.dal.GenreDAO;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Profile("prod")
public class GenreService {

    GenreDAO genreDAO;

    public GenreService(GenreDAO genreDAO) {
        this.genreDAO = genreDAO;
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
