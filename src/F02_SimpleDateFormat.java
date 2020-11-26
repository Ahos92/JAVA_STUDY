import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class F02_SimpleDateFormat {

	public static void main(String[] args) {
		
		// 간편하게 날짜, 시간을 문자열로 변환하는 방법
		
		/* 
		  	y : 년
		 	M : 월
			d : 일
			D : 일 ( 월 구분이 없음 1 ~ 365)
		 	E : 요일
		 	w : 년의 몇번째 주
		 	W : 월의 몇번째 주
			
			K : 시 (0 ~ 11)
			k : 시 (1 ~ 24)
		 	H : 시 (0 ~ 23)
		 	h : 시 (1 ~ 12)
		 	m : 분
		 	s : 초
		 	S : 밀리세컨드 (1/1000초)
		 	a : 오전 / 오후
		*/
		
		SimpleDateFormat simple = new SimpleDateFormat("yyyy년 MM월 dd일");
		
		Date now = new Date();
		
		Calendar k_time = Calendar.getInstance();
		//Calendar의 Instance는 getTime()을 이용하면 Date타입으로 변환이 가능
		System.out.println("Calendar의 getTime() : " + k_time.getTime());
		
		System.out.println("Date 클래스의 toString() : " + now);
		System.out.println("simple format을 사용 : " + simple.format(now));
		System.out.println("simple format을 사용 : " + simple.format(k_time.getTime()));
		
		
	}
}
