package service;

import dao.UserDao;

import java.sql.*;
import java.util.Scanner;

public class UserDaoImpl extends UserDao {
    @Override
    public void addUser() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter person id :");
        int person_id = sc.nextInt();

        System.out.println("Enter username :");
        String user_name = sc.next();

        try (Connection c = connect()) {
            Statement stmt = connect().createStatement();
            stmt.execute("select name from user1");

            ResultSet rs = stmt.getResultSet();

            while (rs.next()) {
                String name = rs.getString("name");
                if (user_name.equalsIgnoreCase(name)) {
                    System.err.println("This name is already used! Please change it");
                    System.out.println("Enter username :");
                    user_name = sc.next();
                }
            }

        }
        catch (SQLException ex) {
        }

        System.out.println("Enter password");
        String pass = sc.next();


        try {
            PreparedStatement stmt2 = connect().prepareStatement("INSERT INTO\n" +
                    "user1(id, name, password)\n" +
                    "values (?,?,?)");
            stmt2.setInt(1, person_id);
            stmt2.setString(2, user_name);
            stmt2.setString(3, pass);
            stmt2.execute();
            System.out.println("User is registered successfully!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
