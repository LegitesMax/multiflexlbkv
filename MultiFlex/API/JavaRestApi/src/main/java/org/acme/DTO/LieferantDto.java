package org.acme.DTO;

import lombok.Getter;
import lombok.Setter;
import org.acme.model.Material;


import java.util.List;
import java.util.Set;

@Getter
@Setter
public class LieferantDto {
    private Integer id;

    private String name;

    private String weblink;

    private Integer lieferzeit;

    private List<Integer> material_ids;

    public LieferantDto() {
    }

    public LieferantDto(Integer id, String name, String weblink, Integer lieferzeit, List<Integer> material_ids) {
        this.id = id;
        this.name = name;
        this.weblink = weblink;
        this.lieferzeit = lieferzeit;
        this.material_ids = material_ids;
    }
}
