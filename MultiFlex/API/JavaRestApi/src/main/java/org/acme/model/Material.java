package org.acme.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Material")
public class Material {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long material_id;

    @NotNull(message = "material must have a Name")
    @Column(nullable = false, length = 32)
    private String name;

    @Column(nullable = false)
    private int dimension;

    @Column(nullable = false)
    private int farbe_id;

    @Column
    private int lieferant_id;

    @Column
    private int produkt_id;

    public String getName() {
        return name;
    }

    public int getDimension() {
        return dimension;
    }

    public int getFarbe_id() {
        return farbe_id;
    }
}
