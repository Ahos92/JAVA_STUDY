package jdbc.quiz;

import java.util.Random;

public class Car {

	private static final String HANGUL = "가나다라마바사아자거너더러머버저고노도로모보조구누두루무부주하허호";

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
		//		 10 = 01_69 승용차,  20 = 70~79 승합차 ,  30 = 80~97 화물차, 40 = 98-99 특수차량
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
		//		100 = 가~마,거~저,고~조,구~주 일반자가용 /  200 = 아 바 사 자 영업용 / 300 = 하허호 렌터카
		if (hanNum == '하' 
				|| hanNum == '허' 
				|| hanNum == '호') {
			return 300;
			
		} else if (hanNum == '바' 
				|| hanNum == '사' 
				|| hanNum == '아'
				|| hanNum == '자'){
			return 200;
			
		} else {
			return 100;
		}


	}
}
