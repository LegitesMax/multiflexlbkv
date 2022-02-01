package org.acme.mapper;

import org.acme.DTO.RegalDto;
import org.acme.model.Regal;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface RegalMapper {
    @Mapping(target = "faecher", ignore = true)
    @Mapping(target = "fachIds", ignore = true)
    RegalDto toResource(List<Regal> regal);
    //RegalDto regalToDto(Regal regal);
}
