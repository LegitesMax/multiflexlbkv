package org.acme.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Fach")
public class Fach {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private Integer position;

    @Column
    private Integer maxbestand;

    @ManyToOne
    @MapsId("id")
    private Ware ware;

    @ManyToOne
    @MapsId("id")
    private Regal regal;

    public Fach(Integer position, Integer maxbestand, Ware ware, Regal regal) {
        this.position = position;
        this.maxbestand = maxbestand;
        this.ware = ware;
        this.regal = regal;
    }
}
