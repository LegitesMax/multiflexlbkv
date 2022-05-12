package org.acme.mapper;

import javax.annotation.processing.Generated;
import javax.enterprise.context.ApplicationScoped;
import org.acme.DTO.RegalDto;
import org.acme.DTO.ShelfDto;
import org.acme.DTO.SupplierDto;
import org.acme.DTO.TypeDto;
import org.acme.DTO.WareDto;
import org.acme.model.Regal;
import org.acme.model.Shelf;
import org.acme.model.Supplier;
import org.acme.model.Type;
import org.acme.model.Ware;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-05-02T12:57:43+0200",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 15.0.2 (Amazon.com Inc.)"
)
@ApplicationScoped
public class ObjectMapperImpl implements ObjectMapper {

    @Override
    public RegalDto toDTO(Regal regal) {
        if ( regal == null ) {
            return null;
        }

        RegalDto regalDto = new RegalDto();

        regalDto.setId( regal.getId() );
        regalDto.setName( regal.getName() );
        regalDto.setMaxAmountShelfs( regal.getMaxAmountShelfs() );

        return regalDto;
    }

    @Override
    public Regal fromDto(RegalDto regal) {
        if ( regal == null ) {
            return null;
        }

        Regal regal1 = new Regal();

        regal1.setId( regal.getId() );
        regal1.setName( regal.getName() );
        regal1.setMaxAmountShelfs( regal.getMaxAmountShelfs() );

        return regal1;
    }

    @Override
    public ShelfDto toDTO(Shelf fach) {
        if ( fach == null ) {
            return null;
        }

        ShelfDto shelfDto = new ShelfDto();

        shelfDto.setId( fach.getId() );
        shelfDto.setPosition( fach.getPosition() );
        shelfDto.setMaxAmount( fach.getMaxAmount() );

        return shelfDto;
    }

    @Override
    public Shelf fromDto(ShelfDto fach) {
        if ( fach == null ) {
            return null;
        }

        Shelf shelf = new Shelf();

        shelf.setId( fach.getId() );
        shelf.setPosition( fach.getPosition() );
        shelf.setMaxAmount( fach.getMaxAmount() );

        return shelf;
    }

    @Override
    public WareDto toDTO(Ware ware) {
        if ( ware == null ) {
            return null;
        }

        WareDto wareDto = new WareDto();

        wareDto.setId( ware.getId() );
        wareDto.setName( ware.getName() );
        wareDto.setStock( ware.getStock() );
        wareDto.setMinAmount( ware.getMinAmount() );
        wareDto.setMaxAmount( ware.getMaxAmount() );

        return wareDto;
    }

    @Override
    public Ware fromDto(WareDto ware) {
        if ( ware == null ) {
            return null;
        }

        Ware ware1 = new Ware();

        ware1.setId( ware.getId() );
        ware1.setName( ware.getName() );
        ware1.setStock( ware.getStock() );
        ware1.setMinAmount( ware.getMinAmount() );
        ware1.setMaxAmount( ware.getMaxAmount() );

        return ware1;
    }

    @Override
    public SupplierDto toDTO(Supplier lieferant) {
        if ( lieferant == null ) {
            return null;
        }

        SupplierDto supplierDto = new SupplierDto();

        supplierDto.setId( lieferant.getId() );
        supplierDto.setName( lieferant.getName() );
        supplierDto.setLink( lieferant.getLink() );
        supplierDto.setDeliveryTime( lieferant.getDeliveryTime() );

        return supplierDto;
    }

    @Override
    public Supplier fromDto(SupplierDto lieferant) {
        if ( lieferant == null ) {
            return null;
        }

        Supplier supplier = new Supplier();

        supplier.setId( lieferant.getId() );
        supplier.setName( lieferant.getName() );
        supplier.setLink( lieferant.getLink() );
        supplier.setDeliveryTime( lieferant.getDeliveryTime() );

        return supplier;
    }

    @Override
    public TypeDto toDTO(Type typ) {
        if ( typ == null ) {
            return null;
        }

        TypeDto typeDto = new TypeDto();

        typeDto.setId( typ.getId() );
        typeDto.setName( typ.getName() );

        return typeDto;
    }

    @Override
    public Type fromDto(TypeDto type) {
        if ( type == null ) {
            return null;
        }

        Type type1 = new Type();

        type1.setId( type.getId() );
        type1.setName( type.getName() );

        return type1;
    }
}
