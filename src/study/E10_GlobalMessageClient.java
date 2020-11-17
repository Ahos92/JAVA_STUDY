package study;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class E10_GlobalMessageClient {

	public static void main(String[] args) {
		
		try {
			Socket s= new Socket("118.130.22.163", 3455);
			BufferedReader br = new BufferedReader (new InputStreamReader(s.getInputStream()));
			
			while (true) {
				// 서버에서 보내는 메세지를 읽을 준비
			System.out.println(br.readLine());			
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
