package fr.eni.movieslib.dal;

import fr.eni.movieslib.bll_services.mappers.UserMapper;
import fr.eni.movieslib.bo.users.RegisteredUser;
import org.springframework.context.annotation.Profile;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Profile("prod")
public class UserDAO {

    private final NamedParameterJdbcTemplate JdbcTemplate;

    public UserDAO(NamedParameterJdbcTemplate JdbcTemplate) {
        this.JdbcTemplate = JdbcTemplate;
    }

    public RegisteredUser findById(long id) {
        String request = "SELECT first_name, last_name, email FROM REGISTERED_USERS WHERE ID = :id";
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("id", id);
        RegisteredUser user;
        try {
            user = JdbcTemplate.queryForObject(request, namedParameters, new BeanPropertyRowMapper<>(RegisteredUser.class));
        } catch (DataAccessException e) {
            return null;
        }
        return user;
    }

    public RegisteredUser getByEmail(String email) {
        String request = "SELECT first_name, last_name, email, is_admin FROM REGISTERED_USERS WHERE email = :email";
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("email", email);
        RegisteredUser user;
        try {
            user = JdbcTemplate.queryForObject(request, namedParameters, new UserMapper());
        } catch (DataAccessException e) {
            return null;
        }
        return user;
    }

    public List<RegisteredUser> findAll() {
        String request = "SELECT first_name, last_name, email FROM REGISTERED_USERS";
        return JdbcTemplate.query(request, new BeanPropertyRowMapper<>(RegisteredUser.class));
    }

    public void add(RegisteredUser user) {
        String request = "INSERT INTO REGISTERED_USERS (first_name, last_name, email, password) VALUES first_name = :firstName, last_name = :lastName, email = :email, password = :password";
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("firstName", user.getFirstName());
        namedParameters.addValue("lastName", user.getLastName());
        namedParameters.addValue("email", user.getEmail());
        namedParameters.addValue("password", user.getPassword());
        namedParameters.addValue("isAdmin", user.isAdmin());
        JdbcTemplate.update(request,namedParameters);
    }

    public int delete(long id) {
        String request = "DELETE FROM REGISTERED_USERS WHERE ID = :id";
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("id", id);
        return JdbcTemplate.update(request, namedParameters);
    }
}
