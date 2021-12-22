package org.acme.model;

import javax.persistence.*;

@Entity
@Table(name = "Ware")
public class Ware {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ware_id;

    @Column
    private String name;
    @Column
    private int bestand;
    @Column
    private int mindestbestand;
}
