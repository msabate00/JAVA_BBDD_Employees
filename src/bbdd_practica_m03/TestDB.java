import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class TestDB {

    public static void main(String[] args) {

        String url = "jdbc:mysql://172.16.0.100:3306/employees";
        Properties connectionProperties = new Properties();
        connectionProperties.setProperty("user", "admin");
        connectionProperties.setProperty("password", "1234");
        try (
            Connection con = DriverManager.getConnection(url, connectionProperties);
            Statement st = con.createStatement(); ) { 
            System.out.println("Base de dades connectada!");
            try (
                ResultSet rs = st.executeQuery("SELECT * FROM employees ORDER BY last_name, first_name LIMIT 10");) { 
                System.out.println("Dades de la taula employees:");
                while (rs.next()) { 
                    int empNo = rs.getInt("emp_no");
                    String firstName = rs.getString("first_name"); 
                    String lastName = rs.getString("last_name"); 
                    System.out.printf("%8d %15s %15s\n", empNo, firstName, lastName);
                }
            }
        } catch (SQLException e) {
            System.err.println("Error SQL: " + e.getMessage());
        }
    }
}