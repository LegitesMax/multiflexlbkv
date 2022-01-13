package org.acme.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

@Entity
@Table(name = "Lieferant")
public class Lieferant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long lieferant_id;

    @NotNull
    @Column(nullable = false, length = 64)
    private String name;

    @Column
    private String weblink;

    @PositiveOrZero
    @Column(nullable = false)
    private int lieferzeit;

    public long getLieferant_id() {
        return lieferant_id;
    }

    public void setLieferant_id(long lieferant_id) {
        this.lieferant_id = lieferant_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWeblink() {
        return weblink;
    }

    public void setWeblink(String weblink) {
        this.weblink = weblink;
    }

    public int getLieferzeit() {
        return lieferzeit;
    }

    public void setLieferzeit(int lieferzeit) {
        this.lieferzeit = lieferzeit;
    }
}
