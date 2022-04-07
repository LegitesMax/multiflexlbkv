package org.acme.mapper;

import org.acme.DTO.WareDto;
import org.acme.model.Ware;

import javax.enterprise.context.ApplicationScoped;
import java.util.LinkedList;
import java.util.List;

@ApplicationScoped
public class WareHelper extends MappingHelper{
    public List<WareDto> toDto(List<Ware> wares){
        var result = new LinkedList<WareDto>();
        for (var ware : wares) {
            result.add(toDto(ware));
        }
        return result;
    }
    public WareDto toDto(Ware ware){
        return om.toDTO(ware);
    }

    public Ware fromDto(WareDto dto){
        return om.fromDto(dto);
    }

    public List<Ware> fromDto(List<WareDto> dtos){
        var result = new LinkedList<Ware>();
        for (var dto : dtos) {
            result.add(fromDto(dto));
        }
        return result;
    }
}
