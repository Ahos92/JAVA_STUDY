package quiz;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import myobj.fruit.Mango;

public class D04_MaxMango {

	// Į�θ��� �������� �����Ǵ� ���� Ŭ������ �ϳ� �����ϰ�
	// 100���� ������ ���� Į�θ��� ���� ���� �����غ�����
	
	// Į�θ��� ���� ��� �� ���� �絵�� ���� �ν��Ͻ��� �����ؾ� ��
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
