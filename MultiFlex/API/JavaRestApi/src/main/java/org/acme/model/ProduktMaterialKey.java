package org.acme.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ProduktMaterialKey implements Serializable {

    @Column
    Integer material_id;

    @Column
    Integer produkt_id;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProduktMaterialKey that = (ProduktMaterialKey) o;
        return Objects.equals(material_id, that.material_id) && Objects.equals(produkt_id, that.produkt_id);
    }

}
