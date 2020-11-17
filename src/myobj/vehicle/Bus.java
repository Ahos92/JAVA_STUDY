package myobj.vehicle;

public class Bus {

	String color = "green";
	String purpose = "�ó�����";
	String banner = "��ȭ�ּ��� 000 - 0000 - 0000";
	int max_passenger = 50;
	
	void change_banner(String text) {
		this.banner = text;
		System.out.printf("���� \"%s\"�� ����Ǿ����ϴ�.\n", this.banner);
	}
	
	void getOn() {
		this.max_passenger -= 1;
		if(max_passenger < 0) {
			this.max_passenger += 1;
			System.err.println("�� �̻� Ż�� �����ϴ�.");
			System.out.printf("�� �ڸ� : %d\n", this.max_passenger);
			return;
		}
	
		System.out.printf("�°��� �����ϴ�. �� �ڸ� : %d\n", this.max_passenger);
	}

	
	
	public Bus() {
		
	}

	public Bus(String color, String purpose, String banner, int max_passenger) {
		super();
		this.color = color;
		this.purpose = purpose;
		this.banner = banner;
		this.max_passenger = max_passenger;
	}

	@Override
	public String toString() {
		return "Bus [color=" + color + ", purpose=" + purpose + ", banner="
				+ banner +", max_passenger=" + max_passenger + "]\n";
	}

	
	

	
	
	
}
