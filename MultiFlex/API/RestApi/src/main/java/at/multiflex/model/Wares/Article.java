package at.multiflex.model.Wares;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    private Integer value;

    @Column(nullable = false)
    private Integer minValue;
    //</editor-fold>
    //<editor-fold desc="Navigation Help">
        //<editor-fold desc="Transient Fields">

        //</editor-fold>
        //<editor-fold desc="Relation">

        //</editor-fold>
        //<editor-fold desc="Transient Field configuration">

        //</editor-fold>
    //</editor-fold>
}
