-- 05_유용한 함수.sql

/*
    # DUAL 테이블
        -계산 연습 하는 데이터
        - 하나의 해만 가지고 있는테스트용 테이블
*/

SELECT 1 FROM dual;

-- ABS(n) : 절대 값
SELECT ABS(-99) FROM dual;

--Floor(n) : 버림
SELECT 3.55, FLOOR(3.55) FROM dual;
    
-- ROUND (N) :반올림
SELECT 3.55,  ROUND(3.55) FROM dual;

-- CEIL(n) : 올림
SELECT 3.11,  CEIL(3.1) FROM dual;

-- MOD(Value, divider) : 나머지 연산
SELECT MOD(5, 3) FROM dual;

-- TRUNC(value, 자리) : 지정한 자리 값 이하를 버린다.
SELECT TRUNC(1234.56789, 2) FROM dual;
SELECT TRUNC(1234.56789, -1) FROM dual;
SELECT TRUNC(1234.56789, -2) FROM dual;

-- TRUNC와 sysdate 응용
SELECT sysdate FROM dual; -- sysdate : 현재 날짜 및 시간을 구해준다.

-- TRUNC는 전달한 타입의 단위를 이용한다.
SELECT TRUNC(sysdate, 'YEAR') FROM dual;
SELECT TRUNC(sysdate, 'MONTH') FROM dual;
SELECT TRUNC(sysdate, 'DAY') FROM dual;

-- LOWER
SELECT LOWER('ABC') FROM dual;
-- UPPER
SELECT UPPER('abc') FROM dual;
-- SUBSTR(str, start, numOfChar)
--  start부터 해당 개수만큼의 문자를 자른다.
SELECT SUBSTR('Hello, world!', 1, 5) FROM dual; -- 1 base
SELECT SUBSTR('Hello, world!', 6) FROM dual;
-- LENGTH
SELECT LENGTH('ABC') FROM dual;

-- LPAD(원본, 길이, 채울문자)
-- RPAD(원본, 길이, 채울문자)
SELECT LPAD('MENU', 20 , '#') FROM dual;
SELECT RPAD('MENU', 20 , '#') FROM dual;

-- LTRIM(원본, 제거할 문자)
-- RTRIM(원본, 제거할 문자)
SELECT LTRIM('########MENU', '#') FROM dual;
SELECT RTRIM('MENU###########', '#') FROM dual;

SELECT '           MENU', LTRIM('           MENU') FROM dual;
SELECT 'MENU             ', RTRIM('MENU             ') FROM dual;

-- TRIM() : 앞 뒤의 특정 문자를 제거한다
SELECT TRIM('#' FROM '######MENU#######') FROM dual;

--------------------------------------------------------------------------------

-- 날짜 다루기
SELECT
    sysdate - 1 어제,
    sysdate 오늘, 
    sysdate + 1 내일, 
    sysdate + 2 "내일 모레" 
FROM dual;

-- 날짜 - 날짜
SELECT last_name, FLOOR((sysdate - hire_date) / 365) AS 근무해 FROM employees;

-- 날짜 형식 지정
/*
    YYYY : 년도
    YY : 년도(2자리)
    MM : 월을 숫자로
    DD : 날짜
    MON : 월을 문자로
    DAY : 요일
    DY : 요일 줄임말
    HH, HH12 : 12시
    HH24 : 24시
    mm, mi : 분
    ss : 초
    AM, PM, A.M, P.M : 오전 오후 표시
*/
SELECT last_name, TO_CHAR(hire_date, 'CC YYYY MONDD DY HH:mm:ss') FROM employees;

-- ROUND를 날짜와 함께 이용하기
SELECT last_name, TRUNC(hire_date, 'MONTH') FROM employees;
SELECT last_name, ROUND(hire_date, 'MONTH') FROM employees;

-- TRUNC와 ROUND에 날짜 포맷으로 사용될 수 있는 값들
/*
    CC : 세기(Centry, 51년 이후로 반올림)
    YEAR : 7월 1일 이후부터 반올림
    MONTH : 16일 기준으로 반올림
    DAY : 한 주 단위로 반올림 (그 주의 시작지점으로감)
*/
-- 사용한 날짜 포맷값까지 내림 또는 반올림을 한다.

-- MONTHS_BETWEEN :  두 날짜 사이의 개월 수를 구한다
SELECT MONTHS_BETWEEN(sysdate, hire_date) FROM employees;
SELECT TRUNC(MONTHS_BETWEEN(sysdate, hire_date)) FROM employees;
SELECT FLOOR(MONTHS_BETWEEN(sysdate, hire_date)) FROM employees;

-- ADD_MONTH(date, num): 해당 날짜에 전달한 개월 수를 추가한다.
SELECT last_name, hire_date, ADD_MONTHS(hire_date, 6) FROM employees;

-- NEXT_DAY(date, 요일) : 해당 날짜를 기준으로 다음 요일의 날짜를 찾는다.
SELECT NEXT_DAY(sysdate, '화요일') FROM dual;
SELECT NEXT_DAY(sysdate, '수요일') FROM dual;
SELECT NEXT_DAY(sysdate, '월요일') FROM dual;

-- LAST_DAY(date) : 해당 날짜가 속한 달의 마지막 날짜를 반환한다.
SELECT LAST_DAY(sysdate) FROM dual;
SELECT LAST_DAY('2222/02/01') FROM dual;

