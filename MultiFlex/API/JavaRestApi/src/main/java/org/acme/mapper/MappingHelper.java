package org.acme.mapper;

import org.acme.DTO.WareDto;
import org.acme.model.Ware;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.LinkedList;
import java.util.List;

@ApplicationScoped
public class MappingHelper {
    @Inject
    ObjectMapper om;

    public List<WareDto> toDto(List<Ware> waren){
        var result = new LinkedList<WareDto>();
        for (var ware : waren) {
            result.add(om.toDTO(ware));
        }
        return result;
    }
}
