-- 1. 음료테이블과 카페테이블 만들기
-- 음료테이블 : 음료 이름 / 가격 / 판매하는 카페의 이름
-- 카페테이블 : 카페 이름 / 지역 / 좌석 수
-- [조건] 각 테이블에서 음료이름, 카페 이름은 고유한 값을 갖는다.
CREATE TABLE DRINK(
    D_NAME VARCHAR2(10 CHAR) PRIMARY KEY,
    D_PRICE NUMBER(5) NOT NULL,
    D_CAFE VARCHAR2(10 CHAR) NOT NULL
);

CREATE TABLE CAFE(
    C_NAME VARCHAR2(10 CHAR) PRIMARY KEY,
    C_ADD VARCHAR2(10 CHAR) NOT NULL,
    C_SEAT NUMBER(3) NOT NULL
);

-- 2. 조건에 맞는 테이블을 생성
-- A카페는 서울에 위치하고, 좌석이 100석,
--		(아메리카노, 2000원), (라떼, 3000원), (녹차, 2500원) 을 판매
-- B카페는 독도에 위치하고, 좌석은 80석,
--		(홍차, 2500원), (스무디, 3000원), (에스프레소, 4000원) 을 판매
INSERT INTO CAFE VALUES('A카페', '서울', 100);
INSERT INTO CAFE VALUES('B카페', '독도', 80);
INSERT INTO DRINK VALUES('아메리카노', 2000, 'A카페');
INSERT INTO DRINK VALUES('라떼', 3000, 'A카페');
INSERT INTO DRINK VALUES('녹차', 2500, 'A카페');
INSERT INTO DRINK VALUES('홍차', 2500, 'B카페');
INSERT INTO DRINK VALUES('스무디', 3000, 'B카페');
INSERT INTO DRINK VALUES('에스프레소', 4000, 'B카페');

-- 3. 쿼리문 작성
--		평균가보다 비싼 음료는 몇 종류 ?
SELECT COUNT(*)
    FROM DRINK 
    WHERE D_PRICE > (
        SELECT AVG(D_PRICE)
        FROM DRINK
    );

--		제일 싼 음료를 파는 카페의 이름 ?
SELECT C_NAME
    FROM CAFE
    WHERE C_NAME IN (
    	SELECT D_CAFE
    	FROM DRINK
    	WHERE D_PRICE IN (
        	SELECT MIN(D_PRICE)
        	FROM DRINK
		)
    );

--		서울에 있는 카페에서 만드는 음료의 평균가 ?
SELECT AVG(D_PRICE)
    FROM DRINK
    WHERE D_CAFE IN (
        SELECT C_NAME
        FROM CAFE
        WHERE C_ADD = '서울'
    );

--		좌석이 90석 이상인 카페에서 파는 음료의 이름 ?
SELECT D_NAME
    FROM DRINK
    WHERE D_CAFE IN (
        SELECT C_NAME
        FROM CAFE
        WHERE C_SEAT >= 90
    );

--		평균가 이하인 음료의 이름 ?
SELECT D_NAME
    FROM DRINK
    WHERE D_PRICE <= (
        SELECT AVG(D_PRICE)
        FROM DRINK
    );
    
--		가장 비싼 음료를 파는 카페는 어디에 있는지 ?
SELECT C_ADD
    FROM CAFE
    WHERE C_NAME IN (
        SELECT D_CAFE
        FROM DRINK
        WHERE D_PRICE IN (
            SELECT MAX(D_PRICE)
            FROM DRINK
        )
    );
------------------------------------------------------------------------------------------------------------