-- R (Read)
SELECT [DISTINCT] [컬럼명], [컬럼명 AS 별칭 || 컬럼명 별칭], [연산자 사용], [통계함수], ...
	FROM [테이블명]
	WHERE [조건식]
	GROUP BY [그룹대상]
	HAVING [함수 포험 조건]
	ORDER BY [정렬대상 ASC/DESC (오름차순 / 내림차순)]
	

-- WHERE 절 (조건식)
-- 전체 데이터 중 지정한 조건에 맞는 데이터를 찾아주는 문장
-- 조건식에 사용할 연산자를 알아보자 ! (비교 연산자)
-- =, !=, ^=, <>, <, >, <=, >=, ...
-- 이 중에서 !=, ^=, <> 는 '같지 않다'로 쓰이는 연산자인데... 왜 3개나 될까..?
-- !=, <> 의 경우에는 각각 표준화를 하려다 보니 사용하게 되었고,
-- ^= 의 경우에는 몇몇 DBMS과 차별화를 두기 위해 사용하게 되었음

-- 가격이 3000원인 과자의 모든 정보를 조회
SELECT * FROM SNACK WHERE S_PRICE = 3000; 
-------------------------------------------------------------------------------------------------------------	
	
-- 모든 과자 이름, 가격 조회
SELECT S_NAME 이름, S_PRICE 가격 FROM SNACK;
-- 모든 과자 이름(가격) 조회 (EX: 콘칩(1800원) )
SELECT S_NAME || '(' || S_PRICE || '원)' "이름(가격)" FROM SNACK WHERE S_PRICE = 1800;
-------------------------------------------------------------------------------------------------------------	
-- 2000원 이하의 과자 중 최소가격이 얼마인지 ?
SELECT MIN(S_PRICE) || '원' "최소가격(2000원 이하)" FROM SNACK WHERE S_PRICE <= 2000;

-- 모든 과자의 평균가가 얼마인지 ?
SELECT ROUND(AVG(S_PRICE), 1) || '원' "평균가격" FROM SNACK;

-- 과자의 이름과 가격이 30% 할인된 금액
SELECT S_NAME || '(' || S_PRICE  * 0.7 || '원)' "이름(30% 세일 금액)" FROM SNACK;

-- 3500원인 과자의 갯수는 몇 개 ?
SELECT COUNT(*) || '개' "3500원 과자 갯수" FROM SNACK WHERE S_PRICE = 3500;

-- 3000원 이하인 과자의 이름, 회사 이름
SELECT S_NAME 이름, S_COMPANY 회사 FROM SNACK WHERE S_PRICE <= 3000;
-------------------------------------------------------------------------------------------------------------	
-- 모든 과자 이름, 가격, 유통기한 조회
SELECT S_NAME 이름, S_PRICE || '원' 가격, S_TIME 유통기한 FROM SNACK;

-- 모든 과자 이름, 가격, 부가세(가격의 10%) 조회
SELECT S_NAME 이름, S_PRICE || '원' 가격, (S_PRICE * 0.1) || '원' 부가세 FROM SNACK;

-- 모든 과자 이름, 가격, 판매가 조회(20% 할인) 조회
SELECT S_NAME 이름, S_PRICE || '원' 가격, (S_PRICE * 0.8) || '원' 판매가 FROM SNACK;

-- 3000원보다 큰 금액의 과자들의 평균가 조회
SELECT ROUND(AVG(S_PRICE), 1) || '원' "평균가(3000원 이상)" FROM SNACK WHERE S_PRICE > 3000;

-- 최고가, 최저가, 총 과자 종류 몇 가지인지 조회
SELECT MAX(S_PRICE) || '원' 최고가, MIN(S_PRICE) || '원' 최저가, COUNT(S_NAME) || '개' "총 과자 종류" FROM SNACK;

-- 3000원 이상인 과자의 전체 정보 조회
SELECT * FROM SNACK WHERE S_PRICE >= 3000;

