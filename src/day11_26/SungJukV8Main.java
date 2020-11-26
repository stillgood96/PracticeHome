package day11_26;

import java.util.Scanner;

public class SungJukV8Main {
    public static void main(String[] args) {
        SungJukV8service srv = new SungJukV8service();
        Scanner sc = new Scanner(System.in);
        String menu = "";

        while(true) {
            srv.showDisplay();
            menu=sc.nextLine();
            switch(menu){
                case "1" : srv.newSungJuk(); break;
                case "2" : srv.printSungJuk(); break;
                case "3" : srv.readSungJuk(); break;
                case "0" : System.exit(0); break;
                default :
                    System.out.println("잘못입력! ");
            }

        }
    }
}
