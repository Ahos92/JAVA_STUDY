-- 11_테이블 생성.sql

/*
    # DML (Data Manipulation Language, 데이터 조작어)
        - 테이블 내부의 데이터를 검색/추가/수정/삭제 하는 명령어
        - SELECT : 검색
        - INSERT : 생성
        - UPDATE : 수정
        - DELETE : 삭제 
        
    # DDL (Data Definition Language, 데이터 정의어)
        - 테이블 등(시퀀스, 인덱스, 뷰 ...) 의 구조를 생성하는데 사용하는 명령어
        - CREATE : 생성
        - DROP : 삭제
        - ALTER : 수정
        - TRUNCATE : 완전 삭제
        
    # DCL (Data Control Language, 데이터 제어 명령어)
        - 사용자의 권한을 관리하는데 사용하는 명령어
        - GRANT : 사용자에게 권한을 부여
        - REVOKE : 사용자의 권한을 회수
*/
/*
    # 테이블 생성
        CREATE TABLE 테이블명 (컬럼이름01 컬럼타입01, 컬럼이름02 컬럼타입02 ...);
*/
CREATE TABLE coffees (
    cid     NUMBER(4),
    cname   VARCHAR2(30),
    cprice  NUMBER(6)
);

DESC coffees;

-- # 기존에존재하는 테이블을 복제하면서 만들기 ★★
CREATE TABLE employees2 AS SELECT * FROM employees;
-- 원하는 컬러만 가지고 복제
CREATE TABLE employees3 AS SELECT last_name AS 이름, salary AS 월급, job_id AS 직급 FROM employees;

SELECT * FROM employees3;

-- # 테이블 삭제하기

SELECT * FROM tab;

DROP TABLE coffees;

DROP TABLE employees2;

-- # 휴지통 검색

SHOW recyclebin;

SELECT * FROM recyclebin;

-- # 휴지통 복구하기

FLASHBACK TABLE coffees TO BEFORE DROP;

-- # 휴지통 비우기
PURGE RECYCLEBIN;

-- # 휴지통 거치지 않고 바로 테이블 삭제
DROP TABLE coffees PURGE;
DROP TABLE employees3 PURGE;

-- 연습문제01 : 50번 부서 사람들로만 구성된 테이블을 하나 생성해보세요
CREATE TABLE employees4 AS SELECT * from employees where department_id = 50;
select * from employees4;
drop table employees4 purge;


-- # 테이블의 구조만 복사하기 (일부러 말도 안되는 조건을 넣고 테이블을 복사)
CREATE TABLE employeee AS SELECT * FROM employees WHERE 1 = 0;
desc employeee;
drop table employeee purge;


-- # 테이블 구조 변경 명령어들
CREATE TABLE coffees (
    cid     NUMBER(4),
    cname   VARCHAR2(30),
    cprice  NUMBER(6)
);

-- # ALTER TABLE 테이블명 ADD (컬럼명 컬럼타입, ...)
ALTER TABLE coffees ADD (
    LOCATION_ID NUMBER(4),
    ACIDITY NUMBER(4, 2)
);
DESC coffees;

-- # ALTER TABLE 테이블명 MODIFY (컬럼명 컬럼타입, ...) 
--  컬럼 변경은 데이터 타입이나 크기 등을 변경할 수 있다.
--  컬럼명은 변경 불가 
ALTER TABLE coffees MODIFY(
    CID NUMBER(3),
    CNAME VARCHAR2(50)
);
DESC COFFEES;

-- # ALRTER TABLE 테이블명 DROP COLUMN 컬럼명;
ALTER TABLE coffees DROP COLUMN acidity;
DESC coffees;

-- # 삭제할 준비 시키기 (SET UNUSED) : ALTER TABLE 테이블명 SET UNUSED(컬럼명)
--     - 해당 컬럼을 삭제하기 전에 사용하지 못하는 상태로 변경한다.
--     - 물리적인 삭제는 나중에 진행할 때 사용한다.
--     - 테이블에 저장된 행이 많을 때 안전한 시간에 삭제하기 위해 진행한다. (논리적으로만 배제된 것)
ALTER TABLE coffees SET UNUSED(location_id);
desc coffees;
-- 안전한 시간대에 삭제를 진행한다.
ALTER TABLE coffees DROP UNUSED COLUMNS;
DESC COFFEES;

-- # 테이블 명 변경하기
RENAME coffees TO coffe_shop;
select * from tab;

-- # 컬럼명 수정하기
ALTER TABLE coffe_shop RENAME COLUMN cid to cfid;
desc coffe_shop;

------------------------------------------------------------------------------------

/*
    # 데이터 딕셔너리
        - 테이블을 추가하면 DB에 존재하는 테이블의 정보를 DBMS가 알아서 관리한다.
        - 이처럼 사용자가 직접 관리하는 것이 아닌 데이터들을 데이터 딕셔너리라고 부른다.
        
    # 데이터 딕셔너리 뷰
        - 데이터 딕셔너리를 사용자가 보기 편리하도록 변환하여 제공하는 뷰(View)
*/
-- # 테이블 데이터 딕셔너리 뷰
select * from tab;
select * from tabs;
select * from user_tables; -- USER_ : 현재 user가 가지고 있는 정보만 보여주는 데이터 딕셔너리 뷰
select * from all_tables; -- ALL_ : 모든 USER가 가지고 있는 정보를 보여주는 데이터 딕셔너리 뷰

-- # 제약조건(comstraints) 데이터 딕셔너리 뷰
SELECT * FROM user_constraints;
SELECT * FROM all_constraints;
show user;