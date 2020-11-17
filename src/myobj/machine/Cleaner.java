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
		System.out.println("û�ұ⸦ ����߽��ϴ�.");
		
		src.consum(power);
		
		return "���� 10��ŭ �����������ϴ�.";
	}
	
}
