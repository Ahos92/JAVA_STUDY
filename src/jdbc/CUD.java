package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CUD {

	
	// # CRUD
	//	- 모든 프로그램의 보편적 가치
	//  C : CREATE (INSERT)
	//  R : READ (SELECT)
	//	U : UPDATE (UPDATE)
	//	D : DELETE (DELETE)
	
	// JDBC에서 SELECT를 하면 ResultSet이 반환
	// 그 외 INSERT, UPDATE, DELETE는 적용된 행이 반환된다.
	
	public static void main(String[] args) {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521/xepdb1",
					"hr",
					"hr"
					);
			
			String sql = "INSERT INTO coffees VALUES (empp_seq.nextval, ?, ?)";
			
			PreparedStatement pstmt = 
					con.prepareStatement(sql);
			
			pstmt.setString(1, "카페라떼");
			pstmt.setInt(2, 3200);
			
					// pstmt.executeUpdate()
					// DML ( INSERT, UPDATE, DELETE ) 또는 반횐되는 값이 없는 DDL같은 쿼리문 
					// 변화된 행의 갯수가 리턴
			int row = pstmt.executeUpdate();
			
			System.out.printf("%d 행이 변경되었습니다.\n", row);
			
			if (pstmt != null) pstmt.close();
			if (con != null) con.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}  catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}
