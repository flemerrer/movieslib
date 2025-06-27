package fr.eni.movieslib.bll_services.mappers;

import fr.eni.movieslib.bo.users.RegisteredUser;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class UserMapper implements RowMapper<RegisteredUser> {

    public RegisteredUser mapRow(ResultSet rs, int rowNum) throws SQLException {
        RegisteredUser user = new RegisteredUser();
        user.setId(rs.getLong("id"));
        user.setEmail(rs.getString("email"));
        user.setFirstName(rs.getString("first_name"));
        user.setLastName(rs.getString("last_name"));
        user.setPassword(rs.getString("password"));
        user.setAdmin(rs.getBoolean("is_admin"));
        return user;
    }

}
