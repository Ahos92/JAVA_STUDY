package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcTransaction {

	public static void main(String[] args) {

		DBConnect db = new DBConnect();

		Connection con = db.connecting();

		try {
			// 자동 커밋이 기본적으로 활성화 되어 있으므로
			// 트랜잭션 제어를 위해서 커밋 비활성화
			con.setAutoCommit(false);
			
			String sql1 = "UPDATE coffees SET cprice = cprice + 500 WHERE cfid <= 150";
			
			PreparedStatement pstmt1 = con.prepareStatement(sql1);

			int row = pstmt1.executeUpdate();
			
			System.out.println(row + "행이 변했습니다.");
			
			String sql2 = "SELECT AVG(cprice) FROM coffees";
			PreparedStatement pstmt2 = con.prepareStatement(sql2);
			
			ResultSet rs = pstmt2.executeQuery();
			
			double avg_price = 0 ;
			if (rs.next()) {
				avg_price = rs.getDouble(1);
			}
			
			// savepoint 구현도 가능
			
			System.out.println("평균 커피값이 " + avg_price + " 입니다.");
			
			if (avg_price < 2000) {
				System.out.println("커피값을 올렸습니다.");
				con.commit(); // DML의 결과를 확정 짓는다.
			} else {
				System.out.println("커피값 인상을 취소했습니다.");
				con.rollback(); // DML의 결과를 되돌린다.
			}
			
			if (pstmt1 != null) pstmt1.close();
			if (con != null) con.close();
			
			System.out.println("실행 끝");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
