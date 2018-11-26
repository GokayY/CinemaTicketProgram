
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    // Creating Connection between application and database

    Connection conn;
    private final String dbURL = "jdbc:derby://localhost:1527/CTMDatabase";
    private final String user = "admin";
    private final String password = "password";

    public Connection getConnection() {
        try {
            conn = DriverManager.getConnection(dbURL, user, password);

        } catch (SQLException ex) {
            throw new RuntimeException("Error connecting to the database.", ex);
        }
        return conn;
    }
}
