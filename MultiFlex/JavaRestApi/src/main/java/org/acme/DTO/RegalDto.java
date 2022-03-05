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
public class RegalDto implements Serializable {

    private Integer id;

    private String name;

    private Integer max_anzahl_faecher;

    private List<Integer> fach_ids;
}
