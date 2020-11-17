package study;

public class C02_OOP {

	// ��ü���� ���α׷��� (OOP : Object Oriented Programming)
	//	- �����ϴ� ��� �͵��� ������ �޼���� ǥ���Ϸ��� ���α׷��� ��� 
	//		ex) ���ǽ�(�޼���) -> �ο� ��(����), �ִ�����ο�(���)

	// - ��ü : ���� �����ϴ� ��� ���� (�繰, ����, �˰��� ���)

	//ex: ���
	//	- ����� ���� : ũ��, ��, ��Ȯ��¥, �絵, Į�θ� ��
	//	- ����� �޼��� - �� �޼��� : ��ü�� ������ ������ ��ġ�� �Լ�
	//			-> �Դ´�(ũ��, Į�θ� ��ȭ)
	//		-> ���� (��, �絵 ��ȭ)
	//		-> ...

	// -> Class
	// ��ü�� ���α׷��� ���� ǥ���� �� 
	// Ŭ������ ���� �������ϴ� ���� ��ü�� '�ν��Ͻ�'��� �θ���.
	// Ŭ������ ������ ���� Ÿ���̴�.
	//	(��� Ŭ������ ����ٸ� ��� Ÿ���� ����� �� �ְ� �ȴ�.)

	public static void main(String[] args) {

		Apple apple01 = new Apple(); // Ŭ���� ���� (���赵�� ��ü(Apple�� �ν��Ͻ�)�� ����� �� ��ü�� �ּҸ� ���� apple01������ )
		Apple apple02 = new Apple();
		Apple apple03 = new Apple();

		
		// �迭�� ��ü�� �����Ǿ��ִ°� -> String[] fruits = new String[];
		Apple[] appleBox = new Apple[10];
		
		// �迭�� ��� ��ü ����
		for(int i = 0; i < appleBox.length; ++i) {
			appleBox[i] = new Apple();
		}

		apple02.sweet = 10;
		apple03.sweet = 8;

		// ��ü�� ���� ���赵�� ��밡��
		apple01.birthday = "2020/10/29";
		apple01.size = 10;
		apple01.calorie = apple01.size * 10;
		apple01.color = "red";
		apple01.sweet = 7;

		apple01.eat();
		apple02.eat();
		apple03.eat();
		
		//1. myobj.fruit ��Ű���� Ŭ�����ϳ� �����ϰ� �ν��Ͻ�
		//2. myobj.vehicle ��Ű���� Ŭ�����ϳ� �����ϰ� �ν��Ͻ�
		
	}

}

class Apple {
	
	// �ν��Ͻ� ���� ( �ʵ�, ������� ..)
	// 	- ��� �ν��Ͻ����� ���� �ٸ� ���� ������ �ִ� ����
	int size;
	int sweet;
	int calorie;
	int damage;
	String color;
	String birthday;

	// �ν��Ͻ� �޼���
	// �ν��Ͻ� ������ Ȱ���ϴ� �޼���
	void eat() {
		System.out.println("����� �Ծ����ϴ�.");
		System.out.println(this.sweet + "��ŭ ����� ���������ϴ�.");
		this.size -= 1;
		this.calorie -= 10;
		System.out.printf("ũ�� : %d , ���� Į�θ� : %d\n", this.size, this.calorie);
	}


}
