package fr.eni.movieslib.dal;

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
public class CastMemberDAO {

    @Autowired
    private NamedParameterJdbcTemplate JdbcTemplate;

    public CastMember findById(long id){
        String request = "SELECT first_name, last_name FROM CASTMEMBERS WHERE ID = :id";
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("id", id);
        return JdbcTemplate.queryForObject(request, namedParameters, new BeanPropertyRowMapper<>(CastMember.class));
    }

    public List<CastMember> findAll(){
        String request = "SELECT first_name, last_name FROM CASTMEMBERS";
        return JdbcTemplate.query(request, new BeanPropertyRowMapper<>(CastMember.class));
    }

    public List<CastMember> findCastMembersByMovieId(long movie_id){
        String request = "SELECT first_name, last_name FROM CASTMEMBERS c INNER JOIN ACTORS a ON c.id = a.cast_id WHERE a.movie_id = :movie_id ";
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("movie_id", movie_id);
        return JdbcTemplate.query(request, namedParameters, new BeanPropertyRowMapper<>(CastMember.class));
    }

    public void add(long movie_id, long cast_id){
        String request = "INSERT INTO ACTORS VALUES (:movie_id, :cast_id)";
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("movie_id", movie_id);
        namedParameters.addValue("cast_id", cast_id);
        JdbcTemplate.update(request, namedParameters);
    }

}
