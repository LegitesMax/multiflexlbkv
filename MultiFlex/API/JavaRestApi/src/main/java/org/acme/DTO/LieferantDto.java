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
public class LieferantDto implements Serializable {
    private Integer id;

    private String name;

    private String weblink;

    private Integer lieferzeit;

    private List<Integer> waren_ids;
}
