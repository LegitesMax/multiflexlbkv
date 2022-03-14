package org.acme.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.acme.model.Farbe;
import org.acme.model.Lieferant;
import org.acme.model.Produkt;
import org.acme.model.Ware;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MaterialDto {
    private Integer id;

    private String name;

    private Integer dimension;

    private Ware ware;

    private Lieferant lieferant;

    private Farbe farbe;

    private Set<Produkt> produkte = new HashSet<>();
}
