package fr.eni.movieslib.dal.mock;

import org.springframework.context.annotation.Profile;

@Profile("dev")
public class UserDAOMockFactory {

    private static UserDAOMock userDAOMock;

    public static UserDAOMock getUserDAOMock() {
        if(userDAOMock == null)
            userDAOMock = new UserDAOMock();
        return userDAOMock;
    }

}
