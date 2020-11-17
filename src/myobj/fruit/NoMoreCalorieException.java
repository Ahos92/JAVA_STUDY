package myobj.fruit;

// 상속의 큰 의미
// Exception 클래스를 상속받으면 예외가 된다.
//		- 반드시 처리해야 하는 예외가 된다.

public class NoMoreCalorieException extends Exception {

	public NoMoreCalorieException() {
		super("더 이상 먹을 수 없는 사과");
	}
	
}
