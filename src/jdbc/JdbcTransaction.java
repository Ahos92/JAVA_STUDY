package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcTransaction {

	public static void main(String[] args) {

		DBConnect db = new DBConnect();

		Connection con = db.connecting();

		try {
			// �ڵ� Ŀ���� �⺻������ Ȱ��ȭ �Ǿ� �����Ƿ�
			// Ʈ����� ��� ���ؼ� Ŀ�� ��Ȱ��ȭ
			con.setAutoCommit(false);
			
			String sql1 = "UPDATE coffees SET cprice = cprice + 500 WHERE cfid <= 150";
			
			PreparedStatement pstmt1 = con.prepareStatement(sql1);

			int row = pstmt1.executeUpdate();
			
			System.out.println(row + "���� ���߽��ϴ�.");
			
			String sql2 = "SELECT AVG(cprice) FROM coffees";
			PreparedStatement pstmt2 = con.prepareStatement(sql2);
			
			ResultSet rs = pstmt2.executeQuery();
			
			double avg_price = 0 ;
			if (rs.next()) {
				avg_price = rs.getDouble(1);
			}
			
			// savepoint ������ ����
			
			System.out.println("��� Ŀ�ǰ��� " + avg_price + " �Դϴ�.");
			
			if (avg_price < 2000) {
				System.out.println("Ŀ�ǰ��� �÷Ƚ��ϴ�.");
				con.commit(); // DML�� ����� Ȯ�� ���´�.
			} else {
				System.out.println("Ŀ�ǰ� �λ��� ����߽��ϴ�.");
				con.rollback(); // DML�� ����� �ǵ�����.
			}
			
			if (pstmt1 != null) pstmt1.close();
			if (con != null) con.close();
			
			System.out.println("���� ��");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
