package at.multiflex.model;

import at.multiflex.model.Wares.Product;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

/**
 * An entity that logs all productions
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
public class ProductionLog {
    @Id
    @Column(nullable = false)
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    private Date timestamp;

    @Override
    public String toString() {
        return "ProductionLog{" +
                "id=" + id +
                '}';
    }
}
