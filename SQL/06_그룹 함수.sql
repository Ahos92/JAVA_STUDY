-- 06_그룹 함수.sql

-- # 그룹 함수
/*
    - 여러 행의 값을 취합하는 함수들
    - 총합, 개수, 평균, 최대, 최소 .....
    
*/

-- SUM(COL) : 해당 컬럼의 모든 행의 총합을 구한다
SELECT SUM(salary) 총월급 FROM employees;
SELECT SUM(commission_pct) FROM employees;

-- AVG(COL) : 해당 컬럼의 모든 행의 평균을 구한다.
SELECT TRUNC(AVG(salary), 2) 평균월급 FROM employees;
SELECT ROUND(AVG(salary), 2) 평균월급 FROM employees;

-- MAX(COL) : 해당 컬럼의 모든 값들 중 최대 값을 구한다
SELECT MAX(salary) FROM employees;
-- MIN(COL) : 해당 컬럼의 모든 값들 중 최소 값을 구한다
SELECT MIN(salary) FROM employees;

-- ※ 그룹 함수는 일반 컬럼과 함께 사용할 수 없다.
--      ( 모든 행의 연산결과를 담기 때문에 단일 행이 불가능 한것 )

-- 서브쿼리로 쓸 수 있음
SELECT last_name, salary AS "최고 월급" FROM employees WHERE salary = (SELECT MAX(salary) FROM employees);


-- 연습 문제 01 : 가장 최근에 입사한 사원의 입사일과 
-- 입사한지 가장 오래된 사원의 입사일을 출력하는 쿼리문을 작성해보십시오
SELECT 
    MIN(hire_date) AS "가장 오래된 사원 입사일", 
    MAX(hire_date) AS "가장 최근 사원 입사일"
FROM employees;
