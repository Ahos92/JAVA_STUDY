import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class E09_Clinet {

	// E08�� ������ �õ��ϴ� ���α׷�
	//	- 
	public static void main(String[] args) {
		
		try {
			Socket s = new Socket("118.130.22.163", 3456);
			System.out.println("���ῡ �����߽��ϴ�.");
			
			PrintWriter out = new PrintWriter(
								new OutputStreamWriter(s.getOutputStream())
			);
			
			for (int i = 0; i < 1000; i++) {
				out.println("1");
			}
			
			out.close();
			s.close(); // ���ϵ� �ݾ������
			System.out.println("�޼����� ���������� �����߽��ϴ�.");
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
