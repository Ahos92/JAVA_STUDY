package quiz;

public class B02_conditionQuiz01 {

	public static void main(String[] args) {
		
		/*
		[ �˸��� �񱳿����� �������� ]
		    
		1. int�� ���� a�� 10���� ũ�� 20���� ���� �� true
		2. int�� ���� b�� ¦���� �� true		
		3. int�� ���� c�� 7�� ����� �� true
		4. int�� ���� hour�� 0�̻� 24�̸��̰� 12�̻��� �� true	
		5. int�� ���� d�� e�� ���̰� 30�� �� true	
		6. int�� ���� year�� 400���� ������ �������ų� 
		   �Ǵ� 4�� ������ �������� 100���� ����������� ���� �� true
		7. �μ��� ö������ 2�� ������ true
		8. �μ��� ö������ ������ 3�� ������ true  
 		9. boolean�� ���� powerOn�� false�� �� true
		10. ���ڿ� �������� str�� "yes"�� �� true
		11. �ﰢ�� A�� �����ﰢ���̸� true
	*/
	
		int a=15;
		System.out.println("1�� : "+(a > 10 && a < 20));
		
		int b=250;
		System.out.println("2�� : "+(b % 2 == 0));
		
		int c=49;
		System.out.println("3�� : "+(c % 7 == 0));
		
		int d=-10, e=20;
		System.out.println("5�� : "+(Math.abs(d-e) == 30));
		
		int hour=13;
		System.out.println("4�� : "+((!(hour < 0 && hour >= 24))&&(hour > 12)));
		
		int year=2020;
		System.out.println("6�� : "+(year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)));
		
		int minsuAge=15, chulsuAge=13;
		System.out.println("7�� : "+(minsuAge - chulsuAge == 2));
		
		int minsuBirth=7 , chulsuBirth=10;
		System.out.println("8�� : "+(chulsuBirth - minsuBirth == 3));
		
		boolean powerOn = false;
		System.out.println("9�� : "+(!powerOn));
		
		// ������ ��
		String str ="yes";
		System.out.println("10�� : "+str.equals("yes")); // ���� ���� �� equals
		// String str2 = "yes"; 				str == str2 // �ּ� ��1 true
		// String str3 = new String("yes"); 	str == str3 // �ּ� ��2 false
		
		int b1 = 3, b2 = 4, b3 = 5;
		System.out.println("11�� : "+ (b1*b1 == b2*b2 + b3*b3 ||
									   b2*b2 == b1*b1 + b3*b3 ||
									   b3*b3 == b2*b2 + b1*b1));
		
		int a1 = 30, a2 = 60, a3 = 90; //����
		System.out.println(a1 + a2 + a3 == 180 && (a1 == 90 || a2 == 90 || a3 == 90));
		
	}
}
