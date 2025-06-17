package fr.eni.movieslib.dal;

import fr.eni.movieslib.bo.movies.Genre;
import fr.eni.movieslib.bo.movies.Movie;
import fr.eni.movieslib.bo.movies.Review;
import fr.eni.movieslib.bo.users.CastMember;
import fr.eni.movieslib.bo.users.RegisteredUser;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class MovieDAOMock implements MovieDAO {

    private static List<Movie> moviesList = new ArrayList<>();
    private static List<Genre> genresList = new ArrayList<>();
    @Getter
    private static List<CastMember> castMembers = new ArrayList<>();
    @Getter
    private static final String[] genres = { "Animation", "Science-fiction", "Documentaire", "Action", "Comédie",
            "Drame" };
    private static int moviesIndex = 1;

    @Override
    public Movie create(long id, String title, int year, int duration, String synopsis) {
        return null;
    }

    @Override
    public Movie get(long id) {
        return moviesList.stream().filter(item -> item.getId() == id).findAny().orElse(null);
    }

    @Override
    public List<Movie> getAll() {
        return moviesList;
    }

    @Override
    public Movie update(int id, String title, int year, String genre, int duration, String synopsis, List<CastMember> actors, CastMember director, List<Review> reviews) {
        return null;
    }

    public Genre getGenreById(long id) {
        return genresList.stream().filter(item -> item.getId() == id).findAny().orElse(null);
    }

    public CastMember GetCastMemberById(long id) {
        return castMembers.stream().filter(item -> item.getId() == id).findAny().orElse(null);
    }

    public void addMovie(Movie movie) {
        movie.setId(moviesIndex++);
        moviesList.add(movie);
    }

    public void removeMovie(Movie movie) {
        movie.setId(moviesIndex++);
        moviesList.remove(movie);
    }


    public void mockDALandDB() {
        // Création de la liste des genres
        for (int index = 0; index < genres.length; index++) {
            genresList.add(new Genre(index + 1, genres[index]));
        }

        // Création de la liste des participants aux films (acteurs et réalisateurs)
        // 3 réalisateurs dont 1 pour 2 films et 1 réalisateurs qui est aussi un acteur
        castMembers.add(new CastMember(1, "Spielberg", "Steven"));
        castMembers.add(new CastMember(2, "Cronenberg", "David"));
        castMembers.add(new CastMember(3, "Boon", "Dany"));

        // 2 acteurs par film et l'un d'eux dans 2 films
        castMembers.add(new CastMember(4, "Attenborough", "Richard"));
        castMembers.add(new CastMember(5, "Goldblum", "Jeff"));
        castMembers.add(new CastMember(6, "Davis", "Geena"));
        castMembers.add(new CastMember(7, "Rylance", "Mark"));
        castMembers.add(new CastMember(8, "Barnhill", "Ruby"));
        castMembers.add(new CastMember(9, "Merad", "Kad"));

        // Création de la liste de films
        // 4 films
        Movie jurassicPark = new Movie(moviesIndex++, "Jurassic Park", 1993, 128,
                "Le film raconte l'histoire d'un milliardaire et son équipe de généticiens parvenant à ramener à la vie des dinosaures grâce au clonage.");
        jurassicPark.setGenre(genresList.get(1));
        jurassicPark.setDirector(GetCastMemberById(1));
        // Associer les acteurs
        jurassicPark.addActor(GetCastMemberById(4));
        jurassicPark.addActor(GetCastMemberById(5));
        moviesList.add(jurassicPark);

        Movie theFly = new Movie(moviesIndex++, "The Fly", 1986, 95,
                "Il s'agit de l'adaptation cinématographique de la nouvelle éponyme de l'auteur George Langelaan.");
        theFly.setGenre(genresList.get(1));
        theFly.setDirector(GetCastMemberById(2));
        // Associer les acteurs
        theFly.addActor(GetCastMemberById(5));
        theFly.addActor(GetCastMemberById(6));
        moviesList.add(theFly);

        Movie theBFG = new Movie(moviesIndex++, "The BFG", 2016, 117,
                "Le Bon Gros Géant est un géant bien différent des autres habitants du Pays des Géants.");
        theBFG.setGenre(genresList.get(4));
        theBFG.setDirector(GetCastMemberById(1));
        // Associer les acteurs
        theBFG.addActor(GetCastMemberById(7));
        theBFG.addActor(GetCastMemberById(8));
        moviesList.add(theBFG);

        Movie bienvenueChezLesChtis = new Movie(moviesIndex++, "Bienvenue chez les Ch'tis", 2008, 106,
                "Philippe Abrams est directeur de la poste de Salon-de-Provence. Il est marié à Julie, dont le caractère dépressif lui rend la vie impossible. Pour lui faire plaisir, Philippe fraude afin d'obtenir une mutation sur la Côte d'Azur. Mais il est démasqué: il sera muté à Bergues, petite ville du Nord.");
        bienvenueChezLesChtis.setGenre(genresList.get(4));
        bienvenueChezLesChtis.setDirector(GetCastMemberById(3));
        // Associer les acteurs
        bienvenueChezLesChtis.addActor(GetCastMemberById(3));
        bienvenueChezLesChtis.addActor(GetCastMemberById(9));
        moviesList.add(bienvenueChezLesChtis);

        // Création d'un membre et un avis
        RegisteredUser member1 = new RegisteredUser(1, "Baille", "Anne-Lise", "abaille@campus-eni.fr", null);
        Review review = new Review(1, 4, "On rit du début à la fin", member1);
        bienvenueChezLesChtis.addReview(review);
    }
}
