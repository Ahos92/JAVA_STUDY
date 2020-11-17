package study;
import java.io.*;

public class E04_StreamToPrimitive {

	// # Stream의 데이터를 기본형으로 변환하기
	//	- DataInputStream / DataOutputStream을 사용한다
	//	- 기본타입을 이용해 입/출력을 편하게 구현할 수 있다

	public static void main(String[] args) {

		try {
			DataOutputStream dout = new DataOutputStream(
					new BufferedOutputStream(
							new FileOutputStream("E:\\java_io\\dataout.txt")
							,2048
					)
			);

			// 데이터를 int혹은 byte[]로 변환할 필요가없다.
			// 코드값이 그대로 출력됨
			dout.writeInt(123);
			dout.writeBoolean(true);
			dout.writeFloat(123.123F);
			dout.writeDouble(432.4321);
			dout.writeLong(12345678L);
			dout.writeUTF("한글입니다");

			dout.close();
			System.out.println("파일 출력 완료");
		} catch (FileNotFoundException e) {
			System.err.println("파일을 찾을수가 없습니다.");
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println();
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		try {
			DataInputStream din = new DataInputStream(
					new BufferedInputStream(
							new FileInputStream("E:\\java_io\\dataout.txt"
							)
					)
			);

			int data01 = din.readInt();
			boolean data02 = din.readBoolean();
			float data03 = din.readFloat();
			double data04 = din.readDouble();
			long data05 = din.readLong();
			String data06 = din.readUTF();
			
			System.out.println("data01 : " + data01);
			System.out.println("data02 : " + data02);
			System.out.println("data03 : " + data03);
			System.out.println("data04 : " + data04);
			System.out.println("data05 : " + data05);
			System.out.println("data06 : " + data06);
			
			din.close();
		} catch (IOException e) {
			e.printStackTrace();
		}


	}
}
