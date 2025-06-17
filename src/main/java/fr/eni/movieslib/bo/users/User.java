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
    String surname;
    String lastName;

    public User(String surname, String name) {
        this.surname = name;
        this.lastName = surname;
        idCounter++;
        this.id = idCounter;
    }

    public User(long id, String surname, String name) {
        this.id = id;
        this.surname = name;
        this.lastName = surname;
        idCounter++;
    }

    @Override
    public String toString() {
        return surname + " " + lastName;
    }
}
