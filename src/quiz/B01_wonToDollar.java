package quiz;

import java.util.Scanner;

public class B01_wonToDollar {

	public static void main(String[] args) {
		// 한국돈 입력
		// 달러 구매시 얼마를 받게 되는지 계싼해주는 프로그램
		// 환율 , 소수 둘째자리, 수수료 1.75%
		
		double exchangeRate = 1139.08;
		double exFeeRate = 0.0175;
		System.out.printf("### 환전 예상 프로그램 ### (현재 환율 %.2f, 현재 수수료 %.2f%c)\n", exchangeRate, exFeeRate*100, '%');
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("금액을 입력하세요 (원) :");
		double won = sc.nextDouble();
		
		double dollar = won/exchangeRate;
		double fee = dollar * exFeeRate;
		double resultDollar = dollar - fee;
		System.out.printf("환전 금액 : %.2f$\n", dollar);
		System.out.printf("수수료  : %.2f$\n", fee);
		System.out.printf("총 환전된 금액 : %.2f$", resultDollar);
		
		sc.close();

	}

}
