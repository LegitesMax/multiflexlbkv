package at.multiflex.Logic;

import at.multiflex.model.Wares.Article;
import at.multiflex.model.Wares.Material;
import at.multiflex.model.Wares.Product;
import at.multiflex.repository.CategoryRepository;
import at.multiflex.repository.ColorRepository;
import at.multiflex.repository.SizeRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class CRUDLogic {
    @Inject
    CategoryRepository categoryRepository;
    @Inject
    ColorRepository colorRepository;
    @Inject
    SizeRepository sizeRepository;

    public Article setEmptyFields(Article input){
        var in = input.getName().split(" ");

        if (in.length == 3){
            input.setCategory(categoryRepository.findByAcronym(in[0]));
            input.setSize(sizeRepository.findBySize(Integer.parseInt(in[1])));
            input.setColor(colorRepository.findByColorCode(in[2]));
        } else if (in.length != 1){
            input.setCategory(categoryRepository.findByName(in[0]));
        }
        else {
            throw new IllegalArgumentException("inputValue");
        }



        return input;
    }
    public Material setEmptyFields(Material input){
        var in = input.getName().split(" ");

        if (in.length == 1){
            input.setCategory(categoryRepository.findByName(in[0]));
            if (input.getColor().getName() == null ) {
                input.setColor(colorRepository.findById(999));
            }
        }
        else {
            throw new IllegalArgumentException("inputValue " + in.length);
        }

        return input;
    }
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
}
