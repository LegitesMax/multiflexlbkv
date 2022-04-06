package org.acme.DTO;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.acme.model.Ware;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ShelfDto implements Serializable {

    private Integer id;
    private Integer position;
    /*
    @Column(nullable = false)
    Integer regal_id;

    @Column
    private long ware_id;
     */
    private Integer maxAmount;

    //private WareDto ware;

    private Integer ware_id;
    private Integer regal_id;
}
