package org.acme.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.acme.model.Fach;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.util.List;
import java.util.Set;
@Getter
@Setter
@NoArgsConstructor
public class WareDto {
    private Integer id;

    private String name;

    private Integer bestand;

    private Integer minbestand;

    private Integer maxbestand;

    //private Set<FachDto> fächer;

    List<Integer> fachIds;

    public WareDto(Integer id, String name, Integer bestand, Integer minbestand, Integer maxbestand, List<Integer> fachIds) {
        this.id = id;
        this.name = name;
        this.bestand = bestand;
        this.minbestand = minbestand;
        this.maxbestand = maxbestand;
        this.fachIds = fachIds;
    }
}
