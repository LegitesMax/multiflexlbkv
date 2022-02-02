package org.acme.model;

import javax.persistence.*;

@Entity
@Table(name = "Fach")
public class Fach {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private Integer position;
    /*
    @Column(nullable = false)
    private long regal_id;

    @Column
    private long ware_id;
     */
    @Column
    private Integer maxbestand;

    @ManyToOne
    @MapsId("id")
    private Ware ware;

    @ManyToOne
    @MapsId("id")
    private Regal regal;

    public Fach(Integer position, Integer maxbestand, Ware ware, Regal regal) {
        this.position = position;
        this.maxbestand = maxbestand;
        this.ware = ware;
        this.regal = regal;
    }

    public Fach() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public Integer getMaxbestand() {
        return maxbestand;
    }

    public void setMaxbestand(Integer maxbestand) {
        this.maxbestand = maxbestand;
    }

    public Ware getWare() {
        return ware;
    }

    public void setWare(Ware ware) {
        this.ware = ware;
    }

    public Regal getRegal() {
        return regal;
    }

    public void setRegal(Regal regal) {
        this.regal = regal;
    }
}
