-- 14_���� ����.sql

/*
    # ������ ���Ἲ
        - �����Ͱ� �׻� �����ؾ� �ϴ� ����
        - �����Ͱ� ��Ȯ�� + �ϰ����� �����ϱ� ���� �ʿ��� ��
        
        - ��ü ���Ἲ 
            �ϳ��� ���� ������ �� �ִ� �÷��� �ݵ�� �����ؾ��Ѵ�.
            ���̺��� �ݵ�� PK�� �����ؾ� �Ѵ�
        - ���� ���Ἲ
            ���� ���迡 �ִ� �����Ͱ� �׻� �ϰ��� ���� ������ �Ѵ�.
            �ܷ�Ű�� �ݵ�� �����ϴ� ���̺� �����ϴ� ���� ����ؾ� �Ѵ�.
        - ������ ���Ἲ
            �ش� �÷��� ���� Ÿ���� �����ؾ��Ѵ�.
            
     # ������ ���Ἲ ���� ����
        - ���̺� ���Ἲ�� ��ġ�� �������� �����Ͱ� �ԷµǴ°��� �����ϱ� ���� ��Ģ
        - NOT NULL : �ش� �÷��� NULL�� ������� �ʴ� ��Ģ
        - UNIQUE : �ش� �÷��� �ߺ����� ������� �ʴ� ��Ģ, �׻� ������ ���� ������ ��
        - PRIMARY KEY : NOT NULL + UNIQUE. �⺻Ű�� ����.
        - FOREIGN KEY : �ܷ�Ű�� ������ �÷��� �����ϴ� �÷��� �����ϴ� ���� �߰��� �� �ִ�.
        - CHECK : �������� ������ ������ ���� �����Ͽ� ������ ���Ἲ�� ������ �� �ִ�.
                    ������ �� () �ȿ� ����
*/

-- # �������� ������ ��ųʸ� ��
SELECT * FROM user_constraints WHERE table_name = 'EMPLOYEES';
SELECT * FROM all_constraints WHERE owner = 'HR' AND table_name = 'DEPARTMENTS';

/*
    # ���� ���� ���̺� ���� ���
        - CONSTRAINT_TYPE
            P : Primart key
            R : Foreign Key
            C : Check or Not Null
            U : UNIQUE
            
        - R�� ���� �÷����� �ش� �ܷ�Ű�� �����ϴ� �÷�(PK, UINQUE)�� ������ ��� �ִ�.
            - R_OWNER : �ܷ�Ű�� �����ϴ� ���̺��� ������
            - R_CONSTRAINT_NAME : �ܷ�Ű�� �����ϴ� ��������
            
*/

-- # ���̺� ���� �� �������� �����ϱ�
CREATE TABLE FRUITS(
    fid number(10) primary key,
    fname varchar2(30) not null
);

-- # �÷� �߰��� �������� �����ϱ�
ALTER TABLE FRUITS ADD(
    color varchar2(10) not null
);

/*
    �� ���������� ������ �� �������Ǹ��� �������� ������ ����Ŭ�� �������Ǹ��� �ڵ����� �ο��Ѵ�.
        ����Ŭ�� �ڵ����� �ο��� �������Ǹ����δ� � ���������� �����ߴ��� �˱� ����� ������
        �ݵ�� �����ϴ°��� ����
    
    # ���� ���Ǹ� ��Ģ : [���̺��]_[�÷���]_[�������� ����]
        ex) EMP_DEPT_FK
            DEPT_ID_PK
            DEPT_LOC_fk
            DEPT_NAME_NN
*/

-- # �������� �̸��� �Բ� �������� �����ϴ� ���
ALTER TABLE FRUITS ADD (
    sweet number(4, 2) constraint FRUIT_SWEET_NN NOT NULL,
    fsize number(2) constraint fruit_size_STAND CHECK(fsize BETWEEN 10 AND 20)
);

INSERT INTO fruits VALUES(1, '��', 'brown', 8.88, -5); 

desc fruits;
select * from user_constraints where table_name = 'FRUITS';


/*
    ��������01 : �л� ���̺� �����ϵ� ������ ���� ���������� ���Ѽ� ��������
    
        �л���ȣ 4�ڸ� ����, PK
        �л��̸� 10���� ��������, NOT NULL
        �л����� 1���� ��������, �� M or F�� ���
        �л����� 1���� ����, �� A,B,C,D,F NOT NULL
        �ڵ�����ȣ 13���� ��������, ����Ŭ ����ǥ���� �Լ��� �̿��� �ڵ��� ���Խĸ� �����ϴ� ���, NOT NULL
        
        �� ��� ���� ������ �ڵ� ������ ���� ���Ǹ��� �ƴϾ����
*/
-- column-level constraints���
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

