package myobj.vehicle;

public class Test {

	public static void main(String[] args) {
		Bus bus01 = new Bus("RED", "�ÿܹ���", "kgitbank����~", 10);
		Bus bus02 = new Bus();
		System.out.println(bus01);
		System.out.println(bus02);

		bus01.change_banner("�������� ����~");
		bus02.change_banner("������ 12 ���");
		System.out.println();
		System.out.println(bus01);
		System.out.println(bus02);


		bus01.getOn();
		bus02.getOn();
	}

}
