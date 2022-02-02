package org.acme.DTO;


import java.util.List;

public class WareDto {
    private Integer id;

    private String name;

    private Integer bestand;

    private Integer minbestand;

    private Integer maxbestand;

    //private Set<FachDto> fächer;

    private List<Integer> fach_ids;

    public WareDto(Integer id, String name, Integer bestand, Integer minbestand, Integer maxbestand, List<Integer> fach_ids) {
        this.id = id;
        this.name = name;
        this.bestand = bestand;
        this.minbestand = minbestand;
        this.maxbestand = maxbestand;
        this.fach_ids = fach_ids;
    }

    public WareDto() {
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

    public Integer getBestand() {
        return bestand;
    }

    public void setBestand(Integer bestand) {
        this.bestand = bestand;
    }

    public Integer getMinbestand() {
        return minbestand;
    }

    public void setMinbestand(Integer minbestand) {
        this.minbestand = minbestand;
    }

    public Integer getMaxbestand() {
        return maxbestand;
    }

    public void setMaxbestand(Integer maxbestand) {
        this.maxbestand = maxbestand;
    }

    public List<Integer> getFach_ids() {
        return fach_ids;
    }

    public void setFach_ids(List<Integer> fach_ids) {
        this.fach_ids = fach_ids;
    }
}
