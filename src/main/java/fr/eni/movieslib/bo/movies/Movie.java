package fr.eni.movieslib.bo.movies;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;

import fr.eni.movieslib.bo.users.CastMember;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Movie implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    long id;

    @Size(min = 2, max = 250, message="Le nom doit avoir au moins 2 caractères")
    String title;

    int releaseDate;
    int duration;
    CastMember director;
    Genre genre;
    String synopsis;
    ArrayList<CastMember> actors = new ArrayList<>();
    ArrayList<Review> reviews = new ArrayList<>();

    public Movie(String title, int year, int duration, String synopsis) {
        this.title = title;
        this.releaseDate = year;
        this.duration = duration;
        this.synopsis = synopsis;
    }

    public Movie(long id, String title, int year, int duration, String synopsis) {
        this.id = id;
        this.title = title;
        this.releaseDate = year;
        this.duration = duration;
        this.synopsis = synopsis;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", year=" + releaseDate +
                ", duration=" + duration +
                ", synopsis='" + synopsis + '\'' +
                ", genre=" + genre +
                ", director=" + director +
                ", actors=" + actors +
                ", reviews=" + reviews +
                '}';
    }

    public void addActor(CastMember actor) {
        actors.add(actor);
    }

    public void addReview(Review review) {
        reviews.add(review);
    }
}
