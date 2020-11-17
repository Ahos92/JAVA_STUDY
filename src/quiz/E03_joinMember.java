package quiz;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import myobj.Member;

public class E03_joinMember {

	// 1. ����ڰ� �ڽ��� ���������� �Է��ϸ� 
	//	 �� ������ ������� �̸����� �� ���Ͽ� �����غ�����
	// �� java_io\\member\\������̸�.txt ����

	// 2. ������� �̸��� ���� ������ �ش� ����ڰ�
	//	���Ե� ȸ���̶�� ���Ͽ��� ������ �о� ������ְ�
	//	���� ���Ե��� ���� ����̶�� ���Ե��� �ʾҴٰ� ����ϴ� �޼��带 �ۼ��غ�����.

	// 3. ����� ������� ������ ������ �� �ִ� �޼��带 �����غ�����.
	
	public static boolean checkNotMember(String name) throws IOException {
		String cd = "E:\\java_io\\member\\";
		String filename = name + ".txt";
		
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(cd + filename));
		
			String[] data = br.readLine().split(" / ");
			
			System.out.printf("<< \'%s\'���� ���� >>\n", data[0]);
			System.out.println("�̸� : " + data[0]);
			System.out.println("���� : " + data[1]);
			System.out.println("�ּ� : " + data[2]);
			System.out.println("��ȣ : " + data[3]);
			
			return false;
		} catch (FileNotFoundException e) {
			System.out.println("[System] ȸ�������� �����մϴ�.");
			return true;
		} finally {
			if (br != null) {
				br.close();
			}
		}
		
	}
	
	public static void save(Member info) throws IOException {
		String cd = "E:\\java_io\\member\\";
		String filename = info.name + ".txt";
		
		FileWriter fw = new FileWriter(cd + filename);
		PrintWriter pw = new PrintWriter(new BufferedWriter(fw, 4096));
		
		pw.print(info);
		
		pw.close();
		
	}
	
	public static void modify (Member to_update) throws IOException {
		String cd = "E:\\java_io\\member\\";
		String filename = to_update.name + ".txt";
		
		BufferedReader br = null;
		PrintWriter pw = null;
		// to_update�� �̸��� �ּҸ� �Ѿ���� �������� �����ǰ� �ּҸ� �����ǵ��ϸ����
		
		//���� �����͸� �о���δ�
		try {
			br = new BufferedReader(new FileReader(cd + filename));
			
			String[] data = br.readLine().split(" / ");
			
			Member before = new Member(data[0], 
										Integer.parseInt(data[1]), 
										data[2], 
										data[3]);
			
			// �⺻�����͸� ���ο���ͷ� �����.
			Member after = before.update(to_update);
			
			// �ϼ��� �����͸� ���Ͽ� �����.
			pw = new PrintWriter(new BufferedWriter(new FileWriter(cd + filename)));
			
			// Member��ü�� toString()�� �̿��Ѵ�.
			pw.print(after);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (br != null) br.close();
			if (pw != null) pw.close();
		}
	}
	
	public static void main(String[] args) throws IOException {

//		Member to_upadate = new Member("��浿", -1, "���ֵ�", null);
//		
//		modify(to_upadate);
		
		// ���� ��ȸ
		// System.in �� InputStream�̴�		
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			System.out.print("�̸� >");
			String name = br.readLine();
			
			if (checkNotMember(name)) {
				System.out.print("���� >");
				int age = Integer.parseInt(br.readLine());
				
				System.out.print("�ּ� >");
				String address = br.readLine();
				
				System.out.print("�ڵ�����ȣ >");
				String phoneNumber = br.readLine();
				
				save(new Member(name, age, address, phoneNumber));
				
				br.close();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
