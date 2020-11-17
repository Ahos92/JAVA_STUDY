package myobj.fruit;

public class Test {

	public static void main(String[] args) {
		Kiwi kiwi01 = new Kiwi();
		Kiwi kiwi02 = new Kiwi(20, "green", 100); 
		
		
		kiwi01.size = 10;
		kiwi01.color = "gold";
		kiwi01.sweet = 80;
		
		System.out.println(kiwi01);
		System.out.println(kiwi02);
		
		kiwi01.eat();

		kiwi02.eat();
		
		
	}
}
