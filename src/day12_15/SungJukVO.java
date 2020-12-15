package day12_15;

public class SungJukVO {
    private String name;
    private int kor;
    private int math;
    private int eng;
    private int sum;
    private double mean;
    private char grade;


    public SungJukVO() {
    }

    public SungJukVO(String name, int kor, int math, int eng, int sum, double mean, char grade) {
        this.name = name;
        this.kor = kor;
        this.math = math;
        this.eng = eng;
        this.sum = sum;
        this.mean = mean;
        this.grade = grade;
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

    public int getMath() {
        return math;
    }

    public void setMath(int math) {
        this.math = math;
    }

    public int getEng() {
        return eng;
    }

    public void setEng(int eng) {
        this.eng = eng;
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

    public char getGrade() {
        return grade;
    }

    public void setGrade(char grade) {
        this.grade = grade;
    }
}
