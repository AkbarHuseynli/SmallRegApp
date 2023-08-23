package service;

import dao.MenuService;
import entity.Gender;
import entity.Person;
import entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Handler;

public class Display extends MenuService {

    @Override
    public void process() {
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
