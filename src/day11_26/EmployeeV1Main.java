package day11_26;

import java.util.Scanner;

public class EmployeeV1Main {
    public static void main(String[] args) {
        EmployeeService srv = new EmployeeService();
        Scanner sc = new Scanner(System.in);
        String menu = "";

        while(true) {
            srv.showDisplay();
            menu = sc.nextLine();
            switch(menu){
                case "1" : srv.newEP(); break;
                case "2" : srv.readEP(); break;
                case "3" : srv.readOneEP(); break;
                case "4" : srv.modifyEP(); break;
                case "5" : srv.removeEP(); break;
                case "0" : System.exit(0);
                default :
                    System.out.println("값을 잘못 입력!");
            }
        }

    }
}
