package org.acme.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Supplier")
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Column(nullable = false, length = 64, unique = true)
    private String name;

    @Column(unique = true)
    private String link;

    @PositiveOrZero
    @Column(nullable = false)
    private Integer deliveryTime;

    @ManyToMany(mappedBy = "suppliers")
    private Set<Ware> wares = new HashSet<>();

    public Supplier(String name, String link, Integer deliveryTime) {
        this.name = name;
        this.link = link;
        this.deliveryTime = deliveryTime;
    }
}
