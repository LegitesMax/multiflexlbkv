package org.acme.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Produkt")
public class Produkt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private int preis;
/*
    @OneToMany(mappedBy = "produkt")
    private Set<Farbe> myProdukts = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "farbe_farbe_id")
    private Farbe farbe;
 */
    @OneToOne
    @JoinColumn(name = "wareId")
    private Ware ware;

    @OneToMany(mappedBy = "produkt")
    private Set<FarbeProdukt> farben = new HashSet<>();

    @OneToMany(mappedBy = "produkt")
    private Set<ProduktMaterial> materials = new HashSet<>();

    public Ware getWare() {
        return ware;
    }
}
