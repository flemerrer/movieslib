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
    public List<RegisteredUser> findAll() {
        return userDAOMock.getAllUsers();
    }

    @Override
    public RegisteredUser findByEmail(String username) {
        return userDAOMock.getUserByUsername(username);
    }

    @Override
    public RegisteredUser findById(long id) {
        return null;
    }

    @Override
    public void add(RegisteredUser user) {
        userDAOMock.createUser(user);
    }

    @Override
    public void delete(long id) {
        userDAOMock.deleteUser(id);
    }

}

