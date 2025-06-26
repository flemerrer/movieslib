package fr.eni.movieslib.dal;

import org.springframework.context.annotation.Profile;

@Profile("dev")
public class UserDAOFactory {

    private static UserDAO userDAO;

    public static UserDAO getUserDAO() {
        if(userDAO == null)
            userDAO = new UserDAO();
        return userDAO;
    }

}
