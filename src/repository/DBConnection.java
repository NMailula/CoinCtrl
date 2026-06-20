package repository;

//
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// Class to handle Database credentials
public class DBConnection {

    // Setting static variables as Database credentials
    private static final String URL = "jdbc:mysql://localhost:3306/coinctrl";
    private static final String USER = "root";
    private static final String PASSWORD = "";


    // Method to establish connection with the database using DB credentials
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
