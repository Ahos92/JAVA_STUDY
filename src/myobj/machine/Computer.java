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
		System.out.println("��ǻ�Ͱ� ����ǰ� �ֽ��ϴ�.");
		return "���� ��";
	}


}