INSERT INTO STUDENTS VALUES(1, '�迵ȣ', 'M', 'C', '010-1234-1234');
INSERT INTO STUDENTS VALUES(2, '�迵ȣ', NULL, 'A', '010-1234-1234');

INSERT INTO STUDENTS VALUES(3, '�迵ȣ', 'F', NULL, '010-1234-1234');
INSERT INTO STUDENTS VALUES(3, '�迵ȣ', 'F', 'A', '010-124-1234');


/*
    # DEFAULT ���� ����
        - �÷��� �ƹ� ���� �Է����� �ʾ��� �� ��� �� �⺻ ���� �����صд�.
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
-- # ���̺� �÷� ������ ��ųʸ� �信�� �ش� �÷��� DATA_DEFAULT�� Ȯ���� �� �ִ�.
SELECT * FROM user_tab_columns WHERE table_name = 'STUDENTS';

-------------------------------------------------------------------------------------------
/*
     # table-level
        -�÷��� ��� ������ �ڿ� ���� �������� �����ϱ�
        - DEFAULT�� NOT NULL�� table-level���� ������ �� ����.
*/
CREATE TABLE students2(
    st_id       number(4),
    st_name     varchar2(10) DEFAULT '��ö��' CONSTRAINT st2_name_nn NOT NULL,
    st_gender   char(1),
    st_grade    char(1),
    CONSTRAINT st2_id_pk PRIMARY KEY (st_id),
    --CONSTRAINT st2_id_pk PRIMARY KEY(st_id, st_tel), -- ���̺� ���� �̿��ϸ� ���� �⺻Ű�� ������ �� �ִ�
    CONSTRAINT st2_gender_ch CHECK (st_gender IN ('M', 'F')),
    CONSTRAINT st2_grade_ch CHECK (st_grade IN ('A', 'B', 'C', 'D', 'F'))
);
DESC students2;

-------------------------------------------------------------------------------------

/*
    # Foreign Key �����ϱ�
        - ���������� ������ �� � ���̺��� � �÷��� �������� �Բ� �����ؾ� �Ѵ�.
*/
-- # �÷�-������ FK �����ϱ�
-- �ٸ� ���̺��� PKȤ�� UNIQUE�� ������ �÷��� �ܷ�Ű�� ������ �� �ִ�.
ALTER TABLE students ADD (
    location_id NUMBER(4) CONSTRAINT st_loc_fk REFERENCES locations ( location_id )
);
-- PK Ȥ�� UNIQUE�� �ƴ� �÷��� ������ ���
ALTER TABLE students ADD (
    st_parent varchar2(25) CONSTRAINT st_pa_fk REFERENCES employees ( last_name )
);

-- # ���̺�-������ FK�����ϱ�
--  - FK ������ �ϴ� �÷��� FOREIGN KEY�� �����ϰ�, �����ϴ� ���̺� �� �÷��� REFERENCES�� �����Ѵ�
ALTER TABLE students ADD(
    department_id NUMBER(4),
    CONSTRAINT st_dept_fk FOREIGN KEY (department_id) REFERENCES departments (department_id)
);

INSERT INTO students VALUES(1, 'ȫ�浿', 'M', 'B', '010-1234-1234', 90, 2500, 10);

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
-- # �̹� �����ϴ� �÷��� �������� �߰��ϱ�
ALTER TABLE students2 ADD CONSTRAINT st2_tel_uk UNIQUE(st_tel);
-- # NOT NULL, DEFAULT �� ADD CONSTRAINT ��� MODIFY�� �̿��� �����Ѵ�.
ALTER TABLE students2 MODIFY st_tel CONSTRAINT st2_tel_nn NOT NULL;
ALTER TABLE students2 MODIFY st_tel DEFAULT '000-0000-0000';

-- # �÷��� �̹� �����ϴ� �������� �����ϱ�
ALTER TABLE students2 DROP CONSTRAINT st2_tel_uk;


desc students2;
select * from user_constraints where table_name = 'STUDENTS2';
select * from user_tab_columns where table_name = 'STUDENTS2';


--------------------------------------------------------------------------------

/*
    # ON DELETE ��
        - FK�� �����ϰ� �ִ� PK�� �����Ǿ��� �� �ش� FK�� ��� �������� �����Ѵ�
        - CASCADE : �����ϴ� PK�� ���� �Ǹ� FK�� ���� �Բ� �����Ѵ�.
                ex) department���� 50�� �μ��� �����ϸ� employees�� ��� 50�� �μ��� ���� ����� �����ȴ�.
                
        - SET NULL : �����ϴ� PK�� �����Ǹ� FK�� ���� NULL�� ��ȯ�Ѵ�.
                ex) department���� 50�� �μ��� �����ϸ� employees�� ��� 50�� �μ��� ���� �����
                        department_id�� null�� ��ȯ�Ѵ�.

        - RESTRICT : �ڽ��� �ִ� �θ�Ű�� ������ �� �� ������ �����Ѵ�.
            (ON DELETE�� �������� ���� ���)
*/

