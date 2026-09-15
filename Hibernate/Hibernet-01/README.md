# Hibernate - 01 (CRUD Operations)

A Maven-based Java application demonstrating full **CRUD (Create, Read, Update, Delete)** operations using **Hibernate ORM** and MySQL with an interactive command-line interface.

---

## 📋 Features

- **Insert Employee**: Persists a new `Employee` record into the MySQL database.
- **Select Employee by ID**: Fetches an employee by primary key (`eid`) using `session.get()`.
- **Select All Employees**: Retrieves and displays all employee records using HQL (`from Employee`).
- **Update Employee**: Updates employee attributes (`ename`, `esal`, `eaddr`) with Hibernate dirty checking and transaction commit.
- **Delete Employee**: Deletes an employee record from the database using `session.remove()`.
- **Interactive CLI Menu**: Switch-case driven console loop for testing operations.

---

## 🏗️ Project Structure

```text
Hibernet-01/
├── pom.xml
└── src/
    └── main/
        ├── java/
        │   └── in/ioi/pw/
        │       ├── entity/
        │       │   └── Employee.java       # Hibernate Entity class
        │       └── TestApp.java             # Main application with CLI menu
        └── resources/
            └── hibernate.cfg.xml            # Database & Hibernate configuration
```

---

## 🧩 Code Components

### 1. `Employee.java` (Entity)
- Annotated with `@Entity` and `@Table(name = "employee")`.
- Primary key `eid` configured with `@Id` and `@GeneratedValue(strategy = GenerationType.IDENTITY)`.
- Fields: `ename` (String), `esal` (Double), `eaddr` (String).
- Provides default and parameterized constructors, getters, setters, and `toString()`.

### 2. `TestApp.java` (Driver / Service Layer)
- Configures `SessionFactory` using `new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class).buildSessionFactory()`.
- Provides an interactive console menu with options 1 to 6.
- Manages Hibernate `Session` lifecycle and `Transaction` boundaries (`beginTransaction`, `commit`, `rollback`, `close`).

---

## ⚙️ Configuration (`hibernate.cfg.xml`)

| Property | Value |
|---|---|
| **Driver Class** | `com.mysql.cj.jdbc.Driver` |
| **Connection URL** | `jdbc:mysql://localhost:3307/springdb` |
| **Username** | `root` |
| **Dialect** | `org.hibernate.dialect.MySQLDialect` |
| **hbm2ddl.auto** | `update` |
| **show_sql / format_sql** | `true` |

---

## 🚀 How to Run

1. Make sure MySQL server is running with database `springdb`.
2. Open the project in Eclipse / IntelliJ IDEA or run via Maven:
   ```bash
   mvn clean compile
   ```
3. Run `in.ioi.pw.TestApp` as a Java application.
