package practice;

public class Car implements Vehicle{

	class Tire{}
	
	static class Engine{}

	@Override
	public void run() {
		System.out.println("승용차가 달립니다.");
	}
	
	
}