-------------------------------------------------------------------------------

-- 형 변환 함수들
/*
    Number    - TO_CHAR ->       Character       -  TO_DATE->     Date
    
    Number    <- TO_NUMBER -       Character       <- TO_CHAR -     Date
                        ※ 한번에 변환은 못함
*/
-- 날짜를 문자로 변환
SELECT TO_CHAR(sysdate, 'YY/MM/DD HH:mi:ss day') FROM dual;

-- 숫자를 문자로 변환
/* 
    0 : 자릿수를 나타낸다. 숫자가 비면 0으로 채운다.
    9 : 자릿수를 나타낸다. 숫자가 비면 빈칸으로 채운다.
    L : 각 지역별 통화 기호를 붙인다.
    . : 소수점을 출력한다
    , : 천 단위를 구분하는 쉼표를 사용
*/
SELECT TO_CHAR(12345, '000,000,000.00') FROM dual;
SELECT TO_CHAR(1234, '999999999') FROM dual;
SELECT last_name, TO_CHAR(salary, '99999L') FROM employees;

-- TO_DATE : 문자를 날짜로 변환
SELECT TO_DATE('1999/05/24', 'YYYY/MM/DD') FROM dual;
SELECT TO_DATE('19990524', 'YYYYMMDD') FROM dual;

-- TO_NUMBER : 문자를 숫자로 변환
SELECT TO_NUMBER('123,455', '999,999') FROM dual;

-- NVL : NULL을 다른값으로 치환
SELECT NVL(null, 'other value') FROM dual;

SELECT last_name, NVL(commission_pct, 0.0) FROM employees;
SELECT last_name, 'CEO' AS MANAGER_ID FROM employees WHERE manager_id IS NULL;

-- DECODE() : switch case 같은 역할을 한다.
SELECT * FROM employees;

SELECT 
    last_name AS myname, 
    manager_id, 
    DECODE(manager_id,
                        -- subquery : 쿼리문 내부에 사용되는 쿼리
                100, (SELECT last_name FROM employees WHERE employee_id = 100),
                102, 'De Haan',
                103, (SELECT last_name FROM employees WHERE employee_id = 103)
    ) AS manager_name
FROM
    employees
WHERE
    manager_id IN (100, 102, 103);
    
-- 연습 문제 01 : 직급에 따라 급여를 인상해서 출력해보세요
--  IT_PROG : 15%인상
--  FI_ACCOUNT : 10%인상
--  모든 CLERK : 20% 인상
-- ※ 원래 급여 before_salary 인상된 급여 after_salary로 
--      이름과 함께 출력
SELECT * FROM employees;

SELECT
    last_name, 
    job_id,
    salary AS before_salary,
    DECODE (job_id,  'IT_PROG', salary * 1.15,
                     'FI_ACCOUNT', salary * 1.10,
                     'ST_CLERK', salary * 1.20,
                     'SH_CLERK', salary * 1.20,
                     'PU_CLERK', salary * 1.20
    ) AS after_salary
FROM 
    employees
WHERE 
    job_id IN ('IT_PROG', 'FI_ACCOUNT') OR 
    job_id LIKE '%CLERK%';
    
    
-------------------------------------------------------------------------------
-- FROM TABLE 절에 SELECT문이 서브쿼리로 들어갈 수 있다 
--     (내부에서 정한 컬럼 별칭을 바깥 SELECT문에서 사용할 수 있다.) 실행 결과가 끝나기 전까지 테이블이 존재하는 개념?
SELECT 
    * 
FROM
    (SELECT
        last_name, 
        job_id,
        salary AS before_salary,
        DECODE (job_id, 'IT_PROG', salary * 1.15,
                        'FI_ACCOUNT', salary * 1.10,
                        'ST_CLERK', salary * 1.20,
                        'SH_CLERK', salary * 1.20,
                        'PU_CLERK', salary * 1.20
        ) AS after_salary
    FROM 
        employees
    )
WHERE 
    after_salary IS NOT NULL;
    
--------------------------------------------------------------------------------
-- UNION 이용하기
SELECT 
    last_name, 
    job_id, 
    salary AS before_salary, 
    salary * 1.15 AS after_salary
FROM
    employees
WHERE
    job_id = 'IT_PROG'
UNION
SELECT 
    last_name, 
    job_id, 
    salary, 
    salary * 1.1
FROM
    employees
WHERE
    job_id = 'FI_ACCOUNT'
UNION
SELECT 
    last_name, 
    job_id, 
    salary,
    salary * 1.2
FROM
    employees
WHERE
    job_id LIKE '%_CLERK';

--------------------------------------------------------------------------------    

-- DECODE는 해당 컬럼의 값과 정확하게 일치하는 값만 이용할 수 있다는 단점이 있다.
-- 그럴 때는 CASE (WHEN, THEN)절 이용한다
SELECT * FROM (SELECT 
    last_name, job_id, salary AS before_salary,
    CASE WHEN job_id = 'IT_PROG' THEN salary * 1.15
         WHEN job_id = 'FI_ACCOUNT' THEN salary * 1.1
         WHEN job_id LIKE '%CLERK%' THEN salary * 1.2
    END AS after_salary
FROM    
    employees)
WHERE
    after_salary IS NOT NULL;
    