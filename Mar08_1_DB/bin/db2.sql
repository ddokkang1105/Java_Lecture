-- < 쓸만한 내장 함수 >
-- 1. 숫자 함수
--		- ABS(숫자) : 절대값 계산									EX> ABS(-4.6)
--		- ROUND(숫자, M) : 숫자 반올림, M은 반올림 기준 자릿수		EX> ROUND(5.36, 1)
--		- POWER(숫자, N) : 숫자 N제곱한 값							EX> POWER(2, 3)
--		- TRUNC(숫자, M) : 숫자의 M번째 자리까지 남기고 값을 버림	EX> TRUNC(123.456, 2)
--																	EX> TRUNC(123.456, -1)
--																	EX> TRUNC(123.456, 0)
--		- FLOOR(계산식) : 정수값 결과 (내림)						EX> FLOOR(10/4)
--		- CEIL(계산식) : 정수값 결과 (올림)							EX> CEIL(3)
--		- MOD(M, N) : 숫자 M을  N으로 나눈 나머지					EX> MOD(6, 4)
--		- SQRT(숫자) : 숫자의 제곱근 값을 계산(숫자는 양수 !)		EX> SQRT(9.0)
-------------------------------------------------------------------------------------------------------------
-- 2. 문자 함수
--		- CONCAT(S1, S2) : 두 문자열을 연결							EX> CONCAT('ABCD', 'EFG')
--		- SUBSTR(S1, N, K) : 문자열의 N번째부터 K만큼의 길이를 반환 EX> SUBSTR('ABCDEFG', 3, 4)
--		- INSTR(S1, S2, N, K) : S1의 N번째부터 시작해서 찾고자하는	EX> INSTR('HELLO', 'L', 1, 2)
--							S2가 K번째 나타내는 문자열의 위치 반환
--		- LPAD(S, N, C) : 자릿수 N에서 문자열 S의 개수를 뺀 나머지를EX> LPAD('ABC', 5, '*')
--						  문자열 N의 왼쪽에 지정한 문자 C로 채워줌
--		- RPAD(S, N, C) : 자릿수 N에서 문자열 S의 개수를 뺀 나머지를EX> RPAD('ABC', 5, '*')
--						  문자열 N의 오른쪽에 지정한 문자 C로 채워줌
--		- LTRIM(S1, S2) : 문자열 S1 기준으로 						EX> LTRIM('*ABC', '*')
--						  왼쪽에 있는 지정한 문자 S2 제거
--		- RTRIM(S1, S2) : 문자열 S1 기준으로 						EX> RTRIM('*ABC', '*')
--						  오른쪽에 있는 지정한 문자 S2 제거
--		- REPLACE(S1, S2, S3) : S1의 지정한 문자 S2를 문자 S3로 변경EX> REPLACE('JACK and JUE', 'J', 'BL')
--		- LENGTH(S1) : 글자수를 세어주는 함수						EX> LENGTH('ZZZ')
--		- LENGTHB1(S1) : 글자의 용량(바이트)을 세어주는 함수		EX> LENGTHB('ZZZ')
-------------------------------------------------------------------------------------------------------------
-- 3. 날짜 / 시간 함수 ***
--	[날짜 형식] 대문자 !
--			YYYY : 4자리 연도
--			YYY, YY, Y : 각각 4자리 연도의 마지막 3, 2, 1자리
--			MM : 월
--			DD : 1달 중 날짜(일자)
--			DAY : 요일(월요일 ~ 일요일)
--			DY : 요일 약자(월 ~ 일)
--			HH, HH12 : 12시간 / AM or PM : 오전 or 오후
--			HH24 : 24시간 / MI : 분 / SS : 초

--			- SYSDATE : 현재 날짜 / 시간을 반환			
--			- TO_DATE(S1, DATETIME형식) : 문자형 데이터를 날짜형으로 반환
SELECT TO_DATE('2023-03-14 오전 06:00', 'YYYY-MM-DD PM HH:MI') FROM DUAL;

--			- TO_CAHR(DATE, DATETIME형식) : 날짜형 데이터를 문자형으로 반환 (DATETIME형식 제외하고는 특수문자만 !)
SELECT TO_CHAR(SYSDATE, 'YYYY-MM-DD') FROM DUAL;

