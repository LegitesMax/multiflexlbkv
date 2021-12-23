package org.acme.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class FarbeProduktKey implements Serializable {

    @Column
    Integer farbe_id;

    @Column
    Integer produkt_id;

    protected FarbeProduktKey() {}
    public FarbeProduktKey(Integer farbe_id, Integer produkt_id) {
        this.farbe_id = farbe_id;
        this.produkt_id = produkt_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FarbeProduktKey that = (FarbeProduktKey) o;
        return Objects.equals(farbe_id, that.farbe_id) && Objects.equals(produkt_id, that.produkt_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(farbe_id, produkt_id);
    }

}
