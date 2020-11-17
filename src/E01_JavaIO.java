import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class E01_JavaIO {

	// # Java I/O (Input and Output)
	//	- 자바는 스트림을 이용해 입출력을 다룬다
	//	- 우리 프로그램으로 들어오는 모든 데이터들을 입력(Input) 이라고 부른다
	//	- 프로그램이 연산해서 내보내는 모든 데이터(Output) 들을 출력이라고 부른다.
	
	// # Stream
	//	- 데이터들이 오가는 통로
	//	- 입력받을 때 사용하는 통로를 InputStream이라고 부른다.
	//	- 출력 할 때 사용하는 통로를 OutputStream이라고 부른다.
	//	- 데이터가 Stream을 통해 이동할 때는 0과 1로 변환하여 전송한다.
	
	// # OutputStream 클래스의 공통 메서드
	//	- write(int)
	//	- write(byte[]) - > 모든데이터들은 바이트로 변해 0,1 전기신호로 보냄
	//	- flush() : 모아놨던 데이터를 전송한다.
	//	- close() : Stream을 폐기한다 (닫는다, 메모리 해제)
	
	// # InputStream 클래스의 공통 메서드
	//	- int read() : 다음 한 바이트를 읽어온다, EOF에 도달하면 -1을 반환  ( EOF - End Of file)
	//	- int read(byte[])
	//	- int read(byte[], off, len) - BufferedIO.class에설명
	// 	- close() : 스트림을 닫는다
	
	// ※ Stream 클래스는 gc가 메모리 해제 타이밍을 잡기힘들어 사용자가 직접 닫아줘야함 ( close() )
	
	public static void main(String[] args) {
	
		// # FileOutputStream
		//	- 파일로 출력하는데에 특화된 OutputStream
		//	- Java IO 클래스들은 대부분 필수적으로 처리해야하는 예외가 존재한다.
		
		try {
			FileOutputStream fout = 
					new FileOutputStream("E:\\java_io\\testout.txt");
			//int 사용
//			fout.write(65);
			
			// byte[]을 사용
			byte[] data = "안녕하세요".getBytes();
			fout.write(data);
			
			// Java IO의 스트림들은 GC가 수거해가지 않기 떄문에 
			//다 쓴 반드시 프로그래머가 스트림은 받드시 닫아준다.
			fout.close();
			System.out.println("쓰기(write) 성공");
			
		} catch (FileNotFoundException e) {
			System.err.println("파일을 못찾았습니다.");
		} catch (IOException e) {
			System.err.println("쓰다가 뭔가 발생한 에러");
		}
		System.out.println();
		
		// # FileInputStream
		//	- 파일로부터 입력을 받는데 특화된 InputStream
		
		try {
			FileInputStream fin = 
					new FileInputStream("E:\\java_io\\testout.txt");
			
			byte[] bytes = new byte[100];
			//읽은 값이 -1이 아닌동안 계속 읽어들인다
			int ch = -1;
			int index = 0;
			while ((ch = fin.read()) != -1) {
				bytes[index++] =  (byte) ch;
			}
			
			System.out.println("byte[]에 저장된 값들 : " + Arrays.toString(bytes));
			System.out.println(new String(bytes));
			
			fin.close();
		} catch (FileNotFoundException e) {
			System.err.println("해당 파일을 찾지 못했습니다.");
			
		} catch (IOException e) {
			System.err.println("IO도중 에러 발생");
		}
		System.out.println();
		
		// # FileInputStream, FileOutputStream은 데이터를 코드로 읽어오기 때문에
		//	프로그래머가 원래 형태로 재조립하는 과정이 필요하다
		
		
	
	}
	
}
