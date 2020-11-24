package jdbc.quiz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Arrays;
import java.util.Random;

import jdbc.DBConnect;


public class GenerateRandomCar {

	// ���� ���� ���� �ڵ������� �ϳ��� 100�� �����Ǿ� DB�� ����Ǵ� ���α׷��� ��������

	// ���� ��ȣ�� ����
	// https://post.naver.com/viewer/postView.nhn?volumeNo=24171702&memberNo=35787715
	//	��ȣ�� ���� ������ �ڿ� ��ȣ�� ���� �����Ǵ� �͵� ����		
	// 	���� ��ü�� ������ �� DB�� �˸°� ����

	// ��ȣ��(PK)[����2,�ѱ�, ����4], ����, ��ⷮ, ���� ũ��, ���� ����, ���� Ÿ��, ���� �뵵 

	// ���ڸ� �μ��� 01~99
	//			 10 = 01_69 �¿���,  20 = 70~79 ������ ,  30 = 80~97 ȭ����, 40 = 98-99 Ư������
	// 100 = ��~��,��~��,��~��,��~�� �Ϲ��ڰ��� /  200 = �� �� �� �� ������ / 300 = ����ȣ ����ī
	// 0100 ~ 9999
	// JAVA�ڵ�� DB��ũ������ �����ֽø� �˴ϴ�.
	
	public static void main(String[] args) {
		DBConnect db = new DBConnect();
		Random ran = new Random();
		
		Connection con = db.connecting();
		
		try {
			String sql = "INSERT INTO cars VALUES(?, ?, ?, ?, ?, ?, ?)"; 
			PreparedStatement pstmt = 
					con.prepareStatement(sql);

			// Batch : �ϰ�ó��
			int row = 0;
			int[] rows = null;
			while (row != 100) {
				Car car = new Car();
				
				String car_num = car.createCarNum(); 
				int cc = Math.round((ran.nextInt(19671)+330) / 100 ) * 100;

				pstmt.setString(1, car_num); // ��ȣ��
				pstmt.setString(2, car.randomColor()); // ��
				pstmt.setInt(3, cc); // ��ⷮ
				pstmt.setString(4, car.carSize(cc)); // ũ��
				pstmt.setString(5, car.carEngine()); // ����
				pstmt.setInt(6, car.carType(car_num)); // Ÿ��
				pstmt.setInt(7, car.carUsage(car_num)); // �뵵

				try {
					// �ѹ��� ó��
					pstmt.addBatch();
					
				} catch (SQLIntegrityConstraintViolationException e) {
					row--;
				}
				
				row++;
			}
			rows = pstmt.executeBatch();
			
//			System.out.println("�ϰ�ó�� �迭 : " + Arrays.toString(rows)); // �ϰ�ó�� �Ȱ� Ȯ��
			System.out.println(row + "���� ���� �Ǿ����ϴ�.");
			
			if (pstmt != null) pstmt.close();
			if (con != null) con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
