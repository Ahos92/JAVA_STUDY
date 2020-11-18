-- 08_JOIN.sql
/*
    # �ĺ�Ű (Candidate Key)
        - ���̺� ������ �� ���� �����ϰ� ������ �� �ִ� ��� �÷� (�ߺ��� ���� �ʴ�)
    
    # �⺻ Ű (Primary Key, PK)
        - �ĺ�Ű �� ���̺��� Ű�� ���õ� ��
        - �� ���̺�� �⺻Ű �ϳ��ۿ� ������ �� ����.
    
    # �ܷ�Ű (Foreigh Key, FK)
        - �ٸ� ���̺����� �⺻Ű(Ȥ�� �ĺ�Ű) ������, ���� ���̺����� �ߺ��Ǵ� ���� �÷�
            
            ex) employees���̺��� job_id > jobs���̺��� �⺻Ű
            
            ex2) employees���̺��� department_id > departments���̺��� �⺻Ű
            
        - �ܷ�Ű�� ������ ���̺����� ���谡 �����ȴ�.
            (�ٸ����̺��� �⺻Ű�� ������ ����ϴ� ���� ���̺��� ���踦 �����Ѵ�) 
                => ���̺��� ������ �������� �ߺ��� �ּ�ȭ 
                => �⺻Ű�� �ܷ�Ű�� �����̺� ���� �������� ���� (����)
*/
SELECT * FROM employees;

SELECT * FROM departments;
SELECT * FROM jobs;
/*
    # ���̺� JOIN
        - �⺻Ű�� �ܷ�Ű�� �̿��� ���谡 �����Ǿ� �ִ� ���̺���� 
            ������ �����Ͽ� ��ȸ�ϴ� ��
    
    # CROSS JOIN
        - �� ���̺��� �����͸� �����Ͽ� ���� �� �ִ� ��� ��츦 ����� JOIN
        - �׳� ��� ��츦 ������ ������� ����
*/
-- CROSS JOIN 
SELECT * FROM employees; -- 107 ROWS
SELECT * FROM departments; -- 27 ROWS
SELECT * FROM employees, departments; -- 107 * 27 ROWS

/*
    # EQUI JOIN
        - �� ���̺� ���� ���� ������ ���� ���� �÷��� �̿��Ͽ�
            CROSS JOIN���� �ǹ� �ִ� �����͸� �ɷ����� JOIN
            
*/
-- EQUI JOIN
SELECT 
    last_name, department_name 
FROM 
    employees, departments 
WHERE 
    employees.department_id = departments.department_id
ORDER BY
    last_name ASC;
    
-- ��������01 : last_name�� Bloom�� ����� ������ �μ����� ��ȸ�غ�����
SELECT 
    last_name, department_name 
FROM
    employees, departments
WHERE
    employees.department_id = departments.department_id 
    AND last_name = 'Bloom';
-- ��������02 : job_id�� IT_PROG�� ������� last_name, �μ���ȣ, �μ��� ��ȸ�غ�����
SELECT
    last_name, employees.department_id, department_name
FROM
    employees, departments
WHERE
    employees.department_id = departments.department_id 
    AND job_id = 'IT_PROG';

-- ��������03 : �þ�Ʋ���� �ٹ��ϴ� ��� ����� �̸��� �޿��� ��ȸ�غ�����
SELECT
    first_name, last_name, salary
FROM
    employees, locations, departments
WHERE
    employees.department_id = departments.department_id 
    AND locations.location_id = departments.location_id 
    AND city = 'Seattle';

-- ��������04 : ��å�̸��� Marketing�� �� ��� ����� �̸��� �޿��� ������� ��ȸ�غ�����
SELECT
    last_name, salary, hire_date
FROM 
    employees, jobs
WHERE
    employees.job_id = jobs.job_id 
    AND job_title LIKE '%Marketing%';
    
-- ���̺��� �����ϰ� �� �ɰ������� �ʿ��Ҷ� �ϳ��� ���̺�� ���ļ� ����� �� �ְ�
-- �����;��� ���� �� �ִ� (��� ��ȸ�� �ణ ����)

/*
    # SELF JOIN
        - �ϳ��� ���̺� ������ �ڽŰ� JOIN�Ͽ� ���ϴ� �����͸� ���� ��
        - manager_id �� employees ���̺��� �⺻Ű�� �� �� �ִ� �ܷ�Ű�̴�.
*/
-- ���� �̸��� �ش� ������ ����ϴ� �Ŵ��� �̸� ��ȸ
SELECT 
    a.last_name AS "���� �̸�", b.last_name AS "�Ŵ��� �̸�" 
FROM 
    employees a, employees b
WHERE
    a.manager_id = b.employee_id
ORDER BY
    a.last_name ASC;
    
-- ��������05 : �Ŵ����� King�� ������� �̸��� job_title�� ��ȸ�غ�����.
SELECT 
    a.last_name, job_title
FROM 
    employees a, employees b, jobs
WHERE 
    a.manager_id = b.employee_id
    AND a.job_id = jobs.job_id
    AND b.last_name = 'King';
    
-- ��������06 : Taylor �� ������ ��å�� ���� ����� ������ ��� ��ȸ�غ�����.
SELECT
    a.*
FROM 
    employees a, employees b
WHERE 
    a.job_id = b.job_id
    AND b.last_name = 'Taylor';


/*
    # OUTER JOIN
        - JOIN ������ �������� ���ؼ� �������� ���� �����͵��� Ȯ���� �� ����ϴ� JOIN
        - �������� ���� ���� Ȯ���ϰ� ���� ���� �ݴ��� ���ǿ� (+)�� ���δ�
        - (+)�� �������� �࿡ null�� �߰��Ͽ� ���� Ȯ���Ѵ�.
*/
SELECT 
    a.last_name as "�� �̸�", b.last_name "�Ŵ��� �̸�"
FROM
    employees a, employees b
WHERE 
    a.manager_id = b.employee_id(+)
ORDER BY
    b.last_name DESC;
    
-- ��������07 : �����/�μ���ȣ/�μ��̸��� ��� �ϵ� ����� �Ѹ� ������ ���� �μ��� ��ȸ�غ�����.
SELECT
    last_name, e.department_id, department_name
FROM
    employees e, departments d
WHERE
    e.department_id(+) = d.department_id
ORDER BY
    e.department_id;
    
-- ��������08 : �����/����ID/���޸��� ����ϵ� ����� �Ѹ� ������ ���� ���޵� �Բ� ��ȸ�غ�����.
SELECT
    last_name, e.job_id, job_title
FROM
    employees e, jobs j
WHERE
    e.job_id(+) = j.job_id
ORDER BY
    e.job_id;
    
-- ��������09 : �μ���/�ּ�/���ø��� ����ϵ� �Ҽӵ� �μ��� ���� ���õ� ��ȸ�غ�����.
SELECT 
    department_name, street_address, city
FROM
    departments d, locations l
WHERE
    d.location_id(+) = l.location_id
ORDER BY
    d.department_name;
