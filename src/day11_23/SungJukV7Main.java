package day11_23;

import java.util.Scanner;
/**
 * 파일명: SungjukV7
 * 작성일: 2020.11.23
 * 프로그램 설명: 성적처리프로그램 v7
 * 중간고사와 기말고사 성적처리프로그램을 만들려고 함
 * SungJukV1을 토대로 중간고사 성적과 기말고사 성적 클래스를
 * 인터페이스를 이용해서 작성하세요
 *
 * 부모클래스 : SungJukV7
 * 인터페이스 : IsungJukV7
 * 중간고사(MidSungJuk2) : 국어,영어,수학
 * 기말고사(FinalSungJuk2) : 국여,영어,수학,미술,과학
 * 성적입력 : readSungJuk2
 * 성적처리 : computeSungJuk2
 * 결과출력 : printSungJuk2
 */
public class SungJukV7Main {
    public static void main(String[] args) {
        /*
        MidExam sw=new MidExam();
        sw.readSungJukV7();
        sw.computeSungJukV7();
        sw.printSungJukV7();
         */

        FinalExam fsw=new FinalExam();
        fsw.readSungJukV7();
        fsw.computeSungJukV7();
        fsw.printSungJukV7();

    }
}


abstract class SungJukV7{
    protected String name;
    protected int kor;
    protected int eng;
    protected int math;
    protected int sum;
    protected double mean;
    protected char grd;

    public SungJukV7() {
    }

    public SungJukV7(String name, int kor, int eng, int math) {
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getKor() {
        return kor;
    }

    public void setKor(int kor) {
        this.kor = kor;
    }

    public int getEng() {
        return eng;
    }

    public void setEng(int eng) {
        this.eng = eng;
    }

    public int getMath() {
        return math;
    }

    public void setMath(int math) {
        this.math = math;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public double getMean() {
        return mean;
    }

    public void setMean(double mean) {
        this.mean = mean;
    }

    public char getGrd() {
        return grd;
    }

    public void setGrd(char grd) {
        this.grd = grd;
    }
}

interface IsungJukV7{
    void readSungJukV7();
    void computeSungJukV7();
    void printSungJukV7();

}


class MidExam extends SungJukV7
implements IsungJukV7{


    @Override
    public void readSungJukV7() {
        Scanner sc=new Scanner(System.in);
        System.out.printf("이름 :");
        name=sc.nextLine();
        System.out.printf("국어 :");
        kor=sc.nextInt();
        System.out.printf("영어 :");
        eng=sc.nextInt();
        System.out.printf("수학 :");
        math=sc.nextInt();
    }

    @Override
    public void computeSungJukV7() {
        sum=kor+eng+math;
        mean=(double)sum/3;

        switch((int)(mean/10)){
            case 10: case 9:
                grd='수';break;
            case 8:
                grd='음';break;
            case 7:
                grd='미';break;
            case 6:
                grd='양';break;
            default:
                grd='가';break;

        }
    }

    @Override
    public void printSungJukV7() {
        String fmt=
                "이름 :%s\n국어:%d\n영어:%d\n수학:%d\n총점:%d\n평균:%.1f\n학점:%c\n";

        String result=String.format(fmt,name,kor,eng,math,sum,mean,grd);

        System.out.println(result);
    }
}

class FinalExam extends SungJukV7
implements  IsungJukV7{
    protected int art;
    protected int sci;
    @Override
    public void readSungJukV7() {
        Scanner sc=new Scanner(System.in);
        System.out.printf("이름 :");
        name=sc.nextLine();
        System.out.printf("국어 :");
        kor=sc.nextInt();
        System.out.printf("영어 :");
        eng=sc.nextInt();
        System.out.printf("수학 :");
        math=sc.nextInt();
        System.out.printf("미술 :");
        art=sc.nextInt();
        System.out.printf("과학 :");
        sci=sc.nextInt();


    }

    @Override
    public void computeSungJukV7() {
        sum=kor+eng+math+art+sci;
        mean=(double)sum/5;

        switch((int)(mean/10)){
            case 10: case 9:
                grd='수';break;
            case 8:
                grd='음';break;
            case 7:
                grd='미';break;
            case 6:
                grd='양';break;
            default:
                grd='가';break;

        }
    }

    @Override
    public void printSungJukV7() {
        String fmt=
                "이름 :%s\n국어:%d\n영어:%d\n수학:%d\n미술:%d\n과학:%d\n총점:%d\n평균:%.1f\n학점:%c\n";

        String result=String.format(fmt,name,kor,eng,math,art,sci,sum,mean,grd);

        System.out.println(result);

    }
}