-- 3000원 미만인 과자의 이름, 가격, 판매가(20% 할인)
SELECT S_NAME "이름(3000원 미만)", S_PRICE || '원' 가격, (S_PRICE * 0.8) || '원' 판매가 FROM SNACK WHERE S_PRICE < 3000;

-- 허니버터칩의 가격 조회
SELECT S_PRICE || '원' "허니버터칩 가격" FROM SNACK WHERE S_NAME = '허니버터칩';

-- 크라운 회사의 과자 가격 총합 조회
SELECT SUM(S_PRICE) || '원' "크라운 회사 과자 총합" FROM SNACK WHERE S_COMPANY = '크라운';

-- 7월 안으로 먹어야 하는 과자 이름, 가격, 유통기한 조회
SELECT S_NAME 이름, S_PRICE || '원' 가격, S_TIME "유통기한(올해 7월)" FROM SNACK WHERE S_TIME < '2023-07-31 23';
SELECT S_NAME 이름, S_PRICE || '원' 가격, S_TIME "유통기한(올해 7월)" FROM SNACK WHERE S_TIME < '2023-08-01';
-- DATE 타입과 비교하는게 더 정확한 코드 !!
SELECT S_NAME 이름, S_PRICE || '원' 가격, S_TIME "유통기한(올해 7월)" FROM SNACK 
	WHERE S_TIME < TO_DATE('2023-08-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS');
-------------------------------------------------------------------------------------------------------------	
-- 관계 연산자 
-- NOT, AND, OR, BETWEEN, IN

-- AND, BETWEEN 연산자
-- 가격이 1000원 이상 3000원 이하인 과자의 전체내용을 조회 
-- AND를 이용해서
-- 문법에 맞지 않는 코드 !! 
-- SELECT * FROM SNACK WHERE 1000 <= S_PRICE <= 3000;
SELECT * FROM SNACK WHERE S_PRICE >= 1000 AND S_PRICE <= 3000;
-- BETWEEN을 이용해서 
SELECT * FROM SNACK WHERE S_PRICE BETWEEN 1000 AND 3000;

-- 뭐가 다른가요 ? 그냥 BETWEEN 쓰는게 더 좋은거 아닌가요 ?!
-- BETWEEN은 이상/이하로 조건 범위를 정하기 때문에
-- 1000원 초과 3000원 미만인 과자를 조회할 때에는 ... ㅠ_ㅠ

-- 가격이 1000원, 2000원, 3000원인 과자의 전체 정보를 조회

-- OR 연산자
SELECT * FROM SNACK WHERE S_PRICE = 1000 OR S_PRICE = 2000 OR S_PRICE = 3000;
-- 지금이야 이렇게 풀 수 있겠지만, 점점 OR을 써야하는 갯수가 많아진다면 ... ? 귀찮다 !!
-- 뭔가 비효율적이고, 복잡하고, 귀찮데쓰,,, 어떻게 편하게 쓸까??

-- IN 연산자
SELECT * FROM SNACK WHERE S_PRICE IN (1000, 2000, 3000);
-- S_PRICE(가격)가 1000원 OR 2000원 OR 3000원 을 나타내주는 연산자 !!
-- 완전 편해지고, 효율적이에요 !! 매력덩어리 \>_</
-- 연속되지 않을 값들을 받아오고 싶을 때 -> IN을 사용하자 !!

-- NOT 연산자
-- 그럼 이 결과에 반대되는 결과값을 받아오고 싶다면 ? -> NOT 연산자 !!
SELECT * FROM SNACK WHERE S_PRICE NOT IN (1000, 2000, 3000);
-- IN 연산자 앞에다가 NOT을 붙여서 사용하면 된다 ~
------------------------------------------------------------------------------------------------------------
-- 패턴 연산자
--	문자열을 포함하는 검색 : LIKE '패턴' 의 형태 
--	이 때 패턴에는 [%] 를 넣는데 뭐가 들어갈지 모른다는 뜻 !
--		LIKE '%ㅋ' : ㅋ로 끝나는 거
--		LIKE 'ㅋ%' : ㅋ로 시작하는 거
--		LIKE '%ㅋ%' : ㅋ가 포함
-- 그럼 LIKE 대신에 ( = 'ㅋ%' ) 는 안되나요 ?
--		=> 등호를 써서 식을 표현하면 패턴으로 인식하는게 아니라 'ㅋ%'라는 문자로 인식한다.
--		=> 그래서 LIKE로 'ㅋ%' 이런 패턴의 값을 찾아라 ~ 라고 표현해줌

