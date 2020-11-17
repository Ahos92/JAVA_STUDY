package study;

// 추상 클래스 : 클래스 내부에 추상 메서드를 지닌 클래스

// # 추상 메서드 abstract
//	- 함수의 형태만 정해놓고 자식 클래스에서 구현하게(오버라이드) 만든다.
//	- 자식 클래스에서 오버라이드 하지 않으면 에러가 발생 (강제성 효과)
//	- 자식 클래스에 같은 형태의 해당 메서드가 100% 존재
// 	- 업캐스팅 했을 때 자식 클래스에서 구현된 코드를 사용하게 된다.

// 자식 클래스들의 형태를 미리 결정한 뒤 
// 자식 클래스들이 메서드를 오버라이드 하여 사용하게 만든다.

public class C06_abstract {

	public static void app(String msg, String read, C06_ChatApp chatapp) {
		chatapp.send(msg);
		chatapp.read(read);
		System.out.println();
	}

	public static void messenger(String msg, String read, int code) {
		switch(code) {
		case 1:
			app(msg, read, new C06_Kakao());
			break;
		case 2:
			app(msg, read, new C06_Line());
			break;
		case 3:
			app(msg, read, new C06_Telegram());
			break;
		}

	}

	public static void main(String[] args) {

		// abstract 클래스와 그것을 상속 받는 케이스를 설계 해보세요
		// (추상 메서드가 반드시 존재해야 함)
		
		messenger("하이", "그래", 1);
		messenger("하이", "그래", 2);
		messenger("하이", "그래", 3);

	}

}




