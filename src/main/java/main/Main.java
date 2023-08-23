package main;

import dao.AbstractDao;
import entity.Gender;
import service.Register;
import util.MenuUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        while (true) {
            MenuUtil.showMenu();
        }
    }

}