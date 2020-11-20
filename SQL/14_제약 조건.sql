-- 14_제약 조건.sql

/*
    # 데이터 무결성
        - 데이터가 항상 유지해야 하는 성질
        - 데이터가 정확성 + 일관성을 유지하기 위해 필요한 것
        
        - 개체 무결성 
            하나의 행을 구분할 수 있는 컬럼이 반드시 존재해야한다.
            테이블에는 반드시 PK가 존재해야 한다
        - 참조 무결성
            참조 관계에 있는 데이터가 항상 일관된 값을 가져야 한다.
            외래키는 반드시 참조하는 테이블에 존재하는 값을 사용해야 한다.
        - 도메인 무결성
            해당 컬럼의 값의 타입이 일정해야한다.
            
     # 데이터 무결성 제약 조건
        - 테이블에 무결성을 해치는 부적절한 데이터가 입력되는것을 방지하기 위한 규칙
        - NOT NULL : 해당 컬럼에 NULL을 허용하지 않는 규칙
        - UNIQUE : 해당 컬럼에 중복값을 허용하지 않는 규칙, 항상 유일한 값을 갖도록 함
        - PRIMARY KEY : NOT NULL + UNIQUE. 기본키의 조건.
        - FOREIGN KEY : 외래키로 설정된 컬럼은 참조하는 컬럼에 존재하는 값만 추가할 수 있다.
        - CHECK : 데이터의 범위나 조건을 직접 지정하여 도메인 무결성을 유지할 수 있다.
                    지정할 때 () 안에 조건
*/

-- # 제약조건 데이터 딕셔너리 뷰
SELECT * FROM user_constraints WHERE table_name = 'EMPLOYEES';
SELECT * FROM all_constraints WHERE owner = 'HR' AND table_name = 'DEPARTMENTS';

/*
    # 제약 조건 테이블 보는 방법
        - CONSTRAINT_TYPE
            P : Primart key
            R : Foreign Key
            C : Check or Not Null
            U : UNIQUE
            
        - R이 붙은 컬럼들은 해당 외래키가 참조하는 컬럼(PK, UINQUE)의 정보를 담고 있다.
            - R_OWNER : 외래키가 참조하는 테이블의 소유자
            - R_CONSTRAINT_NAME : 외래키가 참조하는 제약조건
            
*/

-- # 테이블 생성 시 제약조건 정의하기
CREATE TABLE FRUITS(
    fid number(10) primary key,
    fname varchar2(30) not null
);

-- # 컬럼 추가시 제약조건 정의하기
ALTER TABLE FRUITS ADD(
    color varchar2(10) not null
);

/*
    ※ 제약조건을 정의할 때 제약조건명을 지정하지 않으면 오라클이 제약조건명을 자동으로 부여한다.
        오라클이 자동으로 부여한 제약조건명으로는 어떤 제약조건을 위반했는지 알기 힘들기 때문에
        반드시 지정하는것이 좋다
    
    # 제약 조건명 규칙 : [테이블명]_[컬럼명]_[제약조건 유형]
        ex) EMP_DEPT_FK
            DEPT_ID_PK
            DEPT_LOC_fk
            DEPT_NAME_NN
*/

-- # 제약조건 이름과 함께 제약조건 정의하는 방법
ALTER TABLE FRUITS ADD (
    sweet number(4, 2) constraint FRUIT_SWEET_NN NOT NULL,
    fsize number(2) constraint fruit_size_STAND CHECK(fsize BETWEEN 10 AND 20)
);

INSERT INTO fruits VALUES(1, '배', 'brown', 8.88, -5); 

desc fruits;
select * from user_constraints where table_name = 'FRUITS';


/*
    연습문제01 : 학생 테이블 생성하되 다음과 같은 제약조건을 지켜서 만들어보세요
    
        학생번호 4자리 정수, PK
        학생이름 10글자 가변문자, NOT NULL
        학생성별 1글자 고정문자, 값 M or F만 허용
        학생성적 1글자 고정, 값 A,B,C,D,F NOT NULL
        핸드폰번호 13글자 고정문자, 오라클 정규표현식 함수를 이용해 핸드폰 정규식를 만족하는 경우, NOT NULL
        
        ※ 모든 제약 조건이 자동 생성된 제약 조건명이 아니어야함
*/
-- column-level constraints방식
CREATE TABLE STUDENTS (
    ST_ID number(4) constraint ST_ID_PK primary key,
    ST_NAME varchar2(10) CONSTRAINT ST_NAME_NN not null,
    ST_GENDER char(1) CONSTRAINT ST_GENDER_MF check(ST_GENDER in ('M', 'F')),
    ST_GRADE char(1) CONSTRAINT ST_GRADE_AF check(ST_GRADE in ('A', 'B', 'C', 'D', 'F')) 
                        CONSTRAINT ST_GRADE_NN NOT NULL,
    ST_TEL char(13) CONSTRAINT ST_TEL_REG check(REGEXP_LIKE(ST_TEL, '^010-\d{4}-\d{4}$')) 
                        CONSTRAINT ST_TEL_NN NOT NULL
                        CONSTRAINT ST_TEL_UK UNIQUE
);

