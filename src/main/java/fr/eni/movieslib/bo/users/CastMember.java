package fr.eni.movieslib.bo.users;

import fr.eni.movieslib.bo.movies.Movie;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;

@Getter
@Setter
@NoArgsConstructor
public class CastMember extends User implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    Roles role;
    ArrayList<Movie> movies = new ArrayList<>();

    public CastMember(String name, String firstName) {
        super(name, firstName);
    }

    public CastMember(long id, String name, String firstName) {
        super(id, name, firstName);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
