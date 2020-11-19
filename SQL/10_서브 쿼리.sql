-- 10_���� ����.sql

/*
    # ��������
        - �ϳ��� SELECT ���忡 ���Ե� �� �ϳ��� SELECT ����
        - ���� ������ �����ϰ� �ִ� ������ ���� ������� �Ѵ�.
        - ���� ������ �񱳿����� �ϴ� ��쿡�� �ݵ�� �������� �����ʿ� ����ؾ� �Ѵ�
        - �ݵ�� ��ȣ�� �ѷ��׾ƾ� �Ѵ�.
        - ���� ������ ���������� ����Ǳ� ���� �ѹ��� ���� �ȴ�.
        
    # ���� �� ���� ����
        - ���� ������ �������� �� �ϳ��� �ุ ��ȯ�ϴ� ���� ����
        - =, < , <=, >, >=, <> �ϳ��� ���� �䱸�ϴ� �� �������̹Ƿ�
            ���� �� ���� ������ �Բ� ����ؾ� �Ѵ�.
*/
SELECT
    *
FROM
    employees
WHERE
    last_name = 'King';


-- King�� ���� �μ��� �ٹ��ϴ� ����� ������ ���������� �̿��� ��ȸ �غ���

SELECT
    *
FROM
    employees
WHERE
    department_id = (
        SELECT
            department_id
        FROM
            employees
        WHERE
                last_name = 'King'
            AND first_name LIKE 'S%'
    ); -- ���� �� �����ڴ� ���� ���� ����� ���� ���̾ƴ� ��� ������ �߻��Ѵ�.

SELECT
    *
FROM
    employees;
-- ��������01 : ���������� �̿��� Ki Gee�� ������ ������ ���� ����� ��ȸ�غ�����

SELECT
    *
FROM
    employees
WHERE
    job_id = (
        SELECT
            job_id
        FROM
            employees
        WHERE
                first_name = 'Ki'
            AND last_name = 'Gee'
    );

-- ��������02 : ���������� �̿��� Ki Gee���� �޿��� ���� �޴� ��� ���� �̸��� �޿��� ��ȸ�غ�����

SELECT
    first_name,
    last_name,
    salary
FROM
    employees
WHERE
    salary > (
        SELECT
            salary
        FROM
            employees
        WHERE
                first_name = 'Ki'
            AND last_name = 'Gee'
    )
ORDER BY
    salary;

-- ��������03 : ���������� �̿��� Purchasing�μ����� �ٹ��ϴ� ����� �̸��� �μ���ȣ�� ��ȸ�غ�����

SELECT
    first_name
    || ' '
    || last_name,
    department_id
FROM
    employees
WHERE
    department_id = (
        SELECT
            department_id
        FROM
            departments
        WHERE
            department_name = 'Purchasing'
    );
    
/*
    # ���� �� ���� ����
        - ���� �������� ��ȯ�Ǵ� ����� �ϳ� �̻��� ���� ���� ����
        - ���� �� �����ڿ� �Բ� ����ؾ� �Ѵ�.
            (IN : ���� ������ ��� �߿��� �ϳ��� ��ġ�ϸ� TRUE, 
             ANY, SOME : ���� ������ ����� �ϳ� �̻� ��ġ�ϸ� TRUE, 
             ALL : ���� ������ ����� ��� ���� ��ġ�ؾ� TRUE
             )
*/
-- �޿��� 10000$ �̻��� ����� �Ҽӵ� �μ����� �ٹ��ϴ� ��� ����� ��ȸ

SELECT
    last_name,
    salary,
    department_id
FROM
    employees
WHERE
    department_id IN (
        SELECT DISTINCT
            department_id
        FROM
            employees
        WHERE
            salary >= 10000
    ) -- �� ���������� ��� ( 20, 30, 70, 80, 90, 100, 110) : ���� �� ���������� ���� �� �����ڿ� �Բ� ����ؾ��Ѵ�.
ORDER BY
    department_id ASC;
    
    
-- ALL ������
-- 50�� �μ��� ��� ��� ���� �޿��� ���� �޴� ������� ��ȸ�غ���
--    (50�� �μ����� ���� ���̹޴� ������� �� ���� �޴� �����)

SELECT
    *
FROM
    employees
WHERE
    salary > ALL (
        SELECT
            salary
        FROM
            employees
        WHERE
            department_id = 50
    );


-- ��������04 : ���α׷��ӵ� ���� �޿��� ���� �޴� ������� �̸� / �޿� / ��åid�� ����ϵ� ���α׷��Ӵ� ������� �ʴ´�.

SELECT
    first_name,
    salary,
    job_id
FROM
    employees
WHERE
    salary > ALL (
        SELECT
            salary
        FROM
            employees
        WHERE
            job_id = 'IT_PROG'
    );
    
    
-- ANY, SOME ������
-- ���� ������ ��� ��� �� �� �ϳ� �̻� ��ġ�ϸ� ��
-- 50�� �μ��� ��� ����� �� ���� ���� �޴� ������� ���� �޴� ����� ��� ��ȸ

SELECT
    *
FROM
    employees
WHERE
    salary > ANY (
        SELECT
            salary
        FROM
            employees
        WHERE
            department_id = 50
    );

-- 50�� �μ��� ��� ����� �� ���� ���� �޴� ������� ���Թ޴� ����� ��� ��ȸ

SELECT
    *
FROM
    employees
WHERE
    salary < ANY (
        SELECT
            salary
        FROM
            employees
        WHERE
            department_id = 50
    );

    
-- ��������05 : ���� ���� �޴� ���α׷��Ӻ��� ���� �޴� ��� ����� ��ȸ�غ�����

SELECT
    *
FROM
    employees
WHERE
    salary > ANY (
        SELECT
            salary
        FROM
            employees
        WHERE
            job_id = 'IT_PROG'
    );


-- EXIST
--  �ش� ���� ������ ����� �����ϸ� ���� �ȴ�.
--  ���� ������ �����ϴ� ���߿� ���� �ϳ��� �߰ߵǸ� �ٷ� TRUE�� �ȴ�.

-- job_history ���̺� ����� �����ϴ� ����� ���� ���� ���
SELECT
    *
FROM
    employees
WHERE
    EXISTS (
        SELECT
            *
        FROM
            job_history
        WHERE
            employees.employee_id = job_history.employee_id
    );
    
select * from employees where employee_id in (select distinct employee_id from job_history);
select * from employees where employee_id = any (select distinct employee_id from job_history);
-- ���� 3���� ����