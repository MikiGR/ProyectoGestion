package Entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "tusuario", schema = "mydb", catalog = "")
public class TusuarioEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "nif")
    private String nif;
    @Basic
    @Column(name = "password")
    private String password;
    @Basic
    @Column(name = "rolName")
    private String rolName;

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

    public String getRolName() {
        return rolName;
    }

    public void setRolName(String rolName) {
        this.rolName = rolName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TusuarioEntity that = (TusuarioEntity) o;
        return Objects.equals(nif, that.nif) && Objects.equals(password, that.password) && Objects.equals(rolName, that.rolName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nif, password, rolName);
    }
}
