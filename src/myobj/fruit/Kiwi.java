package myobj.fruit;

public class Kiwi {

	int size;
	String color;
	int sweet;
	
	public Kiwi() {
		
	}
	
	public Kiwi(int size, String color, int sweet) {
		this.size = size;
		this.color = color;
		this.sweet = sweet;
	}


	void eat() {
		int size = 2;
		this.size -= size; 
		if(this.size == 0) {
			System.err.println("�� �Ծ����ϴ�.");
			return; 
		}
		
		System.out.printf("Ű���� %d��ŭ �پ����ϴ�. ���� �� : %d\n", size, this.size);
		
	}

	@Override
	public String toString() {
		return "Kiwi [size=" + size + ", color=" + color + ", sweet=" + sweet + "]";
	}
	
}
