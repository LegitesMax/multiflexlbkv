package at.multiflex.Logic;

import at.multiflex.model.Wares.Article;
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

    public Article getArticle(Article input){
        var in = input.getName().split(" ");

        if (in.length != 3){
            throw new IllegalArgumentException("inputValue");
        }

        input.setCategory(categoryRepository.findByAcronym(in[0]));
        input.setSize(sizeRepository.findBySize(Integer.parseInt(in[1])));
        input.setColor(colorRepository.findByColorCode(in[2]));

        return input;
    }
}
