package at.multiflex.model;

import at.multiflex.model.Wares.Product;
import lombok.*;

import javax.persistence.*;
/**
 * An entity that logs all productions
 */
@Getter
@Setter
@AllArgsConstructor
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

    @Override
    public String toString() {
        return "ProductionLog{" +
                "id=" + id +
                '}';
    }
}
