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

    private Integer stock;

    private Integer minAmount;

    private Integer maxAmount;

    //private Set<ShelfDto> fächer;

    private List<Integer> shelf_ids;

    //private List<ShelfDto> shelfs;

    //private String type;
    //private TypeDto type;

}
