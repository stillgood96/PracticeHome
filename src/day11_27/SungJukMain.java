package day11_27;

import java.util.Scanner;

public class SungJukMain {
    public static void main(String[] args) {
        SungJukService srv = new SungJukService();
        Scanner sc = new Scanner(System.in);
        String menu ="";
        while(true){
            srv.showDisplay();
            menu = sc.nextLine();
            switch(menu) {
                case "1" : srv.newSungJuk(); break;
                case "2" : srv.readSungJuk(); break;
                case "3" : srv.readOneSungJuk(); break;
                case "0" : System.exit(0); break;
                default :
                    System.out.println("작업코드 잘못입력 !"); break;
            }
        }



    }
}
