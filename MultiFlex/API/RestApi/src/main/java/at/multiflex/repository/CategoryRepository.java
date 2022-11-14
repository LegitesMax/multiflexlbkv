package at.multiflex.repository;

import at.multiflex.model.Category;
import at.multiflex.model.Wares.Article;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * This class has all Database Queries of the Category class
 */
@ApplicationScoped
public class CategoryRepository extends Repository{
    /**
     * A Query to load all Category entities from the database
     * @return A list with all Category entities from the database
     */
    @Transactional
    public List<Category> loadAll() {
        //var res = em.createQuery("select x from Category x join x.products y where y.name like lower(concat('%', concat(x.acronym, '%')))", Category.class).getResultList();
        var products = em.createQuery("select x from Article x join x.category order by x.name", Article.class).getResultList();
        //System.out.println(res.size());
        var res = em.createQuery("select x from Category x", Category.class).getResultList();

        var newRes = new ArrayList<Category>();
        for (var result:res) {
            result.getProducts().clear();
            for (var product:products) {
                if (product.getName().startsWith(result.getAcronym() + " ")
                    || product.getName().startsWith(result.getName())){
                    result.getProducts().add(product);
                }

            }
            newRes.add(result);
        }

        return em.createQuery("select x from Category x join x.products y order by y.name", Category.class).getResultList();

    }
    /**
     * Loads a Category entity from the database
     * @param id The id of the entity to load
     * @return The entity loaded from the database
     */
    @Transactional
    public Category findById(Integer id){
        var category = em.createQuery("select x from Category x where x.id = :id", Category.class).setParameter("id", id).getSingleResult();
        var articles = em.createQuery("select x from Article x join x.category order by x.name", Article.class).getResultList();

        category.getProducts().clear();
        for (var article:articles) {
            if (article.getName().startsWith(category.getAcronym() + " ")
                    || article.getName().startsWith(category.getName())){
                category.getProducts().add(article);
            }

        }

        return category;
        //return  em.createQuery("select x from Article x inner join x.category y where y.id = :id", Category.class).setParameter("id", id).getSingleResult();
    }
    /**
     * Loads all products categorised by category out of the database
     * @return The resulting List
     */
    @Transactional
    public List<Category> loadAllProducts() {
        //var res = em.createQuery("select x from Category x join x.products y where y.name like lower(concat('%', concat(x.acronym, '%')))", Category.class).getResultList();
        //var products = em.createQuery("select x from Product x join x.category order by x.name", Product.class).getResultList();
        ////System.out.println(res.size());
        //var res = em.createQuery("select x from Category x", Category.class).getResultList();

        //var newRes = new ArrayList<Category>();
        //for (var result:res) {
        //    result.getProducts().clear();
        //    for (var product:products) {
        //        if (product.getName().startsWith(result.getAcronym() + " ")
        //                || product.getName().startsWith(result.getName())){
        //            result.getProducts().add(product);
        //        }

        //    }

        //    newRes.add(result);
        //}

        //newRes.removeIf(item -> item.getProducts().isEmpty());

        //return em.createQuery("select distinct x.name from Category x inner join x.products y order by x.name, y.name", Category.class).getResultList();
        var result = em.createQuery("select x from  Category x where x.id < 1000 group by x.name order by x.name", Category.class).getResultList();
        //var resultList = new ArrayList<Category>();
        for (var singleResult : result){
            singleResult.setProducts(new HashSet<>(em.createQuery("select x from Article x where x.category.id = :id order by x.name DESC", Article.class)
                    .setParameter("id", singleResult.getId()).getResultList()));
            //resultList.add(singleResult);
            //Arrays.sort(singleResult.getProducts().toArray(), Collections.reverseOrder());
        }
        return result;
    }
    /**
     * Loads all materials categorised by category out of the database
     * @return The resulting List
     */
    @Transactional
    public List<Category> loadAllMaterials() {
        ////var res = em.createQuery("select x from Category x join x.products y where y.name like lower(concat('%', concat(x.acronym, '%')))", Category.class).getResultList();
        //var products = em.createQuery("select x from Material x join x.category order by x.name", Material.class).getResultList();
        ////System.out.println(res.size());
        //var res = em.createQuery("select x from Category x", Category.class).getResultList();

        //var newRes = new ArrayList<Category>();
        //for (var result:res) {
        //    result.getProducts().clear();
        //    for (var product:products) {
        //        if (product.getName().startsWith(result.getAcronym() + " ")
        //                || product.getName().startsWith(result.getName())){
        //            result.getProducts().add(product);
        //        }

        //    }
        //    newRes.add(result);
        //}

        //newRes.removeIf(item -> item.getProducts().isEmpty());
        var result = em.createQuery("select x from  Category x where x.id > 1000 group by x.name order by x.name", Category.class).getResultList();
        //var resultList = new ArrayList<Category>();
        for (var singleResult : result){
            singleResult.setProducts(new HashSet<>(em.createQuery("select x from Article x where x.category.id = :id order by x.value DESC", Article.class)
                    .setParameter("id", singleResult.getId()).getResultList()));
            //resultList.add(singleResult);
        }
        return result;
    }
    /**
     * Loads all Category entities from the database with the given name
     * @param name The name of the entity to load
     * @return A list of entities loaded from the database
     */
    @Transactional
    public Category findByName(String name){
        return em.createQuery("select x from Category x where x.name like lower(concat('%', concat(:name, '%')))", Category.class).setParameter("name", name).getSingleResult();
    }
    /**
     * Loads the Category entity from the database with the given acronym
     * @param name An acronym of an entity
     * @return The entity loaded from the database
     */
    @Transactional
    public Category findByAcronym(String name){
        return em.createQuery("select x from Category x where x.acronym = :name", Category.class).setParameter("name", name).getSingleResult();
    }
    @Transactional
    public void getChecksum(){
        var x = em.createNativeQuery("CHECKSUM TABLE Category").getResultList();

        System.out.println(x.size());
        System.out.println(x.toString());
        System.out.println(x.getClass());
        System.out.println(x.get(0).hashCode());
        System.out.println();
    }
}
