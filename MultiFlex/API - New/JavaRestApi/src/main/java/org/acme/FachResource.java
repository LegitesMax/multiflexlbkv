package org.acme;

//import org.acme.mapper.FachMapper;

import javax.ws.rs.Path;

@Path("/fach")
public class FachResource extends EntityManagerObject {

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
