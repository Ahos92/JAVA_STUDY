import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class E09_Clinet {

	// E08에 접속을 시도하는 프로그램
	//	- 
	public static void main(String[] args) {
		
		try {
			Socket s = new Socket("118.130.22.163", 3456);
			System.out.println("연결에 성공했습니다.");
			
			PrintWriter out = new PrintWriter(
								new OutputStreamWriter(s.getOutputStream())
			);
			
			for (int i = 0; i < 1000; i++) {
				out.println("1");
			}
			
			out.close();
			s.close(); // 소켓도 닫아줘야함
			System.out.println("메세지를 성공적으로 전송했습니다.");
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
