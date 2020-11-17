package myobj.vehicle;

public class Test {

	public static void main(String[] args) {
		Bus bus01 = new Bus("RED", "시외버스", "kgitbank광고~", 10);
		Bus bus02 = new Bus();
		System.out.println(bus01);
		System.out.println(bus02);

		bus01.change_banner("국비지원 광고~");
		bus02.change_banner("아이폰 12 출시");
		System.out.println();
		System.out.println(bus01);
		System.out.println(bus02);


		bus01.getOn();
		bus02.getOn();
	}

}
