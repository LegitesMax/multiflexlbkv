package org.acme.mapper;

import org.acme.DTO.FachDto;
import org.acme.model.Fach;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "cdi")
public interface FachMapper {

    @Mapping(target = "id")
    FachDto toDTO(Fach fach);

    @Mapping(target = "id")
    Fach dtoToFach(FachDto fach);

}
