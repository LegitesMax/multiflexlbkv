package org.acme.mapper;

import org.acme.DTO.WareDto;
import org.acme.model.Ware;
import org.mapstruct.Mapper;

//@Mapper
public interface WareMapper {
    WareDto toResource(Ware ware);
}
