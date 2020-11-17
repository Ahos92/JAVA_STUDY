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
		
		this.name = ++mango_id; // 유일하게 확실히 다른객체란걸 알려주는 것
		
//		System.out.printf("%d번 망고가 생성되었습니다. \n", mango_id);
	}
	
	/* 
	 * 비교 대상용 망고를 생성하는 생성자
	 */
	public Mango(int calorie, int sweet, int name) {
		this.calorie = calorie;
		this.sweet = sweet;
		this.name = name;
	}
	@Override
	public int hashCode() {
		// 이 객체를 유일하게 구분하려면 어떻게 해야할까 를 정의하는 곳
		//		(기본 동작은 이 인스턴스의 주소값을 해시화 한다)
//		System.out.println(super.hashCode());
		// 해쉬코드 값에 내가 만든 id값을 넣어도됨 (Primary Key개념)
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
