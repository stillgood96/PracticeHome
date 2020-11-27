package day11_27;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class SungJukService extends SungJukGeneric {
    List<SungJukVO> sjdata = new ArrayList<>();

    SungJukVO sj = new SungJukVO();
    private String fpath = "c:/Java/SungJuk.dat";
    private FileWriter fw = null;
    private BufferedWriter bw = null;
    private FileReader fr = null;
    private BufferedReader br = null;

    public SungJukService () {
        try {
            loadSungJuk();
        } catch (IOException e) {
            System.out.println("성적불러오기 실패");
            e.printStackTrace();
        }
    }


    public void showDisplay (){
        StringBuilder sb = new StringBuilder();

        sb.append("---------성적관리시스템-------\n")
          .append("1.성적등록\n")
          .append("2.성적불러오기\n")
          .append("3.상세성적 불러오기\n")
          .append("0.프로그램 종료\n")
          .append("-----------------------------\n")
          .append("작업코드 입력 :");
        System.out.println(sb);
    }

    @Override
    public void newSungJuk() {
        String name;
        int kor;
        int eng;
        int math;
        String fmt = "%s %d %d %d";

        Scanner sc = new Scanner(System.in);
        System.out.print("이름 :");
        name = sc.nextLine();
        System.out.print("국어점수 :");
        kor = sc.nextInt();
        System.out.print("영어점수 :");
        eng = sc.nextInt();
        System.out.print("수학점수 :");
        math = sc.nextInt();

        SungJukVO sj = new SungJukVO(name,kor,eng,math,0,0.0,' ');

        computeSungJuk(sj);

        sjdata.add(sj);

        try {
            writeSungJuk(sj);
        } catch (IOException e) {
            System.out.println("파일 쓰기 오류 ! ");
            e.printStackTrace();
        }
    }

    public void computeSungJuk(SungJukVO sj) {
        sj.setSum(sj.getKor()+sj.getEng()+sj.getMath());
        sj.setMean(sj.getSum()/3.0);

        switch ((int)(sj.getMean()/10)) {
                     case 10 : case 9:  sj.setGrd('수'); break;
                     case 8 : sj.setGrd('음'); break;
                     case 7 : sj.setGrd('미'); break;
                     case 6 : sj.setGrd('양'); break;
                     default : sj.setGrd('가');
        }
    }

    public void writeSungJuk (SungJukVO sj) throws IOException {
        String fmt = "%s,%d,%d,%d,%d,%.1f,%c";
        fw = new FileWriter(fpath,true);
        bw = new BufferedWriter(fw);

        String data = String.format(fmt,sj.getName(),sj.getKor(),sj.getEng(),sj.getMath(),sj.getSum(),
                sj.getMean(),sj.getGrd());

        bw.write(data);
        bw.newLine();

        bw.close();
        fw.close();
    }

    @Override
    public void readSungJuk() {
        Iterator<SungJukVO> iter = sjdata.iterator();
        String fmt = "이름 :%s 국어 :%d 영어 :%d 수학 :%d 총점 :%d 평균 :%.1f 학점 :%c\n";
        while ( iter.hasNext()){
            SungJukVO sj = iter.next();
            System.out.printf(fmt,sj.getName(),sj.getKor(),sj.getEng(),sj.getMath(),sj.getSum(),sj.getMean(),
                    sj.getGrd());
        }

    }

    @Override
    public void readOneSungJuk() {
        String fmt = "이름 :%s\n국어 :%d\n영어 :%d\n수학 :%d\n총점 :%d\n평균 :%.1f\n학점 :%c\n";
        Scanner sc = new Scanner(System.in);
        System.out.print("조회하실 학생이름은 ? :");
        String name = sc.nextLine();

        for (SungJukVO sw : sjdata ){
            if (sw.getName().equals(name)) {
                System.out.printf(fmt,sj.getName(),sj.getKor(),sj.getEng(),sj.getMath(),sj.getSum(),sj.getMean(),
                        sj.getGrd());
            }
        }
    }

    public void loadSungJuk () throws IOException {
        fr = new FileReader(fpath);
        br = new BufferedReader(fr);

        while(br.ready()){
            String sjf []= br.readLine().split(",");

            sj = new SungJukVO(sjf[0],Integer.parseInt(sjf[1]),
                    Integer.parseInt(sjf[2]),Integer.parseInt(sjf[3]),Integer.parseInt(sjf[4]),Double.parseDouble(sjf[5]),
                    sjf[6].charAt(0));
            sjdata.add(sj);
        }

        br.close();
        fr.close();

    }
}
