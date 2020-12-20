package day12_20;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class SamKwangService {

    // 메뉴화면
    public void displaymenu() {
        StringBuilder sb = new StringBuilder();

        sb.append("-----삼광관리프로그램V1-----\n")
        .append("1.인사관리 실행\n")
        .append("2.미정\n")
        .append("3.미정\n")
        .append("0.프로그램종료\n")
                .append("입력 : ");
        System.out.println(sb);
    }
    // 인사관리 화면
    public void employeeMenu() {
        StringBuilder sb = new StringBuilder();
        sb.append("1. 인사정보 추가\n")
                .append("2.인사정보 조회\n")
                .append("3.인사정보 상세조회\n")
                .append("종료시 아무키 (1/2/3/ 제외)\n")
                .append("입력 :");

        System.out.println(sb);
    }

    public void newEmployee() {
        SamKwangVO vo = new SamKwangVO();
        Scanner sc = new Scanner(System.in);
        System.out.print("인사번호 입력 :");
        vo.set인사번호(Integer.parseInt(sc.nextLine()));
        System.out.print("주민등록번호 입력 :");
        vo.set주민등록번호(sc.nextLine());
        System.out.print("성명 입력 :");
        vo.set성명(sc.nextLine());
        System.out.print("소속부서 입력 :");
        vo.set소속부서(sc.nextLine());
        System.out.print("직책 입력 :");
        vo.set직책(sc.nextLine());
        System.out.print("입사일 입력 :");
        vo.set인사일(sc.nextLine());

        String result = SamKwangDAO.insertEMP(vo);

        System.out.println(result);
    }

    public void readEmployee() {
        ArrayList<SamKwangVO> emps = new ArrayList<>();

       emps = SamKwangDAO.readEmp();
       String fmt = "인사번호 :%s 성명 :%s 소속부서 :%s 직책 :%s\n";
       StringBuilder sb = new StringBuilder();
       for(SamKwangVO emp : emps){
           String result = String.format(fmt,emp.get인사번호(),emp.get성명(),emp.get소속부서(),emp.get직책());
           sb.append(result);
       }
        System.out.println(sb.toString());

    }

    public void readOneEmployee() {
    }
}
