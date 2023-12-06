package Entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;
import java.util.Objects;

public class TpermisoEntityPK implements Serializable {
    @Column(name = "rolName")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String rolName;
    @Column(name = "pantalla")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
        TpermisoEntityPK that = (TpermisoEntityPK) o;
        return Objects.equals(rolName, that.rolName) && Objects.equals(pantalla, that.pantalla);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rolName, pantalla);
    }
}
