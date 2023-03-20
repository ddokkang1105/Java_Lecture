-- 계층형 쿼리
-- 테이블에 계층형 데이터가 존재하는 경우 이를 조회하기 위한 쿼리
-- 계층형 데이터란, 동일 테이블에 계층적으로 상위데이터와 하위데이터가 포함된 데이터
-- 하드웨어를 예로..
-- 중앙처리장치, 기억장치, 입출력장치의 상위데이터는 하드웨어다.
-- 입출력장치를 나눠서 입력장치, 출력장치의 상위데이터가 입출력장치라고 하자

-- 이 내용을 정의하는 테이블을 만들어보자
CREATE TABLE MAR14_DEVICE(
    D_NAME VARCHAR2(10 CHAR) PRIMARY KEY,
    D_PRIOR VARCHAR2(10 CHAR)  -- 하드웨어의 상위장치는 없으므로 제약조건 X !!
);

INSERT INTO MAR14_DEVICE VALUES('하드웨어', NULL);
INSERT INTO MAR14_DEVICE VALUES('중앙처리장치', '하드웨어');
INSERT INTO MAR14_DEVICE VALUES('기억장치', '하드웨어');
INSERT INTO MAR14_DEVICE VALUES('입출력장치', '하드웨어');
INSERT INTO MAR14_DEVICE VALUES('입력장치', '입출력장치');
INSERT INTO MAR14_DEVICE VALUES('출력장치', '입출력장치');

-- 계층형 쿼리의 형태
START WITH 조건 			-- 이름에서 추측할 수 있겠지만, 계층 구조 전개 시작 위치를 지정
							-- D_PRIOR IS NULL을 하면 D_PRIOR 컬럼에 NULL값이 들어있는
							-- '하드웨어' 행부터 시작위치로 지정
CONNECT BY [NOCYCLE] 조건	-- CONNECT BY 절은 다음에 전개될 하위 데이터를 지정하는데
							-- PRIOR 하위데이터 = 상위데이터 => 순방향 전개
							-- PRIOR 상위데이터 = 하위데이터 => 역방향 전개
							-- NO CYCLE은 데이터를 전개하면서 이미 나타난 데이터가
							--		또 나오는 것을 방지해줌 (없어도 됨 !)
[ORDER SIBLINGS BY 컬럼];	-- 동일 계층 사이에서 정렬을 해준다

-- SELECT 문
SELECT D_NAME, D_PRIOR, LEVEL FROM MAR14_DEVICE -- 계층을 보기 위해 LEVEL 이라는 컬럼을 심어둠
	START WITH D_PRIOR IS NULL	-- 이걸 통해 '하드웨어'행을 시작점으로 정함
								-- (NULL값이 들어있는 행부터 시작)
	CONNECT BY PRIOR D_NAME = D_PRIOR
								-- 이 때 여기서 시작행인 '하드웨어'가 상위데이터가 되어서 진행
								-- 하드웨어를 상위장치로 가지고 있는 기억, 입출력, 중앙처리장치는
								-- LEVEL 2가 된다.
								-- ... LEVEL 3도 마찬가지
	ORDER SIBLINGS BY D_NAME DESC;
------------------------------------------------------------------------------------------------------------