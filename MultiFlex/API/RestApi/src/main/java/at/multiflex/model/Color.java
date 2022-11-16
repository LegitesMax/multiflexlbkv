package at.multiflex.model;

import at.multiflex.model.Wares.Article;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

/**
 * This Color class gets inserted into the database
 */
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
    //<editor-fold desc="Relation">
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "color", cascade=CascadeType.ALL)
    private Set<Article> products = new java.util.LinkedHashSet<>();
    //</editor-fold>

    @Override
    public String toString() {
        return "Color{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", colorCode='" + colorCode + '\'' +
                '}';
    }
}