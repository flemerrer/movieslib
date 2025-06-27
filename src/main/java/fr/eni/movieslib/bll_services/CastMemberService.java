package fr.eni.movieslib.bll_services;

import fr.eni.movieslib.bo.users.CastMember;
import fr.eni.movieslib.dal.CastMemberDAO;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Profile("prod")
public class CastMemberService {

    CastMemberDAO castMemberDAO;

    public CastMemberService(CastMemberDAO castMemberDAO) {
        this.castMemberDAO = castMemberDAO;
    }

    public void add(long movieId, long castId) {
        castMemberDAO.add(movieId, castId);
    }

    public List<CastMember> findAll() {
        return castMemberDAO.findAll();
    }

    public CastMember findById(long id) {
        return castMemberDAO.findById(id);
    }

    public List<CastMember> findByMovieId(long id) {
        return castMemberDAO.findCastMembersByMovieId(id);
    }
}
