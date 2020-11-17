package study;
import java.util.*;

public class D03_LinkedList {

	// # ���Ḯ��Ʈ
	//	- ArrayList���� ���� / ������ ������ ����Ʈ
	//	- �߰��� ������ �Ͼ�� �� ArrayList�� ��� �����͸� �ڷ� �̵����Ѿ� ������
	//	- LinkedList�� ����� ��常 �ٲٸ� �Ǳ� ������ �ξ� ������.
	
	//	- ArrayList�� ������ ����, �б⿡ ����
	//	- LinkedList�� ������ ���� �� ������ ����
	
	public static void main(String[] args) {
		
		LinkedList<String> mem = new LinkedList<>();
		
		mem.add("ȸ��1");
		mem.add("ȸ��2");
		mem.add("ȸ��3");
		
		mem.addFirst("�� ��");
		mem.addLast("�� ��");
		
		System.out.println(mem);
		
		System.out.println(mem.get(3));
		System.out.println(mem.getFirst());
		System.out.println(mem.getLast());
		
		System.out.println("\n pop");
		// pop() : �� ���� �����͸� �����鼭 ���� (FIFO)
		for (int i = 0, len = mem.size(); i < len; ++i) {
			System.out.println("��� ���� �� : " + mem.pop());
			System.out.println("after pop : " + mem);
		}
		
		System.out.println();
		// LinkedList������ ����Ʈ, ����, ťó�� Ȱ���� �� �ִ�.
		mem.add("ȸ��1");
		mem.add("ȸ��2");
		mem.add("ȸ��3");
		mem.add("ȸ��4");
		mem.add("ȸ��5");
		System.out.println(mem);
		
		System.out.println("\n poll(), pollLast()");
		// poll() : ù ��° ��Ҹ� �����鼭 ��� (pop�� ����)
		System.out.println(mem.poll());
		System.out.println(mem);
		// pollLast() : ���� �ֱٿ� �߰��� ��Ҹ� �����鼭 ��� (LIFO)
		System.out.println(mem.pollLast());
		System.out.println(mem);
		
		System.out.println("\n peek(), peekLast()");
		// peek() : ������ ���� �ʰ� ��ó�� ��Ҹ� ����ϱ�
		System.out.println(mem.peek());
		System.out.println(mem);
		// peekLast() : ������ ���� �ʰ� ������ ��Ҹ� ����ϱ�
		System.out.println(mem.peekLast());
		System.out.println(mem);
		
		System.out.println("\n �ӵ� ���� �׽�Ʈ");
		// �ӵ� ���� �׽�Ʈ
		ArrayList<Integer> arr_list = new ArrayList<>(1000000);
		for (int i = 0; i < 1000000; ++i)
			arr_list.add(i);
		
		LinkedList<Integer> linked_list = new LinkedList<>();
		for (int i = 0; i < 1000000; ++i)
			linked_list.add(i);
		
		HashSet<Integer> toAdd = new HashSet<>();
		for (int i = 0; i < 20; ++i)
			toAdd.add(i);
		
		
		// ArrayList�� �߰��� �����͸� �߰��ϴ°� ����
		long start = System.currentTimeMillis();
		System.out.println("ArrayList �ӵ� �׽�Ʈ ����");
		for (int i = 0; i < 200; ++i) {
			arr_list.addAll(10, toAdd);
		}
		long end  = System.currentTimeMillis();
		System.out.println("ArrayList �ӵ� �׽�Ʈ ���� " + (end - start));
	
		System.out.println();
		// linkedList�� �߰��� �����͸� �߰��ϴ°� ����
		start = System.currentTimeMillis();
		System.out.println("LinkedList �ӵ� �׽�Ʈ ����");
		for (int i = 0; i < 200; ++i) {
			arr_list.addAll(10, toAdd);
		}
		end  = System.currentTimeMillis();
		System.out.println("LinkedList �ӵ� �׽�Ʈ ���� " + (end - start));
		
		// �߰�, ������ Linked�� ����, �б�� ArrayList��
	}
	
}
