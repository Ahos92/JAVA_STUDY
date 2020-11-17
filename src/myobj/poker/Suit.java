package myobj.poker;

public enum Suit {

	// enum 
	//      RankŬ������ �ڵ�����
	
									// order�� 	 name�� �⺻������ �����ȴ�.
	
	SPADE(3, "�����̵�", "��"), 			// order 0,  name "SPADE"  / suitValue 3 , korName "�����̵�" 	....
	DIAMOND(2, "���̾Ƹ��", "��"),			// order 1,  name "DIAMOND"/ suitValue 2 , korName "���̾Ƹ��"	....
	HEART(1, "��Ʈ", "��"),				// order 2,  name "HEART"  / suitValue 1 , korName "��Ʈ"		....
	CLOVER(0, "Ŭ�ι�", "��");				// order 3,  name "CLOVER" / suitValue 0 , korName "Ŭ�ι�"	....

	public static final int NUM_OF_SUIT = 4;
	
	private int suitValue; // ũ�� ���ҋ� ���� ��
	private String korName; // ���� �����ϱ� ���� ���� ��
	private String shape;
	
	//	���ο� ����� �߰��ϰ� �ʹٸ� �����ڸ� �̿��Ѵ�. -> (������� ����)
	// enumŸ�� ��ü�� �����ڰ� �ݵ�� private�̴� ( ����� �� ) 
	private Suit(int suitValue, String korName, String shape) {
		this.suitValue = suitValue;
		this.korName = korName;
		this.shape = shape;
	}

	public int getSuitValue() {
		return suitValue;
	}
	
	public String getKorName() {
		return korName;
	}
	
	public String getShape() {
		return shape;
	}
}
