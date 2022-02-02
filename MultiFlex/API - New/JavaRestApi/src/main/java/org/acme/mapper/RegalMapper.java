package org.acme.mapper;

import org.acme.DTO.RegalDto;
import org.acme.model.Regal;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "cdi")
public interface RegalMapper {

    @Mapping(target = "id")
    RegalDto toDTO(Regal regal);

    @Mapping(target = "id", ignore = true)
    Regal dtoToRegal(RegalDto regal);
}
