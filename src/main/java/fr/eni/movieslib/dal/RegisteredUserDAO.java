package fr.eni.movieslib.dal;

import fr.eni.movieslib.bo.users.RegisteredUser;
import org.springframework.context.annotation.Profile;

@Profile("prod")
public class RegisteredUserDAO {

    public RegisteredUser getById() {
        return null;
    }

    public RegisteredUser getByEmail(String email) {
        return null;
    }

}
