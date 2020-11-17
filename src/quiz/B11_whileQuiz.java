package quiz;

public class B11_whileQuiz {
	
	//반드시 while문을 이용
	
	// 1 부터 100까지의 3의 배수 총합
	
	// 2 200부터 1까지 출력
	
	// 3 1부터 200까지의 숫자중 2의 배수도 아니고 3의 배수도 아닌 숫자들의 총합을 구해보세요
	public static void main(String[] args) {
		
		int i = 0, sum = 0;
		while(i < 100) {
			i++;
			if(i % 3 == 0) {
				sum += i;
			}
		}
		System.out.printf("1부터 100까지 3의 배수 합 : %d\n\n", sum);
		
		int j = 200, num, line= 0;
		while(j > 0) {
			num = j;
			j--;
			line++;
			System.out.printf("%-4d", num);
			if(line == 20) {
				System.out.println();
				line = 0;
			}
		}
		System.out.println();
		
		int k = 0;
		sum = 0;
		while(k < 200) {
			k++;
			if(k % 2 == 0 || k % 3 == 0) {
				continue;
			}
			sum += k ; 
		}
		System.out.printf("2의배수도 아니고 3의배수도 아닌 1~200의 합 : %d", sum);
	}

}
