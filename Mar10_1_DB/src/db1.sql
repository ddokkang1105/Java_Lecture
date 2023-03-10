-- 테이블에 데이터를 검색, 삽입, 수정, 삭제하는데 사용하는 문장인
-- 데이터 조작어 (DML) 중에서 데이터를 넣게하는 명령어인 INSERT와
-- 데이터를 검색 OR 조회할 수 있는 명령어인 SELECT의 구조를 뜯어봤음

-- INSERT INTO [테이블명] VALUES(값, 값, ...) 의 형태 !
-- INSERT를 하면서 PRIMARY KEY를 줄 수 없는 상황에 
-- 강제적으로 고유 번호값을 만드는 방법으로 PRIMARY KEY를 줬었고,
-- 그 고유한 번호값들을 만드는데 있어서 매번 하나하나 지정해줄 수 없으니
-- 번호값들을 찍어내는 공장 !! SEQUENCE라는 기능을 활용했음 ! 
-- 테이블이랑 무관하고, 단점으로 INSERT에 실패하더라도, SEQUENCE의 값은 무조건 올라간다는 것 !

-- 그 다음에 데이터를 검색할 수 있는 SELECT
-- SELECT [DISTINCT] [컬럼명], [컬럼명 AS 별칭 || 컬럼명 별칭], [연산자 사용], [통계함수], ...
--	FROM [테이블명]
--	WHERE [조건식]
--	GROUP BY [그룹대상]
--	HAVING [함수 포함 조건]
-- 	ORDER BY [정렬대상 ASC/DESC]

-- DISTINCT는 중복을 제거해주는 역할 !
-- 컬럼명에 별칭을 부여하는 방법 : AS를 붙이거나 아니면 띄어쓰기 하거나 !
-- 연산자 시리즈 첫번째 산술연산자 (+, -, *, /), 이어서 문자를 이어붙여주는 연산자 '||'
-- DUAL 더미테이블을 이용해서 유용한 내장함수(숫자, 문자, 날짜, 통계, NULL관련 함수)
-- 전체 데이터 중 조건에 맞는 데이터를 찾아주는 WHERE절(조건식) 다루면서
-- 연산자 시리즈 두번째 비교연산자 (=, !=, >, <, >=, <=)
-- 연산자 시리즈 세번째 관계연산자 AND와 BETWEEN의 차이 !
--				연속되지 않은 값들을 받아올 때 사용하는 IN, OR
--				그 반대되는 값을 불러올 때 사용하는 NOT
--				이 때 NOT의 위치는 IN의 앞 !
-- 연산자 시리즈 네번째 패턴연산자 : 문자열을 포함한 검색
--				LIKE '%패턴%'의 형태 / LIKE 대신에 = (등호)를 사용하면 안되는 이유 !
--					=> 등호 사용시 패턴을 문자 그대로 인식해버리기 때문에 !!
-- 연산자 시리즈 마지막 집합연산자
--				UNION / UNION ALL (합집합)
--					: 중복하는 값을 제외하고 / 값 포함 모두 출력
--				INTERSECT (교집합)
--					: 집합 중 공통되는 값을 출력
--				MINUS (차집합)
--					: 앞에 있는 SELECT문 중에서 뒤에 있는 SELECT문에 없는 값 출력
-- 연산자 끝내면서 연산자의 우선순위 (왼쪽이 최우선 순위)
--		괄호 > 비교연산자 > NOT > AND > OR

-- WHERE 조건식 끝냈고
-- 다음으로는 GROUP BY : 그룹으로 묶어서 연산하여 하나의 결과를 나타내는 것 !
--		ROLLUP 연산자 : 컬럼에 대한 소계(SUBTOTAL)을 만들어줌
-- 그 다음에 HAVING절 VS WHERE절
--		: HAVING절은 그룹의 결과를 제한 / WHERE절 조건을 사용해서 결과를 제한
-- 마지막으로 정렬을 해주는 ORDER BY
--		: 오름차순 ASC(기본값이라서 명시하지 않아도 됨 !) / 내림차순 DESC
------------------------------------------------------------------------------------------------------------
-- *** 서브쿼리 (SUBQUERY)
-- SELECT문 안에 다시 SELECT문을 사용하는 기술 !
-- 하나의 SQL문 안에 다른 SQL문이 중첩된 질의문을 말함
-- 다른 테이블에서 가져온 데이터로 현재 테이블에 있는 정보를 찾거나 가공할 때 사용함
-- 보통 데이터가 대량일 때 데이터를 모두 합쳐서 연산하는 JOIN보다
-- 필요한 데이터만 찾아서 공급해주는 SUBQUERY가 성능이 더 좋음

