package fr.eni.movieslib.dal;

import fr.eni.movieslib.bo.users.RegisteredUser;
import org.springframework.context.annotation.Profile;

import java.util.List;

@Profile("prod")
public class UserDAO {

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

    public void delete() {
    }
}
