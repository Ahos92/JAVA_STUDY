import java.util.Arrays;

public class B13_Array {

	// �迭
	// 	- ���� Ÿ���� ������ �ѹ��� ������ �����ϴ� ���
	// 	- �ε����� Ȱ���� �ش� ��°�� ���� ������ �� �ִ�.
	// 		(�ݺ����� �Բ� Ȱ���ϱ� ���ϴ�)
	// 	- �ѹ� ũ�Ⱑ �������� ũ�⸦ ������ �� ����.
	//	- �ʱ�ȭ�� �ڵ����� �Ǿ��ִ�.
	//	  (���� : 0, �Ǽ� : 0.0, boolean : false, ������ : null)
	
	public static void main(String[] args) {
		
		// ���� 100���� ���Ը���� ���
		String[] fruits = new String[5];
		System.out.println(fruits[0]);
		
		int[] a = new int[100];
		
		a[0] = 10;
		a[1] = 55;
		a[2] = 60;
		a[99] = 1200; // 100�� �迭�� [99]����
		
		System.out.println(a[0]);
		System.out.println(a[1]);
		System.out.println(a[2]);
		System.out.println(a[50]);
		System.out.println(a[99]);
		
		/////////////////////////////////////////////////////////////////////////////////////////////////////
		// �迭 ���� ���
		
		// 1. Ÿ��[] �迭�̸� = new Ÿ��[�迭ũ��];
		// 2. Ÿ��[] �迭�̸� = {��1, ��2, ��3 ...};
		String[] colors = {"red", "blue", "green", "gray", "yellow"};
		
		System.out.println(colors[0]);
		System.out.println(colors[1]);
		System.out.println(colors[2]);
		System.out.println(colors[3]);
		System.out.println(colors[4]);
		
		double[] scores = {9.9, 8.8, 7.7, 6.6, 5.5, 4.4, 
							3, 2, 1, 
							'B', 'A', 
							123.123f,
							3000000000L}; // double�Ǵ¾ֵ� �ٵ�
			
		// 3. ž[] �迭�̸� = new Ÿ��[] {��1, ��2, ��3 ...};
		//   		�迭�� �䱸�ϴ� �Լ����־ 'new Ÿ��[]'�� ����
		boolean[] testResult = new boolean[] {true, false, true, false, 
											1 > 0 , 1 < 0, 1 == 0, 1 != 0};	
		// �迭�䱸 �Լ� ���� 
		String result = Arrays.toString(new int[] {1, 2, 3});
		System.out.println(result);
		
		// java.util.Arrays.toString 
		// ������ ��Ʈ������ ��ȯ!
		System.out.println(Arrays.toString(colors));
		System.out.println(Arrays.toString(scores));
		String strbool = Arrays.toString(testResult);
		System.out.println(strbool);
		
		///////////////////////////////////////////////////////////////////////////////////////////////////////
		
		// �迭�� �ݺ��� Ȱ���ϱ�
		System.out.println("colors �迭�� ���� : " + colors.length);
		
		for(int index = 0; index < colors.length; ++index) {
			System.out.printf("%d��° ���� : %s\n",	index, colors[index]);
		}
		
		///////////////////////////////////////////////////////////////////////////////////////////////
		
		// String���� char�� �迭�� ��ȯ�ϱ�
		String msg = "Hello, World!";
		
		char[] msgArr = msg.toCharArray();
		
		System.out.println(msgArr[0]);
		System.out.println(msg.charAt(1));
		
		for(int i= 0 ; i < msgArr.length; i++) {
			System.out.print(msgArr[i]);
		}
		
		
		
	}
	
}
