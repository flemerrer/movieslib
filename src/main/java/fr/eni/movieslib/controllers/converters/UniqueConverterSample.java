/*
package fr.eni.movieslib.controllers.converters;

import fr.eni.movieslib.bll_services.MovieService;
import org.springframework.beans.factory.annotation.*;
        import org.springframework.core.convert.*;
        import org.springframework.core.convert.converter.*;

        import java.util.*;
        import java.util.stream.*;

*/
/** @author Souheil SULTAN *//*

//@Component
public class GenericCollectionConverter3 implements ConditionalGenericConverter {

    @Autowired
    private MovieService service;

    @Override
    public Set<ConvertiblePair> getConvertibleTypes() {
        return null;
    }

    @Override
    public boolean matches( TypeDescriptor idType, TypeDescriptor beanType ) {
        final var idClass = idType.isArray() ? idType.getElementTypeDescriptor().getType() : idType.getType();
        return idClass.equals(String.class) && beanType.isCollection();
    }

    @Override
    public Object convert( Object idValues, TypeDescriptor idType, TypeDescriptor beanType ) {
        final var beanClass = beanType.getElementTypeDescriptor().getType();
        final var values = idType.isArray() ? Arrays.stream((Object[])idValues) : Stream.of(idValues);
        return values.map( id -> switch (beanClass.getSimpleName()) {
            case "Participant" -> service.getParticipantById(Long.parseLong((String)id));
            default -> throw new UnknownFormatConversionException( "Unsupported type: " + beanClass );
        }).collect(Collectors.toList());
    }

}
*/
