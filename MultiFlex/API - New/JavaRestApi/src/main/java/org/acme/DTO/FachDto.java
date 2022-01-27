package org.acme.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.acme.model.Ware;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class FachDto {

    private Integer id;
    private Integer position;
    /*
    @Column(nullable = false)
    private long regal_id;

    @Column
    private long ware_id;
     */
    private Integer maxbestand;

    //private WareDto ware;

    Integer wareIds;
    Integer regalIds;

    public FachDto(Integer id, Integer position, Integer maxbestand, Integer wareIds, Integer regalIds) {
        this.id = id;
        this.position = position;
        this.maxbestand = maxbestand;
        this.wareIds = wareIds;
        this.regalIds = regalIds;
    }
}
