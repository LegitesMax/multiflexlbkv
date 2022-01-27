package org.acme.mapper;

import org.acme.DTO.FachDto;
import org.acme.DTO.RegalDto;
import org.acme.model.Fach;
import org.acme.model.Regal;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

//@Mapper(componentModel = "cdi")
public interface RegalMapper {
    //@Mapping(target = "faecher", ignore = true)
    //@Mapping(target = "fachIds", ignore = true)
    RegalDto toResource(Regal regal);
}
