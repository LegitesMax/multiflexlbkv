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
@Table(name = "Shelf")
public class Shelf {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private Integer position;

    @Column
    private Integer maxAmount;

    @ManyToOne
    @MapsId("id")
    private Ware ware;

    @ManyToOne
    @MapsId("id")
    private Regal regal;

    public Shelf(Integer position, Integer maxAmount, Ware ware, Regal regal) {
        this.position = position;
        this.maxAmount = maxAmount;
        this.ware = ware;
        this.regal = regal;
    }
}
