package study;
import java.io.*;

public class E04_StreamToPrimitive {

	// # Stream�� �����͸� �⺻������ ��ȯ�ϱ�
	//	- DataInputStream / DataOutputStream�� ����Ѵ�
	//	- �⺻Ÿ���� �̿��� ��/����� ���ϰ� ������ �� �ִ�

	public static void main(String[] args) {

		try {
			DataOutputStream dout = new DataOutputStream(
					new BufferedOutputStream(
							new FileOutputStream("E:\\java_io\\dataout.txt")
							,2048
					)
			);

			// �����͸� intȤ�� byte[]�� ��ȯ�� �ʿ䰡����.
			// �ڵ尪�� �״�� ��µ�
			dout.writeInt(123);
			dout.writeBoolean(true);
			dout.writeFloat(123.123F);
			dout.writeDouble(432.4321);
			dout.writeLong(12345678L);
			dout.writeUTF("�ѱ��Դϴ�");

			dout.close();
			System.out.println("���� ��� �Ϸ�");
		} catch (FileNotFoundException e) {
			System.err.println("������ ã������ �����ϴ�.");
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
