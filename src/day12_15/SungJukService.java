package day12_15;

import java.sql.*;
import java.util.Scanner;

public class SungJukService extends SungJukGenericService{
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    void display(){
        StringBuilder dp = new StringBuilder();
        dp = dp.append("--------성적프로그램--------\n")
                .append("1. 성적입력\n")
                .append("2. 성적조회\n")
                .append("3. 특정인원 조회\n")
                .append("4. 성적 수정\n")
                .append("5. 성적 삭제\n")
                .append("5. 성적 종료\n")
                .append("0 입력시 프로그램 종료\n");
        System.out.println(dp);
    }

    @Override
    public void newSungJuk() {
        Scanner sc = new Scanner(System.in);
        System.out.print("이름 입력 :");
        String name = sc.nextLine();
        System.out.print("국어 점수 입력 :");
        int kor = Integer.parseInt(sc.nextLine());
        System.out.print("영어 점수 입력 :");
        int eng = Integer.parseInt(sc.nextLine());
        System.out.print("수학 점수 입력 :");
        int math = Integer.parseInt(sc.nextLine());

        SungJukVO vo = new SungJukVO(name,kor,eng,math,0,0.0,' ');
        computeSungJuk(vo);

        String sql = "insert into SungJuk Values (?,?,?,?,?,?,?)";
        Connection conn = null;
        PreparedStatement pstmt = null;
        conn = makeConn();

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,vo.getName());
            pstmt.setInt(2,vo.getKor());
            pstmt.setInt(3,vo.getEng());
            pstmt.setInt(4,vo.getMath());
            pstmt.setInt(5,vo.getSum());
            pstmt.setString(6,String.format("%.2f",vo.getMean()));
            pstmt.setString(7,String.valueOf(vo.getGrade()));
            int cnt = pstmt.executeUpdate();
        } catch (SQLException throwables) {
            System.out.println("SQL 질의문 생성오류");
        }
        destroyConn(conn,pstmt);


    }
    void computeSungJuk(SungJukVO sj){
        // 총점구하기
        sj.setSum(sj.getKor()+sj.getEng()+sj.getMath());
        // 평균구하기
        sj.setMean((double)sj.getSum() / 3);

        // 수우미양가 구하기
        switch ((int)sj.getMean()/10){
            case 10: case 9:
                sj.setGrade('수');
                break;
            case 8:
                sj.setGrade('우');
                break;
            case 7:
                sj.setGrade('우');
                break;
            case 6:
                sj.setGrade('우');
                break;
            default:
                sj.setGrade('가');
                break;
        }
    }
    public static  Connection makeConn(){
        String DRV = "org.mariadb.jdbc.Driver";
        String URL = "jdbc:mariadb://mariadb.cw2h1nljbpsk.ap-northeast-2.rds.amazonaws.com:3306/playground";
        String USR = "playground";
        String PWD = "playground2020";
        Connection conn = null;

        try {
            Class.forName(DRV);
            conn= DriverManager.getConnection(URL,USR,PWD);
        } catch (ClassNotFoundException e) {
            System.out.println("드라이버 연결실패");
        } catch (SQLException throwables) {
            System.out.println("DB접속 실패");
        }
        return conn;
    }



    public static void destroyConn(Connection conn, PreparedStatement pstmt, ResultSet rs){
        if (conn !=null)
            try { conn.close(); } catch (SQLException throwables) { }
        if (pstmt != null)
            try { pstmt.close();} catch (SQLException throwables){}
        if ( rs != null)
            try { rs.close();} catch (SQLException throwables){}
    }
    public static void destroyConn(Connection conn, PreparedStatement pstmt){
        if (conn !=null)
            try { conn.close(); } catch (SQLException throwables) { }
        if (pstmt != null)
            try { pstmt.close();} catch (SQLException throwables){}

    }



}
