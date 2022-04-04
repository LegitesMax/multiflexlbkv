package org.acme.DTO.QueryModels;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegalFach {
    //Regal
    private Integer id;

    private String name;

    private Integer max_anzahl_faecher;

    //Shelf
    private Integer maxbestand;
}
