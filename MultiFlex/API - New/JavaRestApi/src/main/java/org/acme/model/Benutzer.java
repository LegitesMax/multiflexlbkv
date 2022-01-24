package org.acme.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Benutzer")
public class Benutzer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty
    @NotNull
    @Column(nullable = false, unique = true, length = 32)
    private String benutzername;

    public Benutzer(String benutzername, String hash_pass) {
        this.benutzername = benutzername;
        this.hash_pass = hash_pass;
    }

    public Benutzer() {
    }

    @Column
    private String hash_pass;

    public Integer getId() {
        return id;
    }

    public String getBenutzername() {
        return benutzername;
    }

    public void setBenutzername(String benutzername) {
        this.benutzername = benutzername;
    }

    public String getHash_pass() {
        return hash_pass;
    }

    public void setHash_pass(String hash_pass) {
        this.hash_pass = hash_pass;
    }
}
