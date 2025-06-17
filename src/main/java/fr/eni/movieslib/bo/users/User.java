package fr.eni.movieslib.bo.users;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public abstract class User implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    static long idCounter;
    long id;
    String firstName;
    String lastName;

    public User(String firstName, String name) {
        this.firstName = name;
        this.lastName = firstName;
        idCounter++;
        this.id = idCounter;
    }

    public User(long id, String firstName, String name) {
        this.id = id;
        this.firstName = name;
        this.lastName = firstName;
        idCounter++;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }

}
