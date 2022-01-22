package org.acme.model;

import javax.persistence.*;

@Entity
@Table(name = "Fach")
public class Fach {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private int position;
    /*
    @Column(nullable = false)
    private long regal_id;

    @Column
    private long ware_id;
     */
    @Column
    private int maxbestand;

    @ManyToOne
    @MapsId("id")
    private Ware ware;
    @ManyToOne
    @MapsId("id")
    private Regal regal;

}
