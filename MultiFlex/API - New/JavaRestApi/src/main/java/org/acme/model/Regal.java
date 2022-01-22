package org.acme.model;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import java.util.Set;

@Entity
@Table(name = "Regal")
public class Regal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String name;

    @Positive(message = "can not have a negative value ")
    @Column(nullable = false)
    private int max_anzahl_faecher;

    @OneToMany(mappedBy = "regal")
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

    public int getMax_anzahl_faecher() {
        return max_anzahl_faecher;
    }

    public void setMax_anzahl_faecher(int max_anzahl_faecher) {
        this.max_anzahl_faecher = max_anzahl_faecher;
    }
}
