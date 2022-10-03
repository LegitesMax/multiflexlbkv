package at.multiflex.dao;

import at.multiflex.dto.ColorDto;
import at.multiflex.mapper.ObjectMapper;
import at.multiflex.model.Color;
import at.multiflex.model.Wares.Material;
import at.multiflex.repository.ColorRepository;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

/**
 * This class includes all json requests for the Color class
 */
@Dependent
@Path("/Color")
public class ColorDao  extends GenericDao {
    public ColorDao() {
        type = Color.class;
    }
    //@Inject
    //ColorRepository repository;

    ////<editor-fold desc="Get">
    ///**
    // * This gets all entities with this type from the Database and returns a list with them
    // * @return a list with all ColorDtos
    // */
    //@GET
    //@Produces(MediaType.APPLICATION_JSON_PATCH_JSON)
    //public List<ColorDto> getAll() {
    //    var entities = repository.loadAll();
    //    return toDto(entities);
    //}
    ///**
    // * This gets specific entities from this type from the Database and returns a list with them
    // * @param name Color name which should be searched
    // * @return All entities with this name
    // */
    //@GET
    //@Produces(MediaType.APPLICATION_JSON_PATCH_JSON)
    //@Path("/{name}")
    //public ColorDto getByName(String name) {
    //    var entities = repository.findByName(name);
    //    return ObjectMapper.MAPPER.toDto(entities);
    //}
    ///**
    // * gets an entity from this class by its id
    // * @param id the id of the Color to return
    // * @return The Color with the id of the input param
    // */
    //@GET
    //@Produces(MediaType.APPLICATION_JSON_PATCH_JSON)
    //@Path("/{id}")
    //public ColorDto getById(Integer id) {
    //    var entity = repository.findById(id);
    //    return ObjectMapper.MAPPER.toDto(entity);
    //}
    ////</editor-fold>
    ////<editor-fold desc="Post">
    ///**
    // * transforms a given dto to an entity and adds it into the database
    // * @param dto A dto to insert into the database
    // * @return The JSON Response code
    // */
    //@POST
    //@Produces(MediaType.APPLICATION_JSON_PATCH_JSON)
    //@Path("/add")
    //public Response add(ColorDto dto) {
    //    var entity = ObjectMapper.MAPPER.fromDto(dto);
    //    repository.add(entity);
    //    return Response.status(Response.Status.CREATED).build();
    //}
    ////</editor-fold>
    ////<editor-fold desc="Delete">
    ///**
    // * Deletes a Color entity by that entities id
    // * @param id The id of an entity to delete
    // * @return The JSON Response code
    // */
    //@DELETE
    //@Produces(MediaType.APPLICATION_JSON_PATCH_JSON)
    //@Path("/delete/{id}")
    //public Response delete(@PathParam("id") Integer id) {
    //    var entity = repository.findById(id);
    //    if(entity == null) {
    //        throw new NotFoundException();
    //    }
    //    repository.delete(entity);
    //    return Response.status(Response.Status.NO_CONTENT).build();
    //}
    ////</editor-fold>
    ////<editor-fold desc="Put">
    ///**
    // * Transforms a dto into a Color and updates it
    // * @param dto The dto of the entity
    // * @return The JSON Response code
    // */
    //@PUT
    //@Produces(MediaType.APPLICATION_JSON_PATCH_JSON)
    //@Path("/update")
    //public Response update(ColorDto dto) {
    //    var entity = ObjectMapper.MAPPER.fromDto(dto);
    //    repository.update(entity);
    //    return Response.status(Response.Status.OK).build();
    //}
    ////</editor-fold>
    ///**
    // * Method to transform a list of Color entities to a dto
    // * @param entities list of all Color entities to transform
    // * @return the dtos of all given entities
    // */
    //public List<ColorDto> toDto(List<Color> entities) {
    //    var dtos = new ArrayList<ColorDto>();
    //    entities.forEach(x -> dtos.add(ObjectMapper.MAPPER.toDto(x)));
    //    return dtos;
    //}
}
