package study;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.BufferedInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class E02_BufferdIO {

	// # Bufferd I/O
	//	- ���۸� �̿��� �б� / ���� ������ ����Ű�� Ŭ����
	//	- ���۶�? �����͸� ��/����ϱ� ���� �ӽ÷� �����صδ� �迭
	
	// # ���۸� �̿��ؾ��ϴ� ����
	//	- ���۾��� �б� / ���⸦ �ϰ� �Ǹ� ������� �ʹ� ���� �Ͼ��.	
	// 	- "Java programming"�� ���� ���
	//	- �⺻ OutputStream���� �� ���ھ� ���� 16���� ����� �߻��Ѵ�.
	//	- '�迭�� ����'�س��� �ѹ��� ���� 1���� ��¸����� ����� ����
	
	public static void main(String[] args) {
		StringBuilder text = new StringBuilder();
		
		// dummy data
		for (int i = 0; i < 10000; i++) {
			text.append(i + " �ȳ��ϼ���\n");
		}
		
		// # java.io.BufferedOutputStream
		//	- �����ڿ� OutputStream�� �䱸�Ѵ�
		//	- OutputStream�� ����� ��Ҹ� �����ϴ� �뵵�� ���
		//	- BufferdOutputStream�� ���� ���׷��̵��� �뵵�� ���
		
		try {
			FileOutputStream fout =
							new FileOutputStream("E:\\java_io\\bufferedout.txt");

			BufferedOutputStream bout = 
							new BufferedOutputStream(fout, 1024); 
									// ������ ũ�Ⱑ 1024�� ���
									//	- �����͸� �� �� '1024 ����Ʈ' Ȥ�� 'close()�� �߻�'�ϸ�  �����Ͱ� �� ���̸� ����Ѵ�.
									//	- Ȥ�� flush()�� ȣ���� �� ����Ѵ�.
			
			// �迭�� ��Ƴ��°� ��ü�� Buffer (batch processing - �ϰ� ó��)
			byte[] data = new String(text).getBytes();
			
			bout.write(data);
			
//			for (byte b : data) {
//				bout.write(b);
//			}
			
			// �������� �߰� OutputStream�� ����ϴ� ���
			// ���� ���߿� ������ ������� �ݴ´�.
			bout.close();
			fout.close();
			System.out.println("���� ��� ��");
			
		} catch (FileNotFoundException e) {
			System.err.println("���� ��ã��");
		} catch (IOException e) {
			System.err.println("����/�ݱ� ���� ���� �߻�");
		}
		System.out.println();
		
///////////////////////////////////////////////////////////////////////////////////
		// java.io.BufferedInputStream
		// 	- InputStream�� �����ڷ� �䱸�Ѵ�
		
		try {
			FileInputStream fin = new FileInputStream("E:\\java_io\\bufferedout.txt");
			BufferedInputStream bin = new BufferedInputStream(fin, 1024);
			
			// # read()�� �⺻ �����ε�
			//	- �� ����Ʈ�� int������ �о�´�
			
			// # read(byte[]) �����ε�
			//	- ������ byte[]�� ũ�⸸ŭ�� byteä���ش�
			//	- ������ �迭 �߿� �� byte�� ä�������� ��ȯ (len)
			
			// #reat(byte[], off, len)
			//	- ������ byte[]�߿��� off���� len�������� �����͸� ä���ش�
			//	- ������ �迭�� �� byte�� ä������ ��ȯ�Ѵ�.
			
			// �ѱ��� ��� byte�� �޾ƿ;���
		
			int len;
			while ((len = bin.read()) != -1) {
				System.out.print((char)len);
			}
			
			bin.close();
			fin.close();
		} catch (FileNotFoundException e) {
			System.err.println("���� ��ã��");
		} catch (IOException e) {
			System.err.println("�б�/�ݱ� ���� ���� �߻�");
		}
		System.out.println();
		
	}
}
