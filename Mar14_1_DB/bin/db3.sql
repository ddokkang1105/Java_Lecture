-- 배추, 3000G, 10000원, 홈플러스, 강서점, 1000평, 주차장 500석
-- 무, 500G, 5000원, 홈플러스, 강남점, 500평, 주차장 300석
-- 배추, 2000G, 5000원, 이마트, 서초점, 800평, 주차장 800석
------------------------------------------------------------------------------------------------------------
CREATE TABLE MAR14_MARKET(
    M_NO NUMBER(2) PRIMARY KEY,
    M_NAME VARCHAR2(10 CHAR) NOT  NULL,
    M_LOCATION VARCHAR2(10 CHAR) NOT NULL,
    M_AREA NUMBER(4) NOT NULL,
    M_PARKING NUMBER(4) NOT NULL
);

CREATE SEQUENCE MAR14_MARKET_SEQ;

INSERT INTO MAR14_MARKET VALUES(MAR14_MARKET_SEQ.NEXTVAL, '홈플러스', '강서점', 1000, 500);
INSERT INTO MAR14_MARKET VALUES(MAR14_MARKET_SEQ.NEXTVAL, '홈플러스', '강남점', 500, 300);
INSERT INTO MAR14_MARKET VALUES(MAR14_MARKET_SEQ.NEXTVAL, '이마트', '서초점', 800, 800);
------------------------------------------------------------------------------------------------------------
CREATE TABLE MAR14_PRODUCT(
    P_NO NUMBER(2) PRIMARY KEY,
    P_NAME VARCHAR2(10 CHAR) NOT NULL,
    P_WEIGHT NUMBER(4) NOT NULL,
    P_PRICE NUMBER(5) NOT NULL,
    P_M_NO NUMBER(2) NOT NULL,
        CONSTRAINT FK_MAR14_PRODUCT FOREIGN KEY(P_M_NO)
        REFERENCES MAR14_MARKET(M_NO)
        ON DELETE CASCADE
);

CREATE SEQUENCE MAR14_PRODUCT_SEQ;

INSERT INTO MAR14_PRODUCT VALUES(MAR14_PRODUCT_SEQ.NEXTVAL, '배추', 3000, 10000, 1);
INSERT INTO MAR14_PRODUCT VALUES(MAR14_PRODUCT_SEQ.NEXTVAL, '무', 5000, 5000, 2);
INSERT INTO MAR14_PRODUCT VALUES(MAR14_PRODUCT_SEQ.NEXTVAL, '배추', 2000, 5000, 3);
------------------------------------------------------------------------------------------------------------
-- CREATE TABLE - DBA
-- DROP TABLE - DBA
-- CREATE SEQUENCE - DBA
-- 계정 하나로 여러명 사용 가능
-- 회사가면 개발자용 계정을 알려줌 => 위의 작업들 권한은 없을 듯..?
------------------------------------------------------------------------------------------------------------
-- C - INSERT
--			SEQUENCE 사용, 날짜 집어넣고, ...
-- R - SELECT
--			거의 대부분의 시간을 할애함
-- U - UPDATE
UPDATE 테이블명
	SET 컬럼명 = 값, 컬럼명 = 값, ... -- 수정할 내용
	WHERE 조건;
	
-- 무를 공짜로
UPDATE MAR14_PRODUCT
    SET P_PRICE = 0
    WHERE P_NAME = '무';

-- 배추를 김장용배추로 이름 수정
UPDATE MAR14_PRODUCT
    SET P_NAME = '김장용배추'
    WHERE P_NAME IN '배추';

-- 모든 마트의 주차장 30% 줄이기
UPDATE MAR14_MARKET
    SET M_PARKING = M_PARKING * 0.7;

-- 홈플러스 강서점의 상품가격 10% 할인
UPDATE MAR14_PRODUCT
    SET P_PRICE = P_PRICE * 0.9
    WHERE P_M_NO IN (
        SELECT M_NO
        FROM MAR14_MARKET
        WHERE M_NAME = '홈플러스' AND M_LOCATION = '강서점'
    );
	
-- 제일 비싼 상품 10% 할인
UPDATE MAR14_PRODUCT
    SET P_PRICE = P_PRICE * 0.9
    WHERE P_PRICE IN (
        SELECT MAX(P_PRICE)
        FROM MAR14_PRODUCT
    );
------------------------------------------------------------------------------------------------------------
-- D - DELETE
DELETE FROM 테이블명
	WHERE 조건식;
	
-- 무 삭제
DELETE MAR14_PRODUCT
    WHERE P_NAME = '무';
	
-- 가장 좁은 매장의 상품 다 삭제
DELETE MAR14_PRODUCT
    WHERE P_M_NO IN (
        SELECT M_NO
        FROM MAR14_MARKET
        WHERE M_AREA IN (
            SELECT MIN(M_AREA)
            FROM MAR14_MARKET
        )
    );
------------------------------------------------------------------------------------------------------------
-- 홈플러스 강남점이 폐점
DELETE FROM MAR14_MARKET
	WHERE M_NAME = '홈플러스' AND M_LOCATION = '강남점';
-- 홈플러스 강남점이 없어지는데, 그 안에 있던 상품들은 어떻게 할지..?
-- 그냥 두거나 / 같이 삭제 / 비워두거나 ...
-- 정답이 없어서.. 나중에 프로젝트시 팀원들끼리 잘 상의해야 !!!
------------------------------------------------------------------------------------------------------------