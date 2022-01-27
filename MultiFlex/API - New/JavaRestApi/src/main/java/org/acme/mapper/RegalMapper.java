package org.acme.mapper;

import org.acme.DTO.RegalDto;
import org.acme.model.Regal;
import org.mapstruct.Mapper;

@Mapper
public interface RegalMapper {
    //@Mapping(target = "faecher", ignore = true)
    //@Mapping(target = "fachIds", ignore = true)
    RegalDto regalToDto(Regal regal);
}
