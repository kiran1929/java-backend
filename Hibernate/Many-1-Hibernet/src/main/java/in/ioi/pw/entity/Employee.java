package in.ioi.pw.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer eid;

    private String ename;

    private Double esal;


    // =========================================
    // MANY TO ONE RELATIONSHIP
    // =========================================

    @ManyToOne
    @JoinColumn(name = "did")
    private Department department;


    // Default constructor
    public Employee() {
    }


    // Parameterized constructor
    public Employee(
            String ename,
            Double esal,
            Department department) {

        this.ename = ename;
        this.esal = esal;
        this.department = department;
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


    public Department getDepartment() {
        return department;
    }

    public void setDepartment(
            Department department) {

        this.department = department;
    }


    @Override
    public String toString() {

        return "Employee [eid="
                + eid
                + ", ename="
                + ename
                + ", esal="
                + esal
                + ", department="
                + department
                + "]";
    }
}