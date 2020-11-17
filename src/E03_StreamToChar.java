import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class E03_StreamToChar {

	// # Reader / Writer가 붙은 클래스들은
	//	Stream으로 읽은 데이터를 문자로 변환하는 클래스들이다.
	
	// # 프로그래머가 데이터를 문자로 편하게 다루고 싶을 때
	//	InputStream/OutputStream을 Reader/Writer 클래스로
	//	한번 더 감싸서 사용한다.
	//	문자일 때만 사용
	
	public static void main(String[] args) {
		 
		// # abstract class Reader
		//	- Reader를 상속받아 구현한 클래스들
		//	- BufferedRedaer, InputStreamReader, FileReader....
		//	- Stream으로 얻은 데이터를 문자로 재구성하여 프로그래머에게 제공한다.
		//	- 코드 데이터를 문자로 재구성할시 사용할 Charset을 알맞게 설정하지 않으면 글자가 깨진다. (입출력 클래스 공통)
		
		try {							
		
			// 3단계 업그레이드
			FileInputStream fin = new FileInputStream("E:\\java_io\\bufferedout.txt");
			
			InputStreamReader ir = new InputStreamReader(fin, "EUC-KR"); // 인코딩 깨질 경우 두번째 인자로 Charset.forName()을 넣어준다.
			
			// 위에 2단계 생략 하고 바로 BufferedReader			인코딩 깨질 경우 두번째 인자로 Charset.forName()을 넣어준다.
			FileReader fr = new FileReader("E:\\java_io\\bufferedout.txt");
			
			BufferedReader br = new BufferedReader(ir, 2048);
		
			// Reader 클래스의 read는 다음 byte가 아니라 
			//	다음 char를 읽는다 => 한글이 만들어져서 온다.
			int ch;
			while ((ch = br.read()) != -1) {
				System.out.print((char)ch);
			}
			
			br.close();
			ir.close();
			fin.close();
			fr.close();
			System.out.println("읽기가 모두 끝났습니다.");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println();
		
//////////////////////////////////////////////////////////////////////////////////////////
		 
		// # abstract class Writer
		//	- 파일에 문자를 저장할때 charset을 지정할 수 있따.
		//	- 프로그래머가 좀더 편리하게 OutputStream을 이용할 수 있다.
		
		try {
			long start_time = System.currentTimeMillis();
			// 단계별로 업그레이드
			FileOutputStream fout = new FileOutputStream("E:\\java_io\\bufferedout.txt");
			
			// OutputStream방식에서 Writer로 변환 ( byte -> char )
			OutputStreamWriter ow = new OutputStreamWriter(fout);
			
			// 위에 2단계 과정 생략 할수있는 클래스
			FileWriter fw = new FileWriter("E:\\java_io\\bufferedout.txt");
			
			// Buffered: 성능 향상
			BufferedWriter bw = new BufferedWriter(ow, 4096);
			
			// Print : 프로그래머에게 편리한 print메서드들을 사용할수 있음
			PrintWriter pw = new PrintWriter(bw);
			
			for (int i = 0; i < 10000; i++) {
				// 콘솔에 출력하던 것을 파일에 출력할 수 있다.
				pw.printf("[%d/%d %d:%d] 안녕하세요 반갑습니다\n", 1, 2, 3, 4);
			} 
			
			pw.close();
			bw.close();
			fw.close();
			ow.close();
			fout.close();
			System.out.println("출력 완료 - "
					+ (System.currentTimeMillis() - start_time) + "ms");
		} catch (FileNotFoundException e) {
			System.err.println("파일을 못찾았습니다.");
		} catch (UnsupportedEncodingException e) {
			System.err.println("인코딩이 잘못 되었습니다.");
		} catch (IOException e) {
			System.err.println("쓰는 도중 에러 발생");
		}
	}
}
