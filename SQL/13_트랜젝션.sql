-- 13_Ʈ������.sql

/*
    # Ʈ����� (Transaction)
    
        - ������ ó���� �� ����
        - �ϳ��� ������ �۾��� ó���ϱ� ���� �������� ������
        ex) �۱� Ʈ�����
            - ������ ����� ���忡�� ���� �پ��
            - �޴� ����� ���忡�� ���� �þ
                - ��ɾ��� ������ Ʈ������� ���������� ó���Ǵ� ��쿡�� ��� ó���ϵ��� �Ѵ�
                - All or Nothing
        
        - COMMIT, ROLLBACK, SAVEPOINT�� �̿��� �����͸� ���������� ������ �� �ִ�.
        - Ʈ������� ���������� ����� Ŀ�� or �ѹ� ���ĺ��� 
            ���ο� Ŀ���� �����ϴ� �������� ��� DML�� �ǹ�
            
            COMMIT -> UPADATE - INSERT - UPDATE -> COMMIT (or ROLLBACK)
                    (             DML            )
                    
        
*/

-- Ʈ����� ���߿� DDL���� ����ϸ� �ڵ����� Ŀ���� �Ǳ� ������ �����ؾ� �Ѵ�.
SELECT * FROM emp;

COMMIT;

UPDATE emp SET salary = 100;

 -- CREATE �� DDL�̱� ������ Ʈ�����ǵ��� �� �� �ڵ� Ŀ�Ե�!!
CREATE TABLE fruits(
    fname varchar2(30)
);

ROLLBACK;

----------------------------------------------------------------------
-- # SAVEPOINT ����� Ʈ����� ����
SELECT * FROM emp;

COMMIT;

UPDATE emp SET salary = 200;
SAVEPOINT save01;

UPDATE emp SET salary = 300;
SAVEPOINT save02;

UPDATE emp SET salary = 400;
SAVEPOINT save03;

ROLLBACK TO save01; -- ���� ������ SAVEPOINT�θ� ���ư� �� �ִ�
