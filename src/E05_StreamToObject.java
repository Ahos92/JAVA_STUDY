import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class E05_StreamToObject {

	// Seroalizable �������̽�
	//	- �ش� ��ü�� ����ȭ ������ ��ü�� �����
	//	  �� ����ȭ > �����͸� ���������� ��ȯ�ϴ°�
	static class Apple implements Serializable {
	
		private static final long serialVersionUID = 1L;
		
		int size; 
		String color;
		String local;

		public Apple(int size, String color, String local) {
			this.size = size;
			this.color = color;
			this.local = local;
		}

		@Override
		public String toString() {
			return size + "/" + color + "/" + local;
		}
	}
	// # ObjectOutputStream / ObjectInputStream�� ���� 
	//	- ��ü�� Stream���� ���� �Ҽ� �ִ�.
	public static void main(String[] args) {
		// AutoClosable �������̽��� ������ Ŭ��������
		//	try-with-resources�� �̿��� �� �ִ�
		try (
			FileOutputStream fout = new FileOutputStream("E:\\java_io\\objectout.txt");
			BufferedOutputStream bout = new BufferedOutputStream(fout);
			ObjectOutputStream oout = new ObjectOutputStream(bout);
		) {
			oout.writeObject(new Apple(10, "������", "�뱸"));
			oout.writeInt(12345); // DataOutputStream
			oout.writeObject(new Apple(20, "�ʷϻ�", "ȫ��"));
			oout.writeObject(new Apple(30, "�����", "�±�"));

			System.out.println("���� ���� �Ϸ�");
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println();
		
		try (
			FileInputStream fin = new FileInputStream("E:\\java_io\\objectout.txt");
			BufferedInputStream bin = new BufferedInputStream(fin);
			ObjectInputStream oin = new ObjectInputStream(bin);
		) {
			// ObjectInputStream�� readObject�� ObjectŸ������ �޾ƿ��� ������
			//	������ ����ϱ� ���ؼ��� �ٿ� ĳ������ �ʿ��ϴ�.
			// ��� Ÿ���� �ٵ��� ������ ���� �� ������ �߿�
			System.out.println("���Ͽ��� �о�� ��ü");
			System.out.println(oin.readObject() instanceof Apple);
			System.out.println(oin.readInt()); // DataInputStream
			System.out.println(oin.readObject());
			System.out.println(oin.readObject());
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
}
