package myobj;

public class Member {
	
	public String name; 
	public int age; 
	public String address; 
	public String PhoneNumber;
	
	public Member(String name, int age, String address, String phoneNumber) {
		this.name = name;
		this.age = age;
		this.address = address;
		this.PhoneNumber = phoneNumber;
	}
	
	public Member update(Member to_update) {
		return new Member(
						this.name,
						to_update.age == -1 ? this.age : to_update.age,
						to_update.address == null ? this.address : to_update.address,
						to_update.PhoneNumber == null ? this.PhoneNumber : to_update.PhoneNumber);
	}

	@Override
	public String toString() {
		return String.format("%s / %s / %s / %s", name, age, address, PhoneNumber);
	}

}

