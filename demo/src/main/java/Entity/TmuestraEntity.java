package Entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "tmuestra", schema = "mydb", catalog = "")
public class TmuestraEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID")
    private int id;
    @Basic
    @Column(name = "NIF_Paciente")
    private String nifPaciente;
    @Basic
    @Column(name = "Cultivo")
    private String cultivo;
    @Basic
    @Column(name = "Solucion")
    private int solucion;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNifPaciente() {
        return nifPaciente;
    }

    public void setNifPaciente(String nifPaciente) {
        this.nifPaciente = nifPaciente;
    }

    public String getCultivo() {
        return cultivo;
    }

    public void setCultivo(String cultivo) {
        this.cultivo = cultivo;
    }

    public int getSolucion() {
        return solucion;
    }

    public void setSolucion(int solucion) {
        this.solucion = solucion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TmuestraEntity that = (TmuestraEntity) o;
        return id == that.id && solucion == that.solucion && Objects.equals(nifPaciente, that.nifPaciente) && Objects.equals(cultivo, that.cultivo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nifPaciente, cultivo, solucion);
    }
}
