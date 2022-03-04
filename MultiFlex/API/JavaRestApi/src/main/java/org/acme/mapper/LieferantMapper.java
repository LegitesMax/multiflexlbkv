package org.acme.mapper;

import org.acme.DTO.LieferantDto;
import org.acme.model.Lieferant;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "cdi")
public interface LieferantMapper {
    //@Mapping(target = "id")
    LieferantDto toDTO(Lieferant lieferant);

    //@Mapping(target = "id")
    Lieferant dtoToRegal(LieferantDto lieferant);
}
