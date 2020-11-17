-- 02_SELECT.sql

/*
    # SELECT 컬럼명 FROM 테이블명;
        - 데이터를 조회하는 쿼리문
        - 컬럼명 = * 은 모든 컬럼을 의미
    
    

*/

-- tab 테이블에서 모든 컬럼(속성, 필드, 열)을 조회한다.
SELECT * FROM tab; 

-- 연습용 테이블 설명
/*
    COUNTRIES : 국가 정보를 저장한 테이블
    EMPLOYEES : 사원 정보를 저장한 테이블
    DEPARTMENTS : 부서 정보를 저장한 테이블
    JOBS : 직급 정보를 저장한 테이블
    LOCATIONS : 지역 정보를 저장한 테이블
    REGIONS : 대륙 정보를 저장한 테이블
*/

-- 직원 테이블의 모든 컬럼을 조회한다.
SELECT * FROM employees; 

-- 컬럼명을 적으면 해당 컬럼의 데이터만 조회한다.
SELECT last_name, phone_number, hire_date FROM employees; 

-- -------------------------------------------------------------------------
-- 테이블의 속성 정보 보기
DESC employees;
DESC countries;

-- 오라클의 데이터 타입
/*
    # NUMBER(n) , NUMBER(n, m)
        - 숫자 데이터를 저장할 때 사용하는 컬럼 타입
        - NUMBER(6) : 6자리 정수를 저장할 수 있는 컬럼이 된다.
        - NUMBER(6, 3) : 3자리 정수와 3자리 소수점을 저장할 수 있는 컬럼이 된다.
    
    # CHAR(n)
        - 고정 길이 문자 데이터를 저장할 때 사용하는 컬럼 타입
        - 설정된 길이보다 적은 문자 데이터가 들어와도 고정적으로 설정된 길이를 차지
        - CHAR(10)로 설정된 컬럼에 2글자가 들어오더라도 10Byte를 차지
        
    # VARCHAR2(n)
        - 가변 길이문자 데이터를 저장할 때 사용하는 컬럼 타입
        - 저장된 데이터의 크기에 따라 알맞은 공간만 사용한다.
        - 저장 공간의 낭비를 줄일 수 있다.
        - VARCHAR2(10)로 설정된 컬럼에 2글자가 들어오면 2Byte만 차지한다.
        
    # DATE
        - 날짜 및 시간을 저장하는 컬럼 타입
        - 세기/년/월/일/시/분/초/요일 등을 저장한다.
*/
select * from countries;

-- 연습문제01 : 모든 사원의 사번/이름/월급/부서번호를 조회해보세요
select employee_id, first_name, salary, department_id from employees;
-- ※ 컬럼명, 테이블명은 대소문자를 구분하지 않는다.
-- Keyword는 대문자로 써주는게 관행

-- 산술연산자로 계산된 값 출력하기
SELECT last_name, salary FROM employees;
SELECT last_name, salary + 500 FROM employees;
SELECT last_name, salary * 2 FROM employees;
SELECT last_name, salary / 10 FROM employees;

-- 월급에 보너스 적용해보기
-- 계산식으로 인한 컬럼명 변경을 AS를 이용해 컬럼명을 직접 정할수 있다.
SELECT last_name, salary * commission_pct AS commission FROM employees;

-- 월급 + 보너스
-- null은 존재하지 않는 값이기 때문에 산술연산에 포함되면 무조건 null이 된다.
SELECT last_name, salary + salary * commission_pct AS 실수령액 FROM employees;
-- NVL(컬럼명, 대체값) 함수 : 해당 컬럼에서 NULL값이 나왔을 때 대체값을 사용한다
SELECT last_name, salary * (NVL(commission_pct, 0) + 1) AS total_salary FROM employees;

-- "컬럼명"을 이용하면 컬럼명에도 대소문자를 구분할 수 있다.
SELECT last_name AS "last_Name" FROM employees;
SELECT last_name AS "lastName" FROM employees;


-- 연습문제02 :  모든 사원들의 사번/이름/연봉을 출력해보세요 (salary는 월급)
SELECT employee_id, first_name , salary * 12 * (NVL(commission_pct, 0) + 1) AS 연봉 FROM employees; 

-- -----------------------------------------------------------------------------
-- SELECT DISTINCT : 중복되는 결과가 있어도 한 번만 조회된다.

-- 직원들의 직책을 한번씩만 볼 수 있다.
SELECT DISTINCT job_id FROM employees;

-- 모든 직원들이 속한 부서번호를 한번씩만 볼 수 있다.
SELECT DISTINCT department_id FROM employees;

-- 매니저 역할을 하고있는 사원들의 사번을 한번씩만 조회할 수 있다.
SELECT DISTINCT manager_id FROM employees;

