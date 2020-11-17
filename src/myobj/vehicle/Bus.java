package myobj.vehicle;

public class Bus {

	String color = "green";
	String purpose = "시내버스";
	String banner = "전화주세요 000 - 0000 - 0000";
	int max_passenger = 50;
	
	void change_banner(String text) {
		this.banner = text;
		System.out.printf("광고가 \"%s\"로 변경되었습니다.\n", this.banner);
	}
	
	void getOn() {
		this.max_passenger -= 1;
		if(max_passenger < 0) {
			this.max_passenger += 1;
			System.err.println("더 이상 탈수 없습니다.");
			System.out.printf("빈 자리 : %d\n", this.max_passenger);
			return;
		}
	
		System.out.printf("승객이 탔습니다. 빈 자리 : %d\n", this.max_passenger);
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
