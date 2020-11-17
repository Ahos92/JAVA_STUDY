package quiz;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import myobj.fruit.Mango;

public class D04_MaxMango {

	// 칼로리가 랜덤으로 설정되는 망고 클래스를 하나 생성하고
	// 100개의 망고중 가장 칼로리가 높은 망고를 선택해보세요
	
	// 칼로리가 같은 경우 더 높은 당도를 가진 인스턴스를 선택해야 함
	public static void main(String[] args) {
		
		LinkedList<Mango> mango_box = new LinkedList<>();
		
		for (int i = 0; i < 100; ++i) {
			mango_box.add(new Mango());
		}
		
		System.out.println(mango_box);
	
		System.out.println(Collections.max(mango_box));
	
//		Collections.sort(mango_box);
//		System.out.println(mango_box);
//		System.out.println(mango_box.peekLast());
		
	}
}
