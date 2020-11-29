package day11_29;

import java.io.*;

public class FileReaderWriter {
    public static void main(String[] args) throws IOException {
        // 입력(Write)할 기본 정보 입력
        String name = "아이린";
        int height = 169;
        int weight = 55;

        // 파일 저장위치를 fpath 변수명으로 선언
        String fpath = "c:/Java/Info.dat";

        // FileWriter를 new 생성자로 'fw' 참조변수 생성
        FileWriter fw = new FileWriter(fpath);

        // 위에 입력할 기본 정보들을 파일에 입력(쓰기)을 write(메서드를) 이용하여 입력
        fw.write(name+"\n");
        fw.write(height+"\n");
        fw.write(weight+"\n");

        // 작업이 끝나면 FileWriter 종료 해줘야함 FIFO (First in Fist out)
        fw.close();


        // 파일에 저장된 데이터를 읽기


        // ch 인트형 변수를 선언해서 각 해당하는 문자들이 어떤 숫자로 구성이 되어있는지 확인하기 위함
        int ch = 0;

        // FileReader를 new 생성자로 'fr' 참조변수 생성
        FileReader fr = new FileReader(fpath);


        // while 반복문을 통해 파일안의 데이터를 전부 출려해보는 코드
        while((ch = fr.read()) !=-1) {
            System.out.println(ch + "/" + (char)ch);
        }

        fr.close();



        // 파일에 저장된 데이터를 읽는데 한줄씩 읽기 + BufferedReader를 이용해서 더 빠른 속도로 입력처리하는 코드
        fr = new FileReader ( fpath );
        BufferedReader br = new BufferedReader(fr);


        while(br.ready()){
            System.out.println(br.readLine());
        }

        // Buffered 메서드를 사용시는 LIFO ( Last int First out)
        br.close();
        fr.close();



    }
}
