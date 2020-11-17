package study;

public class C05_extends {

	// # Ŭ���� ���
	//	- �̸� ������ Ŭ������ �״�� ���� �޾Ƽ� ����ϴ� ��
	// 	- ������ִ� Ŭ������ �θ� Ŭ���� Ȥ�� super Ŭ���� ��� �Ѵ�.
	// 	- ��ӹ޴� Ŭ������ �ڽ� Ŭ���� Ȥ�� sub Ŭ���� ��� �Ѵ�.
	//	- �ڽ� Ŭ������ �θ�Ŭ������ ���� ��� ����� �״�� �����޴´�.
	// 	- �ڽ� Ŭ������ �θ𿡰� �������� ����� ������� �����ؼ� �� �� �ִ�.(Override)
	// 	- �ڽ� Ŭ������ �θ𿡰� ���� ����� ���Ǵ�� �߰��ؼ� �� �� �ִ�.
	public static void main(String[] args) {

		Person minsu = new Person("�μ�", 20);
		minsu.sayHi();

		Police police01 = new Police();
		Doctor doctor01 = new Doctor();
		Dentist dentist01 = new Dentist();

		police01.sayHi();
		doctor01.sayHi();
		
		/////////////////////////////////		
		// ��ü�� ������ �ڡڡ�
		//  ������� �����̱⵵ ������ ����̱⵵�ϴ�.
		// 		- Person�� �䱸�ϴ� �ڸ��� Police�� ���⵵�Ѵ� (double Ÿ�Կ� ���������� ���� �Ŷ� ���)
		dentist01.scaling(minsu);
		dentist01.scaling(police01);
		// Police�� �θ��� Person�� ��������� �������֤���
		// �ƹ��������� PersonŸ���� �� �� �ִ�(��ĳ����)
		//  �� ��ĳ������ �Ǹ� �����ִ� ��� ��� ��� => �ٽ� ����ϰ������ ���ư�����
		Person person01 = new Police();  
		// Police police02 = new Person(); <= X
		// Person�� �ڽ��� Police�� �𸣴� ����� ���� �Ҽ� �ֱ� ������
		// �ڽ�Ÿ���� �ɼ� ����.(�ٿ� ĳ����)
		
		// 	�ٿ� ĳ������ Ư���� ��츦 �����ϰ�� �Ұ���
		// Ư���� ��� -> ���� ���������� �ν��Ͻ��� �ٽ� Police�� �ٿ�ĳ���� �� �� �ִ�.
		// (��ĳ������ �ѹ��̶� ������ �ٿ�ĳ���� ����)
		Police police = (Police) person01;
		
		Person person02 = new Dentist();
		Police police2 = (Police) person02; // <= X
		////////////////////////////////////
	}
}

class Person {
	String name; 
	int age;

	public Person() {
		this("default name", 0);
	}

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public void sayHi() { 
		System.out.printf("�ȳ�! �� �̸��� %s�̰� ���̴� %d���̾�.\n", name, age);
	}

}

class Police extends Person{
	String name;
	// 1. ��ӹ��� ��ü�� �θ��� �����ڸ� ���� ���� ȣ���ؾ��Ѵ�.
	//  �� �θ��� �����ڰ� �Ű������� �䱸�ϴ� �����ڸ� �ִٸ� 
	//		�ݵ�� ���� ä������Ѵ�.
	public Police() {
		super("�����", 25);

		// this() ���� �ν��Ͻ��� ���� Ŭ���� ������
		// super() ���� �ν��Ͻ��� �θ� Ŭ���� ������

		System.out.println("super.name : "+super.name);
		System.out.println("this.name : "+this.name);
	}

}

class Doctor extends Person {
	// �⺻ �����ڰ� �ִ� �θ�Ŭ������ ��ӹ޴� ��� �ڵ�����
	// �θ��� �⺻�����ڸ� ȣ���Ѵ�.

	// PersonŬ������ sayHi�� ���ļ� ����ϰ��ִ�.
	@Override
	public void sayHi() {
		System.out.printf("�ȳ��ϼ���. ���� %s�Դϴ�.\n", name);
		// super.sayHi(); 
		// �θ��� �޼���� ��������� �ƴϰ� �״�� ��� ����
	}
}

class Dentist extends Doctor {

	public void scaling(Person target) {
		System.out.printf("ġ���ǻ� %s�� %s���� �����ϸ��� ������ϴ�.\n", name, target.name);

	}
}