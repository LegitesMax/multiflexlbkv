package at.multiflex.model;

import at.multiflex.model.Wares.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
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

    @Column(nullable = false, length = 64, unique = true)
    private String name;

    @Column(nullable = false, length = 64, unique = true)
    private String colorCode;
    //</editor-fold>
    //<editor-fold desc="Navigation Help">
        //<editor-fold desc="Transient Fields">
    @Transient
    //private List<Integer> article_ids = configurateProductIds();
    private List<Integer> product_ids = configurateProductIds();
        //</editor-fold>
        //<editor-fold desc="Relation">
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "color")
    private Set<Product> products = new java.util.LinkedHashSet<>();
        //</editor-fold>
        //<editor-fold desc="Transient Field configuration">
    private List<Integer> configurateProductIds(){
        if (getProducts() != null){
            return getProducts().stream().map(x -> x.getId()).collect(Collectors.toList());
        }
        return new ArrayList<>();
    }

    public List<Integer> getProduct_ids() {
        configurateProductIds();
        return product_ids;
    }
    //</editor-fold>
    //</editor-fold>
}