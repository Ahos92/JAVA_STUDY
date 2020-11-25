package jdbc;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;


import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class HikariCpTest4 {

	public static void main(String[] args) {
									// ���ϰ��
		HikariConfig config =  new  HikariConfig("hikari.properties");
		HikariDataSource ds =  new  HikariDataSource(config);
		
		try {
			Connection conn = ds.getConnection();
			
			PreparedStatement pstmt = 
					conn.prepareStatement("select * from employees "
							+ "where department_id in (?, ?, ?, ?) "
							+ "and last_name like ?");
	
			pstmt.setInt(1, 10);
			pstmt.setInt(2, 20);
			pstmt.setInt(3, 30);
			pstmt.setInt(4, 50);
			pstmt.setString(5, "%a%");
			
		
			ResultSet rs = pstmt.executeQuery();
			
	
			System.out.println("LAST_NAME\tFIRST_NAME\tSALARY\tDEPARTMENT_ID");
			while (rs.next()) {
				System.out.printf("%-15s\t%-10s\t%-10d\t%-10d\n",
							rs.getString("last_name"),
							rs.getString("first_name"),
							rs.getInt("salary"),
							rs.getInt("department_id"));
			}
			
			rs.close();
			pstmt.close();
			
			// ConnectionPool�� ����� ���� conn�� �ݴ� ���
			// �ش� ���̺귯���� close()�� �ؾ���
			ds.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}