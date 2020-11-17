package myobj.item.nomal;

public class Sword extends Nomal{

	public int attack_power;
	public int up_attack_power; 
	public int reinforce;
	public int reinforce_per; 
	
	// 강의 
	// 공격력 증가량 테이블 - 강화마다 공격력증가량 세분화
	// 강화 성공 확률 테이블 - 강화도 마다 확률 세분화
	// 강화 비용 , 파괴 불리언 등 추가
	// 클래스의 테스트는 클래스 에 메인 만들어서 하면 간편
	
	public Sword(int attack_power, int up_attack_power) {
		this.attack_power = attack_power;
		this.up_attack_power = up_attack_power;
	}

	public Sword() {
		this(3, 1);
	}
	
	// 인스턴스 메서드를 만들떄는 스태틱을 뺴야함
	// 	static 메서드는 인스턴스 변수를 활용할 수 없다.
	
	// 강화하기 (성공률에 따라 성공 실패가 적용)
	// 최대강화 레벨까지 도달하기 까지 걸린 강화 횟수 출력
	
	// 강의
	// 1~100 뽑고 강화확률 테이블에 인덱스랑 비교해서 적용
	
	public void doReinforce() {
		
		if(reinforce <= 3) {
			reinforcer01(0);
		}else if(reinforce <=7) {
			reinforcer01(3);
			
		}else if(reinforce < 10) {
			reinforcer02(50);	
		}else {
			System.err.println("더 이상 강화 할수 없습니다.");
			
		}
		

	}

	public int reinforcer01(int per) {
		
		this.reinforce_per = (int)(Math.random() * per + 1);

		if(this.reinforce_per == 1) {
			this.attack_power += this.up_attack_power; // 공격력 증가
			this.reinforce += 1; // 강화도
			System.out.printf("강화가 성공 하였습니다. +%d  %d\n", this.reinforce, this.attack_power);
		}else {
			this.attack_power -= this.up_attack_power; // 공격력 증가
			this.reinforce -= 1; // 강화도
			System.err.printf("강화가 실패 하였습니다. +%d  %d\n", this.reinforce, this.attack_power);
		}

		return 1;
	}
	
	public int reinforcer02(int per) {
		
		this.reinforce_per = (int)(Math.random() * per + 1);

		if(this.reinforce_per == 1) {
			this.attack_power += this.up_attack_power; // 공격력 증가
			this.reinforce += 1; // 강화도
			System.out.printf("강화가 성공 하였습니다. +%d  %d\n", this.reinforce, this.attack_power);
		}else {
			this.attack_power -= this.up_attack_power * this.reinforce;; // 공격력 증가
			this.reinforce = 0; // 강화도
			System.err.printf("강화가 실패 하였습니다. +%d  %d\n", this.reinforce, this.attack_power);
		}

		return 1;
	}

	// 공격
	// 공격의 대상이 되는 객체는 HP가있어야함
	
	//	강의
	// 강화 공격력 배율 계싼
	public int doAttack() {
		return this.attack_power;
	}
	 
	

}
