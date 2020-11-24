package day11_24;

import java.util.Scanner;

/**
 *  LoginMe
 *
 *
 *  로그인 확인 코드
 *  0. 인증용 아이디와 비밀번호를 하나 생성해둠
 *  =>abc123, 987xyz
 *  1. Scanner로 아이디, 비밀번호를 입력받음
 *  2a. 아이디와 비밀번호가 틀리면 "가입되지 않은 아이디!"
 *  2b. 아이디만 맞으면 "비밀번호가 틀렸음!"
 *  2c. 아이디와 비밀번호가 맞으면 "로그인 성공!"
 *
 *
 */
public class LoginMe {
    public static void main(String[] args) {
        /**
         * 수업시간에 흔히 포털에 로그인할때 아이디나 비밀번호가 잘못되었을때
         * 나오는 오류 문구들을 나오게 String클래스에서 알아본 eqauls 메서드를 이용하여
         * 오류문자열들을 출력이 되게 해보았다.
         *
         * 조건문은 if문을 사용하였고
         * 틀렸을때 바로 다시 입력을 받을 수 있도록 while 반복문으로 전체적으로 감싸보았다.
         * 그리고 로그인에 성공했을때 반복문을 탈출할 수 있게 로그인성공 조건에 break;를 추가했다.
         */

        String uid="abc123"; // userID = abc123;
        String ups="987xy"; //  userPassword=987xyz

        String id;         // 입력받을 ID와 PS 변수들
        String ps;


        while(true) {
            Scanner sc = new Scanner(System.in);
            System.out.print("ID를 입력하세요:");
            id = sc.nextLine();
            System.out.print("Password를 입력하세요:");
            ps = sc.nextLine();

            if (id.equals(uid) && ps.equals(ups)) {
                System.out.println("로그인에 성공하셨습니다 !");
                break;
            } else if (id.equals(uid) && !ps.equals(ups)) {
                System.out.println("Password가 틀렸습니다.");
            } else {
                System.out.println("존재하지 않는 ID 입니다.");
            }
        }

    }

}
