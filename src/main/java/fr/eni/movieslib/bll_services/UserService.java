package fr.eni.movieslib.bll_services;

import fr.eni.movieslib.bo.users.RegisteredUser;

import java.util.List;

public interface UserService {
    List<RegisteredUser> findAll();
    RegisteredUser findByEmail(String username);
    void add(RegisteredUser user);
    void delete(long id);
}
