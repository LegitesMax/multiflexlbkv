package at.multiflex.model.Wares;

import at.multiflex.dto.logic.Type;
import at.multiflex.model.Category;
import at.multiflex.model.Color;
import at.multiflex.model.Size;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;

/**
 * This Article class gets inserted into the database
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Article {
    //<editor-fold desc="Common Fields">
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 64, unique = true)
    private String name;

    @Column(nullable = false)
    private Double value;

    @Column(nullable = false)
    private Double minValue;
    //</editor-fold>
    //<editor-fold desc="Navigation Help">
        //<editor-fold desc="Transient Fields">

        //</editor-fold>
        //<editor-fold desc="Relation">

        //</editor-fold>
        //<editor-fold desc="Transient Field configuration">

        //</editor-fold>
    //</editor-fold>

    @ManyToOne
    @JoinColumn(name = "color_id")
    @JsonBackReference
    private Color color;

    @ManyToOne
    @JoinColumn(name = "category_id")
    @JsonBackReference
    private Category category;

    @ManyToOne
    @JoinColumn(name = "size_id")
    @JsonBackReference
    private Size size;

    @Override
    public String toString() {
        var string = "Article{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", value=" + value +
                ", minValue=" + minValue;
        if (color != null){
            string += ", color=" + color.toString();
        }
        if (size != null){
            string += ", size=" + size.toString();
        }
        if (category != null){
            string += ", category=" + category.toString();
        }
        string += '}';

        return string;
    }
}
