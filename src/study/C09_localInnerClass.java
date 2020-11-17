package study;

public class C09_localInnerClass {

	// # ���� ���� Ŭ����
	//	- �޼��� ���ο����� Ŭ���� ����� �����ϴ�
	//	- �޼����� ������ ��� �� ����.
	//	- 
	
	void method() {
		
		class Apple{
			int size;
			String color;
		}
		
		Apple a = new Apple();
		
		System.out.println(a.color);
		System.out.println(a.size);
		
	}
	
	public static void main(String[] args) {
		
		// ���������� ������ ����Ŭ������ ������ ��ħ
		String a = "�뱸";
		String b = "������";
		
		// ���� ���� Ŭ���� (�޼��� ������ Ŭ������ ������� �ȴ�)
		class Apple{
			String addr;
			String color;
			
			public Apple() {
				addr = a;
				color = b;
			}
		}
		
		Apple apple = new Apple();
		
		System.out.println(apple.addr);
		System.out.println(apple.color);
		
	}
}
