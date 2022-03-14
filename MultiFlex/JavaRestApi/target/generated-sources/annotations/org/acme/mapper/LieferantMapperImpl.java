package org.acme.mapper;

import javax.annotation.processing.Generated;
import javax.enterprise.context.ApplicationScoped;
import org.acme.DTO.LieferantDto;
import org.acme.model.Lieferant;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-03-07T20:38:37+0100",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 15.0.2 (Oracle Corporation)"
)
@ApplicationScoped
public class LieferantMapperImpl implements LieferantMapper {

    @Override
    public LieferantDto toDTO(Lieferant lieferant) {
        if ( lieferant == null ) {
            return null;
        }

        LieferantDto lieferantDto = new LieferantDto();

        lieferantDto.setId( lieferant.getId() );
        lieferantDto.setName( lieferant.getName() );
        lieferantDto.setWeblink( lieferant.getWeblink() );
        lieferantDto.setLieferzeit( lieferant.getLieferzeit() );

        return lieferantDto;
    }

    @Override
    public Lieferant dtoToRegal(LieferantDto lieferant) {
        if ( lieferant == null ) {
            return null;
        }

        Lieferant lieferant1 = new Lieferant();

        lieferant1.setId( lieferant.getId() );
        lieferant1.setName( lieferant.getName() );
        lieferant1.setLieferzeit( lieferant.getLieferzeit() );
        lieferant1.setWeblink( lieferant.getWeblink() );

        return lieferant1;
    }
}
