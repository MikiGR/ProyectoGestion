package Entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "tsolucion", schema = "mydb", catalog = "")
public class TsolucionEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID")
    private int id;
    @Basic
    @Column(name = "Solucion")
    private String solucion;
    @Basic
    @Column(name = "Uso")
    private String uso;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSolucion() {
        return solucion;
    }

    public void setSolucion(String solucion) {
        this.solucion = solucion;
    }

    public String getUso() {
        return uso;
    }

    public void setUso(String uso) {
        this.uso = uso;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TsolucionEntity that = (TsolucionEntity) o;
        return id == that.id && Objects.equals(solucion, that.solucion) && Objects.equals(uso, that.uso);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, solucion, uso);
    }
}
