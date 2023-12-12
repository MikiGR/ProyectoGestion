package com.example.work.entity;


import jakarta.persistence.*;


@Entity
@Table(name = "tpermiso")
@IdClass(PermisoId.class)
public class Permiso {

    @Id
    @Column(name = "rolname")
    private String rolName;

    @Id
    private String pantalla;

    private boolean acceso;

    private boolean insertar;

    private boolean modificar;

    private boolean borrar;

    public String getRolName() {
        return rolName;
    }

    public void setRolName(String rolName) {
        this.rolName = rolName;
    }

    public String getPantalla() {
        return pantalla;
    }

    public void setPantalla(String pantalla) {
        this.pantalla = pantalla;
    }

    public boolean isAcceso() {
        return acceso;
    }

    public void setAcceso(boolean acceso) {
        this.acceso = acceso;
    }

    public boolean isInsertar() {
        return insertar;
    }

    public void setInsertar(boolean insertar) {
        this.insertar = insertar;
    }

    public boolean isModificar() {
        return modificar;
    }

    public void setModificar(boolean modificar) {
        this.modificar = modificar;
    }

    public boolean isBorrar() {
        return borrar;
    }

    public void setBorrar(boolean borrar) {
        this.borrar = borrar;
    }
}
