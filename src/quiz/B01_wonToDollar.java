package quiz;

import java.util.Scanner;

public class B01_wonToDollar {

	public static void main(String[] args) {
		// �ѱ��� �Է�
		// �޷� ���Ž� �󸶸� �ް� �Ǵ��� ������ִ� ���α׷�
		// ȯ�� , �Ҽ� ��°�ڸ�, ������ 1.75%
		
		double exchangeRate = 1139.08;
		double exFeeRate = 0.0175;
		System.out.printf("### ȯ�� ���� ���α׷� ### (���� ȯ�� %.2f, ���� ������ %.2f%c)\n", exchangeRate, exFeeRate*100, '%');
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("�ݾ��� �Է��ϼ��� (��) :");
		double won = sc.nextDouble();
		
		double dollar = won/exchangeRate;
		double fee = dollar * exFeeRate;
		double resultDollar = dollar - fee;
		System.out.printf("ȯ�� �ݾ� : %.2f$\n", dollar);
		System.out.printf("������  : %.2f$\n", fee);
		System.out.printf("�� ȯ���� �ݾ� : %.2f$", resultDollar);
		
		sc.close();

	}

}
