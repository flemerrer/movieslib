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

    String pseudo;
    String password;
    boolean isAdmin = false;
    ArrayList<Review> reviews = new ArrayList<>();

    public RegisteredUser(long id, String name, String surname, String pseudo, String password) {
        super(id, name, surname);
        this.pseudo = pseudo;
        this.password = password;
    }

    public RegisteredUser(String name, String surname, String pseudo, String password) {
        super(name, surname);
        this.pseudo = pseudo;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Member{" +
                "isAdmin=" + isAdmin +
                ", reviews=" + reviews +
                ", id=" + id +
                ", name='" + surname + '\'' +
                ", surname='" + lastName + '\'' +
                ", pseudo='" + pseudo + '\'' +
                '}';
    }
}
