package jdbc.quiz;

import java.util.Random;

public class Car {

	private static final String HANGUL = "�����ٶ󸶹ٻ���ڰųʴ����ӹ�����뵵�θ��������η繫��������ȣ";

	static Random ran = new Random();
	
	public String createCarNum() {	

		int front_num = ran.nextInt(99)+1;
		char mid_num = HANGUL.charAt(ran.nextInt(HANGUL.length()));
		int behind_num = ran.nextInt(9900)+100;

		return String.format("%02d%c%04d", front_num, mid_num, behind_num);

	}
	
	public String randomColor() {
		String[] color = {"black", "white", "red", "blue", "yellow"};
		return color[ran.nextInt(color.length)];
	}

	public String carSize(int cc) {
		String size = "";
		if (cc < 1000) {
			size = "light";
		} else if(cc < 1600) {
			size = "small";
		} else if(cc < 2000) {
			size = "mid";
		} else {
			size = "large";
		}
		return size;
	}

	public String carEngine() {
		String[] engine = {"gasoline", "disel", "lpg"};
		return engine[ran.nextInt(engine.length)];
	}

	public int carType(String carNum) {
		int frontNum = Integer.parseInt(carNum.substring(0, 2));
		//		 10 = 01_69 �¿���,  20 = 70~79 ������ ,  30 = 80~97 ȭ����, 40 = 98-99 Ư������
		if (frontNum <= 69) {
			return 10;
			
		} else if (frontNum <= 79) {
			return 20;
			
		} else if (frontNum <= 97) {
			return 30;
			
		} else {
			return 40;
		}

	}

	public int carUsage(String carNum) {
		char hanNum = carNum.charAt(2);
		//		100 = ��~��,��~��,��~��,��~�� �Ϲ��ڰ��� /  200 = �� �� �� �� ������ / 300 = ����ȣ ����ī
		if (hanNum == '��' 
				|| hanNum == '��' 
				|| hanNum == 'ȣ') {
			return 300;
			
		} else if (hanNum == '��' 
				|| hanNum == '��' 
				|| hanNum == '��'
				|| hanNum == '��'){
			return 200;
			
		} else {
			return 100;
		}


	}
}
