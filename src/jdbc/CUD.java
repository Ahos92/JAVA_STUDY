package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CUD {

	
	// # CRUD
	//	- ��� ���α׷��� ������ ��ġ
	//  C : CREATE (INSERT)
	//  R : READ (SELECT)
	//	U : UPDATE (UPDATE)
	//	D : DELETE (DELETE)
	
	// JDBC���� SELECT�� �ϸ� ResultSet�� ��ȯ
	// �� �� INSERT, UPDATE, DELETE�� ����� ���� ��ȯ�ȴ�.
	
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
			
			pstmt.setString(1, "ī���");
			pstmt.setInt(2, 3200);
			
					// pstmt.executeUpdate()
					// DML ( INSERT, UPDATE, DELETE ) �Ǵ� ��Ⱥ�Ǵ� ���� ���� DDL���� ������ 
					// ��ȭ�� ���� ������ ����
			int row = pstmt.executeUpdate();
			
			System.out.printf("%d ���� ����Ǿ����ϴ�.\n", row);
			
			if (pstmt != null) pstmt.close();
			if (con != null) con.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}  catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}
