package org.acme.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ProduktMaterialKey implements Serializable {

    @Column
    Integer materialId;

    @Column
    Integer produktId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProduktMaterialKey that = (ProduktMaterialKey) o;
        return Objects.equals(materialId, that.materialId) && Objects.equals(produktId, that.produktId);
    }

}
