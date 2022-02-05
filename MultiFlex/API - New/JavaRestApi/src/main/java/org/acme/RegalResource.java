package org.acme;

import org.acme.DTO.RegalDto;
//import org.acme.mapper.RegalMapper;
import org.acme.mapper.RegalMap;
import org.acme.mapper.RegalMapper;
import org.acme.model.Regal;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.*;
import java.util.stream.Collectors;

@Path("/regal")
public class RegalResource extends EntityManagerObject {

    @Inject RegalMapper regalMapper;

    @Inject
    RegalService regalService;

    @GET
    @Produces(MediaType.APPLICATION_JSON_PATCH_JSON)
    public List<Regal> getAll() {
        List<Regal> regalList = new ArrayList<>();

        List<RegalDto> regals = regalService.loadAllRegal()
                .stream()
                .map(regal -> regalMapper.toDTO(regal))
                .collect(Collectors.toList());

        regals.forEach(x -> regalList.add(regalMapper.dtoToRegal(x)));
        for (var regal : regalList){
            for(var regalDto : regals){
                if(regalDto.getId() == regal.getId()){
                        regalDto.setFach_ids(regalMap.setIds(regal));
                }
            }
        }
        return regalList;
    }

    /*@GET
    @Path("/{name}")
    @Produces(MediaType.APPLICATION_JSON_PATCH_JSON)
    public RegalDto getOne(@PathParam String name) {
        var regal = regalMapper.toDTO(regalService.loadOneRegal(name));
        return regal;
    }*/

    /*@GET
    @Path("/{name}")
    public Regal getOne(@PathParam String name) {
        return entityManager.createQuery("select r from Regal r where r.name = :name", Regal.class).setParameter("name", name).getSingleResult();
    }

 */
    //@Inject
    //RegalMapper regalMapper;
    private RegalMap regalMap = new RegalMap();

   /* @GET
    @Path("/{name}")
    public RegalDto getOne(@PathParam String name) {
        var regal = (entityManager.createQuery("select r from Regal r where r.name = :name", Regal.class).setParameter("name", name).getSingleResult());
        //RegalMap regalMap = new RegalMap();
        return regalMap.setIds(regal);
    }*/

    /*@GET
    @Produces(MediaType.APPLICATION_JSON_PATCH_JSON)
    public List<RegalDto> getAll() {
        var regalDtos = new LinkedList<RegalDto>();
        var regale = entityManager.createQuery("select r from Regal r", Regal.class).getResultList();
        for(var regal : regale){
            //RegalDto regalDto = new RegalDto(regal.getId(), regal.getName(), regal.getMax_anzahl_faecher(), );
            //regalDto.setId(regal.getId());
            //regalDto.setName(regal.getName());
            //regalDto.setMax_anzahl_faecher(regal.getMax_anzahl_faecher());
            var fachSet = regal.getFaecher();
            List<Integer> fachIds = new LinkedList<>();
            for (var fach : fachSet){
                fachIds.add(fach.getId());
            }
            Collections.sort(fachIds);
            RegalDto regalDto = new RegalDto(regal.getId(), regal.getName(), regal.getMax_anzahl_faecher(),  fachIds);
            regalDtos.add(regalDto);
        }
        return regalDtos;
    }*/

    //@GET
    //@Produces(MediaType.APPLICATION_JSON_PATCH_JSON)
    //public List<RegalDto> getAll() {
    //    var regale = entityManager.createQuery("select r from Regal r", Regal.class).getResultList();
    //    //RegalMap regalMap = new RegalMap();
    //    return regalMap.setIds(regale);
    //}
/*
    @GET
    @Produces(MediaType.APPLICATION_JSON_PATCH_JSON)
    public List<RegalDto> getAll() {
        var regale = entityManager.createQuery("select r from Regal r", Regal.class).getResultList();
        List<RegalDto> regalDtos = new LinkedList<>();
        for (Regal regal : regale){
            var fachSet = regal.getFaecher();
            List<Integer> fachIds = new LinkedList<>();
            for (var fach : fachSet){
                fachIds.add(fach.getId());
            }
            RegalDto regalDto = regalMapper.toResource(regal);
            int size = fachIds.size();
            var x = fachIds.toArray();

            regalDto.setFachIds(fachIds);
            regalDtos.add(regalMapper.toResource(regal));
        }
        return regalDtos;
    }
 
 */
}