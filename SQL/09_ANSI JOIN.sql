-- 09_ANSI JOIN.sql

-- ANSI(미국 국가 표준 협회) 에서 정한 표주을 따르는 JOIN문법

-- ANSI CROSS JOIN
SELECT
    *
FROM
         employees
    CROSS JOIN departments;

-- ANSI INNER JOIN : 조건에 맞는 행만등장하는 JOIN

SELECT
    *
FROM
         employees e
    INNER JOIN departments d ON e.department_id = d.department_id;

/*
    ANSI OUTTER JOIN : 조건에 안 맞는 행동도 보고싶을 대 사용하는 JOIN
    
        - LEFT OUTER JOIN :  오른쪽에 (+)를 붙인 경우와 같음
        - RIGHT OUTER JOIN : 왼쪽에 (+)를 붙인 경우와 같음
        - FULL OUTER JOIN : 양쪽에 (+)를 붙인 경우와 같음
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

-- ANSI JOIN을 이용할 때 JOIN조건에 이용되는 컬럼명이 같은 경우
-- USING을 이용해 쿼리문을 간소화 할수 있다.

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

-- JOIN에 사용되는 조건과 필요해서 사용하는 조건이 구분된다
-- USING에 사용된 컬럼은 어느 테이블의 컬럼인지 명확히 할 필요가 없다.

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

-- ANSI JOIN을 이용하여 풀어보세요
-- 연습문제01 : first_name이 Neena인 사원과 같은 도시에서 근무하는 모든 사원의 이름과 부서번호를 조회해보세요

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


-- 연습문제02 : first_name이 Neena인 사원과 급여가 5000이상 차이나지 않는 모든 사원을 조회해보세요

SELECT
    e1.*
FROM
         employees e1
    INNER JOIN employees e2 ON e2.first_name = 'Neena'
                            AND ABS (e2.salary - e1.salary) <= 5000;
    
    
-- 연습문제03 : Seattle에서 근무하는 모든 사원의 이름과 부서명, 도시를 조회해보세요

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
    
    
-- 연습문제04 : 매니저의 이름이 King인 모든 사원의 이름/직책명/연봉을 조회해보세요

SELECT
    e.first_name,
    e.last_name,
    job_title,
    e.salary * ( nvl(e.commission_pct, 0) + 1 ) * 12 AS 연봉
FROM
         employees e
    INNER JOIN employees  p ON e.manager_id = p.employee_id
    INNER JOIN jobs       j ON e.job_id = j.job_id
                         AND p.last_name = 'King';