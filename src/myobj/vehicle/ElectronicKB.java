package myobj.vehicle;

public class ElectronicKB {

	String material;
	int voltage;
	
	static int wheel;
	static int handle;
	static {
		handle = 2;
		wheel = 2;
	}
	
	public ElectronicKB(String material, int voltage) {
		this.material = material;
		this.voltage = voltage;
	}

	public ElectronicKB() {
		this("steel", 220);
	}

}
