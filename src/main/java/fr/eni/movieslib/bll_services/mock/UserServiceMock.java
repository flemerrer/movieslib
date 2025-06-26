package fr.eni.movieslib.bll_services.mock;

import fr.eni.movieslib.bll_services.UserService;
import fr.eni.movieslib.bo.users.RegisteredUser;
import fr.eni.movieslib.dal.mock.UserDAOMock;
import fr.eni.movieslib.dal.mock.UserDAOMockFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Profile("dev")
public class UserServiceMock implements UserService {

    UserDAOMock userDAOMock;

    public UserServiceMock() {
        this.userDAOMock = UserDAOMockFactory.getUserDAOMock();
    }

    @Override
    public List<RegisteredUser> getAllUsers() {
        return userDAOMock.getAllUsers();
    }

    @Override
    public RegisteredUser getUserByName(String username) {
        return userDAOMock.getUserByUsername(username);
    }

    @Override
    public void addUser(RegisteredUser user) {
        userDAOMock.createUser(user);
    }

    @Override
    public void removeUser(RegisteredUser user) {
        userDAOMock.deleteUser();
    }

}

