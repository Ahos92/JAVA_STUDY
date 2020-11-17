package study;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class E08_NetworkProgramming {

	// # ��Ʈ��ũ ���α׷���
	//	- 2���̻��� ��ǻ�Ͱ� �ڿ��� �Բ� ����ϴ� ���α׷��� ����� ��
	//	- �ٸ� ��ǻ�Ϳ� ����ϱ� ���� IPaddress/Protocol/PortNumber ���� ������ �̿��Ѵ�.
	
	// # IPaddress
	//	- ��ǻ�͸� ã�ư��� ���� �ּ�
	//	- �� �ڸ��� 0-255 (0.0.0.0 ~ 255.255.255.255)
	
	// # Protocol
	//	- ���α׷����� �ǻ������ �ϱ����� ��Ģ
	//	- TCP, FTP, Telnet, SMTP....
	
	// # PortNumber (0 ~ 65535)
	//	- �� ��ǻ�Ϳ��� �������� ���α׷��� �� �ϳ��� �����ϱ� ���� ��ȣ
	//	- IP�ּҿ� ��Ʈ��ȣ�� ���� ������� ���α׷��� ã�ư� �� �ִ�.
	
	// # MACaddress
	//	- ���θ����� �ش� ��ǻ�͸� ��Ȯ�ϰ� ã�ư��� ���� ��ȣ
	
	public static void main(String[] args) {
		
		try {
			// ���� ���� ����
			ServerSocket ss = new ServerSocket(3456);
			
			HashMap<String, Integer> connect_cnt = new HashMap<>();
			
			int cnt = 0;
			while (true) {
				// accpet�޼��带 �����ϸ� ������ �ɋ����� ��ٸ���
				//	- �������� �����ϸ� ������ ������� ������ ����ִ� Socket�� ��ȯ�Ѵ�.
				System.out.println("[Server] ������ ��ٸ��� ��...");
				Socket s = ss.accept();
				System.out.printf("[Server] �޼����� ��ٸ��� ��... "
						+ "(�� ������ : %d��)\n", ++cnt);	
				BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
					
				String msg = br.readLine();
				
				String ipaddr = s.getInetAddress().toString();
				// Socket�� getInetAddress�� ������ IP�ּҸ� �� �� �ִ�.
				//	Socket���� IP�ּ� �̿ܿ��� 
				//	 ������ ���ῡ �ʿ��� �پ��� �������� ����ִ�.
				System.out.printf("(%s) %s\n", ipaddr, msg);
				
				if (connect_cnt.containsKey(ipaddr)) {
					connect_cnt.put(ipaddr,
							connect_cnt.get(ipaddr) + 1);
					
				} else {
					connect_cnt.put(ipaddr, 1);
				}
				
				if (cnt % 10 == 0) {
					System.out.printf("(��) ������ %d�� ����\n", cnt);
				} else if (cnt == 100) {
					break;
				}
			}
			
			for (Map.Entry<String, Integer> entry : connect_cnt.entrySet()) {
				System.out.printf("'%s'���� ���� Ƚ�� : %dȸ\n", entry.getKey(), entry.getValue());
			}
			
			System.out.println("���α׷��� �����մϴ�.");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
