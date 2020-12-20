package day12_20;

public class SamKwangVO {
    private int 인사번호;
    private String 주민등록번호;
    private String 성명;
    private String 소속부서;
    private String 직책;
    private String 인사일;

    public SamKwangVO() {
    }

    public SamKwangVO(int 인사번호, String 주민등록번호, String 성명, String 소속부서, String 직책, String 인사일) {
        this.인사번호 = 인사번호;
        this.주민등록번호 = 주민등록번호;
        this.성명 = 성명;
        this.소속부서 = 소속부서;
        this.직책 = 직책;
        this.인사일 = 인사일;
    }

    public SamKwangVO(int 인사번호, String 성명, String 소속부서, String 직책) {
        this.인사번호 = 인사번호;
        this.성명 = 성명;
        this.소속부서 = 소속부서;
        this.직책 = 직책;
    }

    public int get인사번호() {
        return 인사번호;
    }

    public void set인사번호(int 인사번호) {
        this.인사번호 = 인사번호;
    }

    public String get주민등록번호() {
        return 주민등록번호;
    }

    public void set주민등록번호(String 주민등록번호) {
        this.주민등록번호 = 주민등록번호;
    }

    public String get성명() {
        return 성명;
    }

    public void set성명(String 성명) {
        this.성명 = 성명;
    }

    public String get소속부서() {
        return 소속부서;
    }

    public void set소속부서(String 소속부서) {
        this.소속부서 = 소속부서;
    }

    public String get직책() {
        return 직책;
    }

    public void set직책(String 직책) {
        this.직책 = 직책;
    }

    public String get인사일() {
        return 인사일;
    }

    public void set인사일(String 인사일) {
        this.인사일 = 인사일;
    }
}
