package at.multiflex.model;

import at.multiflex.dto.logic.Type;
import at.multiflex.model.Wares.Article;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

/**
 * This Category class gets inserted into the database
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Category {
    //<editor-fold desc="Common Fields">
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 64, unique = true)
    private String name;

    @Column(length = 8)
    private String acronym;

    @Enumerated(EnumType.STRING)
    private Type type;
    //</editor-fold>
    //<editor-fold desc="Relation">
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "category", cascade=CascadeType.ALL)
    private Set<Article> products = new java.util.LinkedHashSet<>();
    //</editor-fold>

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", acronym='" + acronym + '\'' +
                '}';
    }
}
