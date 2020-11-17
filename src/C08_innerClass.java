
public class C08_innerClass {

	// Ŭ���� ���ο� Ŭ���� ����ϱ�
	public static void main(String[] args) {
		
		AppleBox box = new AppleBox(20);
		
		System.out.println(box.box[0].color);
		
		// �ܺο��� �ٸ� Ŭ������ inner_class ����ϱ� ( ���� ���� )
		AppleBox.Apple apple01 = new AppleBox(10).new Apple();
		System.out.println(apple01.color);
	}
	
}


// outer class
//	- ���� �����ڰ� default�� public�� ����� �� �ִ�.
class AppleBox {
	
	Apple[] box;
	
	public AppleBox(int size) {
		box = new Apple[size];
		for(int i = 0; i < box.length; ++i) {
			// ���� Ŭ���� ������ �ڿ��̱� ������ this. �����ϰ� ��� �Ҽ� �ִ�.
			box[i] = new Apple();
		}
		
	}
	
	// inner class
	// AppleBox�� �ν��Ͻ��� ����� ������ inner class Apple�� �������� �ʴ´�.
	//	- ���������� �����ӰԻ��
	//	- ���� ���� : outer class�� �ʵ忡 ���� �޶����� Ŭ������ �ۼ��� �� �ִ�.(���� Ŭ���� �ۼ�)
	public class Apple {
		int color;
		int size;
	}
	
}