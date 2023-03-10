-- SQL Developer Download
-- google - sql developer 21.2.1 - Oracle SQL Developer Downloads 21.2.1 - Windows 64-bit with JDK 8 included
-- 아니오 - 예 - 왼쪽 초록색 (+ 버튼) ID / PW 설정 후 테스트 -> 상태 성공 시 저장 !!
-- 도구 - 환경설정 - 코드 편집기 - 글꼴 - 글자 크기
-- 도구 - 환경설정 - 코드 편집기 - 행여백 - 행 번호 표시
-- 도구 - 환경설정 - 데이터베이스 - NLS - 날짜형식 - 'YYYY-MM-DD HH24:MI:SS' 로 바꾸기
-- 도구 - 환경설정 - 데이터베이스 - 고급 - 자동 커밋 
-- 도구 - 환경설정 - 코드 편집기 - PL/SQL 구문 색상 - PL/SQL 주석 색상 변경

-- 한줄 복사 : CTRL + SHIFT + D
-- 한줄 삭제 : ALT + SHIFT + D
-- 실행 : 커서 기준으로 CTRL + ENTER
-- 새 워크시트 열기 : ALT + F10

-- 주의 할 점 : sql문이 끝날때마다 ;을 찍는게 좋음

-------------------------------------------------------------------------------------------------------------
-- 엄청난 시행착오르 겪어서 -> DB를 설치
-- CMD기반 sqlplus를 다뤄보면서 DBA들이 하는 업무를 살짝 맛봤음 ! (계정생성, 권한부여, tablespace)
-- 테이블 / 행 / 열 / 스키마 / 인스턴스 / 도메인
-- SQL의 명령문 중 정의어(DDL)를 배우면서 테이블을 만들어봤고
-- 테이블 생성시 필요한 자료형(주력으로 사용하는 것만)
--	문자형 : VARCHAR2 / 숫자형 : NUMBER / 날짜 : DATE
--		문자형 VARCHAR2에 용량 입력할 때는 CHAR를 넣어서 글자 단위로 넣을 수 있게 하자 !
--		숫자형 NUMBER에 용량 입력할 때는 정밀도 / 범위 잘 조절해서 만들자 !
--		날짜 DATE...는 조만간 볼 것 !!
-- 상당히 어려웠던 제약조건 ! / NOT NULL, PRIMARY KEY / FOREIGN KEY
-- 테이블의 구조를 수정하거나, 삭제해보면서 DDL 완료 !

-- 과자 테이블을 만들건데
-- 과자 이름 / 회사 / 가격 정보를 넣고 싶다
-- 테이블 하나에 PK 하나 있었으면... ! => 어디에 PK를 먹일지 생각해보면서 ! 
CREATE TABLE SNACK (
    S_NAME VARCHAR2(10 CHAR) NOT NULL,
    S_COMPANY VARCHAR2(10 CHAR) PRIMARY KEY,
    S_PRICE NUMBER(5) NOT NULL
);

INSERT INTO SNACK VALUES('CHOCO PI', 'ORION', '8000');

SELECT * FROM SNACK;

TRUNCATE TABLE SNACK;

DROP TABLE SNACK CASCADE CONSTRAINT PURGE;

-- 회사에서 한가지 종류의 과자만 만드는 것이 아니므로 PK X
-- 번호값을 만들어서 여기에 PK를 주는 것도 한 방법 !
CREATE TABLE SNACK (
	S_NO NUMBER(4) PRIMARY KEY,
    S_NAME VARCHAR2(10 CHAR) NOT NULL,
    S_COMPANY VARCHAR2(10 CHAR) NOT NULL,
    S_PRICE NUMBER(5) NOT NULL
);
-------------------------------------------------------------------------------------------------------------
-- 그래서 오늘은 DML을 다뤄볼 것 !
-- DML은 데이터 조작어(Data Manipulation Language)라고 하고,
-- 테이블에 데이터를 검색, 삽입, 수정, 삭제 하는데 사용하는 문장
-- SELECT, INSERT, UPDATE, DELETE 등이 있고,
-- CRUD (CREATE, READ, UPDATE, DELETE) 라고 함
-------------------------------------------------------------------------------------------------------------
-- 여기서 C는 (create table - X (DBA의 작업))
-- 데이터를 만든다는 의미의 C (insert - O)
-- 형태는
INSERT INTO 테이블명(컬럼명, 컬럼명, ...) VALUES(값, 값, 값, ...);

INSERT INTO SNACK(S_NO, S_NAME, S_COMPANY, S_PRICE) VALUES(1, '초코파이', '오리온', 5000);

-- 컬럼 순서 바꾸기 - ?! 됨 !!
INSERT INTO SNACK(S_PRICE, S_NO, S_NAME, S_COMPANY) VALUES(5000, 2, '초코파이', '오리온');

-- 컬럼에 값 안넣기 - ?! 에러 !! NOT NULL !!
-- NOT NULL이 없었다면, 값은 정상적으로 들어갔을 것이고, 지정해주지 않은 컬럼에 대해서는 NULL 값 !!
-- 그런데 가급적이면 값들이 다 들어가있었으면 좋겠음 ... !
INSERT INTO SNACK(S_NO, S_NAME, S_COMPANY) VALUES(3, '초코파이', '오리온');

-- (컬럼명, 컬럼명, ...) 생략하고 컬럼 순서대로 넣는 방법도 !
INSERT INTO SNACK VALUES(4, '초코파이', '오리온', 5000);
-------------------------------------------------------------------------------------------------------------
-- 테이블 지우고
-- 다시 테이블 생성해서 값 5개정도만 넣어보자 !
INSERT INTO SNACK VALUES(1, '새우깡', '농심', 3000);
INSERT INTO SNACK VALUES(2, '초코파이', '오리온', 6000);
INSERT INTO SNACK VALUES(3, '홈런볼', '해태', 3000);
INSERT INTO SNACK VALUES(4, '포카칩', '오리온', 3000);
INSERT INTO SNACK VALUES(5, '초코파이', '롯데', 6000);

SELECT * FROM SNACK;

-- 그런데... 지금이야 5개 넣어서 일잃 과자들 번호값을 주면 됐는데
-- 과자의 종류가 엄청 많이 있다 ...
-- 과자 데이터를 계속 넣다가 나중에 과자 번호를 잊어버리면..?
-- 데이터를 만들때마다 과자의 번호가 자동으로 계산이 되었으면 좋겠다 ! \ㅇ0ㅇ/ !

-- FACTORY PATTERN !! 공장화 시스템 !
-- MYSQL : Autoincrement 옵션
-- 현재 우리가 사용하고 있는 OracleDB : Sequence라는 것이 있음
--	번호를 순서에 맞게 자동으로 생성해주는건데
--	테이블과는 무관하고, 단점으로는 INSERT에 실패해도 sequence 값은 무조건 올라감
--	그리고, 증가된 값을 다시 내릴 수는 없다.

-- sequence 생성
CREATE SEQUENCE 시퀀스명;		-- 간단한 시퀀스

-- 테이블명 뒤에 _SEQ를 붙여주는 문화가 있음
CREATE SEQUENCE SNACK_SEQ;

-- 구체적인 시퀀스
CREATE SEQUENCE 시퀀스명
	INCREMENT BY 1			-- 증가값 (1씩 증가)
	START WITH 1			-- 시작값
	MINVALUE 1				-- 최소값
	MAXVALUE 999			-- 최대값
	NOCYCLE / CYCLE			-- 최대값에 도달하면 시작값부터 다시 반복할지 말지
	NOCASHE / CASH			-- 시퀀스를 미리 만들어놓고 메모리에서 가져다 쓸지 말지
	NOORDER / ORDER;		-- 요청순서대로 값을 생성할 지 말지 

-- sequence 삭제
DROP SEQUENCE 시퀀스명;

