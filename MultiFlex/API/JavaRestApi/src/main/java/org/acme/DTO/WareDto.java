package org.acme.DTO;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WareDto implements Serializable {
    private Integer id;

    private String name;

    private Integer bestand;

    private Integer minbestand;

    private Integer maxbestand;

    //private Set<FachDto> fächer;

    private List<Integer> fach_ids;
}
