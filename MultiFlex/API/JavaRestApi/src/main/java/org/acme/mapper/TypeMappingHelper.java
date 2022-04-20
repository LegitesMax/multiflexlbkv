package org.acme.mapper;

import org.acme.DTO.TypeDto;
import org.acme.model.Type;

import javax.enterprise.context.ApplicationScoped;
import java.util.LinkedList;
import java.util.List;

@ApplicationScoped
public class TypeMappingHelper extends MappingHelper{
    public List<TypeDto> toDto(List<Type> types){
        var result = new LinkedList<TypeDto>();
        for (var type : types) {
            result.add(toDto(type));
        }
        return result;
    }
    public TypeDto toDto(Type type){
        return om.toDTO(type);
    }
    public Type fromDto(TypeDto dto){
        return om.fromDto(dto);
    }

    public List<Type> fromDto(List<TypeDto> dtos){
        var result = new LinkedList<Type>();
        for (var dto : dtos) {
            result.add(fromDto(dto));
        }
        return result;
    }
}
