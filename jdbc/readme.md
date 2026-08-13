## JDBC App

This project is a simple JDBC sample that demonstrates storing and downloading an image with MySQL.

### Structure

```text
jdbc/
└── src/
	├── files/
	│   └── kiran.png
	└── in/ioi/pw/
		├── ImageDownload.java
		└── ImageStorageApp.java
```

### Files Included

- `ImageStorageApp.java` stores an image from `src/files/kiran.png` into the database.
- `ImageDownload.java` reads the image back from the database and writes it to `output.png`.
- `kiran.png` is the image resource used by the storage app.

### Notes

- The package name is `in.ioi.pw`.
- The app uses a MySQL database connection on `localhost:3307/springdb`.
- Only the JDBC app files are included here.

