package in.ioi.pw;

import java.io.*;
import java.sql.*;

public class ImageDownload {

    public static void main(String[] args) {

        Connection con = null;
        PreparedStatement pstmt = null;
        InputStream is = null;

        try {

            // 1. Database connection details
            String url = "jdbc:mysql://localhost:3307/springdb";
            String username = "root";
            String password = "root123";

            // 2. Establish database connection
            con = DriverManager.getConnection(url, username, password);

            // 3. Create SELECT query
            String sqlSelectQuery =
                    "SELECT * FROM student WHERE sid = ?";

            // 4. Create PreparedStatement and set value
            pstmt = con.prepareStatement(sqlSelectQuery);
            pstmt.setInt(1, 101);

            // 5. Execute SELECT query
            ResultSet rs = pstmt.executeQuery();

            // 6. Read image from database
            if (rs.next()) {

                is = rs.getBinaryStream("image");

                // 7. Write image into output file
                FileOutputStream fos = new FileOutputStream("output.png");

                byte[] buffer = new byte[4096];
                int noOfBytes;

                while ((noOfBytes = is.read(buffer)) != -1) {
                    fos.write(buffer, 0, noOfBytes);
                }

                fos.close();

                // 8. Display success message
                System.out.println("Image downloaded successfully!");

            } else {
                System.out.println("Student not found!");
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