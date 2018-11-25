
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    // Creating Connection between application and database
    public Connection getConnection() {
        try {
            Connection conn = DriverManager.getConnection("jdbc:derby:lib/CinemaTicketDB;create=false;user=admin;password=password");
            return conn;
        } catch (SQLException ex) {
            throw new RuntimeException("Error connecting to the database.", ex);
        }
    }
}
