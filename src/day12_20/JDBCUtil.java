package day12_20;

import java.sql.*;

public class JDBCUtil {
    public static Connection  makeConn(){
        String DRV="org.mariadb.jdbc.Driver";  // 디비연결을 위한 드라이버
        String  URL="jdbc:mariadb://mariadb.cw2h1nljbpsk.ap-northeast-2.rds.amazonaws.com:3306/playground"; // aws호스트주소
        String USR="playground";
        String PWD="playground2020";

        Connection conn = null;

        try {
            Class.forName(DRV);  // 드라이버 로드
            conn = DriverManager.getConnection(URL,USR,PWD); // 드라이버 연결
        } catch (ClassNotFoundException e) {
            System.out.println("드라이버에 문제있어 ?");
            e.printStackTrace();
        } catch (SQLException throwables) {
            System.out.println("로그인 실패");
            throwables.printStackTrace();
        }

        return conn;
    }
    // 파괴 메서드
    public static void destroyConn(Connection conn, PreparedStatement pstmt, ResultSet rs) {
        if(conn !=null){
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (pstmt !=null){
            try {
                pstmt.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if(rs !=null){
            try {
                rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    public static void destoryConn(Connection conn, PreparedStatement pstmt){
        if(conn !=null){
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (pstmt !=null){
            try {
                pstmt.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
