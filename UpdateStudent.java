import java.sql.*;
public class UpdateStudent {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/record";
        String user = "root";
        String password = "varshitha";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, password);
            System.out.println("Connection Established Successfully!");
            String query = "UPDATE record SET Dept=? WHERE RollNo=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, "CSE");
            ps.setInt(2, 2);
            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Department Updated Successfully!");
            } else {
                System.out.println("Student Not Found.");
            }
            ps.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}