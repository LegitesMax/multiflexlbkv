package org.acme.DTO.QueryModels;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RegalFachWare {
    //Regal

    private Integer id;

    private String name;

    private Integer max_anzahl_faecher;

    //Fach
    //private Integer maxbestand;

    //Ware
    private String nameWare;

    private Integer bestand;

    private Integer minbestand;

    private Integer maxbestand;

    public RegalFachWare(Integer id, String name, Integer max_anzahl_faecher, String nameWare, Integer bestand, Integer minbestand, Integer maxbestand) {
        this.name = name;
        this.max_anzahl_faecher = max_anzahl_faecher;
        this.id = id;
        this.nameWare = nameWare;
        this.bestand = bestand;
        this.minbestand = minbestand;
        this.maxbestand = maxbestand;
    }
}
