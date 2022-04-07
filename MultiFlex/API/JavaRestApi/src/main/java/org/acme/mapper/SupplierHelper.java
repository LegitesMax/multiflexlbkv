package org.acme.mapper;

import org.acme.DTO.SupplierDto;
import org.acme.DTO.TypeDto;
import org.acme.model.Supplier;
import org.acme.model.Type;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@ApplicationScoped
public class SupplierHelper extends MappingHelper{
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
        var lieferantDtos = new LinkedList<SupplierDto>();
        for(var supplier : suppliers){
            toDto(supplier);
        }
        return lieferantDtos;
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
