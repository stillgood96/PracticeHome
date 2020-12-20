package day12_20;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SamKwangDAO {
    public static String insertEMP(SamKwangVO vo) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        String result = "데이터 입력중..?!";

        conn = SamKwangJDBC.makeConn();
        try {
            pstmt = conn.prepareStatement(SamKwangJDBC.insertEmployee);
            pstmt.setInt(1,vo.get인사번호());
            pstmt.setString(2,vo.get주민등록번호());
            pstmt.setString(3,vo.get성명());
            pstmt.setString(4,vo.get소속부서());
            pstmt.setString(5,vo.get직책());
            pstmt.setString(6,vo.get인사일());
            int cnt = pstmt.executeUpdate();
            if(cnt >0){
                result = "데이터 추가 완료!";
            }
        } catch (SQLException se) {
            se.printStackTrace();
        }
        SamKwangJDBC.destoryConn(conn,pstmt);

        return result;
    }

    public static ArrayList<SamKwangVO> readEmp() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ArrayList<SamKwangVO> emps = new ArrayList<>();


        conn = SamKwangJDBC.makeConn();
        try {
            pstmt = conn.prepareStatement(SamKwangJDBC.readEMP);
            rs= pstmt.executeQuery();
            while(rs.next()) {
                SamKwangVO emp = new SamKwangVO(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4));
                emps.add(emp);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        SamKwangJDBC.destroyConn(conn,pstmt,rs);

        return emps;
    }
}