-- 특정 날짜 값을 받아오고 싶다면 SYSDATE자리에 TO_DATE함수를 넣어서 만들면 됨 !
--		=> 반환되는 데이터 타입이 다르다 !!
-- TO_DATE 날짜형 / TO_CHAR 문자형

--			- ADD_MONTHS(DATE, 숫자) : 날짜에서 지정한 달만큼 더해준다(1 : 다음달, -1 : 이전달)
--SELECT ADD_MONTHS(SYSDATE, -2) FROM DUAL;

--			- LAST_DAY(DATE) : 그 달의 마지막 날을 반환
SELECT LAST_DAY(SYSDATE) FROM DUAL;
-------------------------------------------------------------------------------------------------------------
-- 오늘 날짜 기준 연도 조회 (테이블 헤더에 '연도' / 컬럼에 '2023년' 이라고 나오게)
SELECT TO_CHAR(SYSDATE, 'YYYY') || '년' 연도 FROM DUAL;
-- 오늘 날짜 기준 월 조회 (테이블 헤더에 '월' / 컬럼에 '03월' 이라고 나오게)
SELECT TO_CHAR(SYSDATE, 'MM') || '월' 월 FROM DUAL;
-- 오늘 날짜 기준 일 조회 (테이블 헤더에 '일' / 컬럼에 '08일' 이라고 나오게)
SELECT TO_CHAR(SYSDATE, 'DD') || '일' 일 FROM DUAL;
-- 오늘 날짜 기준 시/분 조회 (테이블 헤더 각각 '시', '분' / 컬럼에 각각 '??시' '??분' 이라고 나오게)
SELECT TO_CHAR(SYSDATE, 'HH24') || '시' 시간 , TO_CHAR(SYSDATE, 'MM') || '분' 분 FROM DUAL;
-- 지금이 오전인지 오후인지 조회
-- 띄어쓰기, 특수문자가 별칭에 들어가는 경우 : 별칭을 큰 따옴표로 감싸주기
SELECT TO_CHAR(SYSDATE, 'AM') "오전/오후" FROM DUAL;
-- 문자열 2023-05-05 오전 05:05를 2023.05.05로 조회
SELECT TO_CHAR(TO_DATE('2023-05-05 오전 05:05', 'YYYY.MM.DD AM HH:MI'), 'YYYY.MM.DD') FROM DUAL;
-- 오늘 날짜 기준 3달 전 마지막 날은 몇 월 몇 일인지 조회
SELECT LAST_DAY(ADD_MONTHS(SYSDATE, -3)) FROM DUAL;
SELECT TO_CHAR(LAST_DAY(ADD_MONTHS(SYSDATE, -3)), 'MM/DD') "월/일" FROM DUAL;
SELECT TO_CHAR(LAST_DAY(ADD_MONTHS(SYSDATE, -3)), 'DAY') FROM DUAL;
-------------------------------------------------------------------------------------------------------------
-- 4. 집계 / 분석함수 - SELECT 컬럼명 쪽이나, HAVING 절에서 사용 !
--		- AVG(컬럼명) - 평균
--		- COUNT(컬럼명) : 검색되는 데이터의 수
--		- MAX(컬럼명) : 최대값
--		- MIN(컬럼명) : 최소값
--		- SUM(컬럼명) : 총합
--		- RANK : 중복 순위만큼 다음 순위 값을 표시함
--		- DENSE_RANK : 중복 순위가 존재해도 순차적으로 다음 순위값을 표시함
-------------------------------------------------------------------------------------------------------------
-- 5. NULL 관련 함수
-- 현재 제약조건에 NOT NULL로 무조건 데이터를 입력하게 해놨는데
-- NULL : 미확인된 값이나 아직 적용되지 않은 값 / 0이나 비어있는 공란도 아님

--		- NVL함수 : NULL인 경우만 지정한 값으로 대치하는 함수
--		NVL(값, NULL일때 대체값)
SELECT NVL(NULL, 'B') FROM DUAL;
SELECT NVL('A', 'B') FROM DUAL;

-- 		- NVL2함수 : NULL의 여부에 따라 지정한 값으로 대치하는 함수
--		NVL2(값, 값이 있을때 대체값, NULL일때 대체값)
SELECT NVL2(NULL, 'A', 'B') FROM DUAL;
SELECT NVL2('C', 'A', 'B') FROM DUAL;


























-------------------------------------------------------------------------------------------------------------