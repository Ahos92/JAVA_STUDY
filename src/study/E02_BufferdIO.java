package study;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.BufferedInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class E02_BufferdIO {

	// # Bufferd I/O
	//	- 버퍼를 이용해 읽기 / 쓰기 성능을 향상시키는 클래스
	//	- 버퍼란? 데이터를 입/출력하기 전에 임시로 저장해두는 배열
	
	// # 버퍼를 이용해야하는 이유
	//	- 버퍼없이 읽기 / 쓰기를 하게 되면 입출력이 너무 자주 일어난다.	
	// 	- "Java programming"을 쓰는 경우
	//	- 기본 OutputStream으로 한 글자씩 쓰면 16번의 출력이 발생한다.
	//	- '배열에 저장'해놓고 한번에 쓰면 1번의 출력만으로 출력이 끝남
	
	public static void main(String[] args) {
		StringBuilder text = new StringBuilder();
		
		// dummy data
		for (int i = 0; i < 10000; i++) {
			text.append(i + " 안녕하세요\n");
		}
		
		// # java.io.BufferedOutputStream
		//	- 생성자에 OutputStream을 요구한다
		//	- OutputStream은 출력할 장소를 선택하는 용도로 사용
		//	- BufferdOutputStream은 성능 업그레이드의 용도로 사용
		
		try {
			FileOutputStream fout =
							new FileOutputStream("E:\\java_io\\bufferedout.txt");

			BufferedOutputStream bout = 
							new BufferedOutputStream(fout, 1024); 
									// 버퍼의 크기가 1024인 경우
									//	- 데이터를 쓸 때 '1024 바이트' 혹은 'close()가 발생'하면  데이터가 다 모이면 출력한다.
									//	- 혹은 flush()를 호출할 때 출력한다.
			
			// 배열에 담아놓는거 자체를 Buffer (batch processing - 일괄 처리)
			byte[] data = new String(text).getBytes();
			
			bout.write(data);
			
//			for (byte b : data) {
//				bout.write(b);
//			}
			
			// 여러개의 추가 OutputStream을 사용하는 경우
			// 가장 나중에 열었던 순서대로 닫는다.
			bout.close();
			fout.close();
			System.out.println("파일 출력 끝");
			
		} catch (FileNotFoundException e) {
			System.err.println("파일 못찾음");
		} catch (IOException e) {
			System.err.println("쓰기/닫기 도중 에러 발생");
		}
		System.out.println();
		
///////////////////////////////////////////////////////////////////////////////////
		// java.io.BufferedInputStream
		// 	- InputStream을 생성자로 요구한다
		
		try {
			FileInputStream fin = new FileInputStream("E:\\java_io\\bufferedout.txt");
			BufferedInputStream bin = new BufferedInputStream(fin, 1024);
			
			// # read()의 기본 오버로딩
			//	- 한 바이트를 int값으로 읽어온다
			
			// # read(byte[]) 오버로딩
			//	- 전달한 byte[]의 크기만큼의 byte채워준다
			//	- 전달한 배열 중에 몇 byte를 채웠는지를 반환 (len)
			
			// #reat(byte[], off, len)
			//	- 전달한 byte[]중에서 off부터 len까지에만 데이터를 채워준다
			//	- 전달한 배열에 몇 byte를 채웠는지 반환한다.
			
			// 한글의 경우 byte로 받아와야함
		
			int len;
			while ((len = bin.read()) != -1) {
				System.out.print((char)len);
			}
			
			bin.close();
			fin.close();
		} catch (FileNotFoundException e) {
			System.err.println("파일 못찾음");
		} catch (IOException e) {
			System.err.println("읽기/닫기 도중 에러 발생");
		}
		System.out.println();
		
	}
}
