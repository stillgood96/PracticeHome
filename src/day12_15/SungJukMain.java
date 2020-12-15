package day12_15;

import java.util.Scanner;

public class SungJukMain {
    public static void main(String[] args) {
        SungJukService sjsrv = new SungJukService();
        Scanner sc = new Scanner(System.in);

        while(true){
            sjsrv.display();

            int button = Integer.parseInt(sc.nextLine());
            switch (button){
                case 1 : sjsrv.newSungJuk(); break;
                case 2 : sjsrv.readSungJuk(); break;
                case 3 : sjsrv.readOneSungJuk(); break;
                case 4 : sjsrv.modifySungJuk(); break;
                case 5 : sjsrv.removeSungJuk(); break;
                case 0 : System.exit(0); break;
                default :
                    System.out.println("잘못입력 다시입력~"); break;

            }
        }
    }
}
