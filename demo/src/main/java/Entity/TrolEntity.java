package Entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "trol", schema = "mydb", catalog = "")
public class TrolEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "rolName")
    private String rolName;
    @Basic
    @Column(name = "rolDes")
    private String rolDes;
    @Basic
    @Column(name = "admin")
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TrolEntity that = (TrolEntity) o;
        return admin == that.admin && Objects.equals(rolName, that.rolName) && Objects.equals(rolDes, that.rolDes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rolName, rolDes, admin);
    }
}
