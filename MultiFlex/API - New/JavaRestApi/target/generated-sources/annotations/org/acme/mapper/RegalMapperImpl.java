package org.acme.mapper;

import javax.annotation.processing.Generated;
import javax.enterprise.context.ApplicationScoped;
import org.acme.DTO.RegalDto;
import org.acme.model.Regal;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-03-03T08:17:05+0100",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 15.0.2 (Oracle Corporation)"
)
@ApplicationScoped
public class RegalMapperImpl implements RegalMapper {

    @Override
    public RegalDto toDTO(Regal regal) {
        if ( regal == null ) {
            return null;
        }

        RegalDto regalDto = new RegalDto();

        regalDto.setId( regal.getId() );
        regalDto.setName( regal.getName() );
        regalDto.setMax_anzahl_faecher( regal.getMax_anzahl_faecher() );

        return regalDto;
    }

    @Override
    public Regal dtoToRegal(RegalDto regal) {
        if ( regal == null ) {
            return null;
        }

        Regal regal1 = new Regal();

        regal1.setId( regal.getId() );
        regal1.setName( regal.getName() );
        regal1.setMax_anzahl_faecher( regal.getMax_anzahl_faecher() );

        return regal1;
    }
}
