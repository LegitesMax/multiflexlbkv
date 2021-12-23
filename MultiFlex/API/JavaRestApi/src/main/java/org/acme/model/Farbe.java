package org.acme.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Farbe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long farbe_id;

    @Column
    private String name;

    @OneToMany(mappedBy = "farbe")
    private Set<Produkt> myFarbe = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "produkt_produkt_id")
    private Produkt produkt;

    public Produkt getProdukt() {
        return produkt;
    }

    public void setProdukt(Produkt produkt) {
        this.produkt = produkt;
    }

    public Farbe() {
    }

    public Long getId() {
        return farbe_id;
    }

    public void setId(Long farbe_id) {
        this.farbe_id = farbe_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMyFarbe(Set<Produkt> myFarbe) {
        this.myFarbe = myFarbe;
    }
}