package fr.eni.movieslib.bll_services;

import fr.eni.movieslib.bo.movies.Movie;
import fr.eni.movieslib.bo.movies.Review;
import fr.eni.movieslib.bo.users.CastMember;
import fr.eni.movieslib.dal.CastMemberDAO;
import fr.eni.movieslib.dal.MovieDAO;
import fr.eni.movieslib.dal.ReviewDAO;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Profile("prod")
public class MovieServiceImpl  implements MovieService {

    CastMemberDAO castMemberDAO;
    MovieDAO movieDAO;
    ReviewDAO reviewDAO;

    public MovieServiceImpl(MovieDAO movieDAO, ReviewDAO reviewDAO, CastMemberDAO castMemberDAO) {
        this.movieDAO = movieDAO;
        this.castMemberDAO = castMemberDAO;
        this.reviewDAO = reviewDAO;
    }

    @Override
    public List<Movie> findAll() {
        return movieDAO.findAll();
    }

    @Override
    public List<Movie> getDetailedList(){
        List<Movie> list =  movieDAO.findAll();
        return list;
    }

    @Override
    public Movie findById(long id) {
        return movieDAO.findById(id);
    }

    @Override
    public Movie getMovieDetails(long id){
        Movie movie = movieDAO.findById(id);
        movie.setActors((ArrayList<CastMember>) castMemberDAO.findCastMembersByMovieId(id));
        movie.setReviews((ArrayList<Review>) reviewDAO.findByMovieId(id));
        return movie;
    }

    @Override
    public void add(Movie movie) {
        movieDAO.add(movie);
    }

    @Override
    public String getTitleById(long id) {
        return movieDAO.getTitle(id);
    }

    @Override
    public void delete(long id) {
        movieDAO.delete(id);
    }

    @Override
    public void update(Movie movie) {
        movieDAO.update(movie);
    }

}
