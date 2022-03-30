package org.acme.mapper;

import org.acme.DTO.*;
import org.acme.model.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "cdi")
public interface ObjectMapper {
    //Regal
    @Mapping(target = "id")
    RegalDto toDTO(Regal regal);

    @Mapping(target = "id")
    Regal fromDto(RegalDto regal);

    //Fach
    @Mapping(target = "id")
    FachDto toDTO(Fach fach);

    @Mapping(target = "id")
    Fach fromDto(FachDto fach);

    //Ware
    @Mapping(target = "id")
    WareDto toDTO(Ware ware);

    @Mapping(target = "id")
    Ware fromDto(WareDto ware);

    //Lieferant
    @Mapping(target = "id")
    LieferantDto toDTO(Lieferant lieferant);

    @Mapping(target = "id")
    Lieferant fromDto(LieferantDto lieferant);

    //Material
    @Mapping(target = "id")
    TypDto toDTO(Typ typ);

    @Mapping(target = "id")
    Typ fromDto(TypDto typDto);
}
