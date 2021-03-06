package jdbc;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;


import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class HikariCpTest3 {

	public static void main(String[] args) {
		
		// 설정파일 안에서만들기
		// 저장된 값을 이용하는 방법
		// Map, 딕셔너리, 속성, Property, Entry, JSON..
		// data를 Key = Value형태로 다루는 것들
		Properties props = new Properties();
		props.setProperty("dataSourceClassName", "oracle.jdbc.pool.OracleDataSource");
		props.setProperty("dataSource.url", "jdbc:oracle:thin:@localhost:1521/xepdb1");
		props.setProperty("dataSource.user", "hr");
		props.setProperty("dataSource.password", "hr");
		props.setProperty("dataSource.databaseName", "xepdb1");
		
		props.put("dataSource.logWriter", new PrintWriter(System.out));
		HikariConfig config = new HikariConfig(props);
		
		HikariDataSource ds = new HikariDataSource(config);
		
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
			
			// ConnectionPool을 사용할 때는 conn을 닫는 대신
			// 해당 라이브러리의 close()를 해야함
			ds.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
