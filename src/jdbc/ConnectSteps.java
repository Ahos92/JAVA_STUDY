package jdbc;

import java.sql.*;

public class ConnectSteps {

	// # JDBC
	//	- Java Database Connectivity
	//	- DB�� �������� �����Ͽ� �����ϰ� ����� �޾ƿ� �� �ִ� Java API
	//	- Java �κ��� �ҽ��� � DB�� ����ϴ��� �׻� �����ϴ�
	//	- DB�� ������ �ʿ��� jdbc�� ���Ŀ� ���߱� ������ ���α׷��ӵ��� ���ϰ� ����� �� �ִ�.

	// # OJDBC
	//	- Oracle DB�� ��ġ�ϸ� �����Ǵ� JDBC
	//	- sqldeveloper\jdbc\lib ���ִ�

	public static void main(String[] args) {

		// �� � DB�� ����ϴ��� ��ԵǴ� �Ȱ��� ����

		try {
			// 1. Class.forName(driverName)���� �ش� DBȸ���� jdbc����̹��� �ε��Ѵ�.
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("[ojdbc] ���������� �ε�Ǿ����ϴ�.");


			// 2. DriverManager Ŭ������ ���� DB���� ������ ����
			//	- DriverManager.getConnection() �޼��忡 
			//	  	DB���� �ּҿ� ���̵�/�н����带 �����ϸ� ������ ��ȯ�ȴ�.
			Connection con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521/xepdb1",
					"hr",
					"hr"
					);

			System.out.println("������ �����Ͽ����ϴ�.");
			
			// 3. ��ȯ�� ���ῡ ����� �������� ����Ѵ� ( ; �� ������� �ʴ´�)
			PreparedStatement pstmt = 
					con.prepareStatement("select * from employees "
							+ "where department_id in (?, ?, ?, ?) "
							+ "and last_name like ?");
			// 3-1. �غ��� ������ ?�� �ִٸ� setType�� ���� ���� ä���� �Ѵ�.
			pstmt.setInt(1, 10);
			pstmt.setInt(2, 20);
			pstmt.setInt(3, 30);
			pstmt.setInt(4, 50);
			pstmt.setString(5, "%a%");
			
			// 3-2. �غ�� ������ �����Ѵ�. 
			//			������ select���� ��� ����� Set���� �޾ƿ´�
			ResultSet rs = pstmt.executeQuery();
			
			// 4. ��ȯ�� ����� ����Ѵ�
			System.out.println("LAST_NAME\tFIRST_NAME\tSALARY\tDEPARTMENT_ID");
			while (rs.next()) {
				System.out.printf("%-15s\t%-10s\t%-10d\t%-10d\n",
							rs.getString("last_name"),
							rs.getString("first_name"),
							rs.getInt("salary"),
							rs.getInt("department_id"));
			}
			
			// 5. ���ῡ ���� ��� ��ü�� ������� �ݾ��ش�.
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
