package org.acme.mapper;

import org.acme.DTO.SupplierDto;
import org.acme.model.Supplier;

import javax.enterprise.context.ApplicationScoped;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@ApplicationScoped
public class SupplierMappingHelper extends MappingHelper{
    public SupplierDto toDto(Supplier supplier){
        var supplierDto = om.toDTO(supplier);
        if(supplier.getWares().size() > 0) {
            var materialSet = supplier.getWares();
            List<Integer> wareIds = new LinkedList<>();
            for (var lieferant2 : materialSet) {
                wareIds.add(lieferant2.getId());
            }
            Collections.sort(wareIds);
            supplierDto.setWare_ids(wareIds);
        }
       return supplierDto;
    }

    public List<SupplierDto> toDto(List<Supplier> suppliers){
        var supplierDtos = new LinkedList<SupplierDto>();
        for(var supplier : suppliers){
            supplierDtos.add(toDto(supplier));
        }
        return supplierDtos;
    }

    public Supplier fromDto(SupplierDto dto){
        return om.fromDto(dto);
    }

    public List<Supplier> fromDto(List<SupplierDto> dtos){
        var result = new LinkedList<Supplier>();
        for (var dto : dtos) {
            result.add(fromDto(dto));
        }
        return result;
    }

}
