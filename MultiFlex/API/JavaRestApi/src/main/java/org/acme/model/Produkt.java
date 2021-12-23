package org.acme.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Produkt")
public class Produkt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long produkt_id;

    @Column
    private int preis;

    @OneToMany(mappedBy = "produkt")
    private Set<Farbe> myProdukts = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "farbe_farbe_id")
    private Farbe farbe;

    public Farbe getFarbe() {
        return farbe;
    }
    public void setFarbe(Farbe farbe) {
        this.farbe = farbe;
    }

    public Produkt() {
    }

    public Produkt(int preis, Set<Farbe> myProdukts) {
        this.preis = preis;
        this.myProdukts = myProdukts;
    }

    public void setMyBooks(Set<Farbe> myProdukts) {
        this.myProdukts = myProdukts;
    }
    public Set<Farbe> getMyBooks() {
        return myProdukts;
    }

    public long getProdukt_id() {
        return produkt_id;
    }
    public void setProdukt_id(long produkt_id) {
        this.produkt_id = produkt_id;
    }

    public int getPreis() {
        return preis;
    }
    public void setPreis(int preis) {
        this.preis = preis;
    }
}
