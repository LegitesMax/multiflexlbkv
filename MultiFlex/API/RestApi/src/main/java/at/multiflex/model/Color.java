package at.multiflex.model;

import at.multiflex.model.Wares.Article;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Color {
    //<editor-fold desc="Common Fields">
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 64)
    private String name;

    @Column(nullable = false, length = 64)
    private String color;
    //</editor-fold>
    //<editor-fold desc="Navigation Help">
        //<editor-fold desc="Transient Fields">
    @Transient
    //private List<Integer> article_ids = configurateProductIds();
    private List<Integer> article_ids = configurateProductIds();
        //</editor-fold>
        //<editor-fold desc="Relation">
    @OneToMany(mappedBy = "color")
    private Set<Article> articles = new HashSet<>();
        //</editor-fold>
        //<editor-fold desc="Transient Field configuration">
    private List<Integer> configurateProductIds(){
        if (getArticles() != null){
            return getArticles().stream().map(x -> x.getId()).collect(Collectors.toList());
        }
        return new ArrayList<>();
    }
        //</editor-fold>
    //</editor-fold>
}