-- sequence 사용 : 시퀀스명.NEXTVAL
-- 기존에 있던 테이블 삭제 후 다시 만들어서 값을 넣어봅시다 !
INSERT INTO SNACK VALUES(SNACK_SEQ.nextval, '새우깡', '농심', 3000);
INSERT INTO SNACK VALUES(SNACK_SEQ.nextval, '초코파이', '오리온', 6000);
INSERT INTO SNACK VALUES(SNACK_SEQ.nextval, '홈런볼', '해태', 3000);
INSERT INTO SNACK VALUES(SNACK_SEQ.nextval, '포카칩', '오리온', 3000);
INSERT INTO SNACK VALUES(SNACK_SEQ.nextval, '초코파이', '롯데', 6000);

-- 이제 다시 테이블이랑 시퀀스 지워주고, 테이블 다시 만들 때 속성 추가 ! (유통기한 Date)
CREATE TABLE SNACK (
	S_NO NUMBER(4) PRIMARY KEY,
    S_NAME VARCHAR2(10 CHAR) NOT NULL,
    S_COMPANY VARCHAR2(10 CHAR) NOT NULL,
    S_PRICE NUMBER(5) NOT NULL,
    S_TIME DATE NOT NULL
);

CREATE SEQUENCE SNACK_SEQ;

-- dual 테이블 : 연습장 ! 더미테이블
SELECT SYSDATE FROM DUAL;

INSERT INTO SNACK VALUES(SNACK_SEQ.nextval, '새콤달콤', '크라운', 500, SYSDATE);

-- 특정시간 / 날짜
--		내장함수 - TO_DATE('값', '패턴')
--		패턴(대문자!!!) - YYYY.MM.DD, AM/PM, HH(12시간), HH24(추천), MI(분), SS(초)
INSERT INTO SNACK VALUES(SNACK_SEQ.nextval, '마이쮸', '롯데', 500, TO_DATE('2023-03-14 14', 'YYYY-MM-DD HH24'));

-- 15 ~ 20개
INSERT INTO SNACK VALUES(SNACK_SEQ.nextval, '마이쮸', '롯데', 500, TO_DATE('2023-03-14 14', 'YYYY-MM-DD HH24'));
INSERT INTO SNACK VALUES(SNACK_SEQ.nextval, '새우깡', '농심', 3200, TO_DATE('2023-04-17 16', 'YYYY-MM-DD HH24'));
INSERT INTO SNACK VALUES(SNACK_SEQ.nextval, '초코파이', '오리온', 6100, TO_DATE('2023-11-10 04', 'YYYY-MM-DD HH24'));
INSERT INTO SNACK VALUES(SNACK_SEQ.nextval, '홈런볼', '해태', 3800, TO_DATE('2023-08-16 08', 'YYYY-MM-DD HH24'));
INSERT INTO SNACK VALUES(SNACK_SEQ.nextval, '포카칩', '오리온', 3500, TO_DATE('2023-10-12 11', 'YYYY-MM-DD HH24'));
INSERT INTO SNACK VALUES(SNACK_SEQ.nextval, '초코파이', '롯데', 5700, TO_DATE('2023-12-15 12', 'YYYY-MM-DD HH24'));
INSERT INTO SNACK VALUES(SNACK_SEQ.nextval, '프링글스 ', '켈로그', 4500, TO_DATE('2024-01-10 16', 'YYYY-MM-DD HH24'));
INSERT INTO SNACK VALUES(SNACK_SEQ.nextval, '맛동산', '해태', 2300, TO_DATE('2023-05-11 14', 'YYYY-MM-DD HH24'));
INSERT INTO SNACK VALUES(SNACK_SEQ.nextval, '오징어땅콩', '오리온', 1500, TO_DATE('2023-04-16 11', 'YYYY-MM-DD HH24'));
INSERT INTO SNACK VALUES(SNACK_SEQ.nextval, '에이스', '해태',1800, TO_DATE('2023-08-12 17', 'YYYY-MM-DD HH24'));
INSERT INTO SNACK VALUES(SNACK_SEQ.nextval, '꼬북칩', '오리온', 2500, TO_DATE('2023-09-13 15', 'YYYY-MM-DD HH24'));
INSERT INTO SNACK VALUES(SNACK_SEQ.nextval, '오예스', '해태', 5500, TO_DATE('2023-10-19 13', 'YYYY-MM-DD HH24'));
INSERT INTO SNACK VALUES(SNACK_SEQ.nextval, '몽쉘', '롯데', 4900, TO_DATE('2023-11-14 17', 'YYYY-MM-DD HH24'));
INSERT INTO SNACK VALUES(SNACK_SEQ.nextval, '카스타드', '롯데', 4700, TO_DATE('2023-11-16 18', 'YYYY-MM-DD HH24'));
INSERT INTO SNACK VALUES(SNACK_SEQ.nextval, '허니버터칩', '해태', 2400, TO_DATE('2023-06-13 15', 'YYYY-MM-DD HH24'));
INSERT INTO SNACK VALUES(SNACK_SEQ.nextval, '썬칩', '오리온', 2800, TO_DATE('2023-06-14 19', 'YYYY-MM-DD HH24'));
INSERT INTO SNACK VALUES(SNACK_SEQ.nextval, '빼빼로', '롯데', 1300, TO_DATE('2023-07-15 17', 'YYYY-MM-DD HH24'));
INSERT INTO SNACK VALUES(SNACK_SEQ.nextval, '콘칩', '크라운', 3100, TO_DATE('2023-08-19 16', 'YYYY-MM-DD HH24'));
INSERT INTO SNACK VALUES(SNACK_SEQ.nextval, '마가렛트', '롯데', 5200, TO_DATE('2023-12-19 05', 'YYYY-MM-DD HH24'));
-------------------------------------------------------------------------------------------------------------
-- R(Read) ****
SELECT [DISTINCT] [컬럼명], [컬럼명 AS 별칭 || 컬럼명 별칭], [연산자 사용], [통계함수], ...
	FROM [테이블명]
	WHERE [조건식]
	GROUP BY [그룹대상]
	HAVING [함수 포함 조건]
	ORDER BY [정렬대상 ASC/DESC (오름차순 / 내림차순)] -- 기본값은 오름차순 !
