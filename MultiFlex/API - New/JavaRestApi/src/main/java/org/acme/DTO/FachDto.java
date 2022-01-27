package org.acme.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    Integer ware_id;
    Integer regal_id;

    public FachDto(Integer id, Integer position, Integer maxbestand, Integer ware_id, Integer regal_id) {
        this.id = id;
        this.position = position;
        this.maxbestand = maxbestand;
        this.ware_id = ware_id;
        this.regal_id = regal_id;
    }
}
