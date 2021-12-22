package org.acme.model;

import javax.persistence.*;

@Entity
@Table(name = "Produkt")
public class Produkt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long produkt_id;

    @Column
    private int preis;

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
