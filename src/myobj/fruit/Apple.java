package myobj.fruit;

public class Apple {

	int calorie;
	String color;
	
	public Apple(String color) {
		calorie = 300;
		
		if (!color.equals("red")) {
			throw new InvalidColorException();
		}
		
	}
	

	public Apple eat() { // throws�� try-catch�Ѱܹ����� ���ο��� ��� �Ҷ� ó���ؾ���

		try {
			if(calorie <= 0) {
				throw new NoMoreCalorieException();
			}
		} catch(NoMoreCalorieException e){
			System.out.println(e.getMessage());
			return this;
		}
		
		System.out.println("���ְ� �� �Ծ����ϴ�.");
		calorie -= 100;
		return this;
	}
	
	public static void main(String[] args) {
		
		// �ڱ��ڽ��� ���� �ްԵǸ� ��� ��
		//  ex> "abcd".toUpperCAse().toLowerCase().toUpperCAse().toLowerCase()...... 
		new Apple("red").eat().eat().eat().eat().eat().eat().eat();
		
		
	}
}
