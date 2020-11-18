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

-- COUNT(COL) : �ش� �÷��� ���� ������ ���Ѵ�
SELECT COUNT(salary) FROM employees;
SELECT COUNT(commission_pct) FROM employees;
SELECT COUNT(*) FROM employees;
SELECT 
    COUNT(*) AS "��ü ��� ��", 
    COUNT(commission_pct) AS "���ʽ� �޴� ��� ��"
FROM 
    employees;

-- GROUP BY
/*
    - �׷� �Լ��� �׷� ���� ������ ����� �� �� �ִ�.
    - GROUP BY�� ������ �÷��� �̿��� �׷��� ������ �ȴ�.
    - GROUP���� ���� ��쿡�� �׷��� ������ ������ �Ǵ� �÷��� �׷� �Լ��� �����
        �÷����� ���� �� �� �ִ�.
*/

SELECT job_id, COUNT(*) FROM employees GROUP BY job_id;
SELECT department_id, COUNT(*) FROM employees GROUP BY department_id;

SELECT * FROM employees;
-- �������� 02 : �� ��å�� ��� ������ ���غ�����
SELECT
    job_id AS ��å,
    COUNT (*) AS "��å�� �ο� ��",
    AVG(salary * 12 * (NVL(commission_pct, 0)+1)) AS "��� ����" 
FROM 
    employees
GROUP BY
    job_id;
    
-- �׷� �Լ��� ����� ���ǿ� ����ϴ� ���
-- HAVING�����
-- �Ҽ� ����� 10���̻��� ��å
SELECT job_id FROM employees GROUP BY job_id HAVING COUNT(*) >= 10;
-- �Ҽ� ����� 10���̻��� �μ�
SELECT department_id FROM employees GROUP BY department_id HAVING COUNT(*) >= 10;

-- �������� 03 : �μ��� �ִ� �޿��� �ּ� �޿��� ����ϵ� �ִ� �޿��� 5000�̻��� �μ��� ���
SELECT 
    department_id,
    MAX(salary),
    MIN(salary)
FROM
    employees
GROUP BY   
    department_id
HAVING 
    MAX(salary) >= 5000;
    
-- �������� 04 : �μ��� ��� �޿��� ����ϵ� �ش� �μ��� �Ҽӵ� ����� 5���̻��� ��츸 ����غ�����
SELECT
    department_id as "�μ� ��ȣ",
    COUNT(*) as "�μ��� �ο� ��",
    TRUNC(AVG(salary), 2) as "��� �޿�"
FROM   
    employees
GROUP BY
    department_id
Having
    COUNT(*) >= 5;
    
-- �� �Ŵ����� �� �� �ð� �ִ����� �� �� ����
SELECT COUNT(*), manager_id FROM employees GROUP BY manager_id;
-- �� �Ŵ����� ���� ����� �߿� ������ �ִ� ����� �� �� ������ �� �� ����
SELECT COUNT(job_id), manager_id FROM employees GROUP BY manager_id;
-- �� �Ŵ����� ���� ����� �߿� ���ʽ��� �޴� ����� �� �� ������ �� �� ����
SELECT COUNT(commission_pct), manager_id FROM employees GROUP BY manager_id;


