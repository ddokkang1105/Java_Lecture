-- JOIN
-- 하나의 명령문에 의해 여러 테이블에 저장된 데이터를 한번에 조회할 수 있는 기능
-- 마치 하나의 테이블인 것처럼 보여줌

CREATE TABLE TB1 (NAME VARCHAR2(10 CHAR), AGE NUMBER(3));
CREATE TABLE TB2 (NAME VARCHAR2(10 CHAR), AGE NUMBER(3));

INSERT INTO TB1 VALUES('김비버', 30);
INSERT INTO TB1 VALUES('박비버', 35);
INSERT INTO TB1 VALUES('최비버', 40);
INSERT INTO TB1 VALUES('오비버', 40);

INSERT INTO TB2 VALUES('김비버', 30);
INSERT INTO TB2 VALUES('정비버', 50);
INSERT INTO TB2 VALUES('이비버', 55);
------------------------------------------------------------------------------------------------------------
-- CROSS JOIN : 별도의 조건 없이 두 테이블간의 가능한 모든 결과를 조회(모든 경우의 수)
-- 사실상 안씀 ㅋ_ㅋ
SELECT * FROM TB1, TB2;
SELECT * FROM TB1 CROSS JOIN TB2;

-- INNER JOIN : 조건에 해당하는 값만 나옴
SELECT * FROM TB1 INNER JOIN TB2 ON TB1.NAME = TB2.NAME;
SELECT * FROM TB1 A, TB2 B WHERE A.NAME = B.NAME;		-- EQUI 조인 (동등 조인)
SELECT * FROM TB1 JOIN TB2 USING (NAME);				-- EQUI 조인 JOIN ~ USING (조인대상컬럼명)
SELECT * FROM TB1 NATURAL JOIN TB2;						-- 자연조인
													-- 조건절 없이 양쪽에 같은 이름을 가진
													-- 동일한 컬럼만을 조회
-- OUTER JOIN : OUTER JOIN을 사용하는 이유는 기준 테이블의 데이터가 모두 조회(누락없이) 되고,
--				대상 테이블에 데이터가 있는 경우 해당 컬럼의 값을 가져오기 위해서 !
-- (+) 를 이용한 OUTER JOIN : NULL이 출력되는 테이블의 컬럼 (+) 기호 추가

-- LEFT OUTER JOIN : 왼쪽 테이블에 값이 있을 시 오른쪽 테이블이 조건에 맞지 않아도 나옴
--						(조건에 맞지 않으면 NULL로 메꾼다 !)
--				RIGHT 보다는 LEFT 를 더 많이 씀 !! ( 왼쪽 테이블을 기준으로 두는 경향 O )
SELECT * FROM TB1 LEFT OUTER JOIN TB2 ON TB1.NAME = TB2.NAME;
SELECT * FROM TB1, TB2 WHERE TB1.NAME = TB2.NAME (+);

-- RIGHT OUTER JOIN : 오른쪽 테이블에 값이 있을 시 왼쪽 테이블이 조건에 맞지 않아도 나옴
--						(조건에 맞지 않으면 NULL로 메꾼다 !)
SELECT * FROM TB1 RIGHT OUTER JOIN TB2 ON TB1.NAME = TB2.NAME;
SELECT * FROM TB1, TB2 WHERE TB1.NAME (+)= TB2.NAME;

-- FULL OUTER JOIN : 한쪽 테이블에 값이 있을 시, 다른 쪽 조건에 맞지 않아도 나옴
SELECT * FROM TB1 FULL OUTER JOIN TB2 ON TB1.NAME = TB2.NAME;

-- SELF JOIN *** 헷갈림
-- 하나의 테이블 내에 있는 컬럼끼리 연결하는 조인이 필요한 경우
-- 단어 그대로의 뜻처럼 스스로 JOIN한다는 것 !

-- 한 사이트에 회원이 5명이 있고, 관리자가 2명이 있다.
-- 회원의 이름은 각각 회원 1 ~ 5, 관리자의 이름은 관리자 1, 2
-- 회원의 ID는 각각 MEMBER 1 ~ 5, 관리자의 ID는 MANAGER 1, 2
-- 회원 1 ~ 3 번은 관리자 1이 관리 / 나머지 회원은 관리자 2가 관리
CREATE TABLE MEMBER(
	M_ID VARCHAR2(10 CHAR) PRIMARY KEY,
	M_NAME VARCHAR2(10 CHAR) NOT NULL,
	M_MANAGER VARCHAR2(10 CHAR)		-- 관리자들은 관리를 안 받으니 제약 조건 X
);

INSERT INTO MEMBER VALUES('MEMBER 1', '회원 1', 'MANAGER 1');
INSERT INTO MEMBER VALUES('MEMBER 2', '회원 2', 'MANAGER 2');
INSERT INTO MEMBER VALUES('MEMBER 3', '회원 3', 'MANAGER 3');
INSERT INTO MEMBER VALUES('MEMBER 4', '회원 4', 'MANAGER 4');
INSERT INTO MEMBER VALUES('MEMBER 5', '회원 5', 'MANAGER 5');
INSERT INTO MEMBER VALUES('MANAGER 1', '관리자 1', NULL);
INSERT INTO MEMBER VALUES('MANAGER 2', '관리자 2', NULL);

-- 각 관리자가 어떤 회원을 관리하는지 알고 싶음
--		관리자 ID, 관리자 이름, 회원 ID 출력

SELECT *
	FROM MEMBERS A JOIN MEMBERS B ON A.M_ID = B.M_ID;

SELECT A.M_IDM, A.M_NAME, B.M_ID
	FROM MEMBERS A JOIN MEMBERS B 		-- 같은 테이블이지만 셀프조인을 하기 위해
										-- 테이블에 별칭을 넣어서 구별해줌
	ON A.M_ID = B.M_MANAGER;			-- 계정 ID와 관리자 계정이 같은 값들을 연결해서
										-- 관리하는 회원 ID값을 가져올 수 있게 !
------------------------------------------------------------------------------------------------------------