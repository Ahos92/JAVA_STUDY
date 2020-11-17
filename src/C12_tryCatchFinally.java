import java.util.IllegalFormatConversionException;

public class C12_tryCatchFinally {

	// # ���� ó��
	//	- ������� �˰� �ִ� ���� �۾����� ����(Exception) ��� �θ���
	//	- ���������� Ʋ������ ���ܰ� �ƴ϶� �����̴�.
	// 	- ���α׷��Ӱ� ���ܿ� ���� ������ ��ġ�� ���� �شٸ� 
	//    ���α׷��� �������������ʰ� ����ؼ� ����
	
	// # try
	//	- ���ܰ� �߻��� �� �ִ� �ڵ带 try���ο� ����
	//	- ���ܰ� �߻����� ������ ��� ���� ����
	// # catch
	//	- ���ܰ� �߻��ڴٸ� �ش� ���ܸ� �޴� catch������ �Ѿ�Եȴ�.
	//	- catch���� ������ ��밡��
	//	- catch���� ù ��° �Ű������� ���� ���� ��ü�� ���޵ȴ�. ex> getMessage();, e.printStackTrace();
	//	- ExceptionŸ���� catch���� ��� ���ܸ� catch�� �� �ִ�.
	//		�� Exception - ��� ����Ÿ���� �θ�Ÿ��
	
	// # finally
	//	- try�� ������ ���� �߻� ���ο� ������� ������ ����Ǵ� ����
	
	public static void main(String[] args) {
		int[] abc = new int[10];
		
		try {
			System.out.println("try���� ����");
			
			System.out.println(abc[10]); // ���� �߻� �ڵ�
			
//			System.out.println(Integer.parseInt("abc"));// ���� �߻� �ڵ� 2

//			System.err.printf("%d", "abc"); // ���� �߻� �ڵ� 3 
			
			System.out.println("try���� ������");
		} catch(Exception e) {
			System.out.println("catch : "+e.getMessage()); // ��� ���� ó��
		} finally {
			System.out.println("===================");
			System.out.println("\t /)/)");
			System.out.println("\t(  ..)");
			System.out.println("\t(  >��");
			System.out.println(" Have a Good Time.");
			System.out.println("===================");
		}
		
//		catch (ArrayIndexOutOfBoundsException e) {
//			System.out.println("�ε��� ���� : catch�� ����"); // ���� �߻� 1
//		} catch (NumberFormatException e) {
//			System.out.println("���ڰ� �ƴ� : catch�� ����"); // ���� �߻� 2
//		} catch (IllegalFormatConversionException e) {
//			System.out.println("catch�� ���� : "+e.getMessage()); // ���� �߻� 3
//			
//			// ���� �߻��� �⺻����
//			// e.printStackTrace();
//			// System.exit(0);
//		}
//		
		System.out.println("������� �� ����Ǿ����ϴ�.");
	}
}
