package org.acme.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Farbe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true, length = 32)
    @NotNull(message = "Color must have a Name")
    private String name;

    @ManyToMany
    private Set<Produkt> produkte = new HashSet<>();

    @OneToMany(mappedBy = "farbe")
    private Set<Material> materials = new HashSet<>();

    public Farbe(String name, Set<Produkt> produkte, Set<Material> materials) {
        this.name = name;
        this.produkte = produkte;
        this.materials = materials;
    }
}