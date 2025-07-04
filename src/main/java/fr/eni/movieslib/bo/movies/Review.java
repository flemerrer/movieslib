package fr.eni.movieslib.bo.movies;

import fr.eni.movieslib.bo.users.RegisteredUser;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class Review implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    long id;

    @NotNull
    @Range(min = 1, max = 5)
    int rating;

    String comment;
    RegisteredUser member;

    public Review(int rating, String comment) {
        this.rating = rating;
        this.comment = comment;
    }

    public Review(int rating, String comment, RegisteredUser member) {
        this.rating = rating;
        this.comment = comment;
        this.member = member;
    }

    public Review(long id, int rating, String comment, RegisteredUser member) {
        this.id = id;
        this.rating = rating;
        this.comment = comment;
        this.member = member;
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", rating=" + rating +
                ", comment='" + comment + '\'' +
                ", member=" + member +
                '}';
    }
}
