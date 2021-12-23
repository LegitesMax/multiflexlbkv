package org.acme.model;

import javax.persistence.*;


@Entity
public class FarbeProdukt {

    @EmbeddedId
    FarbeProduktKey id;

    @ManyToOne
    @MapsId("farbe_id")
    Farbe farbe;

    @ManyToOne
    @MapsId("produkt_id")
    Produkt produkt;

    @Column
    boolean isPrimaryAuthor;

    public FarbeProdukt() {
    }

    public FarbeProdukt(Farbe farbe, Produkt produkt, boolean isPrimaryAuthor) {
        this.farbe = farbe;
        this.produkt = produkt;
        this.isPrimaryAuthor = isPrimaryAuthor;
    }

    public FarbeProduktKey getId() {
        return id;
    }
    public void setId(FarbeProduktKey id) {
        this.id = id;
    }

    public Farbe getFarbe() {
        return farbe;
    }
    public void setFarbe(Farbe farbe) {
        this.farbe = farbe;
    }

    public Produkt getProdukt() {
        return produkt;
    }
    public void setProdukt(Produkt produkt) {
        this.produkt = produkt;
    }

    public boolean isPrimaryAuthor() {
        return isPrimaryAuthor;
    }
    public void setPrimaryAuthor(boolean primaryAuthor) {
        isPrimaryAuthor = primaryAuthor;
    }
}
