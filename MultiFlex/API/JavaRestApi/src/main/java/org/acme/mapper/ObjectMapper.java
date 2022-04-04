package org.acme.mapper;

import org.acme.DTO.*;
import org.acme.DTO.Type;
import org.acme.model.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "cdi")
public interface ObjectMapper {
    //Regal
    @Mapping(target = "id")
    RegalDto toDTO(Regal regal);

    @Mapping(target = "id")
    Regal fromDto(RegalDto regal);

    //Shelf
    @Mapping(target = "id")
    ShelfDto toDTO(Shelf fach);

    @Mapping(target = "id")
    Shelf fromDto(ShelfDto fach);

    //Ware
    @Mapping(target = "id")
    WareDto toDTO(Ware ware);

    @Mapping(target = "id")
    Ware fromDto(WareDto ware);

    //Supplier
    @Mapping(target = "id")
    SupplierDto toDTO(Supplier lieferant);

    @Mapping(target = "id")
    Supplier fromDto(SupplierDto lieferant);

    //Material
    @Mapping(target = "id")
    Type toDTO(org.acme.model.Type typ);

    @Mapping(target = "id")
    org.acme.model.Type fromDto(Type type);
}
