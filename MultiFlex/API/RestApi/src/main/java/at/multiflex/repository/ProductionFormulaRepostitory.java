package at.multiflex.repository;

import at.multiflex.model.ProductionFormula;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class ProductionFormulaRepostitory extends CRUDOperations {
    @Transactional
    public List<ProductionFormula> loadAll() {
        return em.createQuery("select x from ProductionFormula x", ProductionFormula.class).getResultList();
    }
    @Transactional
    public ProductionFormula findById(Integer id){
        return em.createQuery("select x from ProductionFormula x where x.id = :id", ProductionFormula.class).setParameter("id", id).getSingleResult();
    }
}
