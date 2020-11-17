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
	
	// 다음 리스트를 이용해 각 과일이 몇 개인지를 저장한 Map을 생성해보세요
	static List<Fruit> fruits;
	
	static{
		fruits = new ArrayList<>();
		
		for (int i = 0; i < 50; ++i) {
			fruits.add(Fruit.values()[(int)(Math.random() * 4)]);
		}
	}
	
	
	public static void main(String[] args) {
		
		Map<Fruit, Integer> fruit_count = new HashMap<>();
		
		// for Each문으로 
		for (int i = 0; i < 4; ++i) {
			fruit_count.put(Fruit.values()[i], Collections.frequency(fruits, Fruit.values()[i]));
		}
		
		System.out.println(fruit_count);
	}
	
}
