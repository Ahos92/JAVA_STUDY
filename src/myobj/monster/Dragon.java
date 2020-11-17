package myobj.monster;

import myobj.item.nomal.Sword;
import myobj.item.nomal.TwohandSword;

public class Dragon	extends Monster {

	public Dragon() {
		super("¿ë", 10000, 100);
	}
	
	@Override
	public void beAttacked(Sword sword) {
		// TODO Auto-generated method stub
		super.beAttacked(sword);
	}

}
