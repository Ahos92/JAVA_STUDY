package project.five.pos.db;

public class DbManager {

	// DBpool
	
	// 재고 테이블
	//  - 재료 코드(, 재료이름, 수량, 입고일, 현재 시제 ...
	int ingred_code;
	String ingred_name;
	int amount;
	int delivery_date;
	int total_money;
	
	// 멤버테이블 
	//  - 멤버십 코드, 핸드폰 번호, 등급, (할인률, 적립률) ...
	int member_id;
	String phone_number;
	String rank;
	double discount_pct;
	double accumualte_pct;
	
	// 상품 테이블
	//  - 음식 이름, 판매 가격, 수량 ...
	String food_name;
	int price;
	int count;
	
	// 직원 테이블
	//  - 직원 코드, 이름, 급여, 입사일 ...
	int employee_id;
	String name;
	int salary;
	String hire_date;
	
}
