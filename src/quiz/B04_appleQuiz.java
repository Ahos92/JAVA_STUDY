package quiz;

//Ctrl + Shift + O �ڵ� import
import java.util.Scanner;

public class B04_appleQuiz {

	// ����� 10���� ���� �� �ִ� �ٱ��ϰ� �ִ�
	// ����ڰ� ����� ������ �Է¹����� �ʿ��� �ٱ����� ������ ������ִ� ���ǽ�
	
	// ����� double�� �޾Ƽ� �Ҽ��� �ø����ε� ����
	// ���Ҽ��ִ°� ������ �����
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.print("����� ���� �Է� : ");
		int apple = sc.nextInt();
		int bucket;
		// ���� �� final �� �����Ұ����� ������ �ȴ�.
		
		if(apple%10 == 0) {
			bucket = apple/10;
		} else {
			bucket = apple/10+1;
		}
		System.out.println("�ٱ����� ���� : "+bucket);
		
		sc.close();
		
	}

}
