package quiz;

public class B10_Gugudan {

	//������ ����
	// 2�� 2x1=2 2x2=4 ...
	// 3�� 3x1=3 3x2=6
	// ...
	
	//������ ����
	// 2�� 	 3�� 	4��	 ...
	// 2x1=2 3x1=3  4x1=4
	// 2x2=4 3x2=6  4x2=8
	// ...
	
	public static void main(String[] args) {

		// 1
		for(int dan = 2; dan <= 9; ++dan) {
			System.out.print(dan+"��: ");
			for(int gop = 1; gop <= 9; ++gop) {
				System.out.printf("%dx%d=%-4d", dan, gop, dan*gop);
			}
			System.out.println();
		}

		System.out.println();
		
		// 2
		for(int gop = 0; gop <= 9; ++gop) {

			for(int dan = 2; dan <= 9; ++dan) {
				
				if(gop == 0) {
					System.out.printf("%d��\t", dan);
				}else {	
					System.out.printf("%dx%d=%-4d", dan, gop, dan*gop);
				}
			}
			System.out.println();

		}
	}

}
