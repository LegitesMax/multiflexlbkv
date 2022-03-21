package org.acme.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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

    @ManyToMany
    private Set<Ware> waren;

    public Lieferant(String name, String weblink, Integer lieferzeit) {
        this.name = name;
        this.weblink = weblink;
        this.lieferzeit = lieferzeit;
    }
}
