-- 06_�׷� �Լ�.sql

-- # �׷� �Լ�
/*
    - ���� ���� ���� �����ϴ� �Լ���
    - ����, ����, ���, �ִ�, �ּ� .....
    
*/

-- SUM(COL) : �ش� �÷��� ��� ���� ������ ���Ѵ�
SELECT SUM(salary) �ѿ��� FROM employees;
SELECT SUM(commission_pct) FROM employees;

-- AVG(COL) : �ش� �÷��� ��� ���� ����� ���Ѵ�.
SELECT TRUNC(AVG(salary), 2) ��տ��� FROM employees;
SELECT ROUND(AVG(salary), 2) ��տ��� FROM employees;

-- MAX(COL) : �ش� �÷��� ��� ���� �� �ִ� ���� ���Ѵ�
SELECT MAX(salary) FROM employees;
-- MIN(COL) : �ش� �÷��� ��� ���� �� �ּ� ���� ���Ѵ�
SELECT MIN(salary) FROM employees;

-- �� �׷� �Լ��� �Ϲ� �÷��� �Բ� ����� �� ����.
--      ( ��� ���� �������� ��� ������ ���� ���� �Ұ��� �Ѱ� )

-- ���������� �� �� ����
SELECT last_name, salary AS "�ְ� ����" FROM employees WHERE salary = (SELECT MAX(salary) FROM employees);


-- ���� ���� 01 : ���� �ֱٿ� �Ի��� ����� �Ի��ϰ� 
-- �Ի����� ���� ������ ����� �Ի����� ����ϴ� �������� �ۼ��غ��ʽÿ�
SELECT 
    MIN(hire_date) AS "���� ������ ��� �Ի���", 
    MAX(hire_date) AS "���� �ֱ� ��� �Ի���"
FROM employees;
