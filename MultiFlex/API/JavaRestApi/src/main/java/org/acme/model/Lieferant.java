package org.acme.model;

import javax.persistence.*;

@Entity
@Table(name = "Lieferant")
public class Lieferant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long lieferant_id;

    @Column
    private String name;

    @Column
    private String weblink;

    @Column
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
