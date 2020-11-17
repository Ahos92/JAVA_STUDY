package myobj.machine;

public class Cleaner implements Electronics {

	ElectricSource src;
	
	int power;
	
	public Cleaner() {
		this.power = 30;
	}
	
	@Override
	public void setConnect(ElectricSource src) {
		this.src = src;
	}
	
	@Override
	public String execute() {
		System.out.println("청소기를 사용했습니다.");
		
		src.consum(power);
		
		return "방이 10만큼 깨끗해졌습니다.";
	}
	
}
