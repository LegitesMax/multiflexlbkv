package org.acme.mapper;

import org.acme.DTO.WareDto;
import org.acme.model.Ware;
import org.acme.repository.ShelfRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@ApplicationScoped
public class WareMappingHelper extends MappingHelper{
    @Inject
    ShelfRepository shelfRepository;

    public List<WareDto> toDto(List<Ware> wares){
        var result = new LinkedList<WareDto>();
        for (var ware : wares) {
            result.add(toDto(ware));
        }
        return result;
    }
    public WareDto toDto(Ware ware){
        var wareDto = om.toDTO(ware);
        if(ware.getShelfs().size() > 0) {
            var shelfSet = ware.getShelfs();
            List<Integer> shelfIds = new LinkedList<>();
            for (var shelf : shelfSet) {
                shelfIds.add(shelf.getId());
            }
            Collections.sort(shelfIds);
            wareDto.setShelf_ids(shelfIds);
        }
        return wareDto;
    }

    public Ware fromDto(WareDto dto){
        var entity = om.fromDto(dto);

        dto.getShelf_ids().forEach(id -> {
            var shelf = shelfRepository.findById(id);
            entity.getShelfs().add(shelf);
        });

        return entity;
    }

    public List<Ware> fromDto(List<WareDto> dtos){
        var result = new LinkedList<Ware>();
        for (var dto : dtos) {
            result.add(fromDto(dto));
        }
        return result;
    }
}
