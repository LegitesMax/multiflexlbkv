package org.acme.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.acme.model.Shelf;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegalDto implements Serializable {

    private Integer id;

    private String name;

    private Integer maxAmountShelfs;

    //private List<ShelfDto> shelfs;

    private List<Integer> shelf_ids;

}
