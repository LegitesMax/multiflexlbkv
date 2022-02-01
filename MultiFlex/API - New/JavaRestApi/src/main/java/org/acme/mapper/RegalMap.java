package org.acme.mapper;

import org.acme.DTO.RegalDto;
import org.acme.model.Regal;

import javax.inject.Inject;
import java.util.LinkedList;
import java.util.List;

public class RegalMap {
    /*@Inject
    RegalMapper regalMapper;

    public RegalDto setIds(Regal regal){
        var regalDto = regalMapper.regalToDto(regal);
        var idList = new LinkedList<Integer>();
        for (var fach : regal.getFaecher()){
            idList.add(fach.getId());
        }
        regalDto.setFach_ids(idList);
        return regalDto;
    }
    public List<RegalDto> setIds(List<Regal> regale){
        var regalDtos = new LinkedList<RegalDto>();
        for (var regal : regale) {
            var regalDto = regalMapper.regalToDto(regal);
            var idList = new LinkedList<Integer>();
            for (var fach : regal.getFaecher()) {
                idList.add(fach.getId());
            }
            regalDto.setFach_ids(idList);
            regalDtos.add(regalDto);
        }
        return regalDtos;
    }*/
}
