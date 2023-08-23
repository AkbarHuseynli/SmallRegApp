package util;

import java.util.Arrays;
import java.util.Scanner;

public class MenuUtil {
    public static void showMenu(){
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
                MenuUtil.exit();
                break;
            default:
                new Exception("Selected index is not valid");

        }

    }
    public static void exit() {
            System.exit(0);
    }



}
