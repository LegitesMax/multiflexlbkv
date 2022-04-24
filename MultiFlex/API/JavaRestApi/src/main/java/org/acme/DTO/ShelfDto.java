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
    private Integer maxAmount;

    //private RegalDto regal;
    //private WareDto ware;

    private Integer ware_id;
    private Integer regal_id;
}
