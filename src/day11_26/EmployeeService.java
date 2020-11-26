package day11_26;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class EmployeeService extends EPgeneric {
    List<EmployeeVO> epData = new ArrayList<>();

    public void showDisplay (){
        StringBuilder sd = new StringBuilder();
        sd.append("--------인사관리프로그램 내버전--------\n")
          .append("1.인사 정보 입력\n")
          .append("2.인사 정보 조회\n")
          .append("3.인사 정보 상세 조회\n")
          .append("4.인사 정보 수정\n")
          .append("5.인사 정보 삭제\n")
          .append("0.프로그램 종료\n")
          .append("------------------------------------\n")
          .append("원하시는 작업은 ? ");
        System.out.println(sd);
    }

    @Override
    public void newEP() {
        EmployeeVO vo = new EmployeeVO(0,"","","",""," ");
        Scanner sc = new Scanner(System.in);
        System.out.print("사원번호입력 :");
        vo.setEpNum(Integer.parseInt(sc.nextLine()));
        System.out.print("사원 이름 입력 : ");
        vo.setEpName( sc.nextLine() );
        System.out.print("입사일 입력 : ");
        vo.setStartDay( sc.nextLine() );
        System.out.print("직책 입력 : ");
        vo.setJob( sc.nextLine() );
        System.out.print("급여 입력 : ");
        vo.setSalary( sc.nextLine() );
        System.out.print("부서번호 입력 : ");
        vo.setPhone( sc.nextLine() );

        epData.add(vo);
    }

    @Override
    public void readEP() {
        String fmt = "%8s %8s %8s %8s %8s %8s \n";
        String fmt2 = "%9s %9s %11s %9s %11s %9s \n";

        System.out.printf(fmt,"epNum","epName","startDay","job","salary","section"); //헤드
        Iterator<EmployeeVO> itr = epData.iterator();
        while( itr.hasNext() ) {
            EmployeeVO ex = itr.next();
            System.out.printf(fmt,ex.getEpNum(),ex.getEpName(),ex.getStartDay(),ex.getJob(),
                    ex.getSalary(),ex.getPhone());
        }
    }

    @Override
    public void readOneEP() {
        String fmt = "%12s %12s %12s %12s %12s %12s \n";
        EmployeeVO num1 = new EmployeeVO();
        Scanner sc = new Scanner(System.in);
        System.out.print("조회하실 사원번호는 ? :");
        num1.setEpNum(sc.nextInt());
        for(EmployeeVO num2 : epData ){
            if (num2.getEpNum() == num1.getEpNum() ) {
                num1=num2;
            }
        }
        System.out.printf(fmt,"epNum","epName","startDay","job","salary","section");
        System.out.printf(fmt,num1.getEpNum(),num1.getEpName(),num1.getStartDay(),num1.getJob(),num1.getSalary(),
                num1.getPhone());



    }
}
