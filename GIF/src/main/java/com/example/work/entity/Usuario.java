package com.example.work.entity;

import jakarta.persistence.*;


@Entity
@Table(name = "tusuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nif")
    private String nif;

    private String password;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "rolname", referencedColumnName = "rolname")
    private Rol rolname;

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Rol getRolname() {
        return rolname;
    }

    public void setRolname(Rol rolname) {
        this.rolname = rolname;
    }
}

