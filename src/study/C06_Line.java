package study;

public class C06_Line extends C06_ChatApp{

	@Override
	public String send(String msg) {
		System.out.printf("\"%s\"\n�޼����� �����Ͽ����ϴ�.\n", msg);
		return msg;
	}

	@Override
	public String read(String read) {
		System.out.printf("\"%s\" ����\n", read);
		return read;
	}
	

}
