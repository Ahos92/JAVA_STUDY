
public class C06_Kakao extends C06_ChatApp{

	@Override
	public String send(String msg) {
		System.out.printf("\"%s\"\n�޼����� ����\n", msg);
		return msg;
	}

	@Override
	public String read(String read) {
		System.out.printf("\"%s\" (���� 1 �����)\n",read);
		return read;
	}

	
}
