package fr.eni.movieslib.bo.context;

import fr.eni.movieslib.bo.users.RegisteredUser;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class UserContext {
    private String username = null;
    boolean isAdmin;

    public UserContext(RegisteredUser user) {
        this.username = user.getEmail();
        this.isAdmin = user.isAdmin();
    }

    @Override
    public String toString() {
        return username;
    }

}
