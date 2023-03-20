-- 학생 테이블 (이름, 키, 강의장(EX: 1강의장 / 2강의장 / 3강의장)) 에 대한 정보 !

-- 학생 데이터 10개 정도 담기 !
CREATE TABLE MAR14_STUDENT (
	S_NO NUMBER(2) PRIMARY KEY,
    S_NAME VARCHAR2(10 CHAR) NOT NULL,
    S_HEIGHT NUMBER(4, 1) NOT NULL,
    S_CLASS VARCHAR2(10 CHAR) NOT NULL
);

CREATE SEQUENCE MAR14_STUDENT_SEQ;

INSERT INTO MAR14_STUDENT VALUES(MAR14_STUDENT_SEQ.NEXTVAL, '김민준', 175.2, '1 강의장');
INSERT INTO MAR14_STUDENT VALUES(MAR14_STUDENT_SEQ.NEXTVAL, '김서준', 170.3, '2 강의장');
INSERT INTO MAR14_STUDENT VALUES(MAR14_STUDENT_SEQ.NEXTVAL, '이민준', 169.1, '3 강의장');
INSERT INTO MAR14_STUDENT VALUES(MAR14_STUDENT_SEQ.NEXTVAL, '김지호', 165.5, '1 강의장');
INSERT INTO MAR14_STUDENT VALUES(MAR14_STUDENT_SEQ.NEXTVAL, '이하준', 162.6, '1 강의장');
INSERT INTO MAR14_STUDENT VALUES(MAR14_STUDENT_SEQ.NEXTVAL, '박건우', 180.4, '2 강의장');
INSERT INTO MAR14_STUDENT VALUES(MAR14_STUDENT_SEQ.NEXTVAL, '차은우', 186.5, '3 강의장');
INSERT INTO MAR14_STUDENT VALUES(MAR14_STUDENT_SEQ.NEXTVAL, '김민재', 174.2, '3 강의장');
INSERT INTO MAR14_STUDENT VALUES(MAR14_STUDENT_SEQ.NEXTVAL, '박준혁', 181.3, '2 강의장');
INSERT INTO MAR14_STUDENT VALUES(MAR14_STUDENT_SEQ.NEXTVAL, '오지환', 174.7, '1 강의장');
------------------------------------------------------------------------------------------------------------
-- WINDOW 함수
-- 행과 행 사이의 관계를 쉽게 정의하기 위해 만든 함수
-- 복잡한 프로그램을 하나의 문장으로 쉽게 해결할 수 있다.
-- 대표적으로 우리가 전에 배운 집계합수, 순위함수가 있다
-- 그래서 이 WINDOW 함수로 순위, 합계, 평균 등을 조작할 수 있음

-- WINDOW 함수의 구조
SELECT 컬럼명, 컬럼명, 집계 함수, ... ,
	OVER ( [PARTITION BY 컬럼] [ORDER BY 컬럼] [WINDOWING 절] )
	FROM 테이블명;
	
	-- OVER() : ORDER BY, GROUP BY 구문을 대체할 수 있는 함수
	-- PARTITION BY : 컬럼을 기준으로 그룹(파티션)을 나눈다
	-- ORDER BY : OVER함수 내에서 정렬
	-- WINDOWING : 행 기준의 범위를 정함
		-- 옵션
		-- ROWS : 범위를 지정 (행을 기준으로)
		-- RANGE : 범위를 지정 (행이 가지고 있는 값을 기준으로)
		-- BETWEEN ~ AND : 시작과 끝 위치를 설정
		-- UNBOUNDED PRECEDING : 시작위치가 첫번째 행
		-- UNBOUNDED FOLLOWING : 마지막위치가 마지막 행
		-- CURRENT ROW : 현재 행까지
		
-- RANK : 중복 순위만큼 다음 순위 값을 증가 시킴
SELECT S_NAME, S_CLASS, S_HEIGHT,
	RANK() OVER (ORDER BY S_HEIGHT DESC) HEIGHT_RANK,
	RANK() OVER (PARTITION BY S_CLASS ORDER BY S_HEIGHT DESC) IN_CLASS_RANK
				-- 강의장 별로 그룹을 지어서 키 순위를 냄
FROM MAR14_STUDENT;

-- DENSE_RANK : 중복 순위가 존재해도 순차적으로 다음 순위 값을 표시함
SELECT S_NAME, S_CLASS, S_HEIGHT,
	RANK() OVER (ORDER BY S_HEIGHT DESC) HEIGHT_RANK,		-- 2등, 2등, 4등
	DENSE_RANK() OVER (ORDER BY S_HEIGHT DESC) DENSE_RANK	-- 2등, 2등, 3등
FROM MAR14_STUDENT;

-- LAST_VALUE : 파티션에서 가장 마지막에 나오는 값
SELECT S_CLASS, S_NAME, S_HEIGHT,
	-- 강의장별로 그룹을 지었고, 그 안에는 학생들의 키 내림차순으로 정렬
	LAST_VALUE(S_NAME) OVER(PARTITION BY S_CLASS ORDER BY S_HEIGHT DESC
	-- 그 그룹내의 처음부터 끝까지 행에는 마지막에 나오는 학생의 이름값을 불러오겠다
	ROWS BETWEEN UNBOUNDED PRECEDING AND UNBOUNDED FOLLOWING)
FROM MAR14_STUDENT;

-- LAG : 이전 행의 값을 가져옴
SELECT S_CLASS, S_NAME, S_HEIGHT,
	-- 이전 행의 S_HEIGHT 값을 가져올건데, 강의장별로 그룹을 지었고, 키 오름차순 정렬
	-- 만약에 이전 행의 키 값이 없어 NULL값이면 '-'으로 바꾸고
	DECODE(LAG(S_HEIGHT) OVER(PARTITION BY S_CLASS ORDER BY S_HEIGHT), NULL, '-',
	-- 이전 행의 키값이 있으면 그 값을 불러오겠다 !
	LAG(S_HEIGHT) OVER(PARTITION BY S_CLASS ORDER BY S_HEIGHT)) LAG_HEIGHT
FROM MAR14_STUDENT;

-- LEAD : 다음 행의 값을 가져옴
SELECT S_CLASS, S_NAME, S_HEIGHT,
	-- 다음 행의 S_HEIGHT 값을 가져올건데, 강의장별로 그룹을 지었고, 키 오름차순 정렬
	-- 만약 다음 행이 없어서 NULL이면 '-'으로 바꾸고
	DECODE(LEAD(S_HEIGHT) OVER(PARTITION BY S_CLASS ORDER BY S_HEIGHT), NULL, '-',
	-- 다음 행의 키 값이 있으면 그 값을 불러오겠다.
	LEAD(S_HEIGHT) OVER(PARTITION BY S_CLASS ORDER BY S_HEIGHT)) LEAD_HEIGHT
FROM MAR14_STUDENT;

-- NTILE : 결과를 사용자가 지정한 그룹의 수로 나눠서 출력
-- 키 내림차순 기준으로 5개의 그룹으로 나누기
SELECT S_CLASS, S_NAME, S_HEIGHT,
    NTILE(5) OVER(ORDER BY S_HEIGHT) N_TILE
FROM MAR14_STUDENT;
------------------------------------------------------------------------------------------------------------