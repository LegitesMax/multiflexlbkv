package org.acme.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RegalDto {
    private Integer id;

    private String name;

    private Integer max_anzahl_faecher;

    //private Set<FachDto> faecher;

    private List<Integer> fach_ids;

    public RegalDto(Integer id, String name, Integer max_anzahl_faecher, List<Integer> fachIds) {
        this.id = id;
        this.name = name;
        this.max_anzahl_faecher = max_anzahl_faecher;
        this.fach_ids = fachIds;
    }

    public RegalDto() {
    }


}
