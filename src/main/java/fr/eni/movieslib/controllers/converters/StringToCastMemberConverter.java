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
        if (source == null) {
            return null;
        }
        String[] split = source.split(" ");
        if  (split.length == 1) {
            return new CastMember(split[0], "");
        }
        if  (split.length > 2) {
            StringBuilder rest = new StringBuilder();
            for (int i = 1; i < split.length; i++) {
                rest.append(split[i]).append(" ");
            }
            rest.deleteCharAt(rest.length() - 1);
            return new CastMember(split[0], rest.toString());
        }
        return new CastMember(split[0], split[1]);
    }
}
