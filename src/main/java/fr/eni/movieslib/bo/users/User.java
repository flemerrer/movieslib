package fr.eni.movieslib.bo.users;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public abstract class User {
    long id;
    String surname;
    String lastName;

    public User(String surname, String name) {
        this.surname = name;
        this.lastName = surname;
    }

    public User(long id, String surname, String name) {
        this.id = id;
        this.surname = name;
        this.lastName = surname;
    }

    @Override
    public String toString() {
        return surname + " " + lastName;
    }
}