-- '해'가 들어가는 회사에서 만든 과자 이름 조회
SELECT S_NAME FROM SNACK WHERE S_COMPANY LIKE '%해%';

-- '이'가 들어가는 과자들의 평균가를 조회
SELECT AVG(S_PRICE) || '원' 평균가 FROM SNACK WHERE S_NAME LIKE '%이%';

-- 오리온 과자거나, 몽쉘 ~ 인거 이름, 제조사, 가격 조회
SELECT S_NAME, S_COMPANY, S_PRICE FROM SNACK WHERE S_COMPANY = '오리온' OR S_NAME LIKE '몽쉘%';

-- 과자의 이름이 '초코파이'를 포함하거나, '몽쉘'을 포함하는 과자의 이름, 제조사, 가격 조회
SELECT S_NAME, S_COMPANY, S_PRICE FROM SNACK WHERE S_NAME LIKE '%초코파이%' OR S_NAME LIKE '%몽쉘%';

-- LIKE ~ IN 구조는 아예 없다 !!
-- SELECT S_NAME, S_COMPANY, S_PRICE FROM SNACK WHERE S_NAME LIKE IN ('%초코파이%', '%몽쉘%');

-- REGEXP_LIKE(컬럼명, 패턴1|패턴2|...)
-- 여러개의 패턴을 찾고 싶다면 |(파이프)를 넣어서 패턴을 추가하면 됨
-- 정규식(REGEX)을 이용해서 문자를 찾는 방법인데...
-- 패턴 앞에 ^를 넣으면 : 패턴값으로 시작하는 문자열 찾기
-- 패턴 뒤에 $를 넣으면 : 패턴값으로 끝나는 문자열 찾기

-- 과자의 이름이 '초코파이'로 시작하거나, '이'로 끝나는 과자의 이름, 제조사, 가격 조회
SELECT S_NAME, S_COMPANY, S_PRICE FROM SNACK WHERE REGEXP_LIKE(S_NAME, '^초코파이 | 이$');
------------------------------------------------------------------------------------------------------------
-- 집합 연산자
--	합집합
--		UNION		: 중복되는 값을 제외하고 출력
SELECT 1 ID, '수학' SUBJECT, 90 SCORE FROM DUAL
	UNION

SELECT 1 ID, '수학' SUBJECT, 90 SCORE FROM DUAL
	UNION
	
SELECT 1 ID, '수학' SUBJECT, 90 SCORE FROM DUAL;

-- 		UNION ALL	: 중복되더라도 모두 출력
SELECT 1 ID, '수학' SUBJECT, 90 SCORE FROM DUAL
	UNION ALL

SELECT 1 ID, '수학' SUBJECT, 90 SCORE FROM DUAL
	UNION ALL
	
SELECT 1 ID, '수학' SUBJECT, 90 SCORE FROM DUAL;

--	교집합
--		INTERSECT : 두 테이블의 집합 중 공통되는 값 출력	
SELECT 1 ID, '수학' SUBJECT, 90 SCORE FROM DUAL
	UNION
SELECT 2 ID, '영어' SUBJECT, 80 SCORE FROM DUAL
	INTERSECT
SELECT 1 ID, '수학' SUBJECT, 90 SCORE FROM DUAL;
	
--	차집합
--		MINUS : 첫번째 SELECT문 중에서 두번째 SELECT문에는 없는 값을 출력
SELECT 1 ID, '수학' SUBJECT, 90 SCORE FROM DUAL
	MINUS
SELECT 1 ID, '수학' SUBJECT, 80 SCORE FROM DUAL -- 여기까지는 첫번째 SELECT 문이 출력
	MINUS
