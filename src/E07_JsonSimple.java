import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class E07_JsonSimple {

	// google 'maven repo' 검색 -> 자바 라이브러리들이 모여있는 사이트
	
	// # 외부 라이브러리 추가 방법
	//	- Buildpath -> Configure Buildpath -> lib tab -> Add External Jar File
	//	-
	
	public static void main(String[] args) {
		// map처럼 데이터를 추가한다.
		JSONObject obj = new JSONObject();
		
		// JSON 배열을 만들기 위해서는 ArrayList를 사용해야한다.
		ArrayList<String> arr = new ArrayList<>();
		
		arr.add("fishing");
		arr.add("programming");
		arr.add("Billiard");
		
		obj.put("car", "BMW");
		obj.put("addr",	"Seoul");
		obj.put("age", 27);
		obj.put("hobbies", arr);
		
		//toString()이 구현되어있음
		System.out.println(obj);
		
		String jsonStr = obj.toString();
		
		System.out.println(jsonStr);
		
		//
		System.out.println();
		JSONParser parser = new JSONParser();
		
		try {
			// File에서 읽어온 데이터를 JSON형태의 Map으로 파싱
			JSONObject obj2 = (JSONObject) parser.parse(new FileReader("E:\\java_io\\data.json"));
			
			System.out.println(obj2);
			System.out.println();
			
			JSONArray programs = (JSONArray) (obj2.get("programming"));
			System.out.println(programs);
			for (Object program : programs) {
				System.out.println(program);
			}
			System.out.println();
			
			System.out.println(obj2.get("민수"));
			// JSONObject 내부의 JSONObject 사용하기
			JSONObject minsu = (JSONObject) obj2.get("민수");
			
			System.out.println(minsu.get("성별"));
			System.out.println(minsu.get("나이"));
			System.out.println(minsu.get("제일 좋아하는 장난감"));
			
			// JSON - 정보만 가지고 Map을 생성할 수 있는 문자열 ( 전송하기 아주 좋음 ) 
			
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			
		}
		
	}
}
