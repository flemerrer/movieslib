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

    boolean isDirector;
    ArrayList<Movie> movies = new ArrayList<>();

    public CastMember(String firstName, String lastName) {
        super(firstName, lastName);
    }

    public CastMember(long id, String firstName, String lastName) {
        super(id, firstName, lastName);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
