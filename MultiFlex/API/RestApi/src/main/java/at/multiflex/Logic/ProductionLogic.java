package at.multiflex.Logic;

import at.multiflex.model.Wares.Article;
import at.multiflex.model.Wares.Product;
import at.multiflex.repository.CRUDOperations;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class ProductionLogic {
    @Inject
    CRUDOperations crud;

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
    public void produce(Product product){
        produce(product, 1);
    }
    public void consume(Product product, int amount) {
        product.setValue(product.getValue() - amount);
        crud.update(product);
    }
    public void consume(Product product){
        consume(product, 1);
    }
    public void fixStock(Article article, Double amount){
        article.setValue(amount);
        crud.update(article);
    }
}
