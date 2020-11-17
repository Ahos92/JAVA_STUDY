import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class E07_JsonSimple {

	// google 'maven repo' �˻� -> �ڹ� ���̺귯������ ���ִ� ����Ʈ
	
	// # �ܺ� ���̺귯�� �߰� ���
	//	- Buildpath -> Configure Buildpath -> lib tab -> Add External Jar File
	//	-
	
	public static void main(String[] args) {
		// mapó�� �����͸� �߰��Ѵ�.
		JSONObject obj = new JSONObject();
		
		// JSON �迭�� ����� ���ؼ��� ArrayList�� ����ؾ��Ѵ�.
		ArrayList<String> arr = new ArrayList<>();
		
		arr.add("fishing");
		arr.add("programming");
		arr.add("Billiard");
		
		obj.put("car", "BMW");
		obj.put("addr",	"Seoul");
		obj.put("age", 27);
		obj.put("hobbies", arr);
		
		//toString()�� �����Ǿ�����
		System.out.println(obj);
		
		String jsonStr = obj.toString();
		
		System.out.println(jsonStr);
		
		//
		System.out.println();
		JSONParser parser = new JSONParser();
		
		try {
			// File���� �о�� �����͸� JSON������ Map���� �Ľ�
			JSONObject obj2 = (JSONObject) parser.parse(new FileReader("E:\\java_io\\data.json"));
			
			System.out.println(obj2);
			System.out.println();
			
			JSONArray programs = (JSONArray) (obj2.get("programming"));
			System.out.println(programs);
			for (Object program : programs) {
				System.out.println(program);
			}
			System.out.println();
			
			System.out.println(obj2.get("�μ�"));
			// JSONObject ������ JSONObject ����ϱ�
			JSONObject minsu = (JSONObject) obj2.get("�μ�");
			
			System.out.println(minsu.get("����"));
			System.out.println(minsu.get("����"));
			System.out.println(minsu.get("���� �����ϴ� �峭��"));
			
			// JSON - ������ ������ Map�� ������ �� �ִ� ���ڿ� ( �����ϱ� ���� ���� ) 
			
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			
		}
		
	}
}
