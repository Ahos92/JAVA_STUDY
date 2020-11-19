-- 12_������ �߰�,����,����.sql

/*
    # INSERT : ���̺� ���ο� ������ �߰� (����)
        
        INSERT INTO ���̺��(�÷���, ...) VALUE(��, ...)
*/
-- # ���� �⺻���� ������ �߰�
INSERT INTO coffees (cfid, cname, cprice) VALUES(1, '���̽� �Ƹ޸�ī��', 2000);
INSERT INTO coffees (cname, cfid, cprice) VALUES('�߰ſ� �Ƹ޸�ī��', 2, 2000);

-- # �Ϻ� �÷����� �������߰�
INSERT INTO coffees (cname, cprice) VALUES('���̽� ī���', 2500);
INSERT INTO coffees (cprice, cfid) VALUES(2500, 4);

-- # �÷��� �����ϸ鼭 ������ �߰� > ��� �÷��� ������� ��� ���� �־����
INSERT INTO coffees values(5, '���̽� ī���ī', 3000);
INSERT INTO coffees values(5, '���̽� ī���ī'); -- ����

SELECT * FROM coffees;

-- # ���������� ������ �����ϱ�
INSERT INTO coffees select * from coffees;


----------------------------------------------------------------

/*
    # UPDATE : ���̺��� �����͸� ����
        
        - UPDATE ���̺�� SET �÷��� - ��, ... WHERE ������ ���� ����;
        - UPDATE���� ������ �Է����� ������ ��� ���� �����ȴ�
        - ������ �����ϴ� ��� ���� �����Ѵ�
        - �ϳ��� ���� ������ �� �ִ� �⺻Ű�� �Բ� �̿�Ǵ� ��찡 ��κ��̴�
*/
UPDATE coffees SET cprice = cprice + 200 WHERE cfid = 2;
select * from coffees where cfid =2;

-- ��������01 : employees ���̺��� ������ �����ϴ� �������� �̿� �Ͽ� emp���̺��� �����غ�����
CREATE TABLE emp AS select * from employees where 1 = 0;
select * from emp;

-- ��������02 : emp���̺� employees�� ��� ����� �� Ȧ�� ����� ���� ����鸸 �߰��غ�����
INSERT INTO emp select * from employees where MOD(employees.employee_id, 2) = 1;

-- ��������03 : emp���̺��� ��� ����� �� job_id�� MAN�� ���Ե� ������� ������ 40% �谨�غ�����
UPDATE emp SET salary = salary * 0.6 where job_id LIKE '%MAN%';


SELECT e1.last_name, e1.job_id, e1.salary, e2.salary
FROM employees e1 INNER JOIN emp e2 USING(employee_id)
WHERE e1.salary - e2.salary <> 0;
