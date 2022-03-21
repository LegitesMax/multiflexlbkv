package org.acme.model;

import io.quarkus.arc.All;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@NoArgsConstructor
@All
@Setter
@Getter
@Entity
public class Typ {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String typ;
    @OneToMany
    private Set<Ware> waren;
}
