package myobj.fruit;

import java.util.Random;

public class Mango implements Comparable<Mango>{
	
	public int sweet;
	public int calorie;
	public int name;
	
	private static int mango_id = 0;
	
	public Mango() {
		this.calorie = (int)(Math.random() * 101 + 200);
		this.sweet = (int)(Math.random() * 11 + 10);
		
		this.name = ++mango_id; // �����ϰ� Ȯ���� �ٸ���ü���� �˷��ִ� ��
		
//		System.out.printf("%d�� ���� �����Ǿ����ϴ�. \n", mango_id);
	}
	
	/* 
	 * �� ���� ���� �����ϴ� ������
	 */
	public Mango(int calorie, int sweet, int name) {
		this.calorie = calorie;
		this.sweet = sweet;
		this.name = name;
	}
	@Override
	public int hashCode() {
		// �� ��ü�� �����ϰ� �����Ϸ��� ��� �ؾ��ұ� �� �����ϴ� ��
		//		(�⺻ ������ �� �ν��Ͻ��� �ּҰ��� �ؽ�ȭ �Ѵ�)
//		System.out.println(super.hashCode());
		// �ؽ��ڵ� ���� ���� ���� id���� �־�� (Primary Key����)
		return this.name;
	}
	
	@Override
	public String toString() {
		return String.format("%06d : %dkcal / %d%%\n", name, calorie, sweet);
	}
	
	@Override
	public int compareTo(Mango next_mango) {
		int result_calorie = this.calorie - next_mango.calorie; 
		
		return result_calorie == 0 ? this.sweet - next_mango.sweet : result_calorie;
//		if (this.calorie > next_mango.calorie) {
//			return 1;
//		} else if (this.calorie < next_mango.calorie) {
//			return -1;
//		} else if (this.calorie == next_mango.calorie) {
//			
//			if (this.sweet > next_mango.sweet) {
//				return 1;
//			} else if (this.sweet < next_mango.sweet) {
//				return -1;
//			}
//		}
//		return 0;
	}
}