drop table students;

INSERT INTO STUDENTS VALUES(1, '김영호', 'M', 'C', '010-1234-1234');
INSERT INTO STUDENTS VALUES(2, '김영호', NULL, 'A', '010-1234-1234');

INSERT INTO STUDENTS VALUES(3, '김영호', 'F', NULL, '010-1234-1234');
INSERT INTO STUDENTS VALUES(3, '김영호', 'F', 'A', '010-124-1234');


/*
    # DEFAULT 제약 조건
        - 컬럼에 아무 값도 입력하지 않았을 때 사용 할 기본 값을 설정해둔다.
*/
ALTER TABLE students ADD(
    st_kor NUMBER(3) DEFAULT 0
);

ALTER TABLE students MODIFY(
    st_kor NUMBER(3) DEFAULT 3
);

desc students;
select * from user_constraints where table_name = 'STUDENTS';
SELECT * FROM STUDENTS;
-- # 테이블 컬럼 데이터 딕셔너리 뷰에서 해당 컬럼의 DATA_DEFAULT를 확인할 수 있다.
SELECT * FROM user_tab_columns WHERE table_name = 'STUDENTS';

-------------------------------------------------------------------------------------------
/*
     # table-level
        -컬럼을 모두 정의한 뒤에 따로 제약조건 정의하기
        - DEFAULT와 NOT NULL은 table-level에서 정의할 수 없다.
*/
CREATE TABLE students2(
    st_id       number(4),
    st_name     varchar2(10) DEFAULT '김철수' CONSTRAINT st2_name_nn NOT NULL,
    st_gender   char(1),
    st_grade    char(1),
    CONSTRAINT st2_id_pk PRIMARY KEY (st_id),
    --CONSTRAINT st2_id_pk PRIMARY KEY(st_id, st_tel), -- 테이블 라벨을 이용하면 복합 기본키를 지정할 수 있다
    CONSTRAINT st2_gender_ch CHECK (st_gender IN ('M', 'F')),
    CONSTRAINT st2_grade_ch CHECK (st_grade IN ('A', 'B', 'C', 'D', 'F'))
);
DESC students2;

-------------------------------------------------------------------------------------

/*
    # Foreign Key 설정하기
        - 제약조건을 설정할 때 어떤 테이블의 어떤 컬럼을 참조할지 함께 설정해야 한다.
*/
-- # 컬럼-레벨로 FK 설정하기
-- 다른 테이블의 PK혹은 UNIQUE로 설정된 컬럼만 외래키로 참조할 수 있다.
ALTER TABLE students ADD (
    location_id NUMBER(4) CONSTRAINT st_loc_fk REFERENCES locations ( location_id )
);
-- PK 혹은 UNIQUE가 아닌 컬럼을 참조할 경우
ALTER TABLE students ADD (
    st_parent varchar2(25) CONSTRAINT st_pa_fk REFERENCES employees ( last_name )
);

-- # 테이블-레벨로 FK설정하기
--  - FK 역할을 하는 컬러은 FOREIGN KEY로 설정하고, 참조하는 테이블 및 컬럼은 REFERENCES로 설정한다
ALTER TABLE students ADD(
    department_id NUMBER(4),
    CONSTRAINT st_dept_fk FOREIGN KEY (department_id) REFERENCES departments (department_id)
);

INSERT INTO students VALUES(1, '홍길동', 'M', 'B', '010-1234-1234', 90, 2500, 10);

SELECT * FROM students INNER JOIN locations USING (location_id)
                        INNER JOIN departments USING (department_id);

SELECT * FROM STUDENTS;
select * from user_constraints where table_name = 'STUDENTS';

select * from locations;
select * from user_constraints where table_name = 'LOCATINS'; -- loc_id_pk

--------------------------------------------------------------------------------

ALTER TABLE students2 ADD(
    st_tel char(13)
);
-- # 이미 존재하는 컬럼에 제약조건 추가하기
ALTER TABLE students2 ADD CONSTRAINT st2_tel_uk UNIQUE(st_tel);
-- # NOT NULL, DEFAULT 는 ADD CONSTRAINT 대신 MODIFY를 이용해 수정한다.
ALTER TABLE students2 MODIFY st_tel CONSTRAINT st2_tel_nn NOT NULL;
ALTER TABLE students2 MODIFY st_tel DEFAULT '000-0000-0000';

-- # 컬럼에 이미 존재하는 제약조건 제거하기
ALTER TABLE students2 DROP CONSTRAINT st2_tel_uk;


desc students2;
select * from user_constraints where table_name = 'STUDENTS2';
select * from user_tab_columns where table_name = 'STUDENTS2';


--------------------------------------------------------------------------------

