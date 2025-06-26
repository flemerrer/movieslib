package fr.eni.movieslib.dal;

import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@Profile("prod")
public class UserDAOFactory {

    private static NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public UserDAOFactory(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        UserDAOFactory.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    private static UserDAO userDAO;

    public static UserDAO getUserDAO() {
        if(userDAO == null) {
            userDAO = new UserDAO();
            userDAO.setJDBCTemplate(namedParameterJdbcTemplate);
        }
        return userDAO;
    }

}
