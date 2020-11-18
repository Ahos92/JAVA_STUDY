-- 07_정렬.sql

-- ORDER BY
/* 
    ORDER BY절을 통해 조회한 내용을 원하는 컬럼 기준으로 정렬 할 수 있다.
        - ASC (ASCENDING) : 오름차순, default값(생략 가능)
        - DESC (DESCENDING) : 내림차순

*/
SELECT * FROM employees; -- 기본 인덱스순
SELECT * FROM employees ORDER BY salary; -- 월급 오름차순
SELECT * FROM employees ORDER BY salary DESC; --  월급 내림차순

-- 먼저 직급 순으로 정렬후 ,  LAST_NAME의 알파벳 순으로 정렬 후, 사번으로 정렬
SELECT * FROM employees ORDER BY job_id DESC, last_name, employee_id;

SELECT COUNT(*), job_id FROM employees GROUP BY job_id ORDER BY COUNT(*) DESC;

-- 연습문제01 : 모든 사원 조회하되 부서번호로 정렬한 뒤 같은 부서 끼리는 First_name 알파벳순
SELECT * FROM employees ORDER BY department_id, first_name;

-- 연습문제02 : 모든 사원들을 최근 입사한 순서대로 조회해보세요.
SELECT * FROM employees ORDER BY hire_date DESC;

-- 연습문제03 : 부하 직원이 있는 사원들만 월급 기준으로 정렬하여 조회해보세요 (매니저 아이디 임플로이 아이디 비교)
SELECT
    *
FROM
    employees
WHERE
    employee_id 
    IN (SELECT DISTINCT manager_id FROM employees WHERE manager_id IS NOT NULL)
ORDER BY
    salary DESC;
