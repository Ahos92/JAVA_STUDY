package myobj.item.nomal;

public class Sword extends Nomal{

	public int attack_power;
	public int up_attack_power; 
	public int reinforce;
	public int reinforce_per; 
	
	// ���� 
	// ���ݷ� ������ ���̺� - ��ȭ���� ���ݷ������� ����ȭ
	// ��ȭ ���� Ȯ�� ���̺� - ��ȭ�� ���� Ȯ�� ����ȭ
	// ��ȭ ��� , �ı� �Ҹ��� �� �߰�
	// Ŭ������ �׽�Ʈ�� Ŭ���� �� ���� ���� �ϸ� ����
	
	public Sword(int attack_power, int up_attack_power) {
		this.attack_power = attack_power;
		this.up_attack_power = up_attack_power;
	}

	public Sword() {
		this(3, 1);
	}
	
	// �ν��Ͻ� �޼��带 ���鋚�� ����ƽ�� ������
	// 	static �޼���� �ν��Ͻ� ������ Ȱ���� �� ����.
	
	// ��ȭ�ϱ� (�������� ���� ���� ���а� ����)
	// �ִ밭ȭ �������� �����ϱ� ���� �ɸ� ��ȭ Ƚ�� ���
	
	// ����
	// 1~100 �̰� ��ȭȮ�� ���̺� �ε����� ���ؼ� ����
	
	public void doReinforce() {
		
		if(reinforce <= 3) {
			reinforcer01(0);
		}else if(reinforce <=7) {
			reinforcer01(3);
			
		}else if(reinforce < 10) {
			reinforcer02(50);	
		}else {
			System.err.println("�� �̻� ��ȭ �Ҽ� �����ϴ�.");
			
		}
		

	}

	public int reinforcer01(int per) {
		
		this.reinforce_per = (int)(Math.random() * per + 1);

		if(this.reinforce_per == 1) {
			this.attack_power += this.up_attack_power; // ���ݷ� ����
			this.reinforce += 1; // ��ȭ��
			System.out.printf("��ȭ�� ���� �Ͽ����ϴ�. +%d  %d\n", this.reinforce, this.attack_power);
		}else {
			this.attack_power -= this.up_attack_power; // ���ݷ� ����
			this.reinforce -= 1; // ��ȭ��
			System.err.printf("��ȭ�� ���� �Ͽ����ϴ�. +%d  %d\n", this.reinforce, this.attack_power);
		}

		return 1;
	}
	
	public int reinforcer02(int per) {
		
		this.reinforce_per = (int)(Math.random() * per + 1);

		if(this.reinforce_per == 1) {
			this.attack_power += this.up_attack_power; // ���ݷ� ����
			this.reinforce += 1; // ��ȭ��
			System.out.printf("��ȭ�� ���� �Ͽ����ϴ�. +%d  %d\n", this.reinforce, this.attack_power);
		}else {
			this.attack_power -= this.up_attack_power * this.reinforce;; // ���ݷ� ����
			this.reinforce = 0; // ��ȭ��
			System.err.printf("��ȭ�� ���� �Ͽ����ϴ�. +%d  %d\n", this.reinforce, this.attack_power);
		}

		return 1;
	}

	// ����
	// ������ ����� �Ǵ� ��ü�� HP���־����
	
	//	����
	// ��ȭ ���ݷ� ���� ���
	public int doAttack() {
		return this.attack_power;
	}
	 
	

}
