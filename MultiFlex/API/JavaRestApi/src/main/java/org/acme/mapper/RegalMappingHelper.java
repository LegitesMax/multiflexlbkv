package org.acme.mapper;

import org.acme.DTO.RegalDto;
import org.acme.model.Regal;
import org.acme.repository.ShelfRepository;
import org.testcontainers.shaded.org.apache.commons.lang.NullArgumentException;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@ApplicationScoped
public class RegalMappingHelper extends MappingHelper{
    @Inject
    ShelfRepository shelfRepository;

    public List<RegalDto> toDto(List<Regal> regale){
        var result = new LinkedList<RegalDto>();
        for(var regal : regale){
             result.add(toDto(regal));
        }
        return result;
    }
    public RegalDto toDto(Regal regal){
        var regalDto = om.toDTO(regal);
        if(regal.getShelfs().size() > 0) {
            var shelfSet = regal.getShelfs();
            List<Integer> shelfIds = new LinkedList<>();
            for (var shelf : shelfSet) {
                shelfIds.add(shelf.getId());
            }
            Collections.sort(shelfIds);
            regalDto.setShelf_ids(shelfIds);
        }
        return regalDto;
    }

    public Regal fromDto(RegalDto dto){
        var entity = om.fromDto(dto);
        dto.getShelf_ids().forEach(id -> {
            var shelf = shelfRepository.findById(id);
            entity.getShelfs().add(shelf);
        });
        return entity;
    }

    public List<Regal> fromDto(List<RegalDto> dtos){
        var result = new LinkedList<Regal>();
        for (var dto : dtos) {
            result.add(fromDto(dto));
        }
        return result;
    }
}
