
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    // Creating Connection between application and database
    

    private String dbURL = "jdbc:derby://localhost:1527/CTMDatabase";
    private String user = "admin";
    private String password = "password";


    public Connection getConnection() {

        try {
            Connection conn = DriverManager.getConnection(dbURL, user, password);
            return conn;
        } catch (SQLException ex) {
            throw new RuntimeException("Error connecting to the database.", ex);
        }
        
    }
}
