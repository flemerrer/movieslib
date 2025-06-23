package fr.eni.movieslib.dal;

public class UserDAOMockFactory {

    private static UserDAOMock userDAOMock;

    public static UserDAOMock getUserDAOMock() {
        if(userDAOMock == null)
            userDAOMock = new UserDAOMock();
        return userDAOMock;
    }

}
