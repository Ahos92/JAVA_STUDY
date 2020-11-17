package study;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;





public class E06_JSON implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// # JSON
	//   - JavaScript에서 사용하는 Map타입 
	//   - 문자열만으로 map을 간결하게 표현할 수 있어서 인기가 많다.
	//   - { K : V, K : V, K : V }의 형태를 가진다.

	// # JSON Value에 사용되는 자바스크립트 타입들
	//   - '', "" : String 
	//   - 그냥 숫자, 소수 : Number
	//   - [] : Array
	//   - {} : JSON

	// # JAVA에서는 JSON타입을 지원하지 않기 때문에 
	//   데이터들을 JSON 형태의 문자열로 만들어줘야 한다.(Parsing, Binding)
	public static void castJSON(HashMap<String, Object> map) {
		String str = "\"";
		StringBuilder sb = new StringBuilder();
		sb.append("{ \n");
		int i = 0;
		int cnt = 0;
		for (Entry<String, Object> entry : map.entrySet()) {

			try {
				Integer.valueOf((String) entry.getValue());
				sb.append(str + entry.getKey() + str + ":" + entry.getValue());

			} catch (NumberFormatException e) {
				String ch[] = entry.getValue().toString().split("[.]");

				for (int j = 0; j < ch.length; j++) {
					try {
						int k = Integer.parseInt(ch[j]);
						if (k > 0 && k < 9) {
							cnt++;
						}

						if (cnt == ch.length){
							sb.append(str + entry.getKey() + str + ":" + entry.getValue());
						}

					} catch (NumberFormatException e1) {
						sb.append(str + entry.getKey() + str + ":" + str + entry.getValue() + str);
					}
				}

			} catch (ClassCastException e) {
				String ch[] = entry.getValue().toString().split("[.;]");
				if (ch[2].equals("String")) {
					sb.append(str + entry.getKey() + str + ":" + Arrays.toString((String[])entry.getValue()));

				} else if (ch[2].equals("Integer")) {
					sb.append(str + entry.getKey() + str + ":" + Arrays.toString((Integer[])entry.getValue()));

				} else if (ch[2].equals("Float")) {
					sb.append(str + entry.getKey() + str + ":" + Arrays.toString((Float[])entry.getValue()));

				} else if (ch[2].equals("Long")) {
					sb.append(str + entry.getKey() + str + ":" + Arrays.toString((Long[])entry.getValue()));
				}
			}

			++i;
			if (i == map.size()) {
				sb.append("\n}");            
			} else {
				sb.append(",\n");
			}
		}

		System.out.println(sb.toString());
	}

	public static void mapToJson(HashMap<String, Object> map) throws IOException {

		StringBuilder builder = new StringBuilder();
		builder.append("{\n");

		int cnt = 0;
		for (Map.Entry<String, Object> el : map.entrySet()) {
			int arrcnt = 0;
			String key = el.getKey();
			Object value = el.getValue();

			builder.append("\t\"" + key + "\"\t:");
			if (value == null) {
				builder.append("null");

			} else if (value instanceof String) {
				builder.append("'" + value + "'");

			} else if (value instanceof Object[]){
				Object[] arr = (Object[]) value;
				if (arr.length == 0) {
					builder.append("[]");
				}

				if (arr instanceof String[]) {
					builder.append("[");

					for (Object obj : arr) {
						builder.append("\"" + obj + "\"");

						if (arrcnt++ == arr.length-1) {
							builder.append("]");
						} else {
							builder.append(",");
						}
					}


				}  else {
					builder.append("[");

					for (Object obj : arr) {
						builder.append(obj);
						if (arrcnt++ == arr.length-1) {
							builder.append("]");
						} else {
							builder.append(",");
						}
					}

				}
			} else {
				builder.append(value);
			}

			if (cnt++ == map.size()-1) {
				builder.append("\n}");
			} else {
				builder.append(",\n");
			}

		}

		FileWriter fw = new FileWriter("E:\\java_io\\data.json");

		fw.write(new String(builder));

		fw.close();
		System.out.println("파일 쓰기 완료");

	}


	private static void jsonFileToMap(HashMap<String, Object> map2) throws IOException {
		FileReader fr = new FileReader("E:\\java_io\\data.json");
		StringBuilder strb = new StringBuilder();
		int ch = 0;
		while ((ch = fr.read()) != -1) {
			strb.append((char)ch);
		}
		String objs = new String(strb.toString());
//		System.out.println(objs);
		fr.close();
		// 문자열 자르기 놀이
		Pattern entry_pattern = Pattern.compile(".+:.+\n");
		
		Matcher matcher = entry_pattern.matcher(objs);
		
		while (matcher.find()) {
			String entry = matcher.group().trim();
			
			if (entry.charAt(entry.length() - 1) == ',') {
				entry = entry.substring(0, entry.length()-1);
			}
//			System.out.println("Entry > " + entry);
			
			String[] entryes = entry.split(":");
			String key = entryes[0].trim().replaceAll("[\"\']", "");
			String value = entryes[1].trim();
			
//			System.out.println("Key > " + key);
//			System.out.println("Value > " + value);
			
			
			if (value.equals("null")) {
//				System.err.println("null");
				map2.put(key, null);
				
			} else if (Pattern.matches("[\"\'].+[\"\']", value)) {
//				System.err.println("문자열!");
				map2.put(key, value.trim().replaceAll("[\'\"]",	 ""));
				
			} else if (Pattern.matches("\\d.", value)) {
//				System.err.println("숫자!");
				map2.put(key, Integer.parseInt(value));
				
			} else if (Pattern.matches("\\d+\\.\\d+", value)) {
//				System.err.println("실수!");
				map2.put(key, Double.parseDouble(value));
				
			} else if (Pattern.matches("\\[.+\\]", value)) {
//				System.err.println("배열!");
				
				value = value.replaceAll("[\\[\\]]", "");
//				System.out.println(value);
				
				String[] items = value.split(",");
				Object[] objArr = null;
				
				if (Pattern.matches("[\"\'].+[\"\']", items[0])) {
					objArr = new String[items.length];
					
					for (int i = 0; i < items.length; ++i) {
						objArr[i] = items[i].trim().replaceAll("[\"\']", "");						
					}					
				} else if (Pattern.matches("\\d+", items[0])) {
					objArr = new Integer[items.length];
					
					for (int i = 0; i < items.length; ++i) {
						objArr[i] = Integer.parseInt(items[i].trim());
					}
				} else if (Pattern.matches("\\d+\\.\\d+", items[0])) {
					objArr = new Double[items.length];
					
					for (int i = 0; i < items.length; ++i) {
						objArr[i] = Double.parseDouble(items[i].trim());
					}
				}	
				
				map2.put(key, objArr);
			}
			
//			System.out.println("==============================");
		}
		
		
		// 내가 짠 망작
//		try (
//				FileReader fr =new FileReader("E:\\java_io\\data.json");
//				BufferedReader bin = new BufferedReader(fr);
//				){
//			
//			
//			while (bin.readLine() != null) {
//			
//				String sp = "[:\t,]";
//				String[] ch_data = bin.readLine().trim().split(sp);
//				String[] ch_key = ch_data[0].split("[\"]"); 
//
//				System.out.println(Arrays.toString(ch_data));
////				System.out.println(ch_data[2]);
//				if (ch_data.length > 1) {
//					if (ch_data[2].contains("[")) {
//						String[] st_arr = ch_data[2].split("[\\[,\\]]");
//						ArrayList<String> arrL = new ArrayList<>();
//						for (int j = 0; j < st_arr.length; j++) {
//							if (st_arr[j].length() > 0) {
//								arrL.add(st_arr[j]);
//							}
//						}
//						
////						System.out.println(Arrays.toString(st_arr));
//						Object[] ob_arr = new Object[arrL.size()];
//						for (int j = 0; j < ob_arr.length; j++) {
//
//							if (arrL.contains("\"")) {
//								ob_arr = new String[arrL.size()];
//								ob_arr[j] = arrL.get(j);								
//							}else {
//								int int_v = Integer.parseInt(arrL.get(j));
//								ob_arr = new Integer[arrL.size()];
//								ob_arr[j] = int_v;
//							}
//
//						}
//
//						map2.put(ch_key[1], ob_arr);
//
//					} else if (ch_data[2].contains("'")) {
//						String[] ch_value = ch_data[2].split("[\']");
//						map2.put(ch_key[1], ch_value[1]);
//
//					} else {
//						int int_v = Integer.parseInt(ch_data[2]);
//						map2.put(ch_key[1], int_v);
//					}
//				}
//			}
//		} catch (FileNotFoundException e) {
//			System.err.println("파일을 찾을 수가 없습니다.");
//		} catch (IOException e) {
//			System.err.println("읽어오는 도중 에러 발생");
//		}
//

	}

	public static void main(String[] args) throws IOException {

		//다음 Map에 저장된 데이터를 JSON형태의 문자열로 생성하여 출력해보세요

//		HashMap<String, Object> map = new HashMap<>();
//		map.put("name", "홍길동");
//		map.put("age", 15);
//		map.put("tel", "010-1234-1234");
//		map.put("programming", new String[] {"java", "Python", "JS"});
//		map.put("dd", new Integer[] {1, 2, 3, 4});
//		map.put("nullTest", null);
//		map.put("sosu", new Double[] {123.123, 234.234, 345.345});
//		
//		System.out.println(map.get("name") instanceof String);
//		System.out.println(map.get("age") instanceof String);
//		System.out.println(map.get("age") instanceof Integer);
//		System.out.println(map.get("programming") instanceof Integer[]);
//		// 출력 예시 : { name:"홍길동", age:15, tel:"010-1234-1234" }
//
//		// castJSON(map);
//
//		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
//		mapToJson(map);

		HashMap<String, Object> map2 = new HashMap<>();

		// .json 파일에 저장된 데이터를 JAVA맵으로 변환하는 메서드를 만들어 보세요
		jsonFileToMap(map2);
		
		System.out.println(map2);

	}


}