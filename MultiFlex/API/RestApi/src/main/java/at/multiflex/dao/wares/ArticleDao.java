package at.multiflex.dao.wares;

import at.multiflex.dao.DaoException;
import at.multiflex.dao.GenericDao;
import at.multiflex.dto.SizeDto;
import at.multiflex.dto.wares.ArticleDto;
import at.multiflex.mapper.MappingHelper;
import at.multiflex.model.Category;
import at.multiflex.model.Color;
import at.multiflex.model.Size;
import at.multiflex.model.Wares.Article;
import at.multiflex.model.Wares.Material;
import at.multiflex.model.Wares.Product;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;

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

    /*@Inject
    EntityManager em;
    @Transactional
    @PUT
    @Produces(MediaType.APPLICATION_JSON_PATCH_JSON)
    @Path("/update")
    public Response update(ArticleDto input) throws DaoException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        Object entity;
        if (Article.class.equals(type)) {
            var dto = mapper.convertValue(input, ArticleDto.class);
            var oldEntitiy = articleRepository.findByName(input.getName());

            var entity2 = (Article)MappingHelper.entityDtoTransformation(input);
            entity2.setId(oldEntitiy.stream().findFirst().get().getId());
            var result = oldEntitiy.stream().findFirst().get();

            entity2.setCategory(result.getCategory());
            entity2.setColor(result.getColor());
            entity2.setSize(result.getSize());

            System.out.println(entity2.getId().toString());
            System.out.println(entity2.getClass());

            em.merge(entity2);
            //crudOperations.update(entity2);

        } else{
            throw new DaoException("Entity type does exist");
        }
        //articleRepository.findByName(entity);
        //crudOperations.update(entity2);
        //please help me i`m under water, pleas help me
        return Response.status(Response.Status.OK).build();
    }*/
}
