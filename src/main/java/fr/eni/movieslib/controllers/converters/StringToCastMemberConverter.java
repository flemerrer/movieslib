package fr.eni.movieslib.controllers.converters;

import fr.eni.movieslib.bll_services.mock.CastMemberServiceMock;
import fr.eni.movieslib.bo.users.CastMember;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringToCastMemberConverter implements Converter<String, CastMember> {

    public void setCastMemberService(CastMemberServiceMock castMemberServiceMock) {
    }

    @Override
    public CastMember convert(String source) {
        String[] split = source.split(" ");
        return new CastMember(split[0], split[1]);
    }
}
