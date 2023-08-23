package dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AbstractDao {
    public Connection connect() {
        String url = "jdbc:postgresql://localhost:5432/smallapp";

        String username = "postgres";
        String password ="12345";

        try {
            return DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            System.out.println("connection problem");
            return null;
        }
    }
}
