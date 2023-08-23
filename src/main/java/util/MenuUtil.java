package util;

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
                Menu.Save.process();
                break;
            case 2:
                Menu.Register.process();
                break;
            case 3:
                Menu.Show.process();
                break;
            case 4:
                Menu.Exit.process();
                break;
            default:
                new Exception("Selected index is not valid");

        }

    }




}
