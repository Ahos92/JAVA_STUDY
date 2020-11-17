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

	// 1. 사용자가 자신의 개인정보를 입력하면 
	//	 그 정보를 사용자의 이름으로 된 파일에 저장해보세요
	// ※ java_io\\member\\사용자이름.txt 저장

	// 2. 사용자의 이름을 전달 받으면 해당 사용자가
	//	가입된 회원이라면 파일에서 정보를 읽어 출력해주고
	//	아직 가입되지 않은 사람이라면 가입되지 않았다고 출력하는 메서드를 작성해보세요.

	// 3. 저장된 사용자의 정보를 수정할 수 있는 메서드를 구현해보세요.
	
	public static boolean checkNotMember(String name) throws IOException {
		String cd = "E:\\java_io\\member\\";
		String filename = name + ".txt";
		
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(cd + filename));
		
			String[] data = br.readLine().split(" / ");
			
			System.out.printf("<< \'%s\'님의 정보 >>\n", data[0]);
			System.out.println("이름 : " + data[0]);
			System.out.println("나이 : " + data[1]);
			System.out.println("주소 : " + data[2]);
			System.out.println("번호 : " + data[3]);
			
			return false;
		} catch (FileNotFoundException e) {
			System.out.println("[System] 회원가입을 진행합니다.");
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
		// to_update에 이름과 주소만 넘어오면 나머지는 유지되고 주소만 수정되도록만들기
		
		//기존 데이터를 읽어들인다
		try {
			br = new BufferedReader(new FileReader(cd + filename));
			
			String[] data = br.readLine().split(" / ");
			
			Member before = new Member(data[0], 
										Integer.parseInt(data[1]), 
										data[2], 
										data[3]);
			
			// 기본데이터를 새로운데이터로 덮어쓴다.
			Member after = before.update(to_update);
			
			// 완성된 데이터를 파일에 덮어쓴다.
			pw = new PrintWriter(new BufferedWriter(new FileWriter(cd + filename)));
			
			// Member객체의 toString()을 이용한다.
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

//		Member to_upadate = new Member("고길동", -1, "제주도", null);
//		
//		modify(to_upadate);
		
		// 생성 조회
		// System.in 도 InputStream이다		
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			System.out.print("이름 >");
			String name = br.readLine();
			
			if (checkNotMember(name)) {
				System.out.print("나이 >");
				int age = Integer.parseInt(br.readLine());
				
				System.out.print("주소 >");
				String address = br.readLine();
				
				System.out.print("핸드폰번호 >");
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
