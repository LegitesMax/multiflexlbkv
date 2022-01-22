package org.acme.model;

import javax.persistence.*;

@Entity
public class ProduktMaterial {

    @EmbeddedId
    private ProduktMaterialKey id;

    @ManyToOne
    @MapsId("materialId")
    private Material material;

    @ManyToOne
    @MapsId("produktId")
    private Produkt produkt;

    public ProduktMaterial() {
    }

    public ProduktMaterial(ProduktMaterialKey id, Material material, Produkt produkt) {
        this.id = id;
        this.material = material;
        this.produkt = produkt;
    }

    public ProduktMaterialKey getId() {
        return id;
    }

    public Material getMaterial() {
        return material;
    }

    public Produkt getProdukt() {
        return produkt;
    }
}
