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
		
		int ch = 0;
		
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
			
			while (true) {
				Scanner sc = new Scanner(System.in);
				System.out.print("부서번호를 입력 하세요 >>");
				ch = sc.nextInt();
				sc.nextLine();
				if ((ch > 0 && ch <= 110)
						&& ch % 10 == 0) {		
					break;
				} else {
					System.out.println("잘못된 부서 번호 입니다.");
				}
			
			}
			
			// 쿼리문
			PreparedStatement pstmt =
					con.prepareStatement("select * from employees where department_id = ?");
		
				pstmt.setInt(1, ch);
			
			// 실행
			ResultSet rs = pstmt.executeQuery();
			System.out.printf("%-8s%-15s%-15s%-15s%-20s%-15s%-15s%-10s%-18s%-15s%-15s\n", 
								"#emp_id",
								"#first_name",
								"#last_name",
								"#email",
								"#phone_number",
								"#hire_date",
								"#job_id",
								"#salary",
								"#commission_pct",
								"#manager_id",
								"#department_id"
								);
			while (rs.next()) {
				
				System.out.printf("%-8d%-15s%-15s%-15s%-20s%-15s%-15s%-10d%-18.2f%-15d%-15d\n",
					
								rs.getInt("employee_id"),
								rs.getString("first_name"),
								rs.getString("last_name"),
								rs.getString("email"),
								rs.getString("phone_number"),
								rs.getDate("hire_date"),
								rs.getString("job_id"),
								rs.getInt("salary"),
								rs.getFloat("commission_pct"),
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
