package day11_29;

import java.io.*;

public class FileReaderWriter2 {
    public static void main(String[] args) throws IOException {
        int hakbun = 20201129;
        String name = "이성경";
        String addr = "서울 성동구";
        String birth = "1985.3.22";
        String dname = "컴퓨터";
        int prof = 5061;


        String fpath = "c:/Java/Info2.dat";


        String fmt = "%d,%s,%s,%s,%s,%d";
        fmt = String.format(fmt,hakbun,name,addr,birth,dname,prof);

        FileWriter fw = new FileWriter(fpath);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(fmt);

        bw.close();
        fw.close();

        /**
         * 실습)
         * 아래의 내용으로 BufferedWriter 사용해서 파일저장해보기
         *         String sjno = "0205";
         *         String sjname = "프로그래밍";
         *         String sjdesc = "자바 프로그래밍";
         *         int sjprof = 301;
         */

        String sjno = "0205";
        String sjname = "프로그래밍";
        String sjdesc = "자바 프로그래밍";
        int sjprof = 301;
        String fpath2 = "c:/java/info3.dat";
        String fmt2 = "%s,%s,%s,%d";
        fmt2 = String.format(fmt2,sjno,sjname,sjdesc,sjprof);

        fw = new FileWriter(fpath2);
        bw = new BufferedWriter(fw);

        bw.write(fmt2);

        bw.close();
        fw.close();

        /**
         * 과목 기본정보가 저장된 파일을 읽어서
         * 출력하기
         * 과목번호 : ~~
         * 과목이름 : ~~
         */

        FileReader fr = new FileReader(fpath2);
        BufferedReader br = new BufferedReader(fr);

        String fmt3 = "과목번호 :%s\n과목정보 :%s\n과목개요 :%s\n교수번호 :%s\n";

        while(br.ready()){
            String line = br.readLine();
            String [] subject = line.split(",");

            String result= String.format(fmt3,subject[0],subject[1],subject[2],subject[3]);
            System.out.println(result);
        }
        br.close();
        fr.close();

    }
}