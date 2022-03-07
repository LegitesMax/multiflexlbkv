package org.acme.mapper;

import javax.annotation.processing.Generated;
import javax.enterprise.context.ApplicationScoped;
import org.acme.DTO.FachDto;
import org.acme.model.Fach;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-03-07T20:38:37+0100",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 15.0.2 (Oracle Corporation)"
)
@ApplicationScoped
public class FachMapperImpl implements FachMapper {

    @Override
    public FachDto toDTO(Fach fach) {
        if ( fach == null ) {
            return null;
        }

        FachDto fachDto = new FachDto();

        fachDto.setId( fach.getId() );
        fachDto.setPosition( fach.getPosition() );
        fachDto.setMaxbestand( fach.getMaxbestand() );

        return fachDto;
    }

    @Override
    public Fach dtoToFach(FachDto fach) {
        if ( fach == null ) {
            return null;
        }

        Fach fach1 = new Fach();

        fach1.setId( fach.getId() );
        fach1.setPosition( fach.getPosition() );
        fach1.setMaxbestand( fach.getMaxbestand() );

        return fach1;
    }
}
