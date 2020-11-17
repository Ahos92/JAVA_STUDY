-- 02_SELECT.sql

/*
    # SELECT �÷��� FROM ���̺��;
        - �����͸� ��ȸ�ϴ� ������
        - �÷��� = * �� ��� �÷��� �ǹ�
    
    

*/

-- tab ���̺��� ��� �÷�(�Ӽ�, �ʵ�, ��)�� ��ȸ�Ѵ�.
SELECT * FROM tab; 

-- ������ ���̺� ����
/*
    COUNTRIES : ���� ������ ������ ���̺�
    EMPLOYEES : ��� ������ ������ ���̺�
    DEPARTMENTS : �μ� ������ ������ ���̺�
    JOBS : ���� ������ ������ ���̺�
    LOCATIONS : ���� ������ ������ ���̺�
    REGIONS : ��� ������ ������ ���̺�
*/

-- ���� ���̺��� ��� �÷��� ��ȸ�Ѵ�.
SELECT * FROM employees; 

-- �÷����� ������ �ش� �÷��� �����͸� ��ȸ�Ѵ�.
SELECT last_name, phone_number, hire_date FROM employees; 

-- -------------------------------------------------------------------------
-- ���̺��� �Ӽ� ���� ����
DESC employees;
DESC countries;

-- ����Ŭ�� ������ Ÿ��
/*
    # NUMBER(n) , NUMBER(n, m)
        - ���� �����͸� ������ �� ����ϴ� �÷� Ÿ��
        - NUMBER(6) : 6�ڸ� ������ ������ �� �ִ� �÷��� �ȴ�.
        - NUMBER(6, 3) : 3�ڸ� ������ 3�ڸ� �Ҽ����� ������ �� �ִ� �÷��� �ȴ�.
    
    # CHAR(n)
        - ���� ���� ���� �����͸� ������ �� ����ϴ� �÷� Ÿ��
        - ������ ���̺��� ���� ���� �����Ͱ� ���͵� ���������� ������ ���̸� ����
        - CHAR(10)�� ������ �÷��� 2���ڰ� �������� 10Byte�� ����
        
    # VARCHAR2(n)
        - ���� ���̹��� �����͸� ������ �� ����ϴ� �÷� Ÿ��
        - ����� �������� ũ�⿡ ���� �˸��� ������ ����Ѵ�.
        - ���� ������ ���� ���� �� �ִ�.
        - VARCHAR2(10)�� ������ �÷��� 2���ڰ� ������ 2Byte�� �����Ѵ�.
        
    # DATE
        - ��¥ �� �ð��� �����ϴ� �÷� Ÿ��
        - ����/��/��/��/��/��/��/���� ���� �����Ѵ�.
*/
select * from countries;

-- ��������01 : ��� ����� ���/�̸�/����/�μ���ȣ�� ��ȸ�غ�����
select employee_id, first_name, salary, department_id from employees;
-- �� �÷���, ���̺���� ��ҹ��ڸ� �������� �ʴ´�.
-- Keyword�� �빮�ڷ� ���ִ°� ����

-- ��������ڷ� ���� �� ����ϱ�
SELECT last_name, salary FROM employees;
SELECT last_name, salary + 500 FROM employees;
SELECT last_name, salary * 2 FROM employees;
SELECT last_name, salary / 10 FROM employees;

-- ���޿� ���ʽ� �����غ���
-- �������� ���� �÷��� ������ AS�� �̿��� �÷����� ���� ���Ҽ� �ִ�.
SELECT last_name, salary * commission_pct AS commission FROM employees;

-- ���� + ���ʽ�
-- null�� �������� �ʴ� ���̱� ������ ������꿡 ���ԵǸ� ������ null�� �ȴ�.
SELECT last_name, salary + salary * commission_pct AS �Ǽ��ɾ� FROM employees;
-- NVL(�÷���, ��ü��) �Լ� : �ش� �÷����� NULL���� ������ �� ��ü���� ����Ѵ�
SELECT last_name, salary * (NVL(commission_pct, 0) + 1) AS total_salary FROM employees;

-- "�÷���"�� �̿��ϸ� �÷����� ��ҹ��ڸ� ������ �� �ִ�.
SELECT last_name AS "last_Name" FROM employees;
SELECT last_name AS "lastName" FROM employees;


-- ��������02 :  ��� ������� ���/�̸�/������ ����غ����� (salary�� ����)
SELECT employee_id, first_name , salary * 12 * (NVL(commission_pct, 0) + 1) AS ���� FROM employees; 

-- -----------------------------------------------------------------------------
-- SELECT DISTINCT : �ߺ��Ǵ� ����� �־ �� ���� ��ȸ�ȴ�.

-- �������� ��å�� �ѹ����� �� �� �ִ�.
SELECT DISTINCT job_id FROM employees;

-- ��� �������� ���� �μ���ȣ�� �ѹ����� �� �� �ִ�.
SELECT DISTINCT department_id FROM employees;

-- �Ŵ��� ������ �ϰ��ִ� ������� ����� �ѹ����� ��ȸ�� �� �ִ�.
SELECT DISTINCT manager_id FROM employees;

