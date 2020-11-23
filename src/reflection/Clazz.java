package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import myobj.fruit.Apple;

public class Clazz {

	// # Ŭ���� Ŭ����
	//	- Ŭ������ ������ ���� �� �ִ� Ŭ����
	// 	- ���ϴ� Ŭ������ �ҷ��� �ش� Ŭ������ �����ִ� ����, �޼��带 ����� �� �ִ�.

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException {
		Apple apple01 = new Apple("red");

		Class c = null;
		Class c2 = apple01.getClass();

		try {
			c = Class.forName("myobj.fruit.Apple");

		} catch (ClassNotFoundException e) {
			System.out.println("Ŭ���� �̸��� Ʋ�Ƚ��ϴ�!");
			System.exit(0);
		}

		System.out.println("forName()�� �ҷ��� Class�̸� : " + c.getName());
		System.out.println("forName()�� �ҷ��� Package�̸� : " + c.getPackageName());
		System.out.println("forName()�� �ҷ��� SimpleName : " + c.getSimpleName());
		System.out.println("�̰� �������̽� �ΰ���? " + c.isInterface());
		System.out.println("�̰� �迭�ΰ��� ? " + c.isArray());
		System.out.println("�̰� �⺻�� �ΰ��� ? " + c.isPrimitive() + "\n");

		System.out.println("getClass()�� �ҷ��� Class�̸� : " + c2.getName() + "\n");


		try {
			Class c3 = Class.forName("reflection.SimpleInterface");
			System.out.println("c3�� �������̽��ΰ��� ? " + c3.isInterface() + "\n");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		// ClassŸ�� ������ ����� Ŭ�������� ���赵 ���·� �����ϰ� �ִ�.
		// 	���赵 �������� ��� 1 : forName()�� ��Ű���� ��Ȯ�� �Է�
		// 	���赵 �������� ��� 2 : ������� �ν��Ͻ����� getClass()�޼��带 ���� 


		// �� Ŭ������ � �����ڵ��� �ִ��� �˾Ƴ��� ���
		for (Constructor con : c.getConstructors()) {
			// Constructor.getParameterTypes() 
			//  - �ش� �����ڰ� ���޹޾ƾ��ϴ� �Ű��������� �迭 ���·� ��ȯ�Ѵ�.
			//	- Ÿ�Ե� Ŭ�����̱� ������, Ŭ���� Ÿ�� �迭�� ��ȯ�ȴ�.
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
		// �� Ŭ������ � �ʵ尪(����)���� �ִ��� �˾Ƴ��� ���
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
			
			// Field Ŭ������ �˾Ƴ� �� �ִ� ������
			System.out.println(calorie.getType());
			
			System.out.println("-------- color field --------");
			System.out.println("Ÿ�� : " + color.getType().getSimpleName());
			System.out.println("���� ������ :" + Modifier.toString(color.getModifiers()));
			System.out.println("������ : " + color.getName());
			
		} catch (NoSuchFieldException e) {
			System.err.println("�ʵ� ����");
			
		} catch (SecurityException e) {
			System.err.println("�� ����");
		} 
		System.out.println();
		
		// �ش� Ŭ������ �޼��� �˾ƺ��� ��
		for (Method m : c.getMethods()) {
			System.out.println("Accessible Metho : " + m);
			
		}
		
		
	}

	private static void printParameter(Class[] parameters) {

		for (int i = 0; i < parameters.length; i++) {

			System.out.printf("%d��° �Ķ������ Ÿ�� : %s(%s)\n", 
					i, 
					parameters[i].getSimpleName(),
					parameters[i].getName());

		}
	}

}
