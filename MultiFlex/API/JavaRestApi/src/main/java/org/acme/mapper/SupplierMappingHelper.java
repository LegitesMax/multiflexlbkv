package org.acme.mapper;

import org.acme.DTO.SupplierDto;
import org.acme.model.Supplier;
import org.acme.model.Ware;
import org.acme.repository.WareRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@ApplicationScoped
public class SupplierMappingHelper extends MappingHelper{
    @Inject
    WareRepository wareRepository;

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
        var entity = om.fromDto(dto);

        if (dto.getWare_ids() != null && dto.getWare_ids().size() > 0){
            dto.getWare_ids().forEach(id -> {
                var shelf = wareRepository.findById(id);
                entity.getWares().add(shelf);
            });
        }

        return entity;
    }

    public List<Supplier> fromDto(List<SupplierDto> dtos){
        var result = new LinkedList<Supplier>();
        for (var dto : dtos) {
            result.add(fromDto(dto));
        }
        return result;
    }

}