/*
    # ON DELETE 절
        - FK가 참조하고 있는 PK가 삭제되었을 때 해당 FK를 어떻게 변경할지 설정한다
        - CASCADE : 참조하던 PK가 삭제 되면 FK의 행을 함께 삭제한다.
                ex) department에서 50번 부서를 삭제하면 employees의 모든 50번 부서에 속한 사원이 삭제된다.
                
        - SET NULL : 참조하더 PK가 삭제되면 FK의 값을 NULL로 변환한다.
                ex) department에서 50번 부서를 삭제하면 employees의 모든 50번 부서에 속한 사원의
                        department_id를 null로 반환한다.

        - RESTRICT : 자식이 있는 부모키는 삭제를 할 수 없도록 제한한다.
            (ON DELETE를 설정하지 않은 경우)
*/

CREATE TABLE empp AS SELECT * FROM employees;
CREATE TABLE depp AS SELECT * FROM departments;
CREATE TABLE jobb AS SELECT * FROM jobs;

select * from user_constraints where table_name = 'EMPLOYEES';
select * from user_constraints where table_name = 'DEPARTMENTS';

-- 연습문제02 : EMPP 테이블과 DEPP 테이블의 기본키/외래키 제약 조건을 설정해보세요.
ALTER TABLE empp ADD CONSTRAINT empp_id_pk PRIMARY KEY(employee_id);
ALTER TABLE depp ADD CONSTRAINT depp_id_pk PRIMARY KEY(department_id);
ALTER TABLE jobb ADD CONSTRAINT jobb_id_pk PRIMARY KEY(job_id);

ALTER TABLE empp ADD (
    CONSTRAINT empp_dept_fk FOREIGN KEY (department_id) REFERENCES depp(department_id),
    -- self join 값
    CONSTRAINT empp_manager_fk FOREIGN KEY (manager_id) REFERENCES empp(employee_id),
    CONSTRAINT empp_job_fk FOREIGN KEY (job_id) REFERENCES jobb(job_id),
    CONSTRAINT empp_email_uk UNIQUE(email)
);
-- 이미 NOT NULL값으로 넘어온 이름 변경
ALTER TABLE empp RENAME CONSTRAINT SYS_C0014491 TO empp_last_name_nn;
ALTER TABLE empp RENAME CONSTRAINT SYS_C0014492 TO empp_email_nn;
ALTER TABLE empp RENAME CONSTRAINT SYS_C0014493 TO empp_hire_date_nn;
ALTER TABLE empp RENAME CONSTRAINT SYS_C0014494 TO empp_job_id_nn;
ALTER TABLE depp RENAME CONSTRAINT SYS_C0014495 TO depp_name_nn;

-- 테스트용 테이블 복제 하기----------------------------------------------------------------
select * from user_constraints where table_name = 'EMPP';
select * from user_constraints where table_name = 'DEPP';

ALTER TABLE empp DROP CONSTRAINT empp_dept_fk;
-- # ON DELETE CASCADE 테스트
-- 1.외래키를 ON DELETE로 설정
ALTER TABLE empp 
    ADD CONSTRAINT empp_dept_fk FOREIGN KEY (department_id) 
        REFERENCES depp(department_id)ON DELETE CASCADE;

SELECT * FROM empp ORDER BY department_id;

-- 2. 부모키를 삭제 (30번 부서를 삭제)
SELECT * FROM depp;
DELETE FROM depp WHERE department_id = 30;

SELECT * FROM empp ORDER BY department_id;

-- ※ CASCADE는 부모키를 삭제하면 관련 FK행이 모두 함께 삭제된다.

------------------------------------------------------------------------
ALTER TABLE empp DROP CONSTRAINT empp_dept_fk;

-- # ON DELETE SET NULL 테스트
-- 1. 외래키를 ON DELETE SET NULL로 설정
ALTER TABLE empp 
    ADD CONSTRAINT empp_dept_fk FOREIGN KEY (department_id) 
        REFERENCES depp(department_id)ON DELETE SET NULL;

-- 2. SET NULL인 상태로 100번 부서를 삭제
DELETE FROM depp WHERE department_id = 100;

SELECT * FROM empp ORDER BY department_id DESC;
-- ※ SET NULL은 부모키를 삭제하면 관련 FK행이 모두 함께 NULL이 된다.


------------------------------------------------------------------------
ALTER TABLE empp DROP CONSTRAINT empp_dept_fk;

-- # ON DELETE 기본값(RESTRICT) 테스트
-- 1. 외래키를 기본값으로 설정
ALTER TABLE empp 
    ADD CONSTRAINT empp_dept_fk FOREIGN KEY (department_id) 
        REFERENCES depp(department_id);
        
-- 2. 기본값인 상태로 50번 부서를 삭제
DELETE FROM depp WHERE department_id = 50;

SELECT * FROM empp ORDER BY department_id ASC;
-- ※ ON DELETE가 설정되지 않은 경우 자식레코드가 있는 부모키를 삭제 할 수 없다.