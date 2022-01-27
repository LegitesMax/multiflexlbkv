package org.acme.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

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

    List<Integer> fach_ids;

    public WareDto(Integer id, String name, Integer bestand, Integer minbestand, Integer maxbestand, List<Integer> fach_ids) {
        this.id = id;
        this.name = name;
        this.bestand = bestand;
        this.minbestand = minbestand;
        this.maxbestand = maxbestand;
        this.fach_ids = fach_ids;
    }
}
