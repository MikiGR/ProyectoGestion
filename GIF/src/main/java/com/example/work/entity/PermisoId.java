package com.example.work.entity;

import java.io.Serializable;
import java.util.Objects;

public class PermisoId implements Serializable {

    private String rolName;
    private String pantalla;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PermisoId that = (PermisoId) o;
        return Objects.equals(rolName, that.rolName) && Objects.equals(pantalla, that.pantalla);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rolName, pantalla);
    }
}
