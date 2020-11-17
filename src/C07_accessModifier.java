import myobj.C07_diffPackage;

public class C07_accessModifier extends C07_diffPackage{
		
			// # ���� ���� (include)
			//	- ����� ���� �ش� Ŭ������ �����ϴ� ��
			//	- ���� ���� ���յ�(��ȣ�������� 
			
			// # ���� ���� (dependency)
			//	- �ϳ��� Ŭ������ �ٸ� Ŭ������ ��� �ϴ°� 
	
	
	// # ���� ������ (Access Modifier)
	//	- �ٸ� Ŭ������ �ش� Ŭ������ �ڿ��� ���(����, ����)�Ϸ��� �� �� 
	// 		�ش� ��ü���� �Ÿ��� ���� ��� ���� ���� (���̴� ���� == visible)
	
	// # ������ �� �ִ� �Ÿ��� ����
	//	- ���� Ŭ���� ������ �ٸ� �ڿ� ( ���� ����� )
	//	- ���� ��Ű�� ������ �ٸ� �ڿ�
	//	- �ٸ� ��Ű���� ��ӹ��� �ڿ�
	//	- �ٸ� ��Ű���� �ڿ� ( ���� �� )
	
	// # ���� �������� ����
	// 	- private		: ���� Ŭ���� ���ο����� ����� �� �ִ� �ڿ��� �ȴ�.
	//	- �ƹ��͵� �� ��	: default. ���� ��Ű�� ���ο����� ��� ����.
	//	- protected		: �ٸ� ��Ű�������� ����� ������ ���� �ִ� �ڿ��� �ȴ�.
	//						(���� ��Ű�������� �����Ӱ� ���)
	//	- public		: ���� �� �Ÿ������� �����Ӱ� ���� �ִ� �ڿ��� �ȴ�.
	
	
	// # ��ü���⿡���� ĸ��ȭ (Encapsulation)
	// 	- ���� �����ڸ� Ȱ���� �ٸ� Ŭ�������Դ� ������ �ʿ���� �ڿ�(���� /�޼���)��
	//		�����ϴ� ���� ���Ѵ�
	
	public static void main(String[] args) {
		
		// # ���� ��Ű�� ������ �ڿ� 
		//	- private �����ϰ� ��� ���δ�. (visible) (�޼��嵵 ����)
		System.out.println(C07_samePackage.package_sInt);
		System.out.println(C07_samePackage.protected_sInt);
		System.out.println(C07_samePackage.public_sInt);
		
		C07_samePackage same_package_instance = new C07_samePackage();
		
		System.out.println(same_package_instance.package_int);
		System.out.println(same_package_instance.protected_int);
		System.out.println(same_package_instance.public_int);
		
		
		// # �ٸ� ��Ű�� �ڿ�
		System.out.println(C07_diffPackage.public_sInt);
		//	- ����� ������ protected���� ���δ�.
		System.out.println(C07_diffPackage.protected_sInt);
		
		C07_diffPackage diff_package_instance = new C07_diffPackage();
		
		System.out.println(diff_package_instance.public_int);

		// ��� ���� Ŭ������ �ν��Ͻ��� ��������� protected�ڿ� ����
		C07_accessModifier child = new C07_accessModifier();
		System.out.println(child.public_int);
		System.out.println(child.protected_int);
		
	}
}
