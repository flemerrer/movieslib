package fr.eni.movieslib.bo.movies;

import fr.eni.movieslib.bo.users.RegisteredUser;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Review {
    long id;
    int rating;
    String comment;
    RegisteredUser member;

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
