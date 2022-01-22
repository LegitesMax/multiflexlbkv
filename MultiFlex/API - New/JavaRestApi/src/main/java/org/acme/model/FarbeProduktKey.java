package org.acme.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class FarbeProduktKey implements Serializable {

    @Column
    Integer farbeId;

    @Column
    Integer produktId;

    protected FarbeProduktKey() {}
    public FarbeProduktKey(Integer farbe_id, Integer produkt_id) {
        this.farbeId = farbe_id;
        this.produktId = produkt_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FarbeProduktKey that = (FarbeProduktKey) o;
        return Objects.equals(farbeId, that.farbeId) && Objects.equals(produktId, that.produktId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(farbeId, produktId);
    }

}
