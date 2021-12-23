package org.acme.model;

import javax.persistence.*;

@Entity
public class ProduktMaterial {

    @EmbeddedId
    ProduktMaterialKey id;

    @ManyToOne
    @MapsId("material_id")
    Material material;

    @ManyToOne
    @MapsId("bookId")
    Produkt produkt;

    @Column
    boolean isPrimaryAuthor;

}
