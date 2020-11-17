package quiz;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class D07_coutnfruits {

	private enum Fruit{
		APPLE,
		BANANA,
		ORANGE,
		KIWI;
	}
	
	// ���� ����Ʈ�� �̿��� �� ������ �� �������� ������ Map�� �����غ�����
	static List<Fruit> fruits;
	
	static{
		fruits = new ArrayList<>();
		
		for (int i = 0; i < 50; ++i) {
			fruits.add(Fruit.values()[(int)(Math.random() * 4)]);
		}
	}
	
	
	public static void main(String[] args) {
		
		Map<Fruit, Integer> fruit_count = new HashMap<>();
		
		// for Each������ 
		for (int i = 0; i < 4; ++i) {
			fruit_count.put(Fruit.values()[i], Collections.frequency(fruits, Fruit.values()[i]));
		}
		
		System.out.println(fruit_count);
	}
	
}
