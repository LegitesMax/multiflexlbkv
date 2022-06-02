package at.multiflex.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Material")
public class Material extends Article{
    @Transient
    private List<Integer> productionFormula_ids = getProductionFormulas().stream().map(x -> x.getId()).collect(Collectors.toList());

    @ManyToMany
    @JoinTable(
            name = "Material_ProductionFormula", // name of the association table
            joinColumns = @JoinColumn(name = "material_id"), // foreign key columns
            inverseJoinColumns = @JoinColumn(name = "productionFormulas_id"))
    private Set<ProductionFormula> productionFormulas;
}
