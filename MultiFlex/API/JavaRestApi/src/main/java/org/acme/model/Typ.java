package org.acme.model;

import io.quarkus.arc.All;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@All
@Setter
@Getter
@AllArgsConstructor
@Entity
public class Typ {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String typ;
    @OneToMany
    private Set<Ware> waren = new HashSet<>();
}