SELECT 1 ID, '수학' SUBJECT, 90 SCORE FROM DUAL; -- 여기는 값이 같으므로 반환되지 않음
------------------------------------------------------------------------------------------------------------
-- 과자 데이터 중에서 회사가 오리온이고, 가격이 1000원 이하이거나 3000원 이상인 과자 전체 조회
-- 연산자 우선 순위 (오른쪽이 최우선순위)
-- OR > AND > NOT > 비교연산자 > 괄호
SELECT * FROM SNACK WHERE S_COMPANY = '오리온' AND (S_PRICE <= 1000 OR S_PRICE >= 3000);	

SELECT * FROM SNACK WHERE S_COMPANY = '오리온' 
    INTERSECT
SELECT * FROM SNACK WHERE S_PRICE <= 1000 OR S_PRICE >= 3000;	
------------------------------------------------------------------------------------------------------------
-- GROUP BY : 그룹으로 묶어 연산해서 하나의 결과를 나타내는 것
-- 회사별 과자 평균 가격, 최소 가격, 최대 가격
-- GROUP BY 하기 전에 최고가, 최소가, 평균가 구했을 때 -> 단일 값으로 출력
-- GROUP BY 한 후에 회사별로 그룹을 지어서 값을 나타냄 
SELECT S_COMPANY, AVG(S_PRICE), MIN(S_PRICE), MAX(S_PRICE) FROM SNACK GROUP BY S_COMPANY;

-- ROLLUP 연산자
-- GROUP BY ROLLUP(그룹 대상)
-- 컬럼에 대한 소계(SUBTOTAL)을 만들어 줌
-- GROUP BY 절의 컬럼의 갯수가 N개라면, ROLLUP을 썼을 때는 N+1개

-- 회사 이름, 회사별 과자 총 가격 합계와 모든 과자들의 가격 합계
SELECT S_COMPANY, SUM(S_PRICE)
	FROM SNACK
	GROUP BY ROLLUP(S_COMPANY);

-- S_COMPANY가 NULL값이면 '전체', 그게 아니면 S_COMPANY 값
SELECT NVL2(S_COMPANY, S_COMPANY, '전체') S_COMPANY, SUM(S_PRICE)
	FROM SNACK
	GROUP BY ROLLUP(S_COMPANY);

-- DECODE(컬럼명, 조건, 조건에 맞는 결과값, 조건에 맞지 않을 때 결과값)
-- DECODE 사용시 : 조건 자리에는 비교연산자 (X), 산술연산자 (O)
SELECT DECODE(S_COMPANY, NULL, '전체', S_COMPANY) S_COMPANY, SUM(S_PRICE)
	FROM SNACK
	GROUP BY ROLLUP(S_COMPANY);
------------------------------------------------------------------------------------------------------------
-- HAVING : GROUP BY절에 의해서 생성된 결과 중원하는 조건에 부합하는 자료만 찾고자 할 때 사용
-- HAVING과 WHERE 모두 조건을 이용해서 원하는 조건에 맞는 데이터만 뽑아온다는 공통점
-- HAVING : 그룹의 결과를 제한
--		VS
-- WHERE : 전체에 대한 결과를 제한
	
-- 회사별 과자 평균 가격이 2000원 이상인 회사의 이름과 과자 평균 가격을 조회
SELECT S_COMPANY, ROUND(AVG(S_PRICE), 1)
    FROM SNACK
    GROUP BY S_COMPANY
   	HAVING AVG(S_PRICE) >= 2000;
   	
-- ORDER BY : 정렬 ! 기본값은 오름차순 ASC, 내림차순 정렬은 DESC
ORDER BY [정렬대상 ASC(생략가능)/DESC]

-- 롯데 또는 해태 회사의 과자 평균 가격이 1800원 이상일 때 각 회사의 평균 가격 내림차순 정렬
SELECT S_COMPANY, ROUND(AVG(S_PRICE), 1)
    FROM SNACK
    WHERE S_COMPANY IN ('롯데', '해태')
    GROUP BY S_COMPANY
    HAVING AVG(S_PRICE) >= 1800 
    ORDER BY AVG(S_PRICE) DESC;
------------------------------------------------------------------------------------------------------------