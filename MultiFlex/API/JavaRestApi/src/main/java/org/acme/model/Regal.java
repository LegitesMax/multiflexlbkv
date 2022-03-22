package org.acme.model;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Regal")
public class Regal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true)
    private String name;

    @Positive(message = "can not have a negative value ")
    @Column(nullable = false)
    private Integer max_anzahl_faecher;

    @OneToMany(mappedBy = "regal"/*, cascade = CascadeType.REMOVE*/)
    private Set<Fach> faecher = new HashSet<>();

    public Regal(String name, Integer max_anzahl_faecher) {
        this.name = name;
        this.max_anzahl_faecher = max_anzahl_faecher;
    }

    public Regal() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getMax_anzahl_faecher() {
        return max_anzahl_faecher;
    }

    public void setMax_anzahl_faecher(Integer max_anzahl_faecher) {
        this.max_anzahl_faecher = max_anzahl_faecher;
    }

    public Set<Fach> getFaecher() {
        return faecher;
    }

    public void setFaecher(Set<Fach> faecher) {
        this.faecher = faecher;
    }
}
