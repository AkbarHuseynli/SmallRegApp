package util;

import service.PersonDaoImpl;
import service.UserDaoImpl;

import java.util.Arrays;
import java.util.Scanner;

public class MenuUtil {
    public static void showMenu(){
        System.out.println("");
        Arrays.stream(Menu.values()).toList().forEach(System.out::println);
        Scanner sc = new Scanner(System.in);
        System.out.println("\nSelect the service: ");
        int index = sc.nextInt();
        switch (index){
            case 1:
                new PersonDaoImpl().addPerson();
                break;
            case 2:
                new UserDaoImpl().addUser();
                break;
            case 3:
                new PersonDaoImpl().showAll();
                break;
            case 4:
                System.out.println("APP is shut down!");
                System.exit(0);
                break;
            default:
                new Exception("Selected index is not valid");

        }

    }




}
