import myobj.C07_diffPackage;

public class C07_accessModifier extends C07_diffPackage{
		
			// # 포함 관계 (include)
			//	- 상속을 통해 해당 클래스를 포함하는 것
			//	- 아주 높은 결합도(선호되지않음 
			
			// # 의존 관계 (dependency)
			//	- 하나의 클래스가 다른 클래스를 사용 하는것 
	
	
	// # 접근 제어자 (Access Modifier)
	//	- 다른 클래스가 해당 클래스의 자원을 사용(포함, 의존)하려고 할 때 
	// 		해당 객체와의 거리에 따른 허용 여부 설정 (보이는 정도 == visible)
	
	// # 구분할 수 있는 거리의 종류
	//	- 같은 클래스 내부의 다른 자원 ( 가장 가까운 )
	//	- 같은 패키지 내부의 다른 자원
	//	- 다른 패키지에 상속받은 자원
	//	- 다른 패키지의 자원 ( 가장 먼 )
	
	// # 접근 제어자의 종류
	// 	- private		: 같은 클래스 내부에서만 사용할 수 있는 자원이 된다.
	//	- 아무것도 안 씀	: default. 같은 패키지 내부에서만 사용 가능.
	//	- protected		: 다른 패키지에서는 상속을 받으면 쓸수 있는 자원이 된다.
	//						(같은 패키지에서는 자유롭게 사용)
	//	- public		: 가장 먼 거리에서도 자유롭게 쓸수 있는 자원이 된다.
	
	
	// # 객체지향에서의 캡슐화 (Encapsulation)
	// 	- 접근 제어자를 활용해 다른 클래스에게는 보여줄 필요없는 자원(변수 /메서드)을
	//		은닉하는 것을 말한다
	
	public static void main(String[] args) {
		
		// # 같은 패키지 내부의 자원 
		//	- private 제외하고 모두 보인다. (visible) (메서드도 같음)
		System.out.println(C07_samePackage.package_sInt);
		System.out.println(C07_samePackage.protected_sInt);
		System.out.println(C07_samePackage.public_sInt);
		
		C07_samePackage same_package_instance = new C07_samePackage();
		
		System.out.println(same_package_instance.package_int);
		System.out.println(same_package_instance.protected_int);
		System.out.println(same_package_instance.public_int);
		
		
		// # 다른 패키지 자원
		System.out.println(C07_diffPackage.public_sInt);
		//	- 상속을 받으면 protected까지 보인다.
		System.out.println(C07_diffPackage.protected_sInt);
		
		C07_diffPackage diff_package_instance = new C07_diffPackage();
		
		System.out.println(diff_package_instance.public_int);

		// 상속 받은 클래스의 인스턴스를 생성해줘야 protected자원 보임
		C07_accessModifier child = new C07_accessModifier();
		System.out.println(child.public_int);
		System.out.println(child.protected_int);
		
	}
}
