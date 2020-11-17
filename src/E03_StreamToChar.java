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

	// # Reader / Writer�� ���� Ŭ��������
	//	Stream���� ���� �����͸� ���ڷ� ��ȯ�ϴ� Ŭ�������̴�.
	
	// # ���α׷��Ӱ� �����͸� ���ڷ� ���ϰ� �ٷ�� ���� ��
	//	InputStream/OutputStream�� Reader/Writer Ŭ������
	//	�ѹ� �� ���μ� ����Ѵ�.
	//	������ ���� ���
	
	public static void main(String[] args) {
		 
		// # abstract class Reader
		//	- Reader�� ��ӹ޾� ������ Ŭ������
		//	- BufferedRedaer, InputStreamReader, FileReader....
		//	- Stream���� ���� �����͸� ���ڷ� �籸���Ͽ� ���α׷��ӿ��� �����Ѵ�.
		//	- �ڵ� �����͸� ���ڷ� �籸���ҽ� ����� Charset�� �˸°� �������� ������ ���ڰ� ������. (����� Ŭ���� ����)
		
		try {							
		
			// 3�ܰ� ���׷��̵�
			FileInputStream fin = new FileInputStream("E:\\java_io\\bufferedout.txt");
			
			InputStreamReader ir = new InputStreamReader(fin, "EUC-KR"); // ���ڵ� ���� ��� �ι�° ���ڷ� Charset.forName()�� �־��ش�.
			
			// ���� 2�ܰ� ���� �ϰ� �ٷ� BufferedReader			���ڵ� ���� ��� �ι�° ���ڷ� Charset.forName()�� �־��ش�.
			FileReader fr = new FileReader("E:\\java_io\\bufferedout.txt");
			
			BufferedReader br = new BufferedReader(ir, 2048);
		
			// Reader Ŭ������ read�� ���� byte�� �ƴ϶� 
			//	���� char�� �д´� => �ѱ��� ��������� �´�.
			int ch;
			while ((ch = br.read()) != -1) {
				System.out.print((char)ch);
			}
			
			br.close();
			ir.close();
			fin.close();
			fr.close();
			System.out.println("�бⰡ ��� �������ϴ�.");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println();
		
//////////////////////////////////////////////////////////////////////////////////////////
		 
		// # abstract class Writer
		//	- ���Ͽ� ���ڸ� �����Ҷ� charset�� ������ �� �ֵ�.
		//	- ���α׷��Ӱ� ���� ���ϰ� OutputStream�� �̿��� �� �ִ�.
		
		try {
			long start_time = System.currentTimeMillis();
			// �ܰ躰�� ���׷��̵�
			FileOutputStream fout = new FileOutputStream("E:\\java_io\\bufferedout.txt");
			
			// OutputStream��Ŀ��� Writer�� ��ȯ ( byte -> char )
			OutputStreamWriter ow = new OutputStreamWriter(fout);
			
			// ���� 2�ܰ� ���� ���� �Ҽ��ִ� Ŭ����
			FileWriter fw = new FileWriter("E:\\java_io\\bufferedout.txt");
			
			// Buffered: ���� ���
			BufferedWriter bw = new BufferedWriter(ow, 4096);
			
			// Print : ���α׷��ӿ��� ���� print�޼������ ����Ҽ� ����
			PrintWriter pw = new PrintWriter(bw);
			
			for (int i = 0; i < 10000; i++) {
				// �ֿܼ� ����ϴ� ���� ���Ͽ� ����� �� �ִ�.
				pw.printf("[%d/%d %d:%d] �ȳ��ϼ��� �ݰ����ϴ�\n", 1, 2, 3, 4);
			} 
			
			pw.close();
			bw.close();
			fw.close();
			ow.close();
			fout.close();
			System.out.println("��� �Ϸ� - "
					+ (System.currentTimeMillis() - start_time) + "ms");
		} catch (FileNotFoundException e) {
			System.err.println("������ ��ã�ҽ��ϴ�.");
		} catch (UnsupportedEncodingException e) {
			System.err.println("���ڵ��� �߸� �Ǿ����ϴ�.");
		} catch (IOException e) {
			System.err.println("���� ���� ���� �߻�");
		}
	}
}
