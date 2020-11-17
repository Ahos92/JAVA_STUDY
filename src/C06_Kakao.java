
public class C06_Kakao extends C06_ChatApp{

	@Override
	public String send(String msg) {
		System.out.printf("\"%s\"\n메세지를 보냄\n", msg);
		return msg;
	}

	@Override
	public String read(String read) {
		System.out.printf("\"%s\" (숫자 1 사라짐)\n",read);
		return read;
	}

	
}
