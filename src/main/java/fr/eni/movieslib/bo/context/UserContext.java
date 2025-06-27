package fr.eni.movieslib.bo.context;

import fr.eni.movieslib.bo.users.RegisteredUser;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class UserContext {
    private String email = null;
    boolean isAdmin;

    public UserContext(RegisteredUser user) {
        this.email = user.getEmail();
        this.isAdmin = user.isAdmin();
    }

    @Override
    public String toString() {
        return email;
    }

}
