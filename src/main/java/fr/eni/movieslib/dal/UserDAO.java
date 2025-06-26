package fr.eni.movieslib.dal;

import fr.eni.movieslib.bo.users.RegisteredUser;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Profile("prod")
public class UserDAO {

    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public void setJDBCTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public RegisteredUser getById() {
        return null;
    }

    public RegisteredUser getByEmail(String email) {
        return null;
    }

    public List<RegisteredUser> findAll() {
        return null;
    }

    public void add(RegisteredUser user) {
    }

    public void delete(long id) {
    }
}
