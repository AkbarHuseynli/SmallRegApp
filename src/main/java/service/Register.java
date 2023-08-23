package service;

import dao.MenuService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Register extends MenuService {

    @Override
    public void process() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter person id");
        int person_id = sc.nextInt();

        System.out.println("Enter username");
        String user_name = sc.next();
        try (Connection c = connect()) {
            Statement stmt = connect().createStatement();
            stmt.execute("select name from user1");

            ResultSet rs = stmt.getResultSet();

            while (rs.next()) {
                String name = rs.getString("name");
                if (user_name == name) {
                    System.out.println("------------------");
//                    user_name = sc.next();
                    throw new Exception("Username is already used! Please change it");
                }
            }
            System.out.println("Enter password");
            String pass = sc.next();

            PreparedStatement stmt2 = connect().prepareStatement("INSERT INTO\n" +
                    "user1(id, name, password)\n" +
                    "values (?,?,?)");
            stmt2.setInt(1, person_id);
            stmt2.setString(2, user_name);
            stmt2.setString(3, pass);
            stmt2.execute();
            System.out.println("User is registered successfully!");

        } catch (Exception ex) {
            System.out.println("Error occured during registering!");
        }


    }
}
