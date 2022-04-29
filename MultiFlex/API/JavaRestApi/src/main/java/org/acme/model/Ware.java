package org.acme.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.util.HashSet;
import java.util.Set;

//@Table(name = "Ware")
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Getter
@Setter
@NoArgsConstructor
@Entity
public class Ware {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "ware must have a Name")
    @Column(nullable = false, length = 64)
    private String name;

    @PositiveOrZero(message = "stock can not be negative")
    @Column(nullable = false)
    private Integer stock;

    @PositiveOrZero(message = "min stock can not be negative")
    @Column
    private Integer minAmount;

    @PositiveOrZero(message = "max stock can not be negative")
    @Column
    private Integer maxAmount;

    @OneToMany(mappedBy = "ware")
    private Set<Shelf> shelfs = new HashSet<>();

    @ManyToOne
    private Type type;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "Ware_Supplier",
               joinColumns = @JoinColumn(name = "ware_id"),
               inverseJoinColumns = @JoinColumn(name = "supplier_id"))
    private Set<Supplier> suppliers = new HashSet<>();

    @ManyToMany
    private Set<Color> colors = new HashSet<>();

    public Ware(String name, Integer stock, Integer minAmount, Integer maxAmount) {
        this.name = name;
        this.stock = stock;
        this.minAmount = minAmount;
        this.maxAmount = maxAmount;
    }
}
