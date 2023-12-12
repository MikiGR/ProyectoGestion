package com.example.work.entity;


import jakarta.persistence.*;


@Entity
@Table(name = "trol")
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rolname")
    private String rolName;

    @Column(name = "roldes")
    private String rolDes;

    private boolean admin;


    public String getRolName() {
        return rolName;
    }

    public void setRolName(String rolName) {
        this.rolName = rolName;
    }

    public String getRolDes() {
        return rolDes;
    }

    public void setRolDes(String rolDes) {
        this.rolDes = rolDes;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
}
