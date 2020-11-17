package myobj.machine;

public interface Electronics {

	// 전자 기기 인터페이스
	
	// 모든 전자기기는 전력 공급을 받을 수 있다.
	
	// 모든 전자기기는 콘솔에 출력할 때마다 전력 소비량 만큼의 전력을 소비한다.
	
	// 모든 전자기기는 실행하고 있는 동작을 콘솔에 출력한다.
	
	// 나중에 가져다 쓸 때 필요한 정보를 받기 위한 메서드들을 정의
	
	 void setConnect(ElectricSource src);

	 String execute();
	
}
