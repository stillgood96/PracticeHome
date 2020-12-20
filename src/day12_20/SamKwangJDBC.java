package day12_20;

public class SamKwangJDBC  extends JDBCUtil{
    public static String insertEmployee =
            "insert into 직원 (인사번호, 주민등록번호, 성명, 소속부서, 직책, 입사일) values ( ?,?,?,?,?,?)";

    public static String readEMP=
            "select 인사번호,성명,소속부서,직책 from 직원";
}
