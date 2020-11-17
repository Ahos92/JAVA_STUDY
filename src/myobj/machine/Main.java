package myobj.machine;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		ElectricSource test_Battery = new ElectricSource() {
			
			@Override
			public void consum(int power) {
				System.out.printf("배터리에서 %d만큼의 전력을 소비했습니다\n", power);
				
			}
		};
		 
//		Electronics a = new MicroWave("LG 전자레인지", 60);
//		a.setConnect(test_Battery);
//		a.execute();
//		 
//		Electronics b = new Cleaner();
//		b.setConnect(test_Battery);
//		b.execute();
		
		Scanner str_sc = new Scanner(System.in);
		
		while(true) {
			
			System.out.print("<< 사용하려는 전자기기 선택 >>\n>");
			String select = str_sc.nextLine();
			
			Electronics e = null;
			if (select.toLowerCase().equals("cleaner")) {
				e = new Cleaner();
			}else if(select.toLowerCase().equals("microwave")){
				e = new MicroWave("전자렌지", 90);
			}else if(select.toLowerCase().equals("computer")) {
				e = new Computer();
			}else {
				System.err.println("제대로된 입력 값이 아닙니다.");
				break;
			}
			
			e.setConnect(test_Battery);
			e.execute();
		}
	}

}
