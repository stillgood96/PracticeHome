package day12_20;

import java.util.Scanner;

public class SamKwangMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SamKwangService sv = new SamKwangService();
        sv.displaymenu();
        int button = Integer.parseInt(sc.nextLine());

        while(true) {
            switch (button) {
                case 1:
                            sv.employeeMenu();
                            button = Integer.parseInt(sc.nextLine());
                            if (button==1){
                                sv.newEmployee();
                            }else if(button==2){
                                sv.readEmployee();
                            }else if(button==3){
                                sv.readOneEmployee();
                            }else sv.displaymenu();
                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 0:
                    System.exit(0);
                    break;
            }
        }
    }


}
