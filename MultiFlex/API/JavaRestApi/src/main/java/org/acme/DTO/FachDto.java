package org.acme.DTO;


import java.io.Serializable;

public class FachDto implements Serializable {

    private Integer id;
    private Integer position;
    /*
    @Column(nullable = false)
    Integer regal_id;

    @Column
    private long ware_id;
     */
    private Integer maxbestand;

    //private WareDto ware;

    private Integer ware_id;
    private Integer regal_id;

    public FachDto(Integer id, Integer position, Integer maxbestand, Integer ware_id, Integer regal_id) {
        this.id = id;
        this.position = position;
        this.maxbestand = maxbestand;
        this.ware_id = ware_id;
        this.regal_id = regal_id;
    }

    public FachDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public Integer getMaxbestand() {
        return maxbestand;
    }

    public void setMaxbestand(Integer maxbestand) {
        this.maxbestand = maxbestand;
    }

    public Integer getWare_id() {
        return ware_id;
    }

    public void setWare_id(Integer ware_id) {
        this.ware_id = ware_id;
    }

    public Integer getRegal_id() {
        return regal_id;
    }

    public void setRegal_id(Integer regal_id) {
        this.regal_id = regal_id;
    }
}
