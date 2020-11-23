package day11_23;

import java.util.Scanner;

/**
 * 파일명: SungjukV6
 * 작성일: 2020.11.23
 * 프로그램 설명: 성적처리프로그램 v6
 * 중간고사와 기말고사 성적처리프로그램을 만들려고 함
 * SungJukV1을 토대로 중간고사 성적과 기말고사 성적 클래스를
 * 상속을 이용해서 작성하세요
 *
 * 중간고사(MidSungJuk) : 국어,영어,수학
 * 기말고사(FinalSungJuk) : 국여,영어,수학,미술,과학
 * 성적처리 : computeSungJuk
 * 결과출력 : printSungJuk
 */

public class SungJukV6Main {
    public static void main(String[] args) {
        /*
        MidSungJuk ms=new MidSungJuk();
        ms.readSungJuk();
        ms.computeSungJuk();
        ms.printSungJuk();
        */
        FinalSungJuk fsw=new FinalSungJuk();
        fsw.readSungJuk();
        fsw.computeSungJuk();
        fsw.printSungJuk();
    }

}


class MidSungJuk{
    protected String name;
    protected int kor;
    protected int eng;
    protected int math;
    protected int sum;
    protected double mean;
    protected char grd;


    public MidSungJuk() {
    }

    public MidSungJuk(String name, int kor, int eng, int math) {
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

    public void readSungJuk(){
        Scanner sc =new Scanner(System.in);
        System.out.printf("이름 :");
        name=sc.nextLine();
        System.out.printf("국어 :");
        kor=sc.nextInt();
        System.out.printf("영어 :");
        eng=sc.nextInt();
        System.out.printf("수학 :");
        math=sc.nextInt();
    }
    public void computeSungJuk(){
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
    public void printSungJuk(){
        String fmt=
                "이름 :%s\n국어:%d\n영어:%d\n수학:%d\n총점:%d\n평균:%.1f\n학점:%c\n";

        String result=String.format(fmt,name,kor,eng,math,sum,mean,grd);

        System.out.println(result);
    }
}

class FinalSungJuk extends  MidSungJuk{
    protected int art;
    protected int sci;

    public FinalSungJuk() {
    }

    public FinalSungJuk(String name, int kor, int eng, int math, int art, int sci) {
        super(name, kor, eng, math);
        this.art = art;
        this.sci = sci;
    }

    public int getArt() {
        return art;
    }

    public void setArt(int art) {
        this.art = art;
    }

    public int getSci() {
        return sci;
    }

    public void setSci(int sci) {
        this.sci = sci;
    }

    @Override
    public void readSungJuk() {
        super.readSungJuk(); //super로 MidSungJuk에있는 기존껄 가져옴
        Scanner sc=new Scanner(System.in);
        System.out.print("미술 :");
        art=sc.nextInt();
        System.out.print("과학 :");
        sci=sc.nextInt();

    }

    @Override
    public void computeSungJuk() {
       //기존 메서드는 3가지과목만 더하는거라 가져와도 쓸모가없음
        //이래서 추상클래스 추상메서드나 인터페이스가 사용됨 어차피 상속받아서 가져와도 쓸모가 없으니까
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
    public void printSungJuk() {
        String fmt=
                "이름 :%s\n국어:%d\n영어:%d\n수학:%d\n미술:%d\n과학:%d\n총점:%d\n평균:%.1f\n학점:%c\n";

        String result=String.format(fmt,name,kor,eng,math,art,sci,sum,mean,grd);

        System.out.println(result);
        //프린트메서드도 마찬가지다
    }
}