package org.acme;

import org.acme.DTO.FachDto;
//import org.acme.mapper.FachMapper;
import org.acme.DTO.RegalDto;
import org.acme.model.Fach;
import org.acme.model.Regal;
import org.hibernate.Incubating;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@Path("/fach")
public class FachResource extends EntitiyManagerObject {

    //@Inject
    //FachMapper fachMapper;
/*
    @GET
    @Produces(MediaType.APPLICATION_JSON_PATCH_JSON)
    public List<Fach> getAll() {
        return entityManager.createQuery("select f from Fach f", Fach.class).getResultList();
    }

 */
    //@GET
    //@Produces(MediaType.APPLICATION_JSON_PATCH_JSON)
    //public List<FachDto> getAll() {
    //    var faecher = entityManager.createQuery("select f from Fach f", Fach.class).getResultList();
    //    List<FachDto> fachDtos = new LinkedList<>();
    //    for (Fach fach : faecher){
//
    //        //fachDtos.add(fachMapper.toResource(fach));
    //    }
    //    return fachDtos;
    //}
    @GET
    @Produces(MediaType.APPLICATION_JSON_PATCH_JSON)
    public List<FachDto> getAll() {
        var fachDtos = new LinkedList<FachDto>();
        var faecher = entityManager.createQuery("select f from Fach f", Fach.class).getResultList();
        for(var fach : faecher){
            //RegalDto regalDto = new RegalDto(fach.getId(), fach.getName(), fach.getMax_anzahl_faecher(), );
            //regalDto.setId(fach.getId());
            //regalDto.setName(fach.getName());
            //regalDto.setMax_anzahl_faecher(fach.getMax_anzahl_faecher());
            var fachSet = fach.getWare().getId();
            FachDto fachDto = new FachDto(fach.getId(), fach.getPosition(), fach.getMaxbestand(), fach.getWare().getId(), fach.getRegal().getId());
            fachDtos.add(fachDto);
        }
        return fachDtos;
    }
}
