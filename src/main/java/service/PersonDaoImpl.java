package service;

import dao.PersonDao;
import entity.Gender;
import entity.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PersonDaoImpl extends PersonDao {
    @Override
    public void showAll() {
        List<Person> people = new ArrayList<>();
        try (Connection c = connect()) {
            Statement stmt = connect().createStatement();
            stmt.execute("select * from person");

            ResultSet rs = stmt.getResultSet();
            while(rs.next()){
                people.add(getPerson(rs));
            }
            System.out.println(people);
        } catch (Exception ex) {
        }
    }

    @Override
    public void addPerson() {
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
    private static Person getPerson(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        String name = rs.getString("name");
        String surname = rs.getString("surname");
        String fathername = rs.getString("father_name");
        int age = rs.getInt("age");
        String gender = rs.getString("gender");

        Gender gen = null;
        if(gender.equalsIgnoreCase("male")){
            gen = Gender.Male;
        } else if (gender.equalsIgnoreCase("female")) {
            gen = Gender.Female;
        }


        return new Person(id, name, surname, fathername, age, gen);

    }
}
