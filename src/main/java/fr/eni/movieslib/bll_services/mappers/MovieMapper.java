package fr.eni.movieslib.bll_services.mappers;

import fr.eni.movieslib.bo.movies.Movie;
import fr.eni.movieslib.dal.CastMemberDAO;
import fr.eni.movieslib.dal.GenreDAO;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class MovieMapper implements RowMapper<Movie> {

    GenreDAO genreDAO;

    CastMemberDAO castMemberDAO;

    public MovieMapper(GenreDAO genreDAO, CastMemberDAO castMemberDAO) {
        this.genreDAO = genreDAO;
        this.castMemberDAO = castMemberDAO;
    }

    public Movie mapRow(ResultSet rs, int rowNum) throws SQLException {
       Movie movie = new Movie();
        movie.setId(rs.getLong("id"));
        movie.setTitle(rs.getString("title"));
        movie.setReleaseDate(rs.getInt("release_date"));
        movie.setDirector(castMemberDAO.findById(rs.getLong("director_id")));
        movie.setGenre(genreDAO.findById(rs.getLong("genre_id")));
        movie.setSynopsis(rs.getString("synopsis"));
        return movie;
    }

}
