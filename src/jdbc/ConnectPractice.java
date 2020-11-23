package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ConnectPractice {

	// 사용자로 부터 부서번호를 입력받으면
	// 해당 부서의 모든 사원들의 정보를 조회 해서 콘솔에 출력해보세요

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		try {
			// 드라이버
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버를 성공적으로 로드하였습니다.");
			
			// db연결
			Connection con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521/xepdb1",
					"hr",
					"hr"
					);
			// 쿼리문
			PreparedStatement pstmt =
					con.prepareStatement("select * from employees where department_id = ?");
		
				System.out.print("부서번호를 입력 하세요 >>");
				pstmt.setInt(1, sc.nextInt());
			
			// 실행
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				System.out.printf("%-4d%-15s%-15s%-15s%-20s%-15s%-15s%-10d%-10d%-10d%-10d\n",
					
								rs.getInt("employee_id"),
								rs.getString("first_name"),
								rs.getString("last_name"),
								rs.getString("email"),
								rs.getString("phone_number"),
								rs.getDate("hire_date"),
								rs.getString("job_id"),
								rs.getInt("salary"),
								rs.getInt("commission_pct"),
								rs.getInt("manager_id"),
								rs.getInt("department_id")
				);
				
			}
			
			// close
			if (rs != null) rs.close();
			if (pstmt != null) pstmt.close();
			if (con != null) con.close();
			
		} catch (ClassNotFoundException e) {
			System.err.println(e.getMessage());
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		} 
	}
}
