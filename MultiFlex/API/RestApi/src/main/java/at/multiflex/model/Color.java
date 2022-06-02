package at.multiflex.model;

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
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 64)
    private String name;

    @Column(nullable = false, length = 64)
    private String color;

    @Transient
    //private List<Integer> article_ids = configurateProductIds();
    private List<Integer> article_ids = getArticles().stream().map(x -> x.getId()).collect(Collectors.toList());

    @OneToMany(mappedBy = "color")
    private Set<Article> articles = new HashSet<>();

    //private List<Integer> configurateProductIds(){
    //    var ids = new ArrayList<Integer>();
    //    if (this.getArticles() != null){
    //        this.getArticles().forEach(x -> {
    //            ids.add(x.getId());
    //        });
    //    }
    //     return ids;
    //}
}