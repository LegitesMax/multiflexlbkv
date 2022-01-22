package org.acme.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.util.Set;

@Entity
@Table(name = "Ware")
public class Ware {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull(message = "ware must have a Name")
    @Column(nullable = false, length = 64)
    private String name;
    @PositiveOrZero(message = "stock can not be negative")
    @Column(nullable = false)
    private int bestand;
    @PositiveOrZero(message = "min stock can not be negative")
    @Column
    private int minbestand;
    @PositiveOrZero(message = "max stock can not be negative")
    @Column
    private int maxbestand;

    @OneToMany(mappedBy = "ware")
    private Set<Fach> fächer;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBestand() {
        return bestand;
    }

    public void setBestand(int bestand) {
        this.bestand = bestand;
    }

    public int getMinbestand() {
        return minbestand;
    }

    public void setMinbestand(int minbestand) {
        this.minbestand = minbestand;
    }

    public int getMaxbestand() {
        return maxbestand;
    }

    public void setMaxbestand(int maxbestand) {
        this.maxbestand = maxbestand;
    }
}
