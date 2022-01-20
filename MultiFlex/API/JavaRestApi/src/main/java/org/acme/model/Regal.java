package org.acme.model;

import javax.persistence.*;
import javax.validation.constraints.Positive;

@Entity
@Table(name = "Regal")
public class Regal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long regal_id;

    @Column
    private String name;

    @Positive(message = "can not have a negative value ")
    @Column(nullable = false)
    private int max_anzahl_faecher;

    public Regal() {
    }

    public Regal(String name, int max_anzahl_faecher) {
        this.name = name;
        this.max_anzahl_faecher = max_anzahl_faecher;
    }

    public long getRegal_id() {
        return regal_id;
    }

    public void setRegal_id(long regal_id) {
        this.regal_id = regal_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMax_anzahl_faecher() {
        return max_anzahl_faecher;
    }

    public void setMax_anzahl_faecher(int max_anzahl_faecher) {
        this.max_anzahl_faecher = max_anzahl_faecher;
    }
}
