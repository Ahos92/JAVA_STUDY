package practice;

public class Anonymous {

	Vehicle filed = new Vehicle() {

		@Override
		public void run() {
			System.out.println("�����Ű� �޸��ϴ�.");
			
		}
		
	};
	
	void method1() {
		Vehicle localVar = new Car();
		
		localVar.run();
	}
	
	void method2(Vehicle v) {
		v.run();
	}
}