CREATE TABLE empp AS SELECT * FROM employees;
CREATE TABLE depp AS SELECT * FROM departments;
CREATE TABLE jobb AS SELECT * FROM jobs;

select * from user_constraints where table_name = 'EMPLOYEES';
select * from user_constraints where table_name = 'DEPARTMENTS';

-- ��������02 : EMPP ���̺�� DEPP ���̺��� �⺻Ű/�ܷ�Ű ���� ������ �����غ�����.
ALTER TABLE empp ADD CONSTRAINT empp_id_pk PRIMARY KEY(employee_id);
ALTER TABLE depp ADD CONSTRAINT depp_id_pk PRIMARY KEY(department_id);
ALTER TABLE jobb ADD CONSTRAINT jobb_id_pk PRIMARY KEY(job_id);

ALTER TABLE empp ADD (
    CONSTRAINT empp_dept_fk FOREIGN KEY (department_id) REFERENCES depp(department_id),
    -- self join ��
    CONSTRAINT empp_manager_fk FOREIGN KEY (manager_id) REFERENCES empp(employee_id),
    CONSTRAINT empp_job_fk FOREIGN KEY (job_id) REFERENCES jobb(job_id),
    CONSTRAINT empp_email_uk UNIQUE(email)
);
-- �̹� NOT NULL������ �Ѿ�� �̸� ����
ALTER TABLE empp RENAME CONSTRAINT SYS_C0014491 TO empp_last_name_nn;
ALTER TABLE empp RENAME CONSTRAINT SYS_C0014492 TO empp_email_nn;
ALTER TABLE empp RENAME CONSTRAINT SYS_C0014493 TO empp_hire_date_nn;
ALTER TABLE empp RENAME CONSTRAINT SYS_C0014494 TO empp_job_id_nn;
ALTER TABLE depp RENAME CONSTRAINT SYS_C0014495 TO depp_name_nn;

-- �׽�Ʈ�� ���̺� ���� �ϱ�----------------------------------------------------------------
select * from user_constraints where table_name = 'EMPP';
select * from user_constraints where table_name = 'DEPP';

ALTER TABLE empp DROP CONSTRAINT empp_dept_fk;
-- # ON DELETE CASCADE �׽�Ʈ
-- 1.�ܷ�Ű�� ON DELETE�� ����
ALTER TABLE empp 
    ADD CONSTRAINT empp_dept_fk FOREIGN KEY (department_id) 
        REFERENCES depp(department_id)ON DELETE CASCADE;

SELECT * FROM empp ORDER BY department_id;

-- 2. �θ�Ű�� ���� (30�� �μ��� ����)
SELECT * FROM depp;
DELETE FROM depp WHERE department_id = 30;

SELECT * FROM empp ORDER BY department_id;

-- �� CASCADE�� �θ�Ű�� �����ϸ� ���� FK���� ��� �Բ� �����ȴ�.

------------------------------------------------------------------------
ALTER TABLE empp DROP CONSTRAINT empp_dept_fk;

-- # ON DELETE SET NULL �׽�Ʈ
-- 1. �ܷ�Ű�� ON DELETE SET NULL�� ����
ALTER TABLE empp 
    ADD CONSTRAINT empp_dept_fk FOREIGN KEY (department_id) 
        REFERENCES depp(department_id)ON DELETE SET NULL;

-- 2. SET NULL�� ���·� 100�� �μ��� ����
DELETE FROM depp WHERE department_id = 100;

SELECT * FROM empp ORDER BY department_id DESC;
-- �� SET NULL�� �θ�Ű�� �����ϸ� ���� FK���� ��� �Բ� NULL�� �ȴ�.


------------------------------------------------------------------------
ALTER TABLE empp DROP CONSTRAINT empp_dept_fk;

-- # ON DELETE �⺻��(RESTRICT) �׽�Ʈ
-- 1. �ܷ�Ű�� �⺻������ ����
ALTER TABLE empp 
    ADD CONSTRAINT empp_dept_fk FOREIGN KEY (department_id) 
        REFERENCES depp(department_id);
        
-- 2. �⺻���� ���·� 50�� �μ��� ����
DELETE FROM depp WHERE department_id = 50;

SELECT * FROM empp ORDER BY department_id ASC;
-- �� ON DELETE�� �������� ���� ��� �ڽķ��ڵ尡 �ִ� �θ�Ű�� ���� �� �� ����.