package in.ioi.pw.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "department")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer did;

    private String dname;


    // Default constructor
    public Department() {
    }


    // Parameterized constructor
    public Department(String dname) {
        this.dname = dname;
    }


    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }


    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }


    @Override
    public String toString() {

        return "Department [did="
                + did
                + ", dname="
                + dname
                + "]";
    }
}
