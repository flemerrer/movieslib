package fr.eni.movieslib.dal;

import fr.eni.movieslib.bo.movies.Movie;
import fr.eni.movieslib.bo.movies.Review;
import fr.eni.movieslib.bo.users.CastMember;

import java.util.List;

public interface MovieDAO {

    Movie create(long id, String title, int year, int duration, String synopsis);
    Movie get(long id);
    List<Movie> getAll();
    Movie update(int id, String title, int year, String genre, int duration, String synopsis, List<CastMember> actors, CastMember director, List<Review> reviews);

}
