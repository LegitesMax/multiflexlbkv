package org.acme;

import org.acme.DTO.RegalDto;
import org.acme.DTO.WareDto;
import org.acme.mapper.RegalMapper;
import org.acme.mapper.WareMapper;
import org.acme.model.Regal;
import org.acme.model.Ware;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Path("/ware")
public class WareResource extends EntityManagerObject {

    @Inject
    WareMapper wareMapper;

    WareService wareService = new WareService();

    //@GET
    //@Produces(MediaType.APPLICATION_JSON_PATCH_JSON)
    //public List<Ware> getAll() {
    //    List<Ware> wareList = new ArrayList<>();
//
    //    List<WareDto> regals = wareService.loadAllWare()
    //            .stream()
    //            .map(ware -> wareMapper.toDTO(ware))
    //            .collect(Collectors.toList());
//
    //    regals.forEach(x -> wareList.add(wareMapper.dtoToWare(x)));
    //    return wareList;
    //}

    @GET
    @Produces(MediaType.APPLICATION_JSON_PATCH_JSON)
    public List<WareDto> getAll() {
        var wareDtos = new ArrayList<WareDto>();
        var waren = entityManager.createQuery("select w from Ware w", Ware.class).getResultList();
        for(var ware : waren){
            //RegalDto regalDto = new RegalDto(ware.getId(), ware.getName(), ware.getMax_anzahl_faecher(), );
            //regalDto.setId(ware.getId());
            //regalDto.setName(ware.getName());
            //regalDto.setMax_anzahl_faecher(ware.getMax_anzahl_faecher());
            var fachSet = ware.getFächer();
            List<Integer> fachIds = new ArrayList<>();
            for (var fach : fachSet){
                fachIds.add(fach.getId());
            }
            Collections.sort(fachIds);
            var wareDto = new WareDto(ware.getId(), ware.getName(), ware.getBestand(), ware.getMinbestand(), ware.getMaxbestand(), fachIds);
            wareDtos.add(wareDto);
        }
        return wareDtos;
    }

}
