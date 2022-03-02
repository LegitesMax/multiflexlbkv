package org.acme.DTO;

import java.io.Serializable;
import java.util.List;

public class RegalDto implements Serializable {

    private Integer id;

    private String name;

    private Integer max_anzahl_faecher;

    private List<Integer> fach_ids;

    public RegalDto(Integer id, String name, Integer max_anzahl_faecher, List<Integer> fachIds) {
        this.id = id;
        this.name = name;
        this.max_anzahl_faecher = max_anzahl_faecher;
        this.fach_ids = fachIds;
    }

    public RegalDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getMax_anzahl_faecher() {
        return max_anzahl_faecher;
    }

    public void setMax_anzahl_faecher(Integer max_anzahl_faecher) {
        this.max_anzahl_faecher = max_anzahl_faecher;
    }

    public List<Integer> getFach_ids() {
        return fach_ids;
    }

    public void setFach_ids(List<Integer> fach_ids) {
        this.fach_ids = fach_ids;
    }
}
