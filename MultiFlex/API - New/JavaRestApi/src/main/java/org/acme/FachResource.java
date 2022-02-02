package org.acme;


import org.acme.DTO.FachDto;
import org.acme.mapper.FachMapper;
import org.acme.model.Fach;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Path("/fach")
public class FachResource extends EntityManagerObject {

    @Inject
    FachMapper fachMapper;

    FachService fachService = new FachService();

    @GET
    @Produces(MediaType.APPLICATION_JSON_PATCH_JSON)
    public List<Fach> getAll() {
        List<Fach> fachList = new ArrayList<>();

        List<FachDto> fachs = fachService.loadAllFach()
                .stream()
                .map(fach -> fachMapper.toDTO(fach))
                .collect(Collectors.toList());

        fachs.forEach(x -> fachList.add(fachMapper.dtoToFach(x)));
        return fachList;
    }

 /*
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
    /*@GET
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
    }*/
}
