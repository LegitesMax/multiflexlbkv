package org.acme;

import org.acme.DTO.RegalDto;
import org.acme.DTO.WareDto;
import org.acme.model.Regal;
import org.acme.model.Ware;

import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@Path("/ware")
public class WareResource extends EntitiyManagerObject{

    //@GET
    //@Produces(MediaType.APPLICATION_JSON_PATCH_JSON)
    //public List<Ware> getAll() {
    //    return entityManager.createQuery("select w from Ware w", Ware.class).getResultList();
    //}

    @GET
    @Produces(MediaType.APPLICATION_JSON_PATCH_JSON)
    public List<WareDto> getAll() {
        var wareDtos = new LinkedList<WareDto>();
        var waren = entityManager.createQuery("select w from Ware w", Ware.class).getResultList();
        for(var ware : waren){
            //RegalDto regalDto = new RegalDto(ware.getId(), ware.getName(), ware.getMax_anzahl_faecher(), );
            //regalDto.setId(ware.getId());
            //regalDto.setName(ware.getName());
            //regalDto.setMax_anzahl_faecher(ware.getMax_anzahl_faecher());
            var fachSet = ware.getFächer();
            List<Integer> fachIds = new LinkedList<>();
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
