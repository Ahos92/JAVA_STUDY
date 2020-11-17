package quiz;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import myobj.boardgame.FiveDice;

public class D02_FiveDice {

	// �������� 5���� �ֻ����� ���� ���� (�ֻ��� 1~6)

	// Ǯ�Ͽ콺 ( ���� ���ڰ� 2�� / 3��)
	// ���� ��Ʈ����Ʈ ( 1234 / 2345 / 3456 )
	// ���� ��Ʈ����Ʈ ( 12345 / 23456)
	// 4���̽� ( ���� ���� 4�� )
	// 5���̽� ( ���� ���� 5�� )

	// �� �����ϴ� Ŭ���� �ۼ� �׽�Ʈ


	public static void main(String[] args) throws InterruptedException {

		FiveDice dice = new FiveDice();

		// ���� �Ŀ� ���ϴ� �ֻ����� ������ ��� �ٽ� ������ �ִ� ��� �߰�		
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			dice.roll();
			System.out.println("reRoll �� �ֻ��� ����\n>>");
			Set<Integer> rerolls = new HashSet<>();
			
			int i = -1;
			while ((i = sc.nextInt()) != -1) {
				rerolls.add(i);
			}
			System.out.print("�ٽ� ���� �ε��� : " + rerolls);
			dice.reRoll(rerolls);
			
			Thread.sleep(2000);

		}
		
	}
}
