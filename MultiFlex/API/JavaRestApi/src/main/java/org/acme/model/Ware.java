package org.acme.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.util.HashSet;
import java.util.Set;

//@Table(name = "Ware")
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Getter
@Setter
@NoArgsConstructor
@Entity
public class Ware {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "ware must have a Name")
    @Column(nullable = false, length = 64)
    private String name;

    @PositiveOrZero(message = "stock can not be negative")
    @Column(nullable = false)
    private Integer bestand;

    @PositiveOrZero(message = "min stock can not be negative")
    @Column
    private Integer minbestand;

    @PositiveOrZero(message = "max stock can not be negative")
    @Column
    private Integer maxbestand;

    @OneToMany(mappedBy = "ware")
    private Set<Fach> fächer = new HashSet<>();

    @ManyToOne
    private Typ typ;

    @ManyToMany
    private Set<Lieferant> lieferanten = new HashSet<>();

    @ManyToMany
    private Set<Farbe> farben = new HashSet<>();

    public Ware(String name, Integer bestand, Integer minbestand, Integer maxbestand) {
        this.name = name;
        this.bestand = bestand;
        this.minbestand = minbestand;
        this.maxbestand = maxbestand;
    }
}
