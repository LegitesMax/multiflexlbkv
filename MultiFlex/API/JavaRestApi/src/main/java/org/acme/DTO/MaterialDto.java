package org.acme.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MaterialDto {
    private Integer id;

    private String name;

    private Integer dimension;

    private List<Integer> lieferant_ids;

    //private Ware ware;
//
    //private Lieferant lieferant;
//
    //private Farbe farbe;
//
    //private Set<Produkt> produkte = new HashSet<>();
}
