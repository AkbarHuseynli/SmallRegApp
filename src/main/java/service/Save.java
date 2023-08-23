package service;

import dao.MenuService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Save extends MenuService {
    @Override
    public void process() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter name");
        String name = sc.next();
        System.out.println("Enter surname");
        String surname = sc.next();
        System.out.println("Enter fathername");
        String fathername = sc.next();
        System.out.println("Enter age");
        int age = sc.nextInt();
        System.out.println("Enter gender");
        String gender = sc.next();

        try (Connection c = connect()) {
            PreparedStatement stmt = connect().prepareStatement("INSERT INTO\n" +
                    "person (name, surname, father_name, age, gender)\n" +
                    "values (?,?,?,?,?)");
            stmt.setString(1, name);
            stmt.setString(2, surname);
            stmt.setString(3, fathername);
            stmt.setInt(4, age);
            stmt.setString(5, gender);
            stmt.execute();
            System.out.println("Person is saved sucessfully!");
        } catch (Exception ex) {
            System.out.println("Error occured during saving!");

        }
    }
}
