package fr.eni.movieslib.bo.users;

import fr.eni.movieslib.bo.movies.Movie;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@NoArgsConstructor
public class CastMember extends User{
    Roles role;
    ArrayList<Movie> movies = new ArrayList<>();

    public CastMember(String name, String surname) {
        super(name, surname);
    }

    public CastMember(long id, String name, String surname) {
        super(id, name, surname);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
