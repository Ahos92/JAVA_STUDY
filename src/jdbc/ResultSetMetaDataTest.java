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
			
			// ���������� ������ ResultSet�� ���� ���� ��� ��ü
			ResultSetMetaData rsmd = rs.getMetaData();
			
			System.out.println("�÷� ���� : " + rsmd.getColumnCount());
			
			for (int i = 1; i <= rsmd.getColumnCount(); i++) {
				
				System.out.println(i + "��° �÷� ���� : ");
				System.out.println("\t�÷� �̸� : " + rsmd.getColumnName(i));
				System.out.println("\t�÷� Ÿ�� : " + rsmd.getColumnTypeName(i));
				// java.sql.Types
			}
			
			if (rs != null) rs.close();
			if (pstmt != null) pstmt.close();
			if (con != null) con.close();
			
		} catch (ClassNotFoundException e) {
			System.out.println("[ojdbc] Ŭ���� ��ΰ� Ʋ�Ƚ��ϴ�.");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	
	}
}
