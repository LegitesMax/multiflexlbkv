package at.multiflex.Logic;

import at.multiflex.model.Wares.Article;
import at.multiflex.model.Wares.Material;
import at.multiflex.model.Wares.Product;
import at.multiflex.repository.CategoryRepository;
import at.multiflex.repository.ColorRepository;
import at.multiflex.repository.SizeRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

/**
 * A logic class that handles all regarding insert, update, delete
 */
@ApplicationScoped
public class CRUDLogic {
    /**
     * The category repo
     */
    @Inject
    CategoryRepository categoryRepository;
    /**
     * The color repo
     */
    @Inject
    ColorRepository colorRepository;
    /**
     * The size repo
     */
    @Inject
    SizeRepository sizeRepository;

    /**
     * sets color, category and size
     * @param input the input to set the fields
     * @return returns the input with the set values
     */
    public Material setEmptyFields(Material input){
        var in = input.getName().split(" ");

        if (in.length == 1){
            input.setCategory(categoryRepository.findByName(in[0]));
            if (input.getColor().getName() == null ) {
                input.setColor(colorRepository.findById(999));
            }
            if (input.getSize().getSize() == null ) {
                input.setSize(sizeRepository.findById(999));
            }
        }
        else if (in.length == 2){
            input.setCategory(categoryRepository.findByName(in[0]));
            input.setSize(sizeRepository.findBySize(Integer.parseInt(in[1])));

            if (input.getColor().getName() == null ) {
                input.setColor(colorRepository.findById(999));
            }
        }
        else if (in.length == 3){
            input.setCategory(categoryRepository.findByName(in[0]));
            input.setSize(sizeRepository.findBySize(Integer.parseInt(in[1])));
            input.setColor(colorRepository.findByColorCode(in[2]));
        }
        else {
            throw new IllegalArgumentException("inputValue " + in.length);
        }

        return input;
    }
    /**
     * sets color, category and size
     * @param input the input to set the fields
     * @return returns the input with the set values
     */
    public Product setEmptyFields(Product input){
        var in = input.getName().split(" ");

        if (in.length == 3){
            input.setCategory(categoryRepository.findByAcronym(in[0]));
            input.setSize(sizeRepository.findBySize(Integer.parseInt(in[1])));
            input.setColor(colorRepository.findByColorCode(in[2]));
        } else {
            throw new IllegalArgumentException("inputValue");
        }

        return input;
    }

    /**
     * checks if an object has null values
     * @param obj the input object
     * @param <T> a generic value that extends article
     */
    public <T extends Article> void checkNullRelations(T obj){
        if (!(obj.getSize().getSize() == null && obj.getSize().getDescription() == null)){
            throw new IllegalArgumentException("Size is null");
        }
        if (!(obj.getCategory().getName() == null)){
            throw new IllegalArgumentException("Category is null");
        }
        if (!(obj.getColor().getName() == null)){
            throw new IllegalArgumentException("Color is null");
        }
    }
}
