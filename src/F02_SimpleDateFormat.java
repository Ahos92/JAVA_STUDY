import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class F02_SimpleDateFormat {

	public static void main(String[] args) {
		
		// �����ϰ� ��¥, �ð��� ���ڿ��� ��ȯ�ϴ� ���
		
		/* 
		  	y : ��
		 	M : ��
			d : ��
			D : �� ( �� ������ ���� 1 ~ 365)
		 	E : ����
		 	w : ���� ���° ��
		 	W : ���� ���° ��
			
			K : �� (0 ~ 11)
			k : �� (1 ~ 24)
		 	H : �� (0 ~ 23)
		 	h : �� (1 ~ 12)
		 	m : ��
		 	s : ��
		 	S : �и������� (1/1000��)
		 	a : ���� / ����
		*/
		
		SimpleDateFormat simple = new SimpleDateFormat("yyyy�� MM�� dd��");
		
		Date now = new Date();
		
		Calendar k_time = Calendar.getInstance();
		//Calendar�� Instance�� getTime()�� �̿��ϸ� DateŸ������ ��ȯ�� ����
		System.out.println("Calendar�� getTime() : " + k_time.getTime());
		
		System.out.println("Date Ŭ������ toString() : " + now);
		System.out.println("simple format�� ��� : " + simple.format(now));
		System.out.println("simple format�� ��� : " + simple.format(k_time.getTime()));
		
		
	}
}