-- 의 형태 !

-- 과자테이블 전체 조회
-- '*' : 테이블 내의 모든 컬럼을 가져온다.
SELECT * FROM SNACK;

-- DISTINCT : 중복제거
SELECT S_COMPANY FROM SNACK;			-- 과자별로 회사가 나옴
SELECT DISTINCT S_COMPANY FROM SNACK;	-- 중복 제거되고 한번씩만 나옴

-- 컬럼명은 그대로 컬럼명을 쓰면 되고
-- 별칭 같은 경우에는.. SELECT문 안에서는 숫자 계산이 가능한데(+, -, *, /)
SELECT S_PRICE / 100 FROM SNACK;
-- 컬럼명 자체가 S_PRICE / 100 으로 출력됨 !
-- 실제 프로그래밍 언어와 연동하다보면 컬럼명을 이용해서 값을 불러오는 경우가 있는데,
-- 별칭이라는 것을 써서 헷갈림을 방지하는 용도로 사용

-- AS를 써서 하는 법
SELECT S_PRICE / 100 AS S_PRICE FROM SNACK;
-- AS안쓰고 별칭쓰는 법 ( V )
SELECT S_PRICE / 100 S_PRICE FROM SNACK;

-- 연산자 ! (산술연산자)
-- Dual 테이블
-- 1. 오라클 자체에서 제공해주는 더미테이블
-- 2. 간단하게 함수를 이용해서 계산 결과값을 확인할 때 사용하는 테이블

-- 어떤 값이 나올까 ?! 
SELECT 1 + '3' FROM DUAL;
-- 4가 나옴 !
-- 대부분 다른 언어들 같은 경우에는 '문자 우선' => 13이라는 결과가 나오는데
-- 오라클에서는 반대로 '숫자 우선'
-- 오라클 내에서는 연산자가 숫자만 연산 해줌

SELECT 1 + 'a' FROM DUAL;	-- 에러 ! (숫자로 바꿀수 없다는 에러 'invalid number')

-- 문자를 더해주기 위한 연산자가 따로 있는데
-- 바로 ' || '
SELECT 1 || 'a' FROM DUAL;




































