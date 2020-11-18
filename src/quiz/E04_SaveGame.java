package quiz;

import java.io.*;

// 세이브 게임
public class E04_SaveGame {
	
	static class Game {

		public final static String SAVEPATH;
		public final static File SAVEDIR;
		public final static File SAVEFILE;
		
		static {
			SAVEPATH = "D:\\java_io\\game\\save.sav";
			SAVEDIR  = new File("D:\\java_io\\game");
			SAVEFILE = new File(SAVEDIR, "save.sav");
		}
		
		int win;
		int draw;
		int lose;
		int money;

		//input
		FileInputStream fin = null;
		DataInputStream din = null;
		BufferedInputStream bin = null;
		
		//output
		FileOutputStream fout = null;
		DataOutputStream dout = null;
		BufferedReader br =null;
		
		public Game() {
			// 디렉토리 생성 메서드
			File dir = new File("E:\\java_io\\game\\");
			// 존재하지 않을때만 새로 생성하기
			if (!dir.exists()) {
				dir.mkdir();
			}
			
			// 새 게임 인스턴스가 생성되면 파일에서 전적을 읽은 뒤 변수들을 초기화한다.
			
			try {
				fin = new FileInputStream(new File(dir, "save.sav"));
				din = new DataInputStream(fin);
				
				win = din.readInt();
				draw = din.readInt();
				lose = din.readInt();
				money = din.readInt();
				
			} catch (FileNotFoundException e) {
				// 처음 실행시 발생하는 예외
				System.out.println("처음 실행입니다. 세이브 파일을 생성합니다.");
				try {
					fout = new FileOutputStream(new File(dir, "save.sav"));
					dout = new DataOutputStream(fout);
					
					dout.writeInt(0); 	// win
					dout.writeInt(0); 	// draw
					dout.writeInt(0); 	// lose
					dout.writeInt(5000);// money
					
					// 데이터를 쓴 뒤 인스턴스 변수들을 초기화 한다.
					win = 0;
					draw = 0;
					lose = 0;
					money = 5000;
					
				} catch (Exception e1) {
					System.err.println("세이브 파일 생성 에러 : " + e1.getMessage());
				} finally {
					try {
						if (dout != null) dout.close();
						if (fout != null) fout.close();
					} catch (Exception e1) {}
				}
			} catch (IOException e) {
				System.err.println("데이터 읽기 도중 에러 발생 : " + e.getMessage());
			} finally {
				try {
					if (din != null) din.close();
					if (fin != null) fin.close();
				} catch (IOException e) {}
			}
		
			print_game();
			
		}
		
		public void print_game() {
			System.out.println("----------------------------");
			System.out.println("플레이어 정보 : ");
			System.out.printf("%d승 %d무 %d패\t%d원 보유중\n", win, draw, lose, money);
			System.out.println("----------------------------");
		}

		public void execute_game() {
			br = new BufferedReader(new InputStreamReader(System.in));
			int select = -1;
			int com = 0;
			while (true) {
				try {
					System.out.println("----------------------------");
					System.out.print("가위(0), 바위(1), 보(2) >> ");
					select = Integer.parseInt(br.readLine());
					com = (int)(Math.random() * 3);
					
					if (select < 0 || select > 2) {
						throw new NumberFormatException("범위를 벗어났습니다.");
					}
					
					break;
				} catch (IOException e) {
					e.printStackTrace();
				} catch (NumberFormatException e) {
					System.out.println("제대로 선택해주세요");
				}
			}
			
			int timer = 100;
			try {
				System.err.print("가");
				Thread.sleep(timer);
				System.err.print("위");
				Thread.sleep(timer);
				System.err.print("! ");
				Thread.sleep(timer);
				System.err.print("바");
				Thread.sleep(timer);
				System.err.print("위");
				Thread.sleep(timer);
				System.err.print("! ");
				Thread.sleep(timer);
				System.err.print("보");
				Thread.sleep(timer);
				System.err.print("!\n");
			} catch (InterruptedException e) {}
			
			System.out.println("사용자 선택 : " + select);
			System.out.println("컴퓨터 선택 : " + com);
			if (select == com) {
				++draw;
				System.out.println("무승부");
			} else if (select == (com + 1) % 3) {
				++win;
				money += 500;
				System.out.println("승리! (+500원)");
			} else if ((select + 1) % 3 == com) {
				++lose;
				money -= 500;
				System.out.println("패배! (-500원)");
			}
			
			print_game();
			
		}

		public void save() {
			try {
				fout = new FileOutputStream("E:\\java_io\\game\\save.sav");
				dout = new DataOutputStream(fout);
				
				dout.writeInt(win);
				dout.writeInt(draw);
				dout.writeInt(lose);
				dout.writeInt(money);
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch(IOException e){
				e.printStackTrace();
				
			} finally {
				try {
					if (dout != null) dout.close();
					if (fout != null) fout.close();
				} catch (Exception e) {}
			}
		}
		
	}

	// 컴퓨터와 진행하는 간단한 가위바위보 게임을 만든 후
	// 플레이어의 전적을 파일에 저장해보세요 /

	// 프로그램 실행시 전적을 불러오도록 만들어 보세요 /

	public static void main(String[] args) throws IOException {
	
		Game game = new Game();
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			game.execute_game();
			
			System.out.print("계속 하시겠습니까? (Y/N)");
			if (!"Y".equals(br.readLine())) {
				game.save();
				System.out.println("----------------------------");
				System.out.println("진행 결과가 저장되었습니다.\n프로그램을 종료합니다.");
				break;
			}
		}
		
	}	

}
