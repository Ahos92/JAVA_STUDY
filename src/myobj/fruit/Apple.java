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
	

	public Apple eat() { // throws로 try-catch넘겨버리면 메인에서 사용 할때 처리해야함

		try {
			if(calorie <= 0) {
				throw new NoMoreCalorieException();
			}
		} catch(NoMoreCalorieException e){
			System.out.println(e.getMessage());
			return this;
		}
		
		System.out.println("맛있게 잘 먹었습니다.");
		calorie -= 100;
		return this;
	}
	
	public static void main(String[] args) {
		
		// 자기자신을 리턴 받게되면 계속 씀
		//  ex> "abcd".toUpperCAse().toLowerCase().toUpperCAse().toLowerCase()...... 
		new Apple("red").eat().eat().eat().eat().eat().eat().eat();
		
		
	}
}
