import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class F01_Calendar {

	
	public static void main(String[] args) {
		
		// 자바로 날짜(시간) 다루기
		//	java.util.Date
		//	java.util.Calendar
		
		F01_Calendar c = new F01_Calendar();
		
		// 1970년 1월 1일 이후로 시간이 얼마나 흘렀는지를 통해 시간을 표현
		System.out.println(System.currentTimeMillis());
		
		Date now = new Date();
		System.out.println(now);
		
		// Date 클래스는 전부 deprecated 상태이다 (날짜를 담아놓는 용도로만 사용한다)
		now.getDay();
		
				
		// # Calendar 클래스
		//	- 달력을 표현한 클래스
		//	- 날짜를 쉽게 계산할 수 있는 기능들이 모여있다.
		//	- 생성자 대신 getInstance()라는 함수를 통해 인스턴스를 받아온다.
		Calendar now2 = Calendar.getInstance();
		
		System.out.println(now2);
		System.out.println();
		
		// # TimeZone 클래스
		//	- 경도를 설정할 수 있는 클래스
//		for (String zone_id : TimeZone.getAvailableIDs()) {
//			System.out.println(zone_id);
//		}
		
		TimeZone zone1 = TimeZone.getTimeZone("US/Samoa");
		
		Calendar k_time = Calendar.getInstance();
		
		int k_year = k_time.get(Calendar.YEAR);
		int k_month = k_time.get(Calendar.MONDAY) + 1;
		int k_day = k_time.get(Calendar.DATE);
		int k_dow = k_time.get(Calendar.DAY_OF_WEEK);
		int k_hour = k_time.get(Calendar.HOUR);
		int k_minute = k_time.get(Calendar.MINUTE);
		int k_second = k_time.get(Calendar.SECOND);
		System.out.printf("K-Time : %d/%02d/%02d %s %d:%d:%d\n\n",
							k_year, k_month, k_day,
							c.getStrWeek(k_dow),
							k_hour, k_minute, k_second);
		
		Calendar samoa_time = Calendar.getInstance(zone1);
		System.out.println(samoa_time);
		
		
		// # Calendar의 set메서드로 해당 필드를 내가 원하는 값으로 변경할 수 있다.
		
		// 	- MONTH를 10월로 변경
		samoa_time.set(Calendar.MONTH, 10 - 1);
		samoa_time.set(Calendar.DATE, 20);
		
		///////////////////////////
		// Calendar의 get(field) 로 꺼낼수 있다.
		int samoa_year = samoa_time.get(Calendar.YEAR);
		// Calnedar는 Month만 1월이 0이다.
		int samoa_month = samoa_time.get(Calendar.MONTH) + 1;
		int samoa_date = samoa_time.get(Calendar.DATE);

		int samoa_hour = samoa_time.get(Calendar.HOUR);
		int samoa_minute = samoa_time.get(Calendar.MINUTE);
		int samoa_second = samoa_time.get(Calendar.SECOND);

		int samoa_am_pm = samoa_time.get(Calendar.AM_PM);
		
		//	DAY_OF_WEEK : 요일 
		int samoa_week = samoa_time.get(Calendar.DAY_OF_WEEK);
		
		// WEEK_OF_MONTH : 몇번째 주 인가
		int samoa_wom = samoa_time.get(Calendar.WEEK_OF_MONTH);
		
		// DAY_OF_WEEK_IN_MONTH : 이번 요일이 몇 번째 요일인가?
		int samoa_dowim = samoa_time.get(Calendar.DAY_OF_WEEK_IN_MONTH);
		
		
		System.out.printf("오늘은 %d번째 %s요일 입니다.\n", samoa_dowim, c.getStrWeek(samoa_week));
		System.out.printf("samoa time - %d/%02d/%02d %d:%d:%d %s %s %d번째 주\n",
				samoa_year, samoa_month, samoa_date,
				samoa_hour, samoa_minute, samoa_second,
				samoa_am_pm == 0 ? "AM" : "PM",
				c.getStrWeek(samoa_week), samoa_wom);
		
		
	}
	
	public String getStrWeek(int calendar_dow) {
		switch (calendar_dow) {
		case Calendar.MONDAY:
			return "월";
		case Calendar.TUESDAY:
			return "화";
		case Calendar.WEDNESDAY:
			return "수";
		case Calendar.THURSDAY:
			return "목";
		case Calendar.FRIDAY:
			return "금";
		case Calendar.SATURDAY:
			return "토";
		case Calendar.SUNDAY:
			return "일";
		default:
			return null;
		}
		
	}
}
