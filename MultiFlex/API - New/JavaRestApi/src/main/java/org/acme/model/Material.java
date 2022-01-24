package org.acme.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Material")
public class Material {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "material must have a Name")
    @Column(nullable = false, length = 32)
    private String name;

    @Column(nullable = false)
    private Integer dimension;
/*
    @Column(nullable = false)
    private int farbe_id;

    @Column
    private int lieferant_id;

    @Column
    private int produkt_id;
 */
    @OneToOne
    @JoinColumn(name = "id")
    private Ware ware;

    @ManyToOne
    @MapsId("id")
    private Lieferant lieferant;

    @ManyToOne
    @MapsId("id")
    private Farbe farbe;

    @ManyToMany
    private Set<Produkt> produkte = new HashSet<>();

    public Material(String name, Integer dimension, Ware ware, Lieferant lieferant, Farbe farbe, Set<Produkt> produkte) {
        this.name = name;
        this.dimension = dimension;
        this.ware = ware;
        this.lieferant = lieferant;
        this.farbe = farbe;
        this.produkte = produkte;
    }

    public Material() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDimension() {
        return dimension;
    }

    public void setDimension(Integer dimension) {
        this.dimension = dimension;
    }

    public Integer getId() {
        return id;
    }

    public Ware getWare() {
        return ware;
    }

    public Lieferant getLieferant() {
        return lieferant;
    }

    public Farbe getFarbe() {
        return farbe;
    }

    public Set<Produkt> getProdukte() {
        return produkte;
    }
}
