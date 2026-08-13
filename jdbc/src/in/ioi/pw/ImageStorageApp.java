package in.ioi.pw;

import java.io.*;
import java.sql.*;

public class ImageStorageApp {
	public static void main(String[] args) {
		
		Connection con = null;
        PreparedStatement pstmt = null;
        InputStream is = null;

        try {
            // 1. Load image from resources folder
            is = ImageStorageApp.class
                    .getClassLoader()
                    .getResourceAsStream("files/kiran.png");

            if (is == null) {
                System.out.println("Image not found!");
                return;
            }

            // 2. Database connection details
            String url = "jdbc:mysql://localhost:3307/springdb";
            String username = "root";
            String password = "root123";

            // 3. Establish connection
            con = DriverManager.getConnection(url, username, password);

            // 4. SQL query
            String sqlInsertQuery =
                    "INSERT INTO student (SID, SNAME, IMAGE) VALUES (?, ?, ?)";

            // 5. Create PreparedStatement
            pstmt = con.prepareStatement(sqlInsertQuery);

            // 6. Set values
            pstmt.setInt(1, 101);
            pstmt.setString(2, "Kiran");

            // 7. Store image as BLOB
            pstmt.setBinaryStream(3, is);

            // 8. Execute query
            int rows = pstmt.executeUpdate();

            if (rows > 0) {
                System.out.println("Student and image inserted successfully!");
            } else {
                System.out.println("Insertion failed!");
            }

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            try {
                if (is != null)
                    is.close();

                if (pstmt != null)
                    pstmt.close();

                if (con != null)
                    con.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
		
	}
}
}