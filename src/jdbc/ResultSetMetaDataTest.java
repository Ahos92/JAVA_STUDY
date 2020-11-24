package jdbc;

import java.sql.*;

public class ResultSetMetaDataTest {

	public static void main(String[] args) {
		
		try {
	
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521/xepdb1",
					"hr",
					"hr"
					);

			String sql = "SELECT * FROM employees INNER JOIN departments"
					+ " USING(department_id)";
			PreparedStatement pstmt = 
					con.prepareStatement(sql);
			
			ResultSet rs = pstmt.executeQuery();
			
			// 쿼리문으로 가져온 ResultSet에 대한 정보 목록 객체
			ResultSetMetaData rsmd = rs.getMetaData();
			
			System.out.println("컬럼 개수 : " + rsmd.getColumnCount());
			
			for (int i = 1; i <= rsmd.getColumnCount(); i++) {
				
				System.out.println(i + "번째 컬럼 정보 : ");
				System.out.println("\t컬럼 이름 : " + rsmd.getColumnName(i));
				System.out.println("\t컬럼 타입 : " + rsmd.getColumnTypeName(i));
				// java.sql.Types
			}
			
			if (rs != null) rs.close();
			if (pstmt != null) pstmt.close();
			if (con != null) con.close();
			
		} catch (ClassNotFoundException e) {
			System.out.println("[ojdbc] 클래스 경로가 틀렸습니다.");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	
	}
}
