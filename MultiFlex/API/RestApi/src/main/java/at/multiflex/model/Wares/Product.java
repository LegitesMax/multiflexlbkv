package at.multiflex.model.Wares;

import at.multiflex.model.Category;
import at.multiflex.model.Color;
import at.multiflex.model.Size;
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

    @Transient
    private Integer category_id = configurateCategoryId();

    @Transient
    private List<Integer> size_ids = configurateSizeIds();
        //</editor-fold>
        //<editor-fold desc="Relation">
    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "products")
    private Set<Material> materials = new java.util.LinkedHashSet<>();

    @ManyToOne
    @JoinColumn(name = "color_id", nullable = false)
    private Color color;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "products")
    private Set<Size> sizes = new java.util.LinkedHashSet<>();
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
    private Integer configurateCategoryId(){
        if (getCategory() != null && getCategory().getId() != null){
            return getCategory().getId();
        }
        return null;
    }
    private List<Integer> configurateSizeIds(){
        if (getSizes() != null){
            return getSizes().stream().map(x -> x.getId()).collect(Collectors.toList());
        }
        return new ArrayList<>();
    }
        //</editor-fold>
    //</editor-fold>

    public List<Integer> getMaterial_ids() {
        return configurateMaterialIds();
    }

    public Integer getColor_id() {
        return configurateColerId();
    }

    public Integer getCategory_id() {
        return configurateCategoryId();
    }

    public List<Integer> getSize_ids() {
        return configurateSizeIds();
    }
}
