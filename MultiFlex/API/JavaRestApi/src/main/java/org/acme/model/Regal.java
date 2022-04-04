package org.acme.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Regal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true)
    private String name;

    @Positive(message = "can not have a negative value ")
    @Column(nullable = false)
    private Integer maxAmountShelfs;

    @OneToMany(mappedBy = "regal"/*, cascade = CascadeType.REMOVE*/)
    private Set<Shelf> shelfs = new HashSet<>();

    public Regal(String name, Integer maxAmountShelfs) {
        this.name = name;
        this.maxAmountShelfs = maxAmountShelfs;
    }
}
