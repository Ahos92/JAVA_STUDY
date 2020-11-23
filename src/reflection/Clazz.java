package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import myobj.fruit.Apple;

public class Clazz {

	// # 클래스 클래스
	//	- 클래스의 정보를 담을 수 있는 클래스
	// 	- 원하는 클래스를 불러서 해당 클레스에 속해있는 변수, 메서드를 사용할 수 있다.

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException {
		Apple apple01 = new Apple("red");

		Class c = null;
		Class c2 = apple01.getClass();

		try {
			c = Class.forName("myobj.fruit.Apple");

		} catch (ClassNotFoundException e) {
			System.out.println("클래스 이름이 틀렸습니다!");
			System.exit(0);
		}

		System.out.println("forName()로 불러온 Class이름 : " + c.getName());
		System.out.println("forName()로 불러온 Package이름 : " + c.getPackageName());
		System.out.println("forName()로 불러온 SimpleName : " + c.getSimpleName());
		System.out.println("이게 인터페이스 인가요? " + c.isInterface());
		System.out.println("이게 배열인가요 ? " + c.isArray());
		System.out.println("이게 기본형 인가요 ? " + c.isPrimitive() + "\n");

		System.out.println("getClass()로 불러온 Class이름 : " + c2.getName() + "\n");


		try {
			Class c3 = Class.forName("reflection.SimpleInterface");
			System.out.println("c3가 인터페이스인가요 ? " + c3.isInterface() + "\n");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		// Class타입 변수에 저장된 클래스들은 설계도 형태로 존재하고 있다.
		// 	설계도 가져오는 방법 1 : forName()에 패키지명 정확히 입력
		// 	설계도 가져오는 방법 2 : 만들어진 인스턴스에서 getClass()메서드를 실행 


		// 이 클래스에 어떤 생성자들이 있는지 알아내는 방법
		for (Constructor con : c.getConstructors()) {
			// Constructor.getParameterTypes() 
			//  - 해당 생성자가 전달받아야하는 매개변수들을 배열 형태로 반환한다.
			//	- 타입도 클래스이기 때문에, 클래스 타입 배열로 반환된다.
			printParameter(con.getParameterTypes());
			System.out.println();

		}

		Object apple02 = c.getConstructor(Class.forName("java.lang.String")).newInstance("red");

		((Apple)apple02).eat().eat().eat();
		
		
		Object apple03 = c.getConstructor(
							Class.forName("java.lang.Integer"), 
							Class.forName("java.lang.String")
						).newInstance(900, "green");
		
		((Apple)apple03).eat().eat().eat();
		
		System.out.println();
		// 이 클래스에 어떤 필드값(변수)들이 있는지 알아내는 방법
		for (Field f : c.getFields()) {
			System.out.println("Accessible : " + f);
		}
		System.out.println();
		
		for (Field f : c.getDeclaredFields()) {
			System.out.println("Declared : " + f);
		}
		System.out.println();
		
		try {
			Field calorie = c.getDeclaredField("calorie");
			Field color = c.getDeclaredField("color");
			
			// Field 클래스로 알아낼 수 있는 정보들
			System.out.println(calorie.getType());
			
			System.out.println("-------- color field --------");
			System.out.println("타입 : " + color.getType().getSimpleName());
			System.out.println("접근 제어자 :" + Modifier.toString(color.getModifiers()));
			System.out.println("변수명 : " + color.getName());
			
		} catch (NoSuchFieldException e) {
			System.err.println("필드 없음");
			
		} catch (SecurityException e) {
			System.err.println("안 보임");
		} 
		System.out.println();
		
		// 해당 클래스의 메서드 알아보는 법
		for (Method m : c.getMethods()) {
			System.out.println("Accessible Metho : " + m);
			
		}
		
		
	}

	private static void printParameter(Class[] parameters) {

		for (int i = 0; i < parameters.length; i++) {

			System.out.printf("%d번째 파라미터의 타입 : %s(%s)\n", 
					i, 
					parameters[i].getSimpleName(),
					parameters[i].getName());

		}
	}

}
