package org.acme.model;

import javax.persistence.*;

@Entity
@Table(name = "Regal")
public class Regal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long regal_id;

    @Column
    private String name;

    @Column
    private int max_anzahl_fächer;

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

    public int getMax_anzahl_fächer() {
        return max_anzahl_fächer;
    }

    public void setMax_anzahl_fächer(int max_anzahl_fächer) {
        this.max_anzahl_fächer = max_anzahl_fächer;
    }
}
