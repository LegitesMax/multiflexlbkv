package at.multiflex.model;

import at.multiflex.model.Wares.Article;
import at.multiflex.model.Wares.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;
}
