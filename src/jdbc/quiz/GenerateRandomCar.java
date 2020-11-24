package jdbc.quiz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Arrays;
import java.util.Random;

import jdbc.DBConnect;


public class GenerateRandomCar {

	// 랜덤 값을 가진 자동차들이 하나씩 100대 생성되어 DB에 저장되는 프로그램을 만들어보세요

	// 차량 번호판 정보
	// https://post.naver.com/viewer/postView.nhn?volumeNo=24171702&memberNo=35787715
	//	번호를 랜덤 생성한 뒤에 번호에 따라 결정되는 것들 적용		
	// 	차량 객체를 생성한 후 DB에 알맞게 저장

	// 번호판(PK)[숫자2,한글, 숫자4], 색깔, 배기량, 차량 크기, 엔진 종류, 차량 타입, 차량 용도 

	// 앞자리 두숫자 01~99
	//			 10 = 01_69 승용차,  20 = 70~79 승합차 ,  30 = 80~97 화물차, 40 = 98-99 특수차량
	// 100 = 가~마,거~저,고~조,구~주 일반자가용 /  200 = 아 바 사 자 영업용 / 300 = 하허호 렌터카
	// 0100 ~ 9999
	// JAVA코드와 DB스크린샷을 보여주시면 됩니다.
	
	public static void main(String[] args) {
		DBConnect db = new DBConnect();
		Random ran = new Random();
		
		Connection con = db.connecting();
		
		try {
			String sql = "INSERT INTO cars VALUES(?, ?, ?, ?, ?, ?, ?)"; 
			PreparedStatement pstmt = 
					con.prepareStatement(sql);

			// Batch : 일괄처리
			int row = 0;
			int[] rows = null;
			while (row != 100) {
				Car car = new Car();
				
				String car_num = car.createCarNum(); 
				int cc = Math.round((ran.nextInt(19671)+330) / 100 ) * 100;

				pstmt.setString(1, car_num); // 번호판
				pstmt.setString(2, car.randomColor()); // 색
				pstmt.setInt(3, cc); // 배기량
				pstmt.setString(4, car.carSize(cc)); // 크기
				pstmt.setString(5, car.carEngine()); // 엔진
				pstmt.setInt(6, car.carType(car_num)); // 타입
				pstmt.setInt(7, car.carUsage(car_num)); // 용도

				try {
					// 한번에 처리
					pstmt.addBatch();
					
				} catch (SQLIntegrityConstraintViolationException e) {
					row--;
				}
				
				row++;
			}
			rows = pstmt.executeBatch();
			
//			System.out.println("일괄처리 배열 : " + Arrays.toString(rows)); // 일괄처리 된거 확인
			System.out.println(row + "행이 변경 되었습니다.");
			
			if (pstmt != null) pstmt.close();
			if (con != null) con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
