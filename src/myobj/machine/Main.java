package myobj.machine;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		ElectricSource test_Battery = new ElectricSource() {
			
			@Override
			public void consum(int power) {
				System.out.printf("���͸����� %d��ŭ�� ������ �Һ��߽��ϴ�\n", power);
				
			}
		};
		 
//		Electronics a = new MicroWave("LG ���ڷ�����", 60);
//		a.setConnect(test_Battery);
//		a.execute();
//		 
//		Electronics b = new Cleaner();
//		b.setConnect(test_Battery);
//		b.execute();
		
		Scanner str_sc = new Scanner(System.in);
		
		while(true) {
			
			System.out.print("<< ����Ϸ��� ���ڱ�� ���� >>\n>");
			String select = str_sc.nextLine();
			
			Electronics e = null;
			if (select.toLowerCase().equals("cleaner")) {
				e = new Cleaner();
			}else if(select.toLowerCase().equals("microwave")){
				e = new MicroWave("���ڷ���", 90);
			}else if(select.toLowerCase().equals("computer")) {
				e = new Computer();
			}else {
				System.err.println("����ε� �Է� ���� �ƴմϴ�.");
				break;
			}
			
			e.setConnect(test_Battery);
			e.execute();
		}
	}

}
