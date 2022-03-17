package org.acme.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
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
    //@OneToOne
    //@JoinColumn(name = "id")
    //private Ware ware;

    @ManyToMany
    private Set<Farbe> farben = new HashSet<>();

    @ManyToMany
    private Set<Material> materialien = new HashSet<>();

    public Produkt(Integer preis, Set<Farbe> farben, Set<Material> materialien) {
        this.preis = preis;
        //this.ware = ware;
        this.farben = farben;
        this.materialien = materialien;
    }
}
