package fr.eni.movieslib.dal.mock;

import fr.eni.movieslib.bo.users.RegisteredUser;
import org.springframework.context.annotation.Profile;

import java.util.ArrayList;
import java.util.List;

@Profile("dev")
public class UserDAOMock {
    private static List<RegisteredUser> usersList = new ArrayList<>();

    public void createUser(RegisteredUser user) {
        usersList.add(user);
    }

    public List<RegisteredUser> getAllUsers() {
        return usersList;
    }

    public RegisteredUser getUserByUsername(String username) {
        return usersList.stream().filter(e -> e.getEmail().equals(username)).findFirst().orElse(null);
    }

    public void deleteUser(long id) {
    }

    public UserDAOMock() {
        RegisteredUser user1 = new RegisteredUser("John", "Doe", "admin", null);
        user1.setAdmin(true);
        usersList.add(user1);
        RegisteredUser user2 = new RegisteredUser("Jane", "Doe", "jane", null);
        usersList.add(user2);
    }
}
