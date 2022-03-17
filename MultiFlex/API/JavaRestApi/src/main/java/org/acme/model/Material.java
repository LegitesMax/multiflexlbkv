package org.acme.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "Material")
public class Material{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "material must have a Name")
    @Column(nullable = false, length = 32)
    private String name;

    @Column(nullable = false)
    private Integer dimension;

    //@OneToOne
    //@JoinColumn(name = "id")
    //private Ware ware;

    @ManyToMany
    private Set<Lieferant> lieferanten;

    @ManyToOne
    @MapsId("id")
    private Farbe farbe;

    @ManyToMany
    private Set<Produkt> produkte = new HashSet<>();

    public Material(String name, Integer dimension, Lieferant lieferant, Farbe farbe) {
        this.name = name;
        this.dimension = dimension;
        //this.ware = ware;
        this.farbe = farbe;
        this.produkte = produkte;
    }
}
