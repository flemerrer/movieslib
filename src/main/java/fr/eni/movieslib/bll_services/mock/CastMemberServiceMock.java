package fr.eni.movieslib.bll_services.mock;

import fr.eni.movieslib.bll_services.CastMemberService;
import fr.eni.movieslib.bo.users.CastMember;
import fr.eni.movieslib.dal.MovieDAOMock;
import fr.eni.movieslib.dal.MovieDAOMockFactory;
import org.springframework.stereotype.Service;

@Service
public class CastMemberServiceMock implements CastMemberService {

    MovieDAOMock movieDAOMock;

    public CastMemberServiceMock() {
        this.movieDAOMock = MovieDAOMockFactory.getMovieDAO();
    }

    @Override
    public void add(String firstName, String lastName) {

    }

    @Override
    public void add(CastMember castMember) {
        CastMember comparedMember = movieDAOMock.GetCastMemberById(castMember.getId());
        if (comparedMember == null) {
            movieDAOMock.addCastMember(castMember);
        }
    }
}
