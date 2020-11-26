package quiz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.zaxxer.hikari.HikariDataSource;

public class F01_CalendarQuiz {

	// DB에 저장되어 있는 차량정보를 조회해서 
	// 차량 5부제를 적용해보세요 

	// 오늘은 출입 제한인 차량수
	// 출입 제한을 위반한 차량의 모든 정보를 출력해보세요

	public static void main(String[] args) {

		SimpleDateFormat sp = new SimpleDateFormat("yyyy년 MM월 dd일 EE요일");
		Calendar now = Calendar.getInstance();

		HikariDataSource ds = new HikariDataSource();
		ds.setJdbcUrl("jdbc:oracle:thin:@localhost:1521/xepdb1");
		ds.setUsername("hr");
		ds.setPassword("hr");

		try {
			Connection conn = ds.getConnection();


			PreparedStatement pstmt =
					conn.prepareStatement("SELECT car_number FROM cars");

			// select car_number, '제한' from cars where regexp_like(car_number, ?);
			// 정규 표현식으로 출입 제한걸린 차량만 출력
			// pstmt.setString (1, getTodasRegExp());
			
			ResultSet rs = pstmt.executeQuery();


			int no_access = 0, ch = 0; 
			String car = null;
			int day = now.get(Calendar.DAY_OF_WEEK) - 1;

			System.out.println(sp.format(now.getTime()));
			System.out.println("번호판\t / 출입제한여부");
			System.out.println("-----------------------");
			while (rs.next()) {
				car = rs.getString("car_number");
				ch = Integer.parseInt(car.substring(car.length()-1));

				if (day > 5) {
					System.out.println("주말엔 제한 없음");
				} else {

					if ( ch == day || ch == ((day+5) % 10) ) {
						System.out.println(car + " / 출입 위반");
						no_access++;
					} 
				}
			}
			System.out.printf("출입 위반 차량의 수 : %d\n", no_access);
			
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
