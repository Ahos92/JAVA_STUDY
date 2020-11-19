-- 11_���̺� ����.sql

/*
    # DML (Data Manipulation Language, ������ ���۾�)
        - ���̺� ������ �����͸� �˻�/�߰�/����/���� �ϴ� ��ɾ�
        - SELECT : �˻�
        - INSERT : ����
        - UPDATE : ����
        - DELETE : ���� 
        
    # DDL (Data Definition Language, ������ ���Ǿ�)
        - ���̺� ��(������, �ε���, �� ...) �� ������ �����ϴµ� ����ϴ� ��ɾ�
        - CREATE : ����
        - DROP : ����
        - ALTER : ����
        - TRUNCATE : ���� ����
        
    # DCL (Data Control Language, ������ ���� ��ɾ�)
        - ������� ������ �����ϴµ� ����ϴ� ��ɾ�
        - GRANT : ����ڿ��� ������ �ο�
        - REVOKE : ������� ������ ȸ��
*/
/*
    # ���̺� ����
        CREATE TABLE ���̺�� (�÷��̸�01 �÷�Ÿ��01, �÷��̸�02 �÷�Ÿ��02 ...);
*/
CREATE TABLE coffees (
    cid     NUMBER(4),
    cname   VARCHAR2(30),
    cprice  NUMBER(6)
);

DESC coffees;

-- # �����������ϴ� ���̺��� �����ϸ鼭 ����� �ڡ�
CREATE TABLE employees2 AS SELECT * FROM employees;
-- ���ϴ� �÷��� ������ ����
CREATE TABLE employees3 AS SELECT last_name AS �̸�, salary AS ����, job_id AS ���� FROM employees;

SELECT * FROM employees3;

-- # ���̺� �����ϱ�

SELECT * FROM tab;

DROP TABLE coffees;

DROP TABLE employees2;

-- # ������ �˻�

SHOW recyclebin;

SELECT * FROM recyclebin;

-- # ������ �����ϱ�

FLASHBACK TABLE coffees TO BEFORE DROP;

-- # ������ ����
PURGE RECYCLEBIN;

-- # ������ ��ġ�� �ʰ� �ٷ� ���̺� ����
DROP TABLE coffees PURGE;
DROP TABLE employees3 PURGE;

-- ��������01 : 50�� �μ� �����θ� ������ ���̺��� �ϳ� �����غ�����
CREATE TABLE employees4 AS SELECT * from employees where department_id = 50;
select * from employees4;
drop table employees4 purge;


-- # ���̺��� ������ �����ϱ� (�Ϻη� ���� �ȵǴ� ������ �ְ� ���̺��� ����)
CREATE TABLE employeee AS SELECT * FROM employees WHERE 1 = 0;
desc employeee;
drop table employeee purge;


-- # ���̺� ���� ���� ��ɾ��
CREATE TABLE coffees (
    cid     NUMBER(4),
    cname   VARCHAR2(30),
    cprice  NUMBER(6)
);

-- # ALTER TABLE ���̺�� ADD (�÷��� �÷�Ÿ��, ...)
ALTER TABLE coffees ADD (
    LOCATION_ID NUMBER(4),
    ACIDITY NUMBER(4, 2)
);
DESC coffees;

-- # ALTER TABLE ���̺�� MODIFY (�÷��� �÷�Ÿ��, ...) 
--  �÷� ������ ������ Ÿ���̳� ũ�� ���� ������ �� �ִ�.
--  �÷����� ���� �Ұ� 
ALTER TABLE coffees MODIFY(
    CID NUMBER(3),
    CNAME VARCHAR2(50)
);
DESC COFFEES;

-- # ALRTER TABLE ���̺�� DROP COLUMN �÷���;
ALTER TABLE coffees DROP COLUMN acidity;
DESC coffees;

-- # ������ �غ� ��Ű�� (SET UNUSED) : ALTER TABLE ���̺�� SET UNUSED(�÷���)
--     - �ش� �÷��� �����ϱ� ���� ������� ���ϴ� ���·� �����Ѵ�.
--     - �������� ������ ���߿� ������ �� ����Ѵ�.
--     - ���̺� ����� ���� ���� �� ������ �ð��� �����ϱ� ���� �����Ѵ�. (�������θ� ������ ��)
ALTER TABLE coffees SET UNUSED(location_id);
desc coffees;
-- ������ �ð��뿡 ������ �����Ѵ�.
ALTER TABLE coffees DROP UNUSED COLUMNS;
DESC COFFEES;

-- # ���̺� �� �����ϱ�
RENAME coffees TO coffe_shop;
select * from tab;

-- # �÷��� �����ϱ�
ALTER TABLE coffe_shop RENAME COLUMN cid to cfid;
desc coffe_shop;

------------------------------------------------------------------------------------

/*
    # ������ ��ųʸ�
        - ���̺��� �߰��ϸ� DB�� �����ϴ� ���̺��� ������ DBMS�� �˾Ƽ� �����Ѵ�.
        - ��ó�� ����ڰ� ���� �����ϴ� ���� �ƴ� �����͵��� ������ ��ųʸ���� �θ���.
        
    # ������ ��ųʸ� ��
        - ������ ��ųʸ��� ����ڰ� ���� ���ϵ��� ��ȯ�Ͽ� �����ϴ� ��(View)
*/
-- # ���̺� ������ ��ųʸ� ��
select * from tab;
select * from tabs;
select * from user_tables; -- USER_ : ���� user�� ������ �ִ� ������ �����ִ� ������ ��ųʸ� ��
select * from all_tables; -- ALL_ : ��� USER�� ������ �ִ� ������ �����ִ� ������ ��ųʸ� ��

-- # ��������(comstraints) ������ ��ųʸ� ��
SELECT * FROM user_constraints;
SELECT * FROM all_constraints;
show user;