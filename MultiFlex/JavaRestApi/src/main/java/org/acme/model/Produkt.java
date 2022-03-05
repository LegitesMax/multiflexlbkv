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
    private Integer preis;
/*
    @OneToMany(mappedBy = "produkt")
    private Set<Farbe> myProdukts = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "farbe_farbe_id")
    private Farbe farbe;
 */
    @OneToOne
    @JoinColumn(name = "id")
    private Ware ware;

    @ManyToMany
    private Set<Farbe> farben = new HashSet<>();

    @ManyToMany
    private Set<Material> materialien = new HashSet<>();

    public Produkt() {
    }

    public Produkt(Integer preis, Ware ware, Set<Farbe> farben, Set<Material> materialien) {
        this.preis = preis;
        this.ware = ware;
        this.farben = farben;
        this.materialien = materialien;
    }

    public Integer getPreis() {
        return preis;
    }

    public Set<Farbe> getFarben() {
        return farben;
    }

    public Ware getWare() {
        return ware;
    }

    public Set<Material> getMaterialien() {
        return materialien;
    }

    public void setPreis(Integer preis) {
        this.preis = preis;
    }
}
