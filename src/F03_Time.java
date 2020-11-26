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
		// 1. now()�� ���� ���� �ð��� ������ ���� �ν��Ͻ��� �����ϱ�
		// ��¥�� ����
		LocalDate today = LocalDate.now();
		System.out.println(today);
		
		// �ð��� ����
		LocalTime now = LocalTime.now();
		System.out.println(now);
		
		// ��¥�� �ð��� ����
		LocalDateTime datetime = LocalDateTime.now(ZoneId.of("US/Samoa"));
		System.out.println(datetime);
		
		// ��¥�� �ð��� �浵�� ����
		ZonedDateTime zoned = ZonedDateTime.now(ZoneId.of("US/Samoa"));
		System.out.println(zoned);
	
		System.out.println("\n.of()");
		///////////////////////
		// 2. of()�� �̿��ؼ� �ش� ��¥,�ð��� �ν��Ͻ� ����
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
		
		System.out.println("\n��¥,�ð� ���");
		// ��¥,�ð� ����ϱ�
		today = LocalDate.now();
		
		// Calendar Ŭ������ ������ �ν��Ͻ� �� ��ü�� �ٲ� �� �־�����,
		
		// java.time�� Ŭ���� ���� �ش� �ν��Ͻ��� ������� ����ä��
		// �ν��Ͻ��� �����Ͽ� ��ȯ���ش�. (�ð� ������ �Ұ���)

		// today�� ������� ����ä�� ���ο�LocalDate�ν��Ͻ��� ��ȯ�ȴ�.
		System.out.println("���� -5�� : " + today.minusYears(5));
		System.out.println("���� -4���� : " + today.minusMonths(4));
		System.out.println("���� -4�� : " + today.minusWeeks(4));
		System.out.println("���� -6�� : " + today.minusDays(6));
		System.out.println();
		System.out.println("���� +5�� : " + today.plusYears(5));
		System.out.println("���� +4���� : " + today.plusMonths(4));
		System.out.println("���� +4�� : " + today.plusWeeks(4));
		System.out.println("���� +6�� : " + today.plusDays(6));
		System.out.println();
		System.out.println("1990�� ���÷� ���� : " + today.withYear(1990));
		System.out.println("3�� ���÷� ���� : " + today.withMonth(3));
		System.out.println("�̹� �� �ټ���° ���� ���� : " + today.withDayOfMonth(5));
		System.out.println("������ �ټ���° ���� ���� : " + today.withDayOfYear(5));
		System.out.println();
		System.out.println("���� : " + today);
		
		System.out.println();
		// �ڡڡڡڡڡڹ��ڿ��� ��¥,�ð� ��ü�� ��ȯ (�Ľ�, Parsing) 
		// yyyy-MM--dd�� ���� �⺻������ ��¥���ڿ�
		LocalDate test1 = LocalDate.parse("1234-12-12");
		System.out.println(test1.plusDays(5));
		
		// ofPattern()�� �̿��� ���ϴ� ������ ������ �� �ִ�.
		LocalDateTime test2 = LocalDateTime.parse(
									"2021�� 05�� 05�� 19�� 05�� 35��",
									DateTimeFormatter.ofPattern("yyyy�� MM�� dd�� HH�� mm�� ss��")
								);
		System.out.println(test2);
		
		// ������ ���ϵ��� ����� ���ǵǾ��ִ�,
		test2 = LocalDateTime.parse("2021-05-05T19:05:35",
										DateTimeFormatter.ISO_DATE_TIME);
		System.out.println(test2.plusHours(5));
		
		System.out.println();
		// java.time ��ü�� ���ڿ��� ��ȯ�ϱ�
		
		// format() �̿�
		// ��¥ ��ü�� ���ڿ��� ���ư����� DateTimeFormatter�� ����Ѵ�.
		ZonedDateTime zdt = ZonedDateTime.now();
		System.out.println("BASIC_ISO_DATE : " + zdt.format(DateTimeFormatter.BASIC_ISO_DATE));
		System.out.println("ISO_WEEK_DATE : " + zdt.format(DateTimeFormatter.ISO_WEEK_DATE));
		System.out.println("ISO_DATE : " + zdt.format(DateTimeFormatter.ISO_DATE));
		System.out.println("ISO_ZONED_DATE_TIME : " + zdt.format(DateTimeFormatter.ISO_ZONED_DATE_TIME));
		
		
		// # java.time to java.sql.date
		//	- DB�� ���� �� ����Ѵ�
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
