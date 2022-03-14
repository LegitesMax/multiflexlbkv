package org.acme.mapper;

import javax.annotation.processing.Generated;
import javax.enterprise.context.ApplicationScoped;
import org.acme.DTO.WareDto;
import org.acme.model.Ware;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-03-07T20:38:36+0100",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 15.0.2 (Oracle Corporation)"
)
@ApplicationScoped
public class WareMapperImpl implements WareMapper {

    @Override
    public WareDto toDTO(Ware ware) {
        if ( ware == null ) {
            return null;
        }

        WareDto wareDto = new WareDto();

        wareDto.setId( ware.getId() );
        wareDto.setName( ware.getName() );
        wareDto.setBestand( ware.getBestand() );
        wareDto.setMinbestand( ware.getMinbestand() );
        wareDto.setMaxbestand( ware.getMaxbestand() );

        return wareDto;
    }

    @Override
    public Ware dtoToWare(WareDto ware) {
        if ( ware == null ) {
            return null;
        }

        Ware ware1 = new Ware();

        ware1.setId( ware.getId() );
        ware1.setName( ware.getName() );
        ware1.setBestand( ware.getBestand() );
        ware1.setMinbestand( ware.getMinbestand() );
        ware1.setMaxbestand( ware.getMaxbestand() );

        return ware1;
    }
}
