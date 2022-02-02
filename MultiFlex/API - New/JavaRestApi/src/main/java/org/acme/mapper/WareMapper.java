package org.acme.mapper;

import org.acme.DTO.WareDto;
import org.acme.model.Ware;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "cdi")
public interface WareMapper {

    @Mapping(target = "id")
    WareDto toDTO(Ware ware);

    @Mapping(target = "id", ignore = true)
    Ware dtoToWare(WareDto ware);

}
