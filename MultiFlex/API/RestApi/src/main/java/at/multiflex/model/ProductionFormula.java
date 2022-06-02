package at.multiflex.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ProductionFormula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Transient
    private Integer product_id = getProduct().getId();

    @Transient
    private List<Integer> material_ids = getMaterials().stream().map(x -> x.getId()).collect(Collectors.toList());

    @OneToOne(mappedBy = "productionFormula")
    private Product product;

    @ManyToMany(mappedBy = "productionFormulas")
    private Set<Material> materials = new HashSet<>();

}
