package in.ioi.pw.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer eid;

    private String ename;

    private Double esal;

    private String eaddr;

    public Employee() {
        // Default constructor required by Hibernate
    }

    public Employee(String ename, Double esal, String eaddr) {
        this.ename = ename;
        this.esal = esal;
        this.eaddr = eaddr;
    }

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public Double getEsal() {
        return esal;
    }

    public void setEsal(Double esal) {
        this.esal = esal;
    }

    public String getEaddr() {
        return eaddr;
    }

    public void setEaddr(String eaddr) {
        this.eaddr = eaddr;
    }

    @Override
    public String toString() {
        return "Employee [eid=" + eid
                + ", ename=" + ename
                + ", esal=" + esal
                + ", eaddr=" + eaddr + "]";
    }
}