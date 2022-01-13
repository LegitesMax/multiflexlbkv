package org.acme.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

@Entity
@Table(name = "Ware")
public class Ware {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ware_id;

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

    public long getWare_id() {
        return ware_id;
    }

    public void setWare_id(long ware_id) {
        this.ware_id = ware_id;
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
