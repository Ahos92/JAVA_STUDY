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
	//   - JavaScript���� ����ϴ� MapŸ�� 
	//   - ���ڿ������� map�� �����ϰ� ǥ���� �� �־ �αⰡ ����.
	//   - { K : V, K : V, K : V }�� ���¸� ������.

	// # JSON Value�� ���Ǵ� �ڹٽ�ũ��Ʈ Ÿ�Ե�
	//   - '', "" : String 
	//   - �׳� ����, �Ҽ� : Number
	//   - [] : Array
	//   - {} : JSON

	// # JAVA������ JSONŸ���� �������� �ʱ� ������ 
	//   �����͵��� JSON ������ ���ڿ��� �������� �Ѵ�.(Parsing, Binding)
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
		System.out.println("���� ���� �Ϸ�");

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
		// ���ڿ� �ڸ��� ����
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
//				System.err.println("���ڿ�!");
				map2.put(key, value.trim().replaceAll("[\'\"]",	 ""));
				
			} else if (Pattern.matches("\\d.", value)) {
//				System.err.println("����!");
				map2.put(key, Integer.parseInt(value));
				
			} else if (Pattern.matches("\\d+\\.\\d+", value)) {
//				System.err.println("�Ǽ�!");
				map2.put(key, Double.parseDouble(value));
				
			} else if (Pattern.matches("\\[.+\\]", value)) {
//				System.err.println("�迭!");
				
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
		
		
		// ���� § ����
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
//			System.err.println("������ ã�� ���� �����ϴ�.");
//		} catch (IOException e) {
//			System.err.println("�о���� ���� ���� �߻�");
//		}
//

	}

	public static void main(String[] args) throws IOException {

		//���� Map�� ����� �����͸� JSON������ ���ڿ��� �����Ͽ� ����غ�����

//		HashMap<String, Object> map = new HashMap<>();
//		map.put("name", "ȫ�浿");
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
//		// ��� ���� : { name:"ȫ�浿", age:15, tel:"010-1234-1234" }
//
//		// castJSON(map);
//
//		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
//		mapToJson(map);

		HashMap<String, Object> map2 = new HashMap<>();

		// .json ���Ͽ� ����� �����͸� JAVA������ ��ȯ�ϴ� �޼��带 ����� ������
		jsonFileToMap(map2);
		
		System.out.println(map2);

	}


}