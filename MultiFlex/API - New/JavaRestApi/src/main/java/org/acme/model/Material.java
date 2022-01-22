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
    private int dimension;
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

    @OneToMany(mappedBy = "material")
    private Set<ProduktMaterial> produkts = new HashSet<>();

    public Ware getWare() {
        return ware;
    }

    public String getName() {
        return name;
    }

    public int getDimension() {
        return dimension;
    }
}
