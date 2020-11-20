-- 13_트랜젝션.sql

/*
    # 트랜잭션 (Transaction)
    
        - 데이터 처리의 한 단위
        - 하나의 논리적인 작업을 처리하기 위한 여러개의 쿼리문
        ex) 송금 트랜잭션
            - 보내는 사람의 통장에서 돈이 줄어듬
            - 받는 사람의 통장에서 돈이 늘어남
                - 명령어의 집합인 트랜잭션이 정상적으로 처리되는 경우에만 모두 처리하도록 한다
                - All or Nothing
        
        - COMMIT, ROLLBACK, SAVEPOINT를 이용해 데이터를 안정적으로 복구할 수 있다.
        - 트랜잭션은 마지막으로 실행된 커밋 or 롤백 이후부터 
            새로운 커밋을 실행하는 시점까지 모든 DML을 의미
            
            COMMIT -> UPADATE - INSERT - UPDATE -> COMMIT (or ROLLBACK)
                    (             DML            )
                    
        
*/

-- 트랜잭션 도중에 DDL문을 사용하면 자동으로 커밋이 되기 때문에 주의해야 한다.
SELECT * FROM emp;

COMMIT;

UPDATE emp SET salary = 100;

 -- CREATE 는 DDL이기 때문에 트랜젹션도중 쓸 때 자동 커밋됨!!
CREATE TABLE fruits(
    fname varchar2(30)
);

ROLLBACK;

----------------------------------------------------------------------
-- # SAVEPOINT 사용한 트랜잭션 관리
SELECT * FROM emp;

COMMIT;

UPDATE emp SET salary = 200;
SAVEPOINT save01;

UPDATE emp SET salary = 300;
SAVEPOINT save02;

UPDATE emp SET salary = 400;
SAVEPOINT save03;

ROLLBACK TO save01; -- 먼저 생성된 SAVEPOINT로만 돌아갈 수 있다
