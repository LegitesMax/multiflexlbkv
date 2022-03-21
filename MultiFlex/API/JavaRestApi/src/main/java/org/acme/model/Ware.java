package org.acme.model;

import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.util.Set;

//@Table(name = "Ware")
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
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
    private Set<Fach> fächer;

    @ManyToOne
    private Typ typ;

    @ManyToMany
    private Set<Lieferant> lieferanten;

    public Ware() {
    }

    public Ware(String name, Integer bestand, Integer minbestand, Integer maxbestand, Set<Fach> fächer) {
        this.name = name;
        this.bestand = bestand;
        this.minbestand = minbestand;
        this.maxbestand = maxbestand;
        this.fächer = fächer;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getBestand() {
        return bestand;
    }

    public void setBestand(Integer bestand) {
        this.bestand = bestand;
    }

    public Integer getId() {
        return id;
    }

    public Set<Fach> getFächer() {
        return fächer;
    }

    public Integer getMinbestand() {
        return minbestand;
    }

    public void setMinbestand(Integer minbestand) {
        this.minbestand = minbestand;
    }

    public Integer getMaxbestand() {
        return maxbestand;
    }

    public void setMaxbestand(Integer maxbestand) {
        this.maxbestand = maxbestand;
    }
}
