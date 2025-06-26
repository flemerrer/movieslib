package fr.eni.movieslib.dal;

import fr.eni.movieslib.bo.users.CastMember;
import org.springframework.context.annotation.Profile;

import java.util.List;

@Profile("prod")
public class CastMemberDAO {

    public CastMember findById(int id){
        return null;
    }

    public List<CastMember> findAll(){
        return null;
    }

    public List<CastMember> findCastMembersByMovieId(long movie_id){
        return null;
    }

    public void add(long movie_id, long cast_id){}

}
