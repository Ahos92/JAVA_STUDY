import java.sql.Date;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class F03_Time {

	public static void main(String[] args) {
		
		System.out.println(".now()");
		// 1. now()를 통해 지금 시간의 정보를 가진 인스턴스를 생성하기
		// 날짜만 저장
		LocalDate today = LocalDate.now();
		System.out.println(today);
		
		// 시간만 저장
		LocalTime now = LocalTime.now();
		System.out.println(now);
		
		// 날짜와 시간을 저장
		LocalDateTime datetime = LocalDateTime.now(ZoneId.of("US/Samoa"));
		System.out.println(datetime);
		
		// 날짜와 시간과 경도를 저장
		ZonedDateTime zoned = ZonedDateTime.now(ZoneId.of("US/Samoa"));
		System.out.println(zoned);
	
		System.out.println("\n.of()");
		///////////////////////
		// 2. of()를 이용해서 해당 날짜,시간의 인스턴스 생성
		LocalDate birthday = LocalDate.of(1994, 11, 25);
		System.out.println(birthday);
		
		LocalTime birthtime = LocalTime.of(5, 5, 5, 1234);
		System.out.println(birthtime);
		
		LocalDateTime birthdatetime = LocalDateTime.of(birthday, birthtime);
		System.out.println(birthdatetime);
		
		ZonedDateTime birthdayzoned = ZonedDateTime.of(birthdatetime, ZoneId.of("Asia/Seoul"));
		System.out.println(birthdayzoned);
		
		System.out.println("\nInstant");
		/////////////////////////////////
		Instant start_time = Instant.now();
		System.out.println("start : " + start_time);
		Instant end_time =Instant.now();
		
		System.out.println(start_time.isAfter(end_time));
		System.out.println(start_time.isBefore(end_time));
		System.out.println(start_time.until(end_time, ChronoUnit.MILLIS));
		
		System.out.println("\n날짜,시간 계산");
		// 날짜,시간 계산하기
		today = LocalDate.now();
		
		// Calendar 클래스는 생성된 인스턴스 값 자체를 바꿀 수 있었지만,
		
		// java.time의 클래스 들은 해당 인스턴스느 변경되지 않은채로
		// 인스턴스를 생성하여 반환해준다. (시간 조작이 불가능)

		// today는 변경되지 않은채로 새로운LocalDate인스턴스가 반환된다.
		System.out.println("오늘 -5년 : " + today.minusYears(5));
		System.out.println("오늘 -4개월 : " + today.minusMonths(4));
		System.out.println("오늘 -4주 : " + today.minusWeeks(4));
		System.out.println("오늘 -6일 : " + today.minusDays(6));
		System.out.println();
		System.out.println("오늘 +5년 : " + today.plusYears(5));
		System.out.println("오늘 +4개월 : " + today.plusMonths(4));
		System.out.println("오늘 +4주 : " + today.plusWeeks(4));
		System.out.println("오늘 +6일 : " + today.plusDays(6));
		System.out.println();
		System.out.println("1990년 오늘로 변경 : " + today.withYear(1990));
		System.out.println("3월 오늘로 변경 : " + today.withMonth(3));
		System.out.println("이번 달 다섯번째 날로 변경 : " + today.withDayOfMonth(5));
		System.out.println("올해의 다섯번째 날로 변경 : " + today.withDayOfYear(5));
		System.out.println();
		System.out.println("오늘 : " + today);
		
		System.out.println();
		// ★★★★★★문자열을 날짜,시간 객체로 변환 (파싱, Parsing) 
		// yyyy-MM--dd가 가장 기본형태의 날짜문자열
		LocalDate test1 = LocalDate.parse("1234-12-12");
		System.out.println(test1.plusDays(5));
		
		// ofPattern()을 이용해 원하는 패턴을 생성할 수 있다.
		LocalDateTime test2 = LocalDateTime.parse(
									"2021년 05월 05일 19시 05분 35초",
									DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 HH시 mm분 ss초")
								);
		System.out.println(test2);
		
		// 유명한 패턴들이 상수로 정의되어있다,
		test2 = LocalDateTime.parse("2021-05-05T19:05:35",
										DateTimeFormatter.ISO_DATE_TIME);
		System.out.println(test2.plusHours(5));
		
		System.out.println();
		// java.time 객체를 문자열로 변환하기
		
		// format() 이용
		// 날짜 객체가 문자열로 돌아갈때도 DateTimeFormatter를 사용한다.
		ZonedDateTime zdt = ZonedDateTime.now();
		System.out.println("BASIC_ISO_DATE : " + zdt.format(DateTimeFormatter.BASIC_ISO_DATE));
		System.out.println("ISO_WEEK_DATE : " + zdt.format(DateTimeFormatter.ISO_WEEK_DATE));
		System.out.println("ISO_DATE : " + zdt.format(DateTimeFormatter.ISO_DATE));
		System.out.println("ISO_ZONED_DATE_TIME : " + zdt.format(DateTimeFormatter.ISO_ZONED_DATE_TIME));
		
		
		// # java.time to java.sql.date
		//	- DB에 넣을 때 사용한다
		LocalDate locald = LocalDate.of(1976, 06, 22);
		Date date = Date.valueOf(locald); // Magic happens here!
		
		java.sql.Time time = java.sql.Time.valueOf(LocalTime.of(3, 44, 30, 9981234));
		java.sql.Timestamp timestamp
					= java.sql.Timestamp.valueOf(LocalDateTime.of(2020, 11, 26, 16, 45, 59, 123456));
		
		System.out.println(date);
		System.out.println(time);
		System.out.println(timestamp);
	}		
	
}
