package fr.eni.movieslib.dal;

import fr.eni.movieslib.bll_services.mappers.MovieMapper;
import fr.eni.movieslib.bo.movies.Movie;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Profile("prod")
@Repository
public class MovieDAO {

    private final NamedParameterJdbcTemplate JdbcTemplate;
    GenreDAO genreDAO;
    CastMemberDAO castMemberDAO;

    public MovieDAO(NamedParameterJdbcTemplate JdbcTemplate, CastMemberDAO castMemberDAO, GenreDAO genreDAO) {
        this.JdbcTemplate = JdbcTemplate;
        this.castMemberDAO = castMemberDAO;
        this.genreDAO = genreDAO;
    }

    public void add(Movie movie) {
        String request = "INSERT INTO MOVIES VALUES title = :title, release_date = :releaseDate, duration = :duration, synopsis = :synopsis";
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("title", movie.getTitle());
        namedParameters.addValue("releaseDate", movie.getReleaseDate());
        namedParameters.addValue("duration", movie.getDuration());
        namedParameters.addValue("synopsis", movie.getSynopsis());
        JdbcTemplate.update(request,namedParameters);
    }

    public Movie findById(long id) {
        String request = "SELECT id, title, release_date, duration, synopsis, genre_id, director_id FROM MOVIES WHERE ID = :id";
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("id", id);
        return JdbcTemplate.queryForObject(request, namedParameters,new MovieMapper(genreDAO, castMemberDAO));
    }

    //    String request = "SELECT first_name, last_name FROM CASTMEMBERS c INNER JOIN ACTORS a ON c.id = a.cast_id WHERE a.movie_id = :movie_id ";
    public List<Movie> findAll() {
        String request = "SELECT id, title, release_date, duration, genre_id, director_id synopsis FROM MOVIES";
        return JdbcTemplate.query(request, new MovieMapper(genreDAO, castMemberDAO));
    }

    public String getTitle(long id){
        String request = "SELECT title FROM MOVIES WHERE ID = :id";
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("id", id);
        return JdbcTemplate.queryForObject(request, namedParameters, new BeanPropertyRowMapper<>(String.class));
    }

    public int delete(long id) {
        String request = "DELETE FROM MOVIES WHERE ID = :id";
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("id", id);
        return JdbcTemplate.update(request, namedParameters);
    }

    public void update(Movie movie) {
        String request = "UPDATE MOVIES SET title = :title, release_date = :releaseDate, duration = :duration, synopsis = :synopsis WHERE id = :id";
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("id", movie.getId());
        namedParameters.addValue("title", movie.getTitle());
        namedParameters.addValue("releaseDate", movie.getReleaseDate());
        namedParameters.addValue("duration", movie.getDuration());
        namedParameters.addValue("synopsis", movie.getSynopsis());
        JdbcTemplate.update(request,namedParameters);
    }
}
