package fr.eni.movieslib.dal;

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

    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public void setJDBCTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public void add(Movie movie) {
        String request = "INSERT INTO MOVIES title, release_date, duration, synopsis VALUES title = :title, release_date = :releaseDate, duration = :duration, synopsis = :synopsis";
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("title", movie.getTitle());
        namedParameters.addValue("releaseDate", movie.getReleaseDate());
        namedParameters.addValue("duration", movie.getDuration());
        namedParameters.addValue("synopsis", movie.getSynopsis());
        namedParameterJdbcTemplate.update(request,namedParameters);
    }

    public Movie findById(long id) {
        String request = "SELECT title, release_date, duration, synopsis FROM MOVIES WHERE ID = :id";
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("id", id);
        return namedParameterJdbcTemplate.queryForObject(request, namedParameters, new BeanPropertyRowMapper<>(Movie.class));
    }

    public List<Movie> findAll() {
        String request = "SELECT title, release_date, duration, synopsis FROM MOVIES";
        return namedParameterJdbcTemplate.query(request, new BeanPropertyRowMapper<>(Movie.class));
    }

    public String getTitle(long id){
        String request = "SELECT title FROM MOVIES WHERE ID = :id";
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("id", id);
        return namedParameterJdbcTemplate.queryForObject(request, namedParameters, new BeanPropertyRowMapper<>(String.class));
    }

    public int delete(long id) {
        String request = "DELETE FROM MOVIES WHERE ID = :id";
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("id", id);
        return namedParameterJdbcTemplate.update(request, namedParameters);
    }

    public void update(Movie movie) {
        String request = "UPDATE MOVIES SET title = :title, release_date = :releaseDate, duration = :duration, synopsis = :synopsis WHERE id = :id";
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("id", movie.getId());
        namedParameters.addValue("title", movie.getTitle());
        namedParameters.addValue("releaseDate", movie.getReleaseDate());
        namedParameters.addValue("duration", movie.getDuration());
        namedParameters.addValue("synopsis", movie.getSynopsis());
        namedParameterJdbcTemplate.update(request,namedParameters);
    }
}
