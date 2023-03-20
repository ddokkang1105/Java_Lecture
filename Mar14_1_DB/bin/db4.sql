-- 1. ORACLEDB 서버에 다음 데이터를 표현할 수 있는 DB자료구조를 만드는 SQL문을 작성해주세요

--		- 컴퓨터 이름 : 컴퓨터1
--		- 운영 체제 : WINDOWS 10 PRO
--		- 포맷 날짜 : 2023-02-14
--		- 무게 : 5.12KG
--		- CPU : I5-1234

--		- 컴퓨터 이름 : 컴퓨터2
--		- 운영 체제 : WINDOWS 11 PRO
--		- 포맷 날짜 : 2023-03-01
--		- 무게 : 5.23KG
--		- CPU : I7-5678
CREATE TABLE MAR14_COMPUTER (
    C_NO NUMBER(2) PRIMARY KEY,
    C_NAME VARCHAR2(10 CHAR) NOT NULL,
    C_OS VARCHAR2(20 CHAR) NOT NULL,
    C_FORMAT DATE NOT NULL,
    C_WEIGHT NUMBER(4, 2) NOT NULL,
    C_CPU VARCHAR2(10 CHAR) NOT NULL
);

CREATE SEQUENCE MAR14_COMPUTER_SEQ;

-- 2. 1번에서 만든 테이블에 다음 데이터를 추가하는 SQL문을 작성해주세요
--		(1번의 보기에 있는 데이터도 추가할 것 ( 총 3개의 데이터 ) )

--		- 컴퓨터 이름 : 컴퓨터3
--		- 운영 체제 : WINDOWS 10 PRO
--		- 포맷 날짜 : 2023-02-22
--		- 무게 : 3.22KG
--		- CPU : I7-1234
INSERT INTO MAR14_COMPUTER VALUES(MAR14_COMPUTER_SEQ.NEXTVAL, '컴퓨터1', 'WINDOWS 10 PRO',
    TO_DATE('2023-02-14', 'YYYY-MM-DD'), 5.12, 'I5-1234');

INSERT INTO MAR14_COMPUTER VALUES(MAR14_COMPUTER_SEQ.NEXTVAL, '컴퓨터2', 'WINDOWS 11 PRO',
    TO_DATE('2023-03-01', 'YYYY-MM-DD'), 5.23, 'I7-5678');

    INSERT INTO MAR14_COMPUTER VALUES(MAR14_COMPUTER_SEQ.NEXTVAL, '컴퓨터3', 'WINDOWS 10 PRO',
    TO_DATE('2023-02-22', 'YYYY-MM-DD'), 3.22, 'I7-1234');

-- 3. 1번에서 만든 테이블에서, 포맷한지 가장 오래된 컴퓨터의 날짜와
--		총 컴퓨터 수를 조회하는 SQL문을 작성해주세요
SELECT MIN(C_FORMAT), COUNT(*) FROM MAR14_COMPUTER;

-- 4. 1번에서 만든 테이블에서, 가장 최근에 포맷한 컴퓨터의 이름을 조회하는 SQL문을 작성해주세요
SELECT C_NAME
    FROM MAR14_COMPUTER
    WHERE C_FORMAT IN (
        SELECT MAX(C_FORMAT)
        FROM MAR14_COMPUTER
    );

-- 5. 1번에서 만든 테이블에서, 2번째로 가벼운 컴퓨터 ~ 3번째로 가벼운 컴퓨터의
--		전체 정보를 조회하는 SQL문을 작성해주세요
SELECT *
    FROM (
        SELECT ROWNUM RN, C_NO, C_NAME, C_OS, C_FORMAT, C_WEIGHT, C_CPU
        FROM (
            SELECT C_NO, C_NAME, C_OS, C_FORMAT, C_WEIGHT, C_CPU
            FROM MAR14_COMPUTER
            ORDER BY C_WEIGHT
        )
    )
    WHERE RN BETWEEN 2 AND 3;
------------------------------------------------------------------------------------------------------------