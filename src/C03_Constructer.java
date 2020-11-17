
public class C03_Constructer {

	// Ŭ������ ������ 
	//	- Ŭ������ �̸��� �Ȱ��� �̸��� �Լ� 
	// 	- new�� �Բ� �����ڸ� ȣ���ϸ� Ŭ������ ���ǵ� ��� �ν��Ͻ��� ����
	// 	- �����ڰ� ��� ����� �Ŀ��� ������ �ν��Ͻ��� �ּҰ� ��ȯ�ȴ�.
	// 	- �����ڸ� ���� �������� ������ �ƹ��͵� ���ǵ��� ���� �⺻������ ���
	//				�⺻ ������ - �Ű������� ���� ������
	
	public static void main(String[] args) {
		
		Orange o1 = new Orange();
		Orange o2 = new Orange(5, 5, "green");
		
		
		System.out.println(o1.sweet);
		System.out.println(o1.size);
		System.out.println(o1.color);
		
		System.out.println(o2.sweet);
		System.out.println(o2.size);
		System.out.println(o2.color);
		
		Strawberry s1 = new Strawberry();
		
		Grape g1 = new Grape(30);
		Grape g2 = new Grape(25);
		
		for(int i = 0; i < 31; ++i) {
			g1.eat();
			
		}

		g2.eat();
		
	}
	
	
}

class Orange {
	
	int sweet;
	int size;
	String color;
	
	//�ν��Ͻ� ȣ��� ���� ���� ȣ���
	// �ַ� �ν��Ͻ� �������� �ʱ�ȭ �ϴµ� ���.
	// return Ÿ�� X
	public Orange() {
		// ���ÿ��� Ŭ���� ���ο��� this�� �����ص� �ʵ忡 ���ٰ���
		sweet = 10;
		size = 5; 
		color = "orange";
	}
	
	//�����ڵ� �Լ�ó�� �����ε� ����
	//	- �ϳ��� Ŭ������ �پ��� ������ �����ڸ� ������������ ����
	public Orange(int sweet, int size, String color) {
		// �ʵ尪�� ���� �������� ��ġ�� ��� this�� ���� ����� �������� ��Ȯ�� ����
		this.sweet = sweet;
		this.size = size;
		this.color = color;
		// this - Ŭ���� ���ο��� ���� �ν��Ͻ��� ������ �� ����ϴ� Ű����
	}
}

class Strawberry {
	int seed;
	String color;
	
}

//���ǵ� �����ڰ� ���� ��� �⺻������ �ڵ����� �������� �ʴ´�. ����ϰ���� ��� ���� ����.
class Grape {
	int podo;
	int skin;
	
	public Grape() {
		this(20);
		
		// �����ڿ��� this(); ������ �ٸ� �����ڸ� ȣ���� ���ִ�.
		// �ٸ� �����ڴ� �ݵ�� ������ �� ���� ȣ��
	}
	
	public Grape(int podo) {
		this.podo = podo;
		this.skin = 0;
	}
	
	public void eat() {
		if(podo == 0) {
			System.err	.println("�� ������ �ٸԾ����ϴ�.");
			System.out.printf("���� ���� ������ %d��, ������ %d�� �Դϴ�.\n", podo, skin);
			return;
		}
		podo--;
		skin++;
		System.out.printf("���� ���� ������ %d��, ������ %d�� �Դϴ�.\n", podo, skin);
	}
}