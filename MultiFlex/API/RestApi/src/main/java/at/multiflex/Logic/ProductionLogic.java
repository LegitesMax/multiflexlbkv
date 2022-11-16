package at.multiflex.Logic;

import at.multiflex.model.Wares.Article;
import at.multiflex.model.Wares.Product;
import at.multiflex.repository.CRUDOperations;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

/**
 * The entire logic regarding production
 */
@ApplicationScoped
public class ProductionLogic {
    /**
     * all crud operations
     */
    @Inject
    CRUDOperations crud;

    /**
     * produces a certain amount of products
     * @param product the product which gets produced
     * @param amount the amount that gets produced
     */
    public void produce(Product product, int amount) {
        var pfs = product.getProductionFormula();

        for (var pf : pfs){
            var material = pf.getMaterial();
            material.setValue(material.getValue() - pf.getAmount() * amount);
            crud.update(material);
        }
        product.setValue(product.getValue() + amount);
        crud.update(product);
    }
    /**
     * produces a product
     * @param product the product which gets produced
     */
    public void produce(Product product){
        produce(product, 1);
    }
    /**
     * consumes a certain amount of products
     * @param product the product which gets consumed
     * @param amount the amount that gets consumed
     */
    public void consume(Product product, int amount) {
        product.setValue(product.getValue() - amount);
        crud.update(product);
    }
    /**
     * consumes a products
     * @param product the product which gets consumed
     */
    public void consume(Product product){
        consume(product, 1);
    }
    /**
     * fixes the already existing stock of an article
     * @param article the article which gets fixed
     * @param amount the new amount
     * @param <T> a generic value that extends Article
     */
    public <T extends Article> void fixStock(T article, Double amount){
        article.setValue(amount);
        crud.update(article);
    }
}
