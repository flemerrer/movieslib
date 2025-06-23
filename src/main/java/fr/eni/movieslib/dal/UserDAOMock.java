package fr.eni.movieslib.dal;

import fr.eni.movieslib.bo.users.RegisteredUser;

import java.util.ArrayList;
import java.util.List;

public class UserDAOMock {
    private static List<RegisteredUser> usersList = new ArrayList<>();

    public void createUser(RegisteredUser user) {
        usersList.add(user);
    }

    public List<RegisteredUser> getAllUsers() {
        return usersList;
    }

    public RegisteredUser getUserByUsername(String username) {
        return usersList.stream().filter(e -> e.getPseudo().equals(username)).findFirst().orElse(null);
    }

    public void deleteUser() {
    }

    public UserDAOMock() {
        RegisteredUser user1 = new RegisteredUser("John", "Doe", "admin", null);
        user1.setAdmin(true);
        usersList.add(user1);
        RegisteredUser user2 = new RegisteredUser("Jane", "Doe", "jane", null);
        usersList.add(user2);
    }
}
