package at.multiflex.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer Value;

    @Column(nullable = false)
    private Integer minValue;

    @Transient
    private Integer color_id = getColor().getId();

    @ManyToOne
    @JoinColumn(name = "color_id", nullable = false)
    private Color color;
}
