package fr.eni.movieslib.bo.movies;

import java.util.ArrayList;
import java.util.Calendar;

import fr.eni.movieslib.bo.users.CastMember;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Movie {
    long id;
    String title;
    int year;
    int duration;
    String synopsis;
    Genre genre;
    CastMember director;
    ArrayList<CastMember> actors = new ArrayList<>();
    ArrayList<Review> reviews = new ArrayList<>();

    public Movie(String title, int year, int duration, String synopsis) {
        this.title = title;
        this.year = year;
        this.duration = duration;
        this.synopsis = synopsis;
    }

    public Movie(long id, String title, int year, int duration, String synopsis) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.duration = duration;
        this.synopsis = synopsis;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", year=" + year +
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
