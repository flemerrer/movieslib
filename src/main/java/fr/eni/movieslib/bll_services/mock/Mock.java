package fr.eni.movieslib.bll_services.mock;

import java.util.ArrayList;
import java.util.List;


import fr.eni.movieslib.bll_services.MovieService;
import fr.eni.movieslib.bo.movies.Movie;
import fr.eni.movieslib.bo.movies.Genre;
import fr.eni.movieslib.bo.movies.Review;
import fr.eni.movieslib.bo.users.CastMember;
import fr.eni.movieslib.bo.users.RegisteredUser;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("dev")
public class Mock implements MovieService {
    // Attributs statiques pour gérer les valeurs à afficher et simuler les données
    // en base
    private static List<Movie> moviesList = new ArrayList<>();
    private static List<Genre> genresList = new ArrayList<>();
    private static List<CastMember> CastMembers = new ArrayList<>();
    private static int moviesIndex = 1;

    // Représente la table en base de données des genres des films
    private static final String[] genres = { "Animation", "Science-fiction", "Documentaire", "Action", "Comédie",
            "Drame" };

    public Mock() {
    }

    @Override
    public List<Movie> getAllMovies() {
        return moviesList;
    }

    /**
     * \@return film si id correspond
     * \@return null si inconnu
     */
    @Override
    public Movie getMovieById(long id) {
        return moviesList.stream().filter(item -> item.getId() == id).findAny().orElse(null);
    }

    @Override
    public List<Genre> getGenresList() {
        return genresList;
    }

    @Override
    public List<CastMember> getCastMembers() {
        return CastMembers;
    }

    @Override
    public Genre getGenreById(long id) {
        return genresList.stream().filter(item -> item.getId() == id).findAny().orElse(null);
    }

    /**
     * \@return participant si id correspond
     * \@return null si inconnu
     */
    @Override
    public CastMember GetCastMemberById(long id) {
        return CastMembers.stream().filter(item -> item.getId() == id).findAny().orElse(null);
    }

    @Override
    public void addMovie(Movie movie) {
        // Sauvegarde du film
        movie.setId(moviesIndex++);
        moviesList.add(movie);
    }

    /**
     * Cette méthode permet de simuler le stockage en base de données et la remontée
     * d'information
     */
    public void mockDALandDB() {
        // Création de la liste des genres
        for (int index = 0; index < genres.length; index++) {
            genresList.add(new Genre(index + 1, genres[index]));
        }

        // Création de la liste des participants aux films (acteurs et réalisateurs)
        // 3 réalisateurs dont 1 pour 2 films et 1 réalisateurs qui est aussi un acteur
        CastMembers.add(new CastMember(1, "Spielberg", "Steven"));
        CastMembers.add(new CastMember(2, "Cronenberg", "David"));
        CastMembers.add(new CastMember(3, "Boon", "Dany"));

        // 2 acteurs par film et l'un d'eux dans 2 films
        CastMembers.add(new CastMember(4, "Attenborough", "Richard"));
        CastMembers.add(new CastMember(5, "Goldblum", "Jeff"));
        CastMembers.add(new CastMember(6, "Davis", "Geena"));
        CastMembers.add(new CastMember(7, "Rylance", "Mark"));
        CastMembers.add(new CastMember(8, "Barnhill", "Ruby"));
        CastMembers.add(new CastMember(9, "Merad", "Kad"));

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
