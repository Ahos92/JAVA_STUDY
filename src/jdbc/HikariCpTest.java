package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class HikariCpTest {

	public static void main(String[] args) {
		
		// config객체만들어서 전달
		HikariConfig config = new HikariConfig();
		
		config.setJdbcUrl("jdbc:oracle:thin:@localhost:1521/xepdb1");
		config.setUsername("hr");
		config.setPassword("hr");
		config.addDataSourceProperty("cachePrepStmts", "true");
		config.addDataSourceProperty("prepStmtCacheSize", "250");
		config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
		
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
