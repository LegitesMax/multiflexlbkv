package at.multiflex.model.Wares;

import at.multiflex.model.Color;
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
@Table(name = "Product")
public class Product extends Article {
    //<editor-fold desc="Common Fields">

    //</editor-fold>
    //<editor-fold desc="Navigation Help">
        //<editor-fold desc="Transient Fields">
    @Transient
    private List<Integer> material_ids = configurateMaterialIds();

    @Transient
    private Integer color_id = configurateColerId();
        //</editor-fold>
        //<editor-fold desc="Relation">
    @ManyToMany(mappedBy = "products")
    private Set<Material> materials = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "color_id", nullable = false)
    private Color color;
        //</editor-fold>
        //<editor-fold desc="Transient Field configuration">
    private List<Integer> configurateMaterialIds(){
        if (getMaterials() != null){
            return getMaterials().stream().map(x -> x.getId()).collect(Collectors.toList());
        }
        return new ArrayList<>();
    }

    private Integer configurateColerId(){
        if (getColor() != null && getColor().getId() != null){
            return getColor().getId();
        }
        return null;
    }
        //</editor-fold>
    //</editor-fold>

    public void setMaterial_ids(List<Integer> material_ids) {
        configurateMaterialIds();
        this.material_ids = material_ids;
    }

    public void setColor_id(Integer color_id) {
        configurateColerId();
        this.color_id = color_id;
    }
}
