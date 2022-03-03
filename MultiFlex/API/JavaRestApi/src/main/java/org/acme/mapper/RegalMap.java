package org.acme.mapper;

import org.acme.DTO.RegalDto;
import org.acme.model.Regal;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.LinkedList;
import java.util.List;

public class RegalMap {
    @Inject
    RegalMapper regalMapper;

    @Transactional
    public List<Integer> setIds(Regal regal){
        //var regalDto = regalMapper.toDTO(regal);
        var idList = new LinkedList<Integer>();
        if (regal.getFaecher() != null){
            for (var fach : regal.getFaecher()){
                idList.add(fach.getId());
            }
        }

        //regalDto.setFach_ids(idList);
        return idList;
    }
    //public List<RegalDto> setIds(List<Regal> regale){
    //    var regalDtos = new LinkedList<RegalDto>();
    //    for (var regal : regale) {
    //        var regalDto = regalMapper.toDTO(regal);
    //        var idList = new LinkedList<Integer>();
    //        for (var fach : regal.getFaecher()) {
    //            idList.add(fach.getId());
    //        }
    //        regalDto.setFach_ids(idList);
    //        regalDtos.add(regalDto);
    //    }
    //    return regalDtos;
    //}
}
