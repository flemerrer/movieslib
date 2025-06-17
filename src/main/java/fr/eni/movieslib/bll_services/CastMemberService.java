package fr.eni.movieslib.bll_services;

import fr.eni.movieslib.bo.users.CastMember;

public interface CastMemberService {
    void add(String firstName, String lastName);
    void add(CastMember castMember);
}
