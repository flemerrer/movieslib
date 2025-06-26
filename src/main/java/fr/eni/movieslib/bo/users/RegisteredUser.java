package fr.eni.movieslib.bo.users;

import fr.eni.movieslib.bo.movies.Review;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;

@Getter
@Setter
@NoArgsConstructor
public class RegisteredUser extends User implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    String email;
    String password;
    boolean isAdmin = false;

    public RegisteredUser(long id, String lastName, String firstName, String email, String password) {
        super(id, lastName, firstName);
        this.email = email;
        this.password = password;
    }

    public RegisteredUser(String name, String firstName, String email, String password) {
        super(name, firstName);
        this.email = email;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Member{" +
                "isAdmin=" + isAdmin +
                ", id=" + id +
                ", name='" + firstName + '\'' +
                ", firstName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
