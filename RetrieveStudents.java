
       import java.sql.*;
    public class RetrieveStudents {
        public static void main(String[] args) {
            String url = "jdbc:mysql://localhost:3306/record";
            String user = "root";
            String password = "varshitha";
            try {

                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection(url, user, password);
                System.out.println("Connection Established Successfully!");
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("SELECT * FROM record");
                System.out.println("\nStudent Details:");
                System.out.println("------------------------------");
                while (rs.next()) {
                    System.out.println(
                            "Roll No : " + rs.getInt("RollNo") +
                                    "\nName : " + rs.getString("Name") +
                                    "\nDept : " + rs.getString("Dept")
                    );
                    System.out.println("------------------------------");
                }
                // Close resources
                rs.close();
                st.close();
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

