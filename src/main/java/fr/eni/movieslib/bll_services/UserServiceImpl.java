package fr.eni.movieslib.bll_services;

import fr.eni.movieslib.bo.users.RegisteredUser;
import fr.eni.movieslib.dal.UserDAO;
import fr.eni.movieslib.dal.UserDAOFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Profile("prod")
public class UserServiceImpl implements UserService {

    UserDAO userDAO;

    public UserServiceImpl() {
        this.userDAO = UserDAOFactory.getUserDAO();
    }

    @Override
    public List<RegisteredUser> findAll() {
        return userDAO.findAll();
    }

    @Override
    public RegisteredUser findByEmail(String email) {
        return userDAO.getByEmail(email);
    }

    @Override
    public void add(RegisteredUser user) {
        userDAO.add(user);
    }

    @Override
    public void delete(long id) {
        userDAO.delete(id);
    }

}

