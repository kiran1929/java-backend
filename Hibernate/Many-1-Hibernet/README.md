# Many-to-One Hibernate Mapping (`Many-1-Hibernet`)

A Maven-based Java application demonstrating entity relationship mapping using Hibernate ORM with **Many-to-One (`@ManyToOne`)** association between `Employee` and `Department`.

---

## 📋 Features

- **Many-to-One Relationship Mapping**: Maps multiple `Employee` records to a single `Department`.
- **Foreign Key Configuration**: Uses `@JoinColumn(name = "did")` on the `Employee` entity to link with `Department`.
- **Department & Employee Persistence**: Demonstrates saving parent departments first and associating them with multiple employees before persisting.
- **HQL Querying**: Retrieves and displays employee records along with their associated department details.

---

## 🏗️ Project Structure

```text
Many-1-Hibernet/
├── pom.xml
└── src/
    └── main/
        ├── java/
        │   └── in/ioi/pw/
        │       ├── entity/
        │       │   ├── Department.java     # Parent Entity
        │       │   └── Employee.java       # Child Entity with @ManyToOne
        │       └── TestApp.java             # Main application runner
        └── resources/
            └── hibernate.cfg.xml            # Database & Hibernate configuration
```

---

## 🧩 Code Components

### 1. `Department.java` (Entity)
- Annotated with `@Entity` and `@Table(name = "department")`.
- Primary key `did` generated with `@GeneratedValue(strategy = GenerationType.IDENTITY)`.
- Department name `dname` (e.g., "IT", "HR").

### 2. `Employee.java` (Entity)
- Annotated with `@Entity` and `@Table(name = "employee")`.
- Association:
  ```java
  @ManyToOne
  @JoinColumn(name = "did")
  private Department department;
  ```
- Fields: `eid` (Primary key), `ename`, `esal`, `department`.

### 3. `TestApp.java` (Driver)
- Builds `SessionFactory` with both annotated classes (`Employee.class`, `Department.class`).
- Creates and persists departments (`IT`, `HR`).
- Creates multiple employees (`Ravi`, `Kiran`, `Priya`, `Rahul`) linked to their respective departments.
- Commits transactions and fetches all employees with HQL (`from Employee`) to display the joined department data.

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

1. Ensure MySQL Server is active on port `3307` with `springdb` database.
2. Open the project in Eclipse / IntelliJ IDEA or build via Maven:
   ```bash
   mvn clean compile
   ```
3. Run `in.ioi.pw.TestApp` as a Java application.