-- 주질의(MAIN QUERY, 외부질의)와 부속질의(SUBQUERY, 내부질의)로 구성됨

SELECT S_NAME, S_PRICE
	FROM SNACK
									WHERE S_PRICE < (
										SELECT AVG(S_PRICE)
										FROM SNACK
									);

-- 평균가보다 가격이 낮은 과자의 이름과 가격 정보를 조회한 것

-- 팁 : 부분으로 나눠서 구성해보면 조금 더 가독성이 좋아지고, 조건에 맞게 잘 찾을 수 있음 !
-- 메인쿼리의 WHERE절에서 서브쿼리의 결과와 비교할 때는 반드시 !! 비교연산자를 사용해야 함 !

-- 과자들 중 최고가
SELECT MAX(S_PRICE) FROM SNACK;

-- 제일 비싼 과자 이름, 제조사, 가격
-- 괄호 주의 !!!!
-- 괄호를 안 넣으면 구문 오류라고 하는데,,, 왜 해야하는지 모르겠지만
-- WHERE절 이후 SELECT문에서는 소괄호를 넣고 시작해야 !
SELECT S_NAME, S_COMPANY, S_PRICE
    FROM SNACK
    WHERE S_PRICE = (
        SELECT MAX(S_PRICE)
        FROM SNACK
    );

-- 제일 싼 과자는 어디에서 만드나요 ?
SELECT S_COMPANY
    FROM SNACK
    WHERE S_PRICE = (
        SELECT MIN(S_PRICE)
        FROM SNACK
    );

-- 평균가보다 비싼 과자는 몇 종류 ?
SELECT COUNT(*) "평균가보다 비싼 과자"
    FROM SNACK
    WHERE S_PRICE > (
        SELECT AVG(S_PRICE)
        FROM SNACK
    );
        
-- 유통기한이 가장 오래 남은 과자의 전체정보 조회
SELECT *
    FROM SNACK
    WHERE S_TIME = (
        SELECT MAX(S_TIME)
        FROM SNACK
    );
------------------------------------------------------------------------------------------------------------
-- 과자 회사 테이블을 만들건데, 회사이름, 주소 (지역명 EX> 서울, 인천), 직원 수 값을 가지게 만들어주세요 !
-- 과자 테이블에 맞춰서 데이터를 넣기 !

CREATE TABLE COMPANY(
    C_NAME VARCHAR2(10 CHAR) PRIMARY KEY,
    C_ADD VARCHAR2(5 CHAR) NOT NULL,
    C_EMP NUMBER(3) NOT NULL
);

INSERT INTO COMPANY VALUES('크라운', '부천', 70);
INSERT INTO COMPANY VALUES('농심', '서울', 120);
INSERT INTO COMPANY VALUES('해태', '광주', 50);
INSERT INTO COMPANY VALUES('롯데', '부산', 30);
INSERT INTO COMPANY VALUES('오리온', '서울', 80);
INSERT INTO COMPANY VALUES('켈로그', '경기', 15);
------------------------------------------------------------------------------------------------------------
-- 직원 수 제일 적은 회사에서 만드는 과자 이름, 가격
SELECT S_NAME, S_PRICE
    FROM SNACK
    WHERE S_COMPANY = (
        SELECT C_NAME
        FROM COMPANY
            WHERE C_EMP = (
                SELECT MIN(C_EMP)
                FROM COMPANY
            )
    );
    
-- 제일 비싼 과자를 만드는 회사는 어디에 있는지
SELECT C_ADD
    FROM COMPANY
    WHERE C_NAME = (
        SELECT S_COMPANY
        FROM SNACK
        WHERE S_PRICE = (
            SELECT MAX(S_PRICE)
            FROM SNACK
        )
    );
    
-- 부천에 있는 회사에서 만드는 과자의 평균가
SELECT AVG(S_PRICE)
    FROM SNACK
    WHERE S_COMPANY = (
        SELECT C_NAME
        FROM COMPANY
        WHERE C_ADD = '부천'
    );
    
-- 평균가 이상의 과자를 만드는 회사의 이름, 위치
-- 회사명이 해태거나, 롯데거나, ...
-- = 쓰면 단일값 이상의 결과를 내보낼 수 없어서 'SINGLE - ROW ~' 발생
--			=> 관계연산자 < IN > 사용
-- IN은 매력덩어리야 ~~ \^~^/
SELECT DISTINCT C_NAME, C_ADD
    FROM COMPANY
    WHERE C_NAME IN (
        SELECT DISTINCT S_COMPANY
        FROM SNACK
        WHERE S_PRICE >= (
            SELECT AVG(S_PRICE)
            FROM SNACK
        )
    );
------------------------------------------------------------------------------------------------------------