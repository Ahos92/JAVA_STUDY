package myobj.poker;

public class RankClass_ver {

	static String[] names;
	static Integer[] rankValues;
	
	public static final RankClass_ver ACE;
	public static final RankClass_ver DEUCE;
	public static final RankClass_ver THREE;
	public static final RankClass_ver FOUR;
	public static final RankClass_ver FIVE;
	public static final RankClass_ver SIX;
	public static final RankClass_ver SEVEN ;
	public static final RankClass_ver EIGHT;
	public static final RankClass_ver NINE;
	public static final RankClass_ver TEN;
	public static final RankClass_ver JACK;
	public static final RankClass_ver QUEEN;
	public static final RankClass_ver KING;
	
	public static RankClass_ver[] values;
	
	static {
		
		names = new String[] {"ACE", "DEUCE", "THREE", "FOUR", "FIVE", "SIX",
							"SEVEN", "EIGHT", "NINE", "TEN", "JACK", "QUEEN", "KING"};
		
		rankValues = new Integer[] {12, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
		
		
		// 인스턴스들을 생성자로 받아서 생성자와 생성자배열을 만듬
		ACE = new RankClass_ver(0);
		DEUCE = new RankClass_ver(1); 
		THREE = new RankClass_ver(2); 
		FOUR = new RankClass_ver(3);
		FIVE = new RankClass_ver(4); 
		SIX = new RankClass_ver(5); 
		SEVEN = new RankClass_ver(6); 
		EIGHT = new RankClass_ver(7);
		NINE = new RankClass_ver(8); 
		TEN = new RankClass_ver(9); 
		JACK = new RankClass_ver(10); 
		QUEEN = new RankClass_ver(11);
		KING = new RankClass_ver(12);
		
		values = new RankClass_ver[] {
				ACE, DEUCE, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING
		};
		
	}
	
	String name;
	int rankValue;
	int order;
	
	// private 생성자는 외부에서 인스턴트 생성을 막음
	private RankClass_ver(int index) {
		this.order = index;
		this.name = names[index];
		this.rankValue = rankValues[index];
	}
	
	@Override
	public String toString() {
		return name;
	}
	
}
