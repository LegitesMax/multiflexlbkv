package at.multiflex.dao.others;

import at.multiflex.Logic.Hashing;
import at.multiflex.dao.DaoException;
import at.multiflex.dto.logic.HashDto;
import at.multiflex.dto.logic.Type;
import at.multiflex.mapper.MappingHelper;
import at.multiflex.model.ProductionLog;
import at.multiflex.model.Wares.Article;
import at.multiflex.repository.*;
import at.multiflex.repository.wares.ArticleRepository;
import at.multiflex.repository.wares.MaterialRepository;
import at.multiflex.repository.wares.ProductRepository;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Path("/Hash")
public class HashDao {
    /**
     * repository for the article class
     */
    @Inject
    protected ArticleRepository articleRepository;
    /**
     * repository for the material class
     */
    @Inject
    protected MaterialRepository materialRepository;
    /**
     * repository for the product class
     */
    @Inject
    protected ProductRepository productRepository;
    /**
     * repository for the category class
     */
    @Inject
    protected CategoryRepository categoryRepository;
    /**
     * repository for the color class
     */
    @Inject
    protected ColorRepository colorRepository;
    /**
     * repository for the size class
     */
    @Inject
    protected SizeRepository sizeRepository;
    /**
     * all create update delete operations
     */
    @Inject
    protected ProductionLogRepository productionLogRepository;
    /**
     * all create update delete operations
     */
    @Inject
    protected CRUDOperations crudOperations;


    @Inject
    Hashing hashing;

    @GET
    @Produces(MediaType.APPLICATION_JSON_PATCH_JSON)
    public List<HashDto> getAll() {
        var hashes = new LinkedList<HashDto>();

        hashes.add(getArticleHash());
        hashes.add(getMaterialHash());
        hashes.add(getProductHash());
        hashes.add(getProductionLogHash());
        hashes.add(getColorHash());
        hashes.add(getCategoryHash());
        hashes.add(getSizeHash());

        return hashes;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON_PATCH_JSON)
    @Path("/Article")
    public HashDto getArticleHash() {
        var hash = new HashDto();

        var entity = articleRepository.loadAll();

        hash.setHashValue(hashing.hash(entity.toString()));
        hash.setType(Type.Article);

        return hash;
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON_PATCH_JSON)
    @Path("/Material")
    public HashDto getMaterialHash() {
        var hash = new HashDto();

        var entity = materialRepository.loadAll();
        hash.setHashValue(hashing.hash(entity.toString()));
        hash.setType(Type.Material);

        return hash;
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON_PATCH_JSON)
    @Path("/Product")
    public HashDto getProductHash() {
        var hash = new HashDto();

        var entity = productRepository.loadAll();
        hash.setHashValue(hashing.hash(entity.toString()));
        hash.setType(Type.Product);

        return hash;
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON_PATCH_JSON)
    @Path("/Category")
    public HashDto getCategoryHash() {
        var hash = new HashDto();

        var entity = categoryRepository.loadAll();
        hash.setHashValue(hashing.hash(entity.toString()));
        hash.setType(Type.Category);

        return hash;
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON_PATCH_JSON)
    @Path("/Color")
    public HashDto getColorHash() {
        var hash = new HashDto();

        var entity = colorRepository.loadAll();
        hash.setHashValue(hashing.hash(entity.toString()));
        hash.setType(Type.Color);

        return hash;
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON_PATCH_JSON)
    @Path("/ProductionLog")
    public HashDto getProductionLogHash() {
        var hash = new HashDto();

        var entity = productionLogRepository.loadAll();
        hash.setHashValue(hashing.hash(entity.toString()));
        hash.setType(Type.ProductionLog);

        return hash;
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON_PATCH_JSON)
    @Path("/Size")
    public HashDto getSizeHash() {
        var hash = new HashDto();

        var entity = sizeRepository.loadAll();
        hash.setHashValue(hashing.hash(entity.toString()));
        hash.setType(Type.Size);

        return hash;
    }
}
