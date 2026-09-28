    import java.sql.*;
public class DeleteStudent {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/record";
        String user = "root";
        String password = "varshitha";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, password);
            System.out.println("Connection Established Successfully!");
            String query = "DELETE FROM record WHERE RollNo=?";
            PreparedStatement ps = con.prepareStatement(query);ps.setInt(1, 3);
            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Student Record Deleted Successfully!");
            }
            else {
                System.out.println("Student Record Not Found!");
            }
            ps.close();
            con.close();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}

