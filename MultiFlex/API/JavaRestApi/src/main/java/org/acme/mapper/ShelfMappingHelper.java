package org.acme.mapper;

import org.acme.DTO.ShelfDto;
import org.acme.model.Shelf;
import org.acme.repository.RegalRepository;
import org.acme.repository.WareRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.LinkedList;
import java.util.List;

@ApplicationScoped
public class ShelfMappingHelper extends MappingHelper{
    @Inject
    RegalRepository regalRepository;
    @Inject
    WareRepository wareRepository;

    public ShelfDto toDto(Shelf shelf){
        var shelfDto = om.toDTO(shelf);
        shelfDto.setRegal_id(shelf.getRegal().getId());
        shelfDto.setWare_id(shelf.getWare().getId());
        return shelfDto;
    }
    public List<ShelfDto> toDto(List<Shelf> shelves){
        var shelfDtos = new LinkedList<ShelfDto>();

        for(var shelf : shelves){
            shelfDtos.add(toDto(shelf));
        }
        return shelfDtos;
    }

    public Shelf fromDto(ShelfDto dto){
        var entity = om.fromDto(dto);

        var ware = wareRepository.findById(dto.getWare_id());
        var regal = regalRepository.findById(dto.getRegal_id());

        entity.setWare(ware);
        entity.setRegal(regal);

        return entity;
    }

    public List<Shelf> fromDto(List<ShelfDto> dtos){
        var result = new LinkedList<Shelf>();
        for (var dto : dtos) {
            result.add(fromDto(dto));
        }
        return result;
    }
}
