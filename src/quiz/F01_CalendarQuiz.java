package quiz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.zaxxer.hikari.HikariDataSource;

public class F01_CalendarQuiz {

	// DB�� ����Ǿ� �ִ� ���������� ��ȸ�ؼ� 
	// ���� 5������ �����غ����� 

	// ������ ���� ������ ������
	// ���� ������ ������ ������ ��� ������ ����غ�����

	public static void main(String[] args) {

		SimpleDateFormat sp = new SimpleDateFormat("yyyy�� MM�� dd�� EE����");
		Calendar now = Calendar.getInstance();

		HikariDataSource ds = new HikariDataSource();
		ds.setJdbcUrl("jdbc:oracle:thin:@localhost:1521/xepdb1");
		ds.setUsername("hr");
		ds.setPassword("hr");

		try {
			Connection conn = ds.getConnection();


			PreparedStatement pstmt =
					conn.prepareStatement("SELECT car_number FROM cars");

			// select car_number, '����' from cars where regexp_like(car_number, ?);
			// ���� ǥ�������� ���� ���Ѱɸ� ������ ���
			// pstmt.setString (1, getTodasRegExp());
			
			ResultSet rs = pstmt.executeQuery();


			int no_access = 0, ch = 0; 
			String car = null;
			int day = now.get(Calendar.DAY_OF_WEEK) - 1;

			System.out.println(sp.format(now.getTime()));
			System.out.println("��ȣ��\t / �������ѿ���");
			System.out.println("-----------------------");
			while (rs.next()) {
				car = rs.getString("car_number");
				ch = Integer.parseInt(car.substring(car.length()-1));

				if (day > 5) {
					System.out.println("�ָ��� ���� ����");
				} else {

					if ( ch == day || ch == ((day+5) % 10) ) {
						System.out.println(car + " / ���� ����");
						no_access++;
					} 
				}
			}
			System.out.printf("���� ���� ������ �� : %d\n", no_access);
			
			if (rs != null) rs.close();
			if (pstmt != null) pstmt.close();
			if (conn != null) conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static String getTodaysRegExp() {
		Calendar c = Calendar.getInstance();
		
		switch (c.get(Calendar.DAY_OF_WEEK)) {
		case Calendar.MONDAY:
			return ".*1$|6$";
		case Calendar.TUESDAY:
			return ".*2$|7$";
		case Calendar.WEDNESDAY:
			return ".*3$|8$";
		case Calendar.THURSDAY:
			return ".*4$|9$";
		case Calendar.FRIDAY:
			return ".*5$|0$";
		default:
			return ".*";
		}
	}
}
