package at.multiflex.model;

import at.multiflex.model.Wares.Article;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

/**
 * This Size class gets inserted into the database
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Size {
    //<editor-fold desc="Common Fields">
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)
    private Integer size;

    @Column(length = 1024)
    private String description;

    //</editor-fold>
    //<editor-fold desc="Relation">
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "size", cascade=CascadeType.ALL)
    private Set<Article> products = new java.util.LinkedHashSet<>();
    //</editor-fold>

    @Override
    public String toString() {
        return "Size{" +
                "id=" + id +
                ", size=" + size +
                ", description='" + description + '\'' +
                '}';
    }
}
