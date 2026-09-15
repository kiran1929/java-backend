package in.ioi.pw;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import in.ioi.pw.entity.Employee;

public class TestApp {

    public static void main(String[] args) {

        // Create SessionFactory
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        Scanner scan = new Scanner(System.in);

        while (true) {

            System.out.println("\n*********************");
            System.out.println("Services provided");
            System.out.println("1. INSERT");
            System.out.println("2. SELECT ON ID");
            System.out.println("3. SELECT ALL");
            System.out.println("4. UPDATE");
            System.out.println("5. DELETE");
            System.out.println("6. EXIT");
            System.out.println("*********************");

            System.out.print("Enter your choice: ");

            int choice = scan.nextInt();
            scan.nextLine();

            switch (choice) {

                // =====================================
                // INSERT
                // =====================================

                case 1:

                    System.out.print("Enter Employee name: ");
                    String name = scan.nextLine();

                    System.out.print("Enter Employee salary: ");
                    Double salary = scan.nextDouble();
                    scan.nextLine();

                    System.out.print("Enter Employee address: ");
                    String address = scan.nextLine();

                    Employee employee =
                            new Employee(name, salary, address);

                    Session session =
                            sessionFactory.openSession();

                    Transaction transaction =
                            session.beginTransaction();

                    session.persist(employee);

                    transaction.commit();

                    session.close();

                    System.out.println(
                            "Record inserted successfully..."
                    );

                    System.out.println(
                            "Generated Employee ID: "
                                    + employee.getEid()
                    );

                    break;


                // =====================================
                // SELECT BY ID
                // =====================================

                case 2:

                    System.out.print(
                            "Enter the id you want to select: "
                    );

                    int id = scan.nextInt();
                    scan.nextLine();

                    session =
                            sessionFactory.openSession();

                    employee =
                            session.get(
                                    Employee.class,
                                    id
                            );

                    session.close();

                    if (employee != null) {

                        System.out.println(
                                "\nEmployee Details"
                        );

                        System.out.println(
                                "-------------------------"
                        );

                        System.out.println(
                                "EMP ID      IS :: "
                                        + employee.getEid()
                        );

                        System.out.println(
                                "EMP NAME    IS :: "
                                        + employee.getEname()
                        );

                        System.out.println(
                                "EMP SALARY  IS :: "
                                        + employee.getEsal()
                        );

                        System.out.println(
                                "EMP ADDRESS IS :: "
                                        + employee.getEaddr()
                        );

                    } else {

                        System.out.println(
                                "Employee not found..."
                        );
                    }

                    break;


                // =====================================
                // SELECT ALL
                // =====================================

                case 3:

                    session =
                            sessionFactory.openSession();

                    List<Employee> employees =
                            session.createQuery(
                                    "from Employee",
                                    Employee.class
                            ).getResultList();

                    session.close();

                    System.out.println(
                            "\nDisplaying all employee details:"
                    );

                    System.out.println(
                            "--------------------------------"
                    );

                    if (employees.isEmpty()) {

                        System.out.println(
                                "No employee records found."
                        );

                    } else {

                        for (Employee emp : employees) {
                            System.out.println(emp);
                        }
                    }

                    break;


                // =====================================
                // UPDATE
                // =====================================

                case 4:

                    System.out.print(
                            "Enter the id you want to update: "
                    );

                    id = scan.nextInt();
                    scan.nextLine();

                    session =
                            sessionFactory.openSession();

                    transaction =
                            session.beginTransaction();

                    employee =
                            session.get(
                                    Employee.class,
                                    id
                            );

                    if (employee != null) {

                        System.out.println(
                                "OLD NAME    IS :: "
                                        + employee.getEname()
                        );

                        System.out.print(
                                "Enter new name: "
                        );

                        String newName =
                                scan.nextLine();


                        System.out.println(
                                "OLD SALARY  IS :: "
                                        + employee.getEsal()
                        );

                        System.out.print(
                                "Enter new salary: "
                        );

                        Double newSalary =
                                scan.nextDouble();

                        scan.nextLine();


                        System.out.println(
                                "OLD ADDRESS IS :: "
                                        + employee.getEaddr()
                        );

                        System.out.print(
                                "Enter new address: "
                        );

                        String newAddress =
                                scan.nextLine();


                        employee.setEname(newName);

                        employee.setEsal(newSalary);

                        employee.setEaddr(newAddress);


                        /*
                         * Hibernate automatically detects
                         * these changes and performs UPDATE.
                         */

                        transaction.commit();

                        System.out.println(
                                "Record updated successfully..."
                        );

                    } else {

                        transaction.rollback();

                        System.out.println(
                                "Employee not found..."
                        );
                    }

                    session.close();

                    break;


                // =====================================
                // DELETE
                // =====================================

                case 5:

                    System.out.print(
                            "Enter the id of employee "
                                    + "that you want to delete: "
                    );

                    id = scan.nextInt();
                    scan.nextLine();

                    session =
                            sessionFactory.openSession();

                    transaction =
                            session.beginTransaction();

                    employee =
                            session.get(
                                    Employee.class,
                                    id
                            );

                    if (employee != null) {

                        session.remove(employee);

                        transaction.commit();

                        System.out.println(
                                "Record deleted successfully..."
                        );

                    } else {

                        transaction.rollback();

                        System.out.println(
                                "Employee not found..."
                        );
                    }

                    session.close();

                    break;


                // =====================================
                // EXIT
                // =====================================

                case 6:

                    System.out.println(
                            "Thanks for using our application....🙏"
                    );

                    scan.close();

                    sessionFactory.close();

                    return;


                default:

                    System.out.println(
                            "Invalid choice! Please enter 1-6."
                    );
            }
        }
    }
}