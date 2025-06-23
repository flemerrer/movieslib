package fr.eni.movieslib.bll_services;

import fr.eni.movieslib.bo.users.RegisteredUser;

import java.util.List;

public interface UserService {
    List<RegisteredUser> getAllUsers();
    RegisteredUser getUserByName(String username);
    void addUser(RegisteredUser user);
    void removeUser(RegisteredUser user);
}
