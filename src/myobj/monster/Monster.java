package myobj.monster;

import myobj.item.nomal.Sword;

public class Monster {
	
	String name;
	public int health_point;
	public int defense_point;
	
	public Monster(String name, int health_point, int defense_point) {
		this.name = name;
		this.health_point = health_point;
		this.defense_point = defense_point;
	}
	
	public Monster() {
		this("연습용 허수아비", 999999, 0);
	}
	//	강의
	// 변수로 클래스를 받아서 함 그안에 데미지 값을 내부에서 사용
	public void beAttacked(Sword sword) {
		
		int total_damage = sword.doAttack() - this.defense_point;
		if(sword.doAttack() <= this.defense_point) {
			total_damage = 0;
		}
		this.health_point -= total_damage;
		
		if(this.health_point <= 0) {
			System.err.printf("%s을 처치하였습니다.\n", this.name);
			this.health_point = 0;
			return;
		}
		
		System.out.printf("%s의 체력 : %d\n", this.name, this.health_point);
	}

	@Override
	public String toString() {
		return "Enemy [name=" + name + ", health_point=" + health_point + ", defense_point=" + defense_point + "]";
	}
	
	
}
