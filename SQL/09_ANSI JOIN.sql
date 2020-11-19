-- 09_ANSI JOIN.sql

-- ANSI(�̱� ���� ǥ�� ��ȸ) ���� ���� ǥ���� ������ JOIN����

-- ANSI CROSS JOIN
SELECT
    *
FROM
         employees
    CROSS JOIN departments;

-- ANSI INNER JOIN : ���ǿ� �´� �ุ�����ϴ� JOIN

SELECT
    *
FROM
         employees e
    INNER JOIN departments d ON e.department_id = d.department_id;

/*
    ANSI OUTTER JOIN : ���ǿ� �� �´� �ൿ�� ������� �� ����ϴ� JOIN
    
        - LEFT OUTER JOIN :  �����ʿ� (+)�� ���� ���� ����
        - RIGHT OUTER JOIN : ���ʿ� (+)�� ���� ���� ����
        - FULL OUTER JOIN : ���ʿ� (+)�� ���� ���� ����
*/

SELECT
    first_name,
    department_name
FROM
    employees    e
    RIGHT OUTER JOIN departments  d ON e.department_id = d.department_id;
-----------------------------------------------

SELECT
    first_name,
    department_name
FROM
    employees    e
    LEFT OUTER JOIN departments  d ON e.department_id = d.department_id
                                     AND last_name = 'King';
------------------------------------------------

SELECT
    first_name,
    department_name
FROM
    employees    e
    FULL OUTER JOIN departments  d ON e.department_id = d.department_id
                                     AND last_name = 'King'
ORDER BY
    last_name ASC;

-- ANSI JOIN�� �̿��� �� JOIN���ǿ� �̿�Ǵ� �÷����� ���� ���
-- USING�� �̿��� �������� ����ȭ �Ҽ� �ִ�.

SELECT
    *
FROM
         employees e
    INNER JOIN departments d USING ( department_id );

SELECT
    *
FROM
    employees    e
    LEFT OUTER JOIN departments  d USING ( department_id );

SELECT
    *
FROM
    employees    e
    RIGHT OUTER JOIN departments  d USING ( department_id );

SELECT
    *
FROM
    employees    e
    FULL OUTER JOIN departments  d USING ( department_id );

-- JOIN�� ���Ǵ� ���ǰ� �ʿ��ؼ� ����ϴ� ������ ���еȴ�
-- USING�� ���� �÷��� ��� ���̺��� �÷����� ��Ȯ�� �� �ʿ䰡 ����.

SELECT
    last_name,
    department_id,
    department_name
FROM
         employees e
    INNER JOIN departments d USING ( department_id )
WHERE
    salary <= 10000
ORDER BY
    salary DESC;

-- ANSI JOIN�� �̿��Ͽ� Ǯ�����
-- ��������01 : first_name�� Neena�� ����� ���� ���ÿ��� �ٹ��ϴ� ��� ����� �̸��� �μ���ȣ�� ��ȸ�غ�����

SELECT
    first_name,
    last_name,
    department_id
FROM
         employees
    INNER JOIN departments USING ( department_id )
    INNER JOIN locations USING ( location_id )
WHERE
    city = (
        SELECT
            city
        FROM
                 employees e
            INNER JOIN departments  d USING ( department_id )
            INNER JOIN locations    l USING ( location_id )
        WHERE
            first_name = 'Neena'
    );


-- ��������02 : first_name�� Neena�� ����� �޿��� 5000�̻� ���̳��� �ʴ� ��� ����� ��ȸ�غ�����

SELECT
    e1.*
FROM
         employees e1
    INNER JOIN employees e2 ON e2.first_name = 'Neena'
                            AND ABS (e2.salary - e1.salary) <= 5000;
    
    
-- ��������03 : Seattle���� �ٹ��ϴ� ��� ����� �̸��� �μ���, ���ø� ��ȸ�غ�����

SELECT
    first_name,
    last_name,
    department_name,
    city
FROM
         employees
    INNER JOIN departments USING ( department_id )
    INNER JOIN locations USING ( location_id )
WHERE
    city = 'Seattle';
    
    
-- ��������04 : �Ŵ����� �̸��� King�� ��� ����� �̸�/��å��/������ ��ȸ�غ�����

SELECT
    e.first_name,
    e.last_name,
    job_title,
    e.salary * ( nvl(e.commission_pct, 0) + 1 ) * 12 AS ����
FROM
         employees e
    INNER JOIN employees  p ON e.manager_id = p.employee_id
    INNER JOIN jobs       j ON e.job_id = j.job_id
                         AND p.last_name = 'King';