package project.five.pos.db;

public class DbManager {

	// DBpool
	
	// ��� ���̺�
	//  - ��� �ڵ�(, ����̸�, ����, �԰���, ���� ���� ...
	int ingred_code;
	String ingred_name;
	int amount;
	int delivery_date;
	int total_money;
	
	// ������̺� 
	//  - ����� �ڵ�, �ڵ��� ��ȣ, ���, (���η�, ������) ...
	int member_id;
	String phone_number;
	String rank;
	double discount_pct;
	double accumualte_pct;
	
	// ��ǰ ���̺�
	//  - ���� �̸�, �Ǹ� ����, ���� ...
	String food_name;
	int price;
	int count;
	
	// ���� ���̺�
	//  - ���� �ڵ�, �̸�, �޿�, �Ի��� ...
	int employee_id;
	String name;
	int salary;
	String hire_date;
	
}
