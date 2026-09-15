
package in.ioi.pw;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import in.ioi.pw.entity.Department;
import in.ioi.pw.entity.Employee;

public class TestApp {

    public static void main(String[] args) {


        // =========================================
        // CREATE SESSION FACTORY
        // =========================================

        SessionFactory sessionFactory =
                new Configuration()
                        .configure("hibernate.cfg.xml")
                        .addAnnotatedClass(Employee.class)
                        .addAnnotatedClass(Department.class)
                        .buildSessionFactory();


        // =========================================
        // OPEN SESSION
        // =========================================

        Session session =
                sessionFactory.openSession();


        Transaction transaction =
                session.beginTransaction();


        // =========================================
        // CREATE DEPARTMENTS
        // =========================================

        Department itDepartment =
                new Department("IT");

        Department hrDepartment =
                new Department("HR");


        // Save departments first

        session.persist(itDepartment);

        session.persist(hrDepartment);


        // =========================================
        // CREATE EMPLOYEES
        // =========================================

        Employee employee1 =
                new Employee(
                        "Ravi",
                        50000.0,
                        itDepartment
                );


        Employee employee2 =
                new Employee(
                        "Kiran",
                        60000.0,
                        itDepartment
                );


        Employee employee3 =
                new Employee(
                        "Priya",
                        55000.0,
                        hrDepartment
                );


        Employee employee4 =
                new Employee(
                        "Rahul",
                        70000.0,
                        itDepartment
                );


        // =========================================
        // SAVE EMPLOYEES
        // =========================================

        session.persist(employee1);

        session.persist(employee2);

        session.persist(employee3);

        session.persist(employee4);


        // =========================================
        // COMMIT
        // =========================================

        transaction.commit();


        System.out.println(
                "Departments and Employees saved successfully..."
        );


        // =========================================
        // DISPLAY EMPLOYEES
        // =========================================

        List<Employee> employees =
                session.createQuery(
                        "from Employee",
                        Employee.class
                ).getResultList();


        System.out.println(
                "\nEmployee Details"
        );

        System.out.println(
                "===================================="
        );


        for (Employee employee : employees) {

            System.out.println(
                    "Employee ID   : "
                            + employee.getEid()
            );

            System.out.println(
                    "Employee Name : "
                            + employee.getEname()
            );

            System.out.println(
                    "Salary        : "
                            + employee.getEsal()
            );

            System.out.println(
                    "Department    : "
                            + employee
                                    .getDepartment()
                                    .getDname()
            );

            System.out.println(
                    "------------------------------------"
            );
        }


        // =========================================
        // CLOSE
        // =========================================

        session.close();

        sessionFactory.close();
    }
}