package study;

public class C06_Line extends C06_ChatApp{

	@Override
	public String send(String msg) {
		System.out.printf("\"%s\"\n메세지를 전송하였습니다.\n", msg);
		return msg;
	}

	@Override
	public String read(String read) {
		System.out.printf("\"%s\" 읽음\n", read);
		return read;
	}
	

}
