package crypto;

		// 추상 클래스 : 클래스 내부에 추상 메서드를 지닌 클래스
public abstract class Cipher {
	
	// # 추상 메서드 abstract
	//	- 함수의 형태만 정해놓고 자식 클래스에서 구현하게(오버라이드) 만든다.
	//	- 자식 클래스에서 오버라이드 하지 않으면 에러가 발생 (강제성 효과)
	//	- 자식 클래스에 같은 형태의 해당 메서드가 100% 존재
	// 	- 업캐스팅 했을 때 자식 클래스에서 구현된 코드를 사용하게 된다.
	
	// 자식 클래스들의 형태를 미리 결정한 뒤 
	// 자식 클래스들이 메서드를 오버라이드 하여 사용하게 만든다.
	abstract public String encryption(String plain);
	
	abstract public String decryption(String crypto);
	
}

// ex >
class MyAlgo extends Cipher {

	@Override
	public String encryption(String plain) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String decryption(String crypto) {
		// TODO Auto-generated method stub
		return null;
	}
	
}