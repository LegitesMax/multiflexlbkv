package org.acme.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.acme.model.Fach;
import org.acme.model.Regal;

import java.util.List;
import java.util.Set;
@Getter
@Setter
public class RegalDto {
    private Integer id;

    private String name;

    private Integer max_anzahl_faecher;

    //private Set<FachDto> faecher;

    private List<Integer> fachIds;

    public RegalDto(Integer id, String name, Integer max_anzahl_faecher, List<Integer> fachIds) {
        this.id = id;
        this.name = name;
        this.max_anzahl_faecher = max_anzahl_faecher;
        this.fachIds = fachIds;
    }

    public RegalDto() {
    }


}
