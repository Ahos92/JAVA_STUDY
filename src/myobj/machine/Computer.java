package myobj.machine;

public class Computer implements Electronics{

	ElectricSource src;
	
	int power;

	public Computer() {
		this.power = 80;
	}

	@Override
	public void setConnect(ElectricSource src) {
		this.src = src;
	}

	@Override
	public String execute() {
		src.consum(power);
		System.out.println("컴퓨터가 실행되고 있습니다.");
		return "실행 중";
	}


}
