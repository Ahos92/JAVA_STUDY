-- 15_������.sql
/*
    # ������
        - �⺻Ű�� ����ϱ� ���ϵ��� ����� �ڵ� ��ȣ �߻���
        
        CREATE SEQUENCE ��������
                        [START WITH n]  -   �������� ���� ��ȣ ����
                        [INCREMENT BY n] -  �������� ������ ����
                        [MAXVALUE n | NOMAXVALUE] - �ִ밪�� ����
                        [MINVALUE n | NOMINVALUE] - �ּҰ��� ����
                        [CYCLE | NOCYCLE] - ������ ���������ϸ� ��ȯ ���� ����
                        [CACHE n | NOCACHE] - �������� �޸𸮻� �̸� ����� ���� ������ ����
*/
-- ������ ������ ��ųʸ� ��
SELECT * FROM user_sequences;
SELECT * FROM all_sequences;

CREATE SEQUENCE empp_seq START WITH 100 INCREMENT BY 10;

-- ������.nextval : �ش� �������� ���� �ڵ����� ��ȣ�� �޾ƿ´�. 
--      (���� ��ȣ�� ������ �������� �ٽô� ���� ��ȣ�� ���ư� �� ����.)
SELECT empp_seq.nextval FROM dual;
-- ������.currval : ���� �������� ��ȣ�� �޾ƿ´�.
SELECT empp_seq.currval FROM dual;

TRUNCATE TABLE coffees; -- �ѹ� ���� ��� �� ����

-- �������� 99.99%������ INSERT���� �Բ� �̿�ȴ�.
INSERT INTO coffees VALUES (empp_seq.nextval, '�Ƹ޸�ī��', 1000);

SELECT * FROM coffees;

------------------------------------------------------------------------------------------------
-- 700 ~ 710 1�� ���� ��ȯ
CREATE SEQUENCE waiting_num START WITH 700 MINVALUE 700 MAXVALUE 710 INCREMENT BY 1 CYCLE NOCACHE;

-- DROP SEQUENCE ��������; ������ ����

-- ������ ����
ALTER SEQUENCE waiting_num MAXVALUE 707 MINVALUE 600 INCREMENT BY 5;

SELECT waiting_num.nextval FROM dual;
------------------------------------------------------------------------------------------------