package jdbc;

import java.sql.*;

public class ConnectSteps {

	// # JDBC
	//	- Java Database Connectivity
	//	- DB에 쿼리문을 전달하여 실행하고 결과를 받아올 수 있는 Java API
	//	- Java 부분의 소스는 어떤 DB를 사용하더라도 항상 일정하다
	//	- DB를 제작하 쪽에서 jdbc의 형식에 맞추기 때문에 프로그래머들은 편리하게 사용할 수 있다.

	// # OJDBC
	//	- Oracle DB를 설치하면 제공되는 JDBC
	//	- sqldeveloper\jdbc\lib 에있다

	public static void main(String[] args) {

		// ※ 어떤 DB를 사용하더라도 밟게되는 똑같은 절차

		try {
			// 1. Class.forName(driverName)으로 해당 DB회사의 jdbc드라이버를 로드한다.
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("[ojdbc] 성공적으로 로드되었습니다.");


			// 2. DriverManager 클래스를 통해 DB와의 연결을 수립
			//	- DriverManager.getConnection() 메서드에 
			//	  	DB접속 주소와 아이디/패스워드를 전달하면 연결이 반환된다.
			Connection con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521/xepdb1",
					"hr",
					"hr"
					);

			System.out.println("연결이 성공하였습니다.");
			
			// 3. 반환된 연결에 사용할 쿼리문을 등록한다 ( ; 을 사용하지 않는다)
			PreparedStatement pstmt = 
					con.prepareStatement("select * from employees "
							+ "where department_id in (?, ?, ?, ?) "
							+ "and last_name like ?");
			// 3-1. 준비할 구문에 ?가 있다면 setType을 통해 값을 채워야 한다.
			pstmt.setInt(1, 10);
			pstmt.setInt(2, 20);
			pstmt.setInt(3, 30);
			pstmt.setInt(4, 50);
			pstmt.setString(5, "%a%");
			
			// 3-2. 준비된 구문을 실행한다. 
			//			쿼리가 select문인 경우 결과를 Set으로 받아온다
			ResultSet rs = pstmt.executeQuery();
			
			// 4. 반환된 결과를 사용한다
			System.out.println("LAST_NAME\tFIRST_NAME\tSALARY\tDEPARTMENT_ID");
			while (rs.next()) {
				System.out.printf("%-15s\t%-10s\t%-10d\t%-10d\n",
							rs.getString("last_name"),
							rs.getString("first_name"),
							rs.getInt("salary"),
							rs.getInt("department_id"));
			}
			
			// 5. 연결에 사용된 모든 객체를 순서대로 닫아준다.
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
