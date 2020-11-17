package myobj.test;

import myobj.item.nomal.Sword;
import myobj.item.nomal.TwohandSword;
import myobj.monster.Dragon;
import myobj.monster.Monster;

public class Test {

	public static void main(String[] args) {

		Sword nomal_sword = new Sword(5, 2);

		int i = 0;
		while(true) {
			i++;
			System.out.printf("%d 번째 : ", i);
			nomal_sword.doReinforce();	
			if(nomal_sword.reinforce == 10) {
				break;
			}
		}

		Monster enemy01 = new Monster("슬라임", 200, 10);
		System.out.println();
		System.out.println(enemy01);

		// 보통 이쪽을 선호
		i = 0;
		while(true) {
			i++;
			enemy01.beAttacked(nomal_sword);

			if(enemy01.health_point == 0) {
				break;
			}
		}

		Monster enemy02 = new Monster("코볼트", 10, 24);
		System.out.println();
		System.out.println(enemy02);
		// 보통 이쪽을 선호
		i = 0;
		while(true) {
			i++;
			enemy02.beAttacked(nomal_sword);

			if(enemy02.health_point == 0) {
				break;
			}
		}

		Dragon dr =  new Dragon();

		System.out.println(dr.health_point);

		Sword s = new Sword(500, 2);
		dr.beAttacked(s);
		dr.beAttacked(s);

		TwohandSword ts = new TwohandSword();
		dr.beAttacked(ts);
		dr.beAttacked(ts);
	}

}
