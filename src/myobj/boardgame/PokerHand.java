package myobj.boardgame;

import java.util.*;

public class PokerHand {
	
	// �ټ����� PokerCard�� �������־����
	
	// �ټ����� PokerCard�� ���� ���̸� ���� ������ �ϼ��ؾ���
	
	// �ٸ� PokerHand �ν��Ͻ��� ������ ���� ũ��񱳰� �����ؾ� ��
	
	// �ټ��� �� ���ϴ� ī�常 �����ϴ� ���
	
	// ī�带 ���徿 �߰��ϴ� ���

	public static void main(String[] args) {
		Deck deck = new Deck();
		CheckPoker check = new CheckPoker();
		int result = 0, count = 0;
		
		while(true) {
			++count;
			HashSet<String> hand = new HashSet<>();
			// ���� �ڵ�
			while(hand.size() != 5) {
				hand.add(deck.draw());
			}
			if(check.pedigree(hand) == 1 || check.pedigree(hand) == 2) {
			System.out.print(hand);
			result = check.pedigree(hand);
			check.resultPrint(result);
			System.out.println("Ƚ�� : "+count);
			break;
			}
		}
		
		
		
	}
	
}
