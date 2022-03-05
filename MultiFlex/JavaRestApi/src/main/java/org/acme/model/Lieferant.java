package org.acme.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.util.Set;

@Entity
@Table(name = "Lieferant")
public class Lieferant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Column(nullable = false, length = 64)
    private String name;

    @Column
    private String weblink;

    @PositiveOrZero
    @Column(nullable = false)
    private Integer lieferzeit;

    @OneToMany(mappedBy = "lieferant")
    private Set<Material> materials;

    public Lieferant() {
    }

    public Lieferant(String name, String weblink, Integer lieferzeit, Set<Material> materials) {
        this.name = name;
        this.weblink = weblink;
        this.lieferzeit = lieferzeit;
        this.materials = materials;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setLieferzeit(Integer lieferzeit) {
        this.lieferzeit = lieferzeit;
    }

    public Integer getLieferzeit() {
        return lieferzeit;
    }

    public Set<Material> getMaterials() {
        return materials;
    }

    public String getWeblink() {
        return weblink;
    }

    public void setWeblink(String weblink) {
        this.weblink = weblink;
    }
}
