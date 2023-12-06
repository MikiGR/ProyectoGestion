package Entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "tpermiso", schema = "mydb", catalog = "")
@IdClass(TpermisoEntityPK.class)
public class TpermisoEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "rolName")
    private String rolName;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "pantalla")
    private String pantalla;
    @Basic
    @Column(name = "acceso")
    private boolean acceso;
    @Basic
    @Column(name = "insertar")
    private boolean insertar;
    @Basic
    @Column(name = "modificar")
    private boolean modificar;
    @Basic
    @Column(name = "borrar")
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TpermisoEntity that = (TpermisoEntity) o;
        return acceso == that.acceso && insertar == that.insertar && modificar == that.modificar && borrar == that.borrar && Objects.equals(rolName, that.rolName) && Objects.equals(pantalla, that.pantalla);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rolName, pantalla, acceso, insertar, modificar, borrar);
    }
}
