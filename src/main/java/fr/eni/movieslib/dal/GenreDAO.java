package fr.eni.movieslib.dal;

import fr.eni.movieslib.bo.movies.Genre;
import fr.eni.movieslib.bo.users.CastMember;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Profile("prod")
public class GenreDAO {

    NamedParameterJdbcTemplate JdbcTemplate;

    @Autowired
    public GenreDAO(NamedParameterJdbcTemplate JdbcTemplate) {
        this.JdbcTemplate = JdbcTemplate;
    }

    public Genre findById(long id) {
        String request = "SELECT name FROM GENRES WHERE id = :id";
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("id", id);
        return JdbcTemplate.queryForObject(request, namedParameters, new BeanPropertyRowMapper<>(Genre.class));
    }

    public List<Genre> findAll(){
        String request = "SELECT name FROM GENRES";
        return JdbcTemplate.query(request, new BeanPropertyRowMapper<>(Genre.class));
    }
}
