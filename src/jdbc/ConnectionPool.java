package jdbc;

import java.sql.*;
import java.util.*;

public class ConnectionPool {
	
	// 커넥션풀 라이브러리 존재 
	//  개념을 보는 코드
	
	// 보안을 위해 파일에서 읽어오는 것도 좋은 방법.
	final static String URL = "jdbc:oracle:thin:@localhost:1521/xepdb1";
	final static String ID = "hr";
	final static String PASSWORD = "hr";
	
	// 드라이버 로드는 한번만 하면됨 => static으로 처리
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	// 리스트에 커넥션을 미리 생성해두고, 사용중이지 않은 커넥션을 꺼내주기
	List<JdbcConnection> pool;
	
	public ConnectionPool(int size) {
		pool = new ArrayList<>(size);
		
		for (int i = 0; i < size; i++) {
			pool.add(new JdbcConnection());
		}	
	}
	
	public JdbcConnection getConnection() {
		for (JdbcConnection jconn : pool) {
			if (!jconn.using) {
				jconn.using = true;
				return jconn;
			}
		}
		
		System.out.println("전부 사용중입니다.");
		return null;
	}
	
	// 리스트에 boolean을 가지고 같이 이동하기위한 클래스 , 생성자
	class JdbcConnection {
		Connection conn;
		boolean using;
		
		public JdbcConnection() {
			
			try {
				conn = DriverManager.getConnection(URL, ID, PASSWORD);
				using = false;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		public void close() {
			using = false;
		}
	}
	
	public static void main(String[] args) {
		ConnectionPool src = new ConnectionPool(3);
		
		JdbcConnection conn1 = src.getConnection();
		System.out.println("conn1의 주소 : " + conn1);
		
		JdbcConnection conn2 = src.getConnection();
		System.out.println("conn2의 주소 : " + conn2);
		
		JdbcConnection conn3 = src.getConnection();
		System.out.println("conn3의 주소 : " + conn3);
		
		// close를 하면 Connection을 끊는 대신 사용중이지 않은 상태로 변경한
		conn1.close();
		
		JdbcConnection conn4 = src.getConnection();
		System.out.println("conn4의 주소 : " + conn4);
	}
}
