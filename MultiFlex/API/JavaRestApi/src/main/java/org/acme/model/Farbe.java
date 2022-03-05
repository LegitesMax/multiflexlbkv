package org.acme.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Farbe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true, length = 32)
    @NotNull(message = "Color must have a Name")
    private String name;
/*
    @OneToMany(mappedBy = "farbe")
    private Set<Produkt> myFarbe = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "produktId")
    private Produkt produkt;
 */
    @ManyToMany
    private Set<Produkt> produkte = new HashSet<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Farbe() {
    }

    public Farbe(String name, Set<Produkt> produkte, Set<Material> materials) {
        this.name = name;
        this.produkte = produkte;
        this.materials = materials;
    }

    public Integer getId() {
        return id;
    }

    public Set<Produkt> getProdukte() {
        return produkte;
    }

    public Set<Material> getMaterials() {
        return materials;
    }

    @OneToMany(mappedBy = "farbe")
    private Set<Material> materials = new HashSet<>();
}