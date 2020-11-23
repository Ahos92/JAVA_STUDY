package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ConnectPractice {

	// ����ڷ� ���� �μ���ȣ�� �Է¹�����
	// �ش� �μ��� ��� ������� ������ ��ȸ �ؼ� �ֿܼ� ����غ�����

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		try {
			// ����̹�
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("����̹��� ���������� �ε��Ͽ����ϴ�.");
			
			// db����
			Connection con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521/xepdb1",
					"hr",
					"hr"
					);
			// ������
			PreparedStatement pstmt =
					con.prepareStatement("select * from employees where department_id = ?");
		
				System.out.print("�μ���ȣ�� �Է� �ϼ��� >>");
				pstmt.setInt(1, sc.nextInt());
			
			// ����
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
