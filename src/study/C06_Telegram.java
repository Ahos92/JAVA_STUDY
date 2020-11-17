package study;

public class C06_Telegram extends C06_ChatApp{

	@Override
	public String send(String msg) {
		System.out.printf("\"%s\"\nMessage_Send_Complete\n", msg);
		return msg;
	}

	@Override
	public String read(String read) {
		System.out.printf("\"%s\" Read\n", read);
		return read;
	}

}
