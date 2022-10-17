package at.multiflex.dao.wares;

import at.multiflex.dao.DaoException;
import at.multiflex.dao.GenericDao;
import at.multiflex.dto.wares.ArticleDto;
import at.multiflex.mapper.ObjectMapper;
import at.multiflex.model.Wares.Article;
import org.apache.commons.beanutils.BeanUtils;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.lang.reflect.InvocationTargetException;

/**
 * This class includes all json requests for the Article class
 */
@Dependent
@Path("/Article")
public class ArticleDao  extends GenericDao {
    /**
     * A Constructor that tells the superclass which entity class to use
     */
    public ArticleDao() {
        type = Article.class;
    }


    @PUT
    @Produces(MediaType.APPLICATION_JSON_PATCH_JSON)
    @Path("/update")
    public Response update(ArticleDto dto) {
        var entity = articleRepository.findByName(dto.getName()).get(0);
        //var entity = ObjectMapper.MAPPER.fromDto(dto);
        var entity2 = ObjectMapper.MAPPER.fromDto(dto);
        //if (entity2.getName() != null){
            entity.setName(entity2.getName());
        //}else if (entity2.getMinValue() != null) {
            entity.setMinValue(entity2.getMinValue());
        //}else if (entity2.getValue() != null) {
            entity.setValue(entity2.getValue());
        /*}else if (entity2.getCategory() != null){
            entity.setCategory(entity2.getCategory());
        }else if (entity2.getColor() != null) {
            entity.setColor(entity2.getColor());
        }else if (entity2.getSize() != null) {
            entity.setSize(entity2.getSize());
        }
        */

        //BeanUtils.copyProperties(entity, ObjectMapper.MAPPER.fromDto(dto));
        //var entity2 = articleRepository.findByName(entity.getName());
        //System.out.println(entity.getId());
        //em.merge(entity);

        //entity.setId( entity2.get(0).getId());
        //entity.setCategory( entity2.get(0).getCategory());
        //entity.setSize( entity2.get(0).getSize());
        //entity.setColor( entity2.get(0).getColor());

        //crudOperations.delete(entity2.get(0));
        //crudOperations.add(entity);
        //var x = crudOperations.myMerge(entity);

        crudOperations.update(entity);
        return Response.status(Response.Status.OK).build();
    }
}
