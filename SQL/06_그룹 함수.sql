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

-- COUNT(COL) : 해당 컬럼의 행의 개수를 구한다
SELECT COUNT(salary) FROM employees;
SELECT COUNT(commission_pct) FROM employees;
SELECT COUNT(*) FROM employees;
SELECT 
    COUNT(*) AS "전체 사원 수", 
    COUNT(commission_pct) AS "보너스 받는 사원 수"
FROM 
    employees;

-- GROUP BY
/*
    - 그룹 함수를 그룹 별로 적용한 결과를 얻어낼 수 있다.
    - GROUP BY로 설정한 컬럼을 이용해 그룹을 나누게 된다.
    - GROUP으로 나눈 경우에는 그룹을 나누는 기준이 되는 컬럼과 그룹 함수의 결과만
        컬럼으로 선택 할 수 있다.
*/

SELECT job_id, COUNT(*) FROM employees GROUP BY job_id;
SELECT department_id, COUNT(*) FROM employees GROUP BY department_id;

SELECT * FROM employees;
-- 연습문제 02 : 각 직책별 평균 연봉을 구해보세요
SELECT
    job_id AS 직책,
    COUNT (*) AS "직책별 인원 수",
    AVG(salary * 12 * (NVL(commission_pct, 0)+1)) AS "평균 연봉" 
FROM 
    employees
GROUP BY
    job_id;
    
-- 그룹 함수의 결과를 조건에 사용하는 방법
-- HAVING절사용
-- 소속 사원이 10명이상인 직책
SELECT job_id FROM employees GROUP BY job_id HAVING COUNT(*) >= 10;
-- 소속 사원이 10명이상인 부서
SELECT department_id FROM employees GROUP BY department_id HAVING COUNT(*) >= 10;

-- 연습문제 03 : 부서별 최대 급여와 최소 급여를 출력하되 최대 급여가 5000이상인 부서만 출력
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
    
-- 연습문제 04 : 부서별 평균 급여를 출력하되 해당 부서에 소속된 사원이 5명이상인 경우만 출력해보세요
SELECT
    department_id as "부서 번호",
    COUNT(*) as "부서별 인원 수",
    TRUNC(AVG(salary), 2) as "평균 급여"
FROM   
    employees
GROUP BY
    department_id
Having
    COUNT(*) >= 5;
    
-- 각 매니저가 몇 명씩 맡고 있는지를 알 수 있음
SELECT COUNT(*), manager_id FROM employees GROUP BY manager_id;
-- 각 매니저가 맡은 사원들 중에 직급이 있는 사원이 몇 명 인지를 알 수 있음
SELECT COUNT(job_id), manager_id FROM employees GROUP BY manager_id;
-- 각 매니저가 맡은 사원들 중에 보너스를 받는 사원이 몇 명 인지를 알 수 있음
SELECT COUNT(commission_pct), manager_id FROM employees GROUP BY manager_id;


