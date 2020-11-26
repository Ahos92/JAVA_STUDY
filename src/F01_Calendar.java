import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class F01_Calendar {

	
	public static void main(String[] args) {
		
		// �ڹٷ� ��¥(�ð�) �ٷ��
		//	java.util.Date
		//	java.util.Calendar
		
		F01_Calendar c = new F01_Calendar();
		
		// 1970�� 1�� 1�� ���ķ� �ð��� �󸶳� �귶������ ���� �ð��� ǥ��
		System.out.println(System.currentTimeMillis());
		
		Date now = new Date();
		System.out.println(now);
		
		// Date Ŭ������ ���� deprecated �����̴� (��¥�� ��Ƴ��� �뵵�θ� ����Ѵ�)
		now.getDay();
		
				
		// # Calendar Ŭ����
		//	- �޷��� ǥ���� Ŭ����
		//	- ��¥�� ���� ����� �� �ִ� ��ɵ��� ���ִ�.
		//	- ������ ��� getInstance()��� �Լ��� ���� �ν��Ͻ��� �޾ƿ´�.
		Calendar now2 = Calendar.getInstance();
		
		System.out.println(now2);
		System.out.println();
		
		// # TimeZone Ŭ����
		//	- �浵�� ������ �� �ִ� Ŭ����
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
		
		
		// # Calendar�� set�޼���� �ش� �ʵ带 ���� ���ϴ� ������ ������ �� �ִ�.
		
		// 	- MONTH�� 10���� ����
		samoa_time.set(Calendar.MONTH, 10 - 1);
		samoa_time.set(Calendar.DATE, 20);
		
		///////////////////////////
		// Calendar�� get(field) �� ������ �ִ�.
		int samoa_year = samoa_time.get(Calendar.YEAR);
		// Calnedar�� Month�� 1���� 0�̴�.
		int samoa_month = samoa_time.get(Calendar.MONTH) + 1;
		int samoa_date = samoa_time.get(Calendar.DATE);

		int samoa_hour = samoa_time.get(Calendar.HOUR);
		int samoa_minute = samoa_time.get(Calendar.MINUTE);
		int samoa_second = samoa_time.get(Calendar.SECOND);

		int samoa_am_pm = samoa_time.get(Calendar.AM_PM);
		
		//	DAY_OF_WEEK : ���� 
		int samoa_week = samoa_time.get(Calendar.DAY_OF_WEEK);
		
		// WEEK_OF_MONTH : ���° �� �ΰ�
		int samoa_wom = samoa_time.get(Calendar.WEEK_OF_MONTH);
		
		// DAY_OF_WEEK_IN_MONTH : �̹� ������ �� ��° �����ΰ�?
		int samoa_dowim = samoa_time.get(Calendar.DAY_OF_WEEK_IN_MONTH);
		
		
		System.out.printf("������ %d��° %s���� �Դϴ�.\n", samoa_dowim, c.getStrWeek(samoa_week));
		System.out.printf("samoa time - %d/%02d/%02d %d:%d:%d %s %s %d��° ��\n",
				samoa_year, samoa_month, samoa_date,
				samoa_hour, samoa_minute, samoa_second,
				samoa_am_pm == 0 ? "AM" : "PM",
				c.getStrWeek(samoa_week), samoa_wom);
		
		
	}
	
	public String getStrWeek(int calendar_dow) {
		switch (calendar_dow) {
		case Calendar.MONDAY:
			return "��";
		case Calendar.TUESDAY:
			return "ȭ";
		case Calendar.WEDNESDAY:
			return "��";
		case Calendar.THURSDAY:
			return "��";
		case Calendar.FRIDAY:
			return "��";
		case Calendar.SATURDAY:
			return "��";
		case Calendar.SUNDAY:
			return "��";
		default:
			return null;
		}
		
	}
}
