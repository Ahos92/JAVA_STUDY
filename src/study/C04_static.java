package study;

public class C04_static {

	// # static (����, Ŭ���� ����) <=> �ν��Ͻ� ����
	//	- ���� Ŭ������ ��� �ν��Ͻ��� '����'���� ����ϴ� ���� 
	// 	- static ������ Ŭ������ �ϳ� �̹Ƿ� 
	//		Ŭ���� �̸��� .�� ��� ����ϴ°��� ���� (�ν��Ͻ��� ������ �� ���� ���̱⋚����)
	//	- static ������ ����/�޼���(�ڿ�)�� �ν��Ͻ��� ����� ������ ȣ���� �� �ִ�.
	
	//	- �ν��Ͻ����������� ���� ���� Static�� ���� ���ɼ��� �ֱ� ������
	//		static �޼��忡���� instance�ڿ��� ����� �� ����.
	//		(�ν��Ͻ����� ����ƽ������ ������ ���)
	
	public static void main(String[] args) {
		// �ν��Ͻ����� ����� ���� static ����
		System.out.println(Card.width);
		System.out.println(Card.height);

		Card c1 = new Card("Clover", 1);
		Card s1 = new Card("Spade", 1);
		Card h1 = new Card("Heart", 1);
		Card d1 = new Card("Diamond", 1);

		Card.width = 333;// ���� �� ����Ŵ

		System.out.println(Card.width); // ����
		System.out.println(c1.width); // �����
		System.out.println(s1.width);
		System.out.println(h1.width);
		System.out.println(d1.width);
	}
}

// 1 ex
class Card {
	// �� ī�帶�� �ٸ� ���� ������ �־���ϴ� ���� 
	// �ν��Ͻ� ������ ����
	String shape;
	int number;

	// ī���� ũ��� �ݵ�� ���� ���ƾ��� 
	//  �ν��Ͻ����� ����ϱ� ���� ���� -> ���� ������ ����
	static int width;
	static int height;
	// ������ ��� static block���� �ʱ�ȭ�� �����ϴ� ���� ����.
	static {
		width = 100;
		height = 200;
		System.out.println("static block called");
	}

	// instance block
	{
		System.out.println("instance block called");
	}
	
	public Card(String shape, int number) {
		this.shape = shape;
		this.number = number;
		System.out.println("constructor called");
		// �����ڿ��� static�� �ʱ�ȭ�ϴ� ��� -> bad
		// �ʱ�ȭ ���� ������ static�ʵ带 ����� ������ �ִ�.
		// width = 100;
		// height = 200;
	}

	// static �޼���� �Ű�����, static ������ ��밡��
	//	- this�������� ����
	// 			(���� �ν��Ͻ��� �������� �ʾ������� �����Ƿ�)
	// �ν��Ͻ��� �����ϰ� �׻� ������ ����� ������ �� ����Ѵ�
	public static void changeCardSize (int width, int height) {
		Card.width = width;
		Card.height = height;
	}
	
	public static int[] getCardSize() {
		return new int[] {width, height};
	}
}

// 2 ex
class Coffe {

	int from;

	// ������ ��ȣ�� ��� Ŀ�ǵ��� ���� ���� ���ؾ���
	//	-> ���� ������ ����ϴ°��� �ո���.
	final static int SOUTH_KOREA = 0;
	final static int COLUMBIA = 1;
	final static int BRAZIL = 2;
}
