package day11_26;

import day11_25.ArrayLists;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class SungJukV8service extends SungJukV8generic {
    List<SungJukV8VO> sjData = new ArrayList<>();


    public void showDisplay() {
        StringBuilder sd = new StringBuilder();
        sd.append("--------성적v8 내버전--------\n")
                .append("1.성적 정보 입력\n")
                .append("2.성적 정보 조회\n")
                .append("3.성적 정보 상세 조회\n")
                .append("4.성적 정보 수정\n")
                .append("5.성적 정보 삭제\n")
                .append("0.프로그램 종료\n")
                .append("------------------------------------\n")
                .append("원하시는 작업은 ? ");
        System.out.println(sd);
    }

    @Override
    public void newSungJuk() {
        SungJukV8VO sj = new SungJukV8VO("", 0, 0, 0, 0, 0.0, ' ');
        Scanner sc = new Scanner(System.in);
        System.out.println("이름 입력 :");
        sj.setName(sc.nextLine());
        System.out.println("국어점수 :");
        sj.setKor(sc.nextInt());
        System.out.println("영어점수 :");
        sj.setEng(sc.nextInt());
        System.out.println("수학점수 :");
        sj.setMath(sc.nextInt());

        computeSungJuk(sj);
        sjData.add(sj);

    }

    @Override
    public void printSungJuk() {
        String fmt = "이름: %s 국어: %d 영어: %d 수학: %d 총점: %d 평균: %.1f 등급: %c\n";

        Iterator<SungJukV8VO> iter = sjData.iterator();
        while (iter.hasNext()) {
            SungJukV8VO s = iter.next();
            System.out.printf(fmt, s.getName(), s.getKor(), s.getEng(), s.getMath(), s.getSum(), s.getMean(), s.getGrd());
        }
    }

    @Override
    public void computeSungJuk(SungJukV8VO sj) {
        sj.setSum(sj.getKor() + sj.getEng() + sj.getMath());
        sj.setMean(sj.getSum() / 3.0);
        switch ((int) (sj.getMean() / 10)) {
            case 10:
            case 9:
                sj.setGrd('수');
                break;
            case 8:
                sj.setGrd('음');
                break;
            case 7:
                sj.setGrd('미');
                break;
            case 6:
                sj.setGrd('양');
                break;
            default:
                sj.setGrd('가');
                break;

        }
    }

    @Override
    public void readSungJuk() {
        String fmt = "이름: %s\n국어: %d\n영어: %d\n수학: %d\n총점: %d\n평균: %.1f\n등급: %c\n";
        SungJukV8VO num1 = new SungJukV8VO();
        Scanner sc = new Scanner(System.in);

        System.out.print("성적 조회하려는 이름 입력 :");
        num1.setName(sc.nextLine());


        for (SungJukV8VO num2 : sjData) {
            if (num2.getName().equals(num1.getName())) {
                System.out.printf(fmt, num2.getName(), num2.getKor(), num2.getEng(), num2.getMath(),
                        num2.getSum(), num2.getMean(), num2.getGrd());
                break;
            }
        }

    }
}



