package quiz;

import java.io.*;

// ���̺� ����
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
			// ���丮 ���� �޼���
			File dir = new File("E:\\java_io\\game\\");
			// �������� �������� ���� �����ϱ�
			if (!dir.exists()) {
				dir.mkdir();
			}
			
			// �� ���� �ν��Ͻ��� �����Ǹ� ���Ͽ��� ������ ���� �� �������� �ʱ�ȭ�Ѵ�.
			
			try {
				fin = new FileInputStream(new File(dir, "save.sav"));
				din = new DataInputStream(fin);
				
				win = din.readInt();
				draw = din.readInt();
				lose = din.readInt();
				money = din.readInt();
				
			} catch (FileNotFoundException e) {
				// ó�� ����� �߻��ϴ� ����
				System.out.println("ó�� �����Դϴ�. ���̺� ������ �����մϴ�.");
				try {
					fout = new FileOutputStream(new File(dir, "save.sav"));
					dout = new DataOutputStream(fout);
					
					dout.writeInt(0); 	// win
					dout.writeInt(0); 	// draw
					dout.writeInt(0); 	// lose
					dout.writeInt(5000);// money
					
					// �����͸� �� �� �ν��Ͻ� �������� �ʱ�ȭ �Ѵ�.
					win = 0;
					draw = 0;
					lose = 0;
					money = 5000;
					
				} catch (Exception e1) {
					System.err.println("���̺� ���� ���� ���� : " + e1.getMessage());
				} finally {
					try {
						if (dout != null) dout.close();
						if (fout != null) fout.close();
					} catch (Exception e1) {}
				}
			} catch (IOException e) {
				System.err.println("������ �б� ���� ���� �߻� : " + e.getMessage());
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
			System.out.println("�÷��̾� ���� : ");
			System.out.printf("%d�� %d�� %d��\t%d�� ������\n", win, draw, lose, money);
			System.out.println("----------------------------");
		}

		public void execute_game() {
			br = new BufferedReader(new InputStreamReader(System.in));
			int select = -1;
			int com = 0;
			while (true) {
				try {
					System.out.println("----------------------------");
					System.out.print("����(0), ����(1), ��(2) >> ");
					select = Integer.parseInt(br.readLine());
					com = (int)(Math.random() * 3);
					
					if (select < 0 || select > 2) {
						throw new NumberFormatException("������ ������ϴ�.");
					}
					
					break;
				} catch (IOException e) {
					e.printStackTrace();
				} catch (NumberFormatException e) {
					System.out.println("����� �������ּ���");
				}
			}
			
			int timer = 100;
			try {
				System.err.print("��");
				Thread.sleep(timer);
				System.err.print("��");
				Thread.sleep(timer);
				System.err.print("! ");
				Thread.sleep(timer);
				System.err.print("��");
				Thread.sleep(timer);
				System.err.print("��");
				Thread.sleep(timer);
				System.err.print("! ");
				Thread.sleep(timer);
				System.err.print("��");
				Thread.sleep(timer);
				System.err.print("!\n");
			} catch (InterruptedException e) {}
			
			System.out.println("����� ���� : " + select);
			System.out.println("��ǻ�� ���� : " + com);
			if (select == com) {
				++draw;
				System.out.println("���º�");
			} else if (select == (com + 1) % 3) {
				++win;
				money += 500;
				System.out.println("�¸�! (+500��)");
			} else if ((select + 1) % 3 == com) {
				++lose;
				money -= 500;
				System.out.println("�й�! (-500��)");
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

	// ��ǻ�Ϳ� �����ϴ� ������ ���������� ������ ���� ��
	// �÷��̾��� ������ ���Ͽ� �����غ����� /

	// ���α׷� ����� ������ �ҷ������� ����� ������ /

	public static void main(String[] args) throws IOException {
	
		Game game = new Game();
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			game.execute_game();
			
			System.out.print("��� �Ͻðڽ��ϱ�? (Y/N)");
			if (!"Y".equals(br.readLine())) {
				game.save();
				System.out.println("----------------------------");
				System.out.println("���� ����� ����Ǿ����ϴ�.\n���α׷��� �����մϴ�.");
				break;
			}
		}
		
	}	

}
