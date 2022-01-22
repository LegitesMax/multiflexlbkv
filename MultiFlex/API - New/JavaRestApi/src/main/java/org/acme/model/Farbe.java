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
    @OneToMany(mappedBy = "farbe")
    private Set<FarbeProdukt> produkte = new HashSet<>();

    @OneToMany(mappedBy = "farbe")
    private Set<Material> materials = new HashSet<>();
}