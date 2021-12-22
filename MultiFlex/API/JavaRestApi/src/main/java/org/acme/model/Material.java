package org.acme.model;

import javax.persistence.*;

@Entity
@Table(name = "Material")
public class Material {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long material_id;

    @Column
    private int dimension;

    @Column
    private int farbe_id;

    @Column
    private int lieferant_id;

    @Column
    private int produkt_id;
}
