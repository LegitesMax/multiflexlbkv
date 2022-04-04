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
public class SupplierDto implements Serializable {
    private Integer id;

    private String name;

    private String link;

    private Integer deliveryTime;

    private List<Integer> ware_ids;
}
