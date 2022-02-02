package org.acme;

import javax.ws.rs.Path;

@Path("/ware")
public class WareResource extends EntityManagerObject {

    //@GET
    //@Produces(MediaType.APPLICATION_JSON_PATCH_JSON)
    //public List<Ware> getAll() {
    //    return entityManager.createQuery("select w from Ware w", Ware.class).getResultList();
    //}

   /* @GET
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
    }*/

}
