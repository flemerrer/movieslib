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

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
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
        if (lastName.isEmpty()) {
            return firstName;
        }
        return firstName + " " + lastName.toUpperCase();
    }

}
