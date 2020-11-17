import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class E01_JavaIO {

	// # Java I/O (Input and Output)
	//	- �ڹٴ� ��Ʈ���� �̿��� ������� �ٷ��
	//	- �츮 ���α׷����� ������ ��� �����͵��� �Է�(Input) �̶�� �θ���
	//	- ���α׷��� �����ؼ� �������� ��� ������(Output) ���� ����̶�� �θ���.
	
	// # Stream
	//	- �����͵��� ������ ���
	//	- �Է¹��� �� ����ϴ� ��θ� InputStream�̶�� �θ���.
	//	- ��� �� �� ����ϴ� ��θ� OutputStream�̶�� �θ���.
	//	- �����Ͱ� Stream�� ���� �̵��� ���� 0�� 1�� ��ȯ�Ͽ� �����Ѵ�.
	
	// # OutputStream Ŭ������ ���� �޼���
	//	- write(int)
	//	- write(byte[]) - > ��絥���͵��� ����Ʈ�� ���� 0,1 �����ȣ�� ����
	//	- flush() : ��Ƴ��� �����͸� �����Ѵ�.
	//	- close() : Stream�� ����Ѵ� (�ݴ´�, �޸� ����)
	
	// # InputStream Ŭ������ ���� �޼���
	//	- int read() : ���� �� ����Ʈ�� �о�´�, EOF�� �����ϸ� -1�� ��ȯ  ( EOF - End Of file)
	//	- int read(byte[])
	//	- int read(byte[], off, len) - BufferedIO.class������
	// 	- close() : ��Ʈ���� �ݴ´�
	
	// �� Stream Ŭ������ gc�� �޸� ���� Ÿ�̹��� �������� ����ڰ� ���� �ݾ������ ( close() )
	
	public static void main(String[] args) {
	
		// # FileOutputStream
		//	- ���Ϸ� ����ϴµ��� Ưȭ�� OutputStream
		//	- Java IO Ŭ�������� ��κ� �ʼ������� ó���ؾ��ϴ� ���ܰ� �����Ѵ�.
		
		try {
			FileOutputStream fout = 
					new FileOutputStream("E:\\java_io\\testout.txt");
			//int ���
//			fout.write(65);
			
			// byte[]�� ���
			byte[] data = "�ȳ��ϼ���".getBytes();
			fout.write(data);
			
			// Java IO�� ��Ʈ������ GC�� �����ذ��� �ʱ� ������ 
			//�� �� �ݵ�� ���α׷��Ӱ� ��Ʈ���� �޵�� �ݾ��ش�.
			fout.close();
			System.out.println("����(write) ����");
			
		} catch (FileNotFoundException e) {
			System.err.println("������ ��ã�ҽ��ϴ�.");
		} catch (IOException e) {
			System.err.println("���ٰ� ���� �߻��� ����");
		}
		System.out.println();
		
		// # FileInputStream
		//	- ���Ϸκ��� �Է��� �޴µ� Ưȭ�� InputStream
		
		try {
			FileInputStream fin = 
					new FileInputStream("E:\\java_io\\testout.txt");
			
			byte[] bytes = new byte[100];
			//���� ���� -1�� �ƴѵ��� ��� �о���δ�
			int ch = -1;
			int index = 0;
			while ((ch = fin.read()) != -1) {
				bytes[index++] =  (byte) ch;
			}
			
			System.out.println("byte[]�� ����� ���� : " + Arrays.toString(bytes));
			System.out.println(new String(bytes));
			
			fin.close();
		} catch (FileNotFoundException e) {
			System.err.println("�ش� ������ ã�� ���߽��ϴ�.");
			
		} catch (IOException e) {
			System.err.println("IO���� ���� �߻�");
		}
		System.out.println();
		
		// # FileInputStream, FileOutputStream�� �����͸� �ڵ�� �о���� ������
		//	���α׷��Ӱ� ���� ���·� �������ϴ� ������ �ʿ��ϴ�
		
		
	
	}
	
}
