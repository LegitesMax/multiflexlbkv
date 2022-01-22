package org.acme.model;

import javax.persistence.*;


@Entity
public class FarbeProdukt {

    @EmbeddedId
    FarbeProduktKey id;

    @ManyToOne
    @MapsId("farbeId")
    Farbe farbe;

    @ManyToOne
    @MapsId("produktId")
    Produkt produkt;


    public FarbeProdukt() {
    }

    public FarbeProdukt(Farbe farbe, Produkt produkt) {
        this.farbe = farbe;
        this.produkt = produkt;
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

}
