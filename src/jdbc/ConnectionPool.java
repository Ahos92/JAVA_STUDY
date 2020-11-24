package jdbc;

import java.sql.*;
import java.util.*;

public class ConnectionPool {
	
	// Ŀ�ؼ�Ǯ ���̺귯�� ���� 
	//  ������ ���� �ڵ�
	
	// ������ ���� ���Ͽ��� �о���� �͵� ���� ���.
	final static String URL = "jdbc:oracle:thin:@localhost:1521/xepdb1";
	final static String ID = "hr";
	final static String PASSWORD = "hr";
	
	// ����̹� �ε�� �ѹ��� �ϸ�� => static���� ó��
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	// ����Ʈ�� Ŀ�ؼ��� �̸� �����صΰ�, ��������� ���� Ŀ�ؼ��� �����ֱ�
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
		
		System.out.println("���� ������Դϴ�.");
		return null;
	}
	
	// ����Ʈ�� boolean�� ������ ���� �̵��ϱ����� Ŭ���� , ������
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
		System.out.println("conn1�� �ּ� : " + conn1);
		
		JdbcConnection conn2 = src.getConnection();
		System.out.println("conn2�� �ּ� : " + conn2);
		
		JdbcConnection conn3 = src.getConnection();
		System.out.println("conn3�� �ּ� : " + conn3);
		
		// close�� �ϸ� Connection�� ���� ��� ��������� ���� ���·� ������
		conn1.close();
		
		JdbcConnection conn4 = src.getConnection();
		System.out.println("conn4�� �ּ� : " + conn4);
	}
}
