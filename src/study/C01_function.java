package study;
import java.util.Arrays;

public class C01_function {

	// �Լ� (function) 
	// 	- ����� �̸� �����صΰ� ���߿� ������ ���°�
	// 	- �Լ� �̸� �ڿ� ()�� �ٿ��� �Լ��� ȣ���ϸ� �Լ��� ���� ����� ��ȯ�ȴ�.
	//	- ���߿� ������ ���ɼ��� �ִ� ����� �̸� ���������ν� �۾��� �ݺ��� ���δ�.
	
	// ex) ����� ������ �ٱ����� ũ�⸦ ���޹����� �ʿ��� �ٱ��� ������ �˷��ִ� ��� / �̸������ ����
	public static int appleBasket(int appleNum, int basketSize) {
		
		int result;
		
		if (appleNum % basketSize == 0) {
			result = appleNum / basketSize;
		} else {
			result = appleNum / basketSize + 1;
		}
		
		// �Լ� Ÿ���� int�̹Ƿ� ��ȯ ���� int�����Ѵ�. / return�� ������ �Լ� ����
		return result;  
	}
	
	
	// ex) ���� ������ ��� ������ �Է� ������ ���� �� ������ �˷��ִ� �Լ�
	public static int cheapPrice(int[] prices) {
		int min = 0;
		
		for(int i = 0; i < prices.length; ++i) {
			if(i == 0) {
				min = prices[i];
			}else {
				min = Math.min(min, prices[i]);
			}
		}
		
		return min;
	}
	
	// ex) ������� ��� ���� ����
	public static double avgPrice(int[] price) {
		int sum = 0;
		
		for(int i = 0; i < price.length; ++i) {
			sum += price[i];
		}
		
		return sum / (double) price.length;
	}
	
	// ex) ������ ��� ���ݵ��� 10000���� ������Ű�� �Լ�
	
	public static void raisePrice(int[] prices) {
		
		for(int i = 0; i < prices.length; ++i) {
			prices[i] += 10000;
		}
		// void Ÿ���� return �����ʴ´�. / �ص�����
	}
	
	public static void main(String[] args) {
		
		int count = appleBasket(25, 10);
		
		count = appleBasket(33, 8);
		
		System.out.println("�ʿ��� �ٱ��� ���� : " + count);
		
		int[] apples = {1000, 2000, 3000, 1500, 5000, 990}; 
		int[] apples2 = {1000, 2000, 3000, 1500, 5000, 990, 1320, 32130, 123}; 
				
		System.out.println(cheapPrice(apples));
		
		System.out.println(avgPrice(apples));
		System.out.println(avgPrice(apples2));
		
		// ��ȯ���� ���� �Լ� / ����Ʈ X
		raisePrice(apples);
		raisePrice(apples);
		raisePrice(apples);
		raisePrice(apples);
		
		System.out.println(Arrays.toString(apples));
		
	}
	
}
