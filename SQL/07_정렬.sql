-- 07_����.sql

-- ORDER BY
/* 
    ORDER BY���� ���� ��ȸ�� ������ ���ϴ� �÷� �������� ���� �� �� �ִ�.
        - ASC (ASCENDING) : ��������, default��(���� ����)
        - DESC (DESCENDING) : ��������

*/
SELECT * FROM employees; -- �⺻ �ε�����
SELECT * FROM employees ORDER BY salary; -- ���� ��������
SELECT * FROM employees ORDER BY salary DESC; --  ���� ��������

-- ���� ���� ������ ������ ,  LAST_NAME�� ���ĺ� ������ ���� ��, ������� ����
SELECT * FROM employees ORDER BY job_id DESC, last_name, employee_id;

SELECT COUNT(*), job_id FROM employees GROUP BY job_id ORDER BY COUNT(*) DESC;

-- ��������01 : ��� ��� ��ȸ�ϵ� �μ���ȣ�� ������ �� ���� �μ� ������ First_name ���ĺ���
SELECT * FROM employees ORDER BY department_id, first_name;

-- ��������02 : ��� ������� �ֱ� �Ի��� ������� ��ȸ�غ�����.
SELECT * FROM employees ORDER BY hire_date DESC;

-- ��������03 : ���� ������ �ִ� ����鸸 ���� �������� �����Ͽ� ��ȸ�غ����� (�Ŵ��� ���̵� ���÷��� ���̵� ��)
SELECT
    *
FROM
    employees
WHERE
    employee_id 
    IN (SELECT DISTINCT manager_id FROM employees WHERE manager_id IS NOT NULL)
ORDER BY
    salary DESC;
