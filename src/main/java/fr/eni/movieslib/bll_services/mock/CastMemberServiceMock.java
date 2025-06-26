package fr.eni.movieslib.bll_services.mock;

import fr.eni.movieslib.bll_services.CastMemberService;
import fr.eni.movieslib.bo.users.CastMember;
import fr.eni.movieslib.dal.mock.MovieDAOMock;
import fr.eni.movieslib.dal.mock.MovieDAOMockFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("dev")
public class CastMemberServiceMock {

    MovieDAOMock movieDAOMock;

    public CastMemberServiceMock() {
        this.movieDAOMock = MovieDAOMockFactory.getMovieDAO();
    }

    public void add(String firstName, String lastName) {

    }

    public void add(CastMember castMember) {
        CastMember comparedMember = movieDAOMock.GetCastMemberById(castMember.getId());
        if (comparedMember == null) {
            movieDAOMock.addCastMember(castMember);
        }
    }
}
