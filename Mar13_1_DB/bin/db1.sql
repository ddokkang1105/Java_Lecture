SELECT * FROM FRANCHISE;

SELECT * FROM CEO;

SELECT * FROM MENU;
------------------------------------------------------------------------------------------------------------
-- 제일 비싼 메뉴의 이름, 가격
SELECT M_NAME, M_PRICE
    FROM MENU
    WHERE M_PRICE IN (
        SELECT MAX(M_PRICE)
        FROM MENU
    );
    
-- 최연장자 사장님의 이름, 생일
SELECT C_NAME, C_BIRTHDAY
    FROM CEO
    WHERE C_BIRTHDAY IN (
        SELECT MIN(C_BIRTHDAY)
        FROM CEO
    );
    
-- 좌석 수 제일 적은 식당의 이름, 지점명, 좌석수
SELECT F_NAME, F_LOCATION, F_SEAT
    FROM FRANCHISE
    WHERE F_SEAT IN (
        SELECT MIN(F_SEAT)
        FROM FRANCHISE
    );
------------------------------------------------------------------------------------------------------------
-- 홍콩반점 강서점 운영하는 사람의 이름, 생일    
SELECT C_NAME, C_BIRTHDAY
    FROM CEO
    WHERE C_NO IN (
        SELECT F_CEO
        FROM FRANCHISE
        WHERE F_NAME = '홍콩반점' AND F_LOCATION = '강서'
    );

-- '짜장'이 들어간 음식은 어디가면 먹을 수 있나요 ? (짜장면 파는 식당 이름, 지점명)
SELECT F_NAME, F_LOCATION
    FROM FRANCHISE
    WHERE F_NO IN (
        SELECT M_F_NO
        FROM MENU
        WHERE M_NAME LIKE '%짜장%'
    );
    
-- 좌석 수 제일 많은 식당을 운영하는 사람의 모든 정보
SELECT *
    FROM CEO
    WHERE C_NO IN (
        SELECT F_CEO
        FROM FRANCHISE
        WHERE F_SEAT IN (
            SELECT MAX(F_SEAT)
            FROM FRANCHISE
        )
    );
------------------------------------------------------------------------------------------------------------
-- 최연소 사장님이 운영하는 가게의 메뉴 이름, 가격
SELECT M_NAME, M_PRICE
    FROM MENU
    WHERE M_F_NO IN (
        SELECT F_NO
        FROM FRANCHISE
        WHERE F_CEO IN (
            SELECT C_NO
            FROM CEO
            WHERE C_BIRTHDAY IN (
                SELECT MAX(C_BIRTHDAY)
                FROM CEO
            )
        )
    );
------------------------------------------------------------------------------------------------------------
-- 테이블 여러개를 'JOIN' 시킨다.
--			: 테이블 여러개를 붙여서 RAM에 잠깐 넣어놓는 ... !
------------------------------------------------------------------------------------------------------------
-- 이렇게 테이블을 붙여서 사용이 가능하지만,
--	테이블들이 합쳐지면서 나타낼 수 있는 모~~든 경우의 수들을 다 나타내기 때문에
SELECT * FROM FRANCHISE, CEO;
-- 조건식을 사용해서 진짜 데이터를 가지고 와야 함 !
SELECT * FROM FRANCHISE, CEO WHERE F_CEO = C_NO;

-- 전체 식당 이름, 지점명, 사장님 이름, 사장님 생일
SELECT F_NAME, F_LOCATION, C_NAME, C_BIRTHDAY
    FROM FRANCHISE, CEO
    WHERE F_CEO = C_NO;
    
-- 전체 메뉴명, 가격, 식당이름, 지점명
SELECT M_NAME, M_PRICE, F_NAME, F_LOCATION
    FROM MENU, FRANCHISE
    WHERE M_F_NO = F_NO;
    
-- 좌석수가 50석 이상인 식당의 메뉴명, 가격, 식당이름, 지점명, 좌석 수
SELECT M_NAME, M_PRICE, F_NAME, F_LOCATION, F_SEAT
    FROM MENU, FRANCHISE
    WHERE F_SEAT >= 50 AND F_NO = M_F_NO;
    
-- 규모가 제일 큰 식당의 메뉴명, 가격, 식당이름, 지점명, 좌석 수
SELECT M_NAME, M_PRICE, F_NAME, F_LOCATION, F_SEAT
    FROM MENU, FRANCHISE
    WHERE F_NO = M_F_NO AND F_SEAT IN (
        SELECT MAX(F_SEAT)
        FROM FRANCHISE
    );
    
-- 최연장자 사장님네 전체 메뉴명, 가격, 식당이름, 지점명, 사장님 이름, 생일
--				을 메뉴명 가나다순 -> 메뉴명이 같으면 식당이름 가나다순
SELECT M_NAME, M_PRICE, F_NAME, F_LOCATION, C_NAME, C_BIRTHDAY
    FROM MENU, FRANCHISE, CEO
    WHERE M_F_NO = F_NO AND F_CEO = C_NO AND C_BIRTHDAY IN (
        SELECT MIN(C_BIRTHDAY)
        FROM CEO
    )
    ORDER  BY M_NAME, F_NAME;
------------------------------------------------------------------------------------------------------------
-- 메뉴 데이터를 갯수로 나눠서 페이지로 보여주고 싶음
-- 어떻게 할까 ?
-- 메뉴테이블에 M_NO가 있음 (PRIMARY KEY)
--		SEQUENCE로 처리했음
--			그.런.데.말.입.니.다. SEQUENCE는 INSERT에 실패해도 올라감
--		메뉴 데이터 삭제도 가능함
--	=> M_NO가 정확히 1, 2, 3, 4, ...가 아님 !ㄴ
--	그럼 어떤 방법이 있을까...?    
------------------------------------------------------------------------------------------------------------
-- ROWNUM (가상필드) ************
-- 		SELECT할 때마다 자동으로 부여됨
--		* 랑은 같이 사용할 수 없음
--		ORDER BY보다 먼저 부여 !
--		무조건 1번부터 조회해야 함 !
    
-- 메뉴 이름을 가나다 순으로 정렬해서 메뉴의 전체 정보 조회
SELECT ROWNUM, M_NO, M_NAME, M_PRICE, M_F_NO FROM MENU ORDER BY M_NAME;

-- 메뉴 이름을 가나다 순으로 정렬해서 MENU 테이블 ROWNUM 1 ~ 3 까지 전체 정보를 조회
SELECT ROWNUM, M_NO, M_NAME, M_PRICE, M_F_NO 
    FROM MENU 
    WHERE ROWNUM BETWEEN 1 AND 3	-- ORDER BY 전에 ROWNUM이 생성되어서
    								-- SEQUENCE를 먹인 M_NO와 같게 나와버림
    								-- 우리가 의도한 바는 이름순으로 정렬을 하고
    								-- 그 다음 번호값(ROWNUM)을 주기 원했음 !
    ORDER BY M_NAME;
    
SELECT ROWNUM, M_NO, M_NAME, M_PRICE, M_F_NO
	FROM MENU
	ORDER BY M_NAME
	WHERE ROWNUM BETWEEN 1 AND 3;	-- 코드상 결과값이 나오게 하려면 이렇게 하고 싶은데
									-- 문법 오류 !
								
SELECT ROWNUM, M_NO, M_NAME, M_PRICE	-- 2. 그 다음에 ROWNUM 부여
	FROM (
		SELECT M_NO, M_NAME, M_PRICE 	-- 1. 이 부분을 테이블처럼 사용함
										-- (데이터 정렬 해놓고)
										-- INLINE VIEW라고 함 (인라인 뷰)
		FROM MENU 
		ORDER BY M_NAME
	)
	WHERE ROWNUM >= 1 AND ROWNUM <= 3;
--	WHERE ROWNUM >= 2 AND ROWNUM <= 3;	-- 1번부터 조회야해하기 때문에 !!

-- 메뉴 이름을 가나다 순으로 정렬해서 MENU 테이블 ROWNUM 2 ~ 4 까지 전체 정보를 조회
-- SELECT을 겉에 한번 더 씌워주면 ... ROWNUM(RN)이 숫자만 부여해놓고 효력을 읽어버림
SELECT ROWNUM, RN, M_NO, M_NAME, M_PRICE -- ROWNUM과 RN 은 다른거임 !!
	FROM (
		SELECT ROWNUM RN, M_NO, M_NAME, M_PRICE 
		FROM (
            SELECT M_NO, M_NAME, M_PRICE
            FROM MENU
            ORDER BY M_NAME
        )
    -- WHERE RN >= 2 AND RN <= 3 -- 여기에 조건을 넣으면 에러가 발생함 !
	)
    WHERE RN >= 2 AND RN <= 4;
 
-- ~길동 이름을 가진 사장님네
--		메뉴명, 가격, 식당명, 지점명, 사장님 이름
--		가격 내림차순 -> 메뉴명 가나다순 정렬 후
--		3 ~ 8 번째 조회
SELECT RN, M_NAME, M_PRICE, F_NAME, F_LOCATION, C_NAME		-- RN, M_NAME, M_PRICE, F_NAME, F_LOCATION, C_NAME 대신
															-- * 도 가능 !!
    FROM(
        SELECT ROWNUM RN, M_NAME, M_PRICE, F_NAME, F_LOCATION, C_NAME
        FROM (
            SELECT M_NAME, M_PRICE, F_NAME, F_LOCATION, C_NAME
            FROM MENU, FRANCHISE, CEO
            WHERE M_F_NO = F_NO AND F_CEO = C_NO AND C_NAME LIKE '%길동'
            ORDER BY M_PRICE DESC, M_NAME
        )
    )
    WHERE RN BETWEEN 3 AND 8;
    
-- 김씨 성을 가진 사장님네 메뉴명, 가격, 사장님 이름, 사장님 성별
--	가격 오름차순 정렬 -> 2 ~ 3번만 !    
SELECT *
    FROM (
        SELECT ROWNUM RN, M_NAME, M_PRICE, C_NAME, C_GENDER
        FROM (
            SELECT M_NAME, M_PRICE, C_NAME, C_GENDER
            FROM MENU, FRANCHISE, CEO
            WHERE M_F_NO = F_NO AND F_CEO = C_NO AND C_NAME LIKE '김%'
            ORDER BY M_PRICE 
        )
    )
    WHERE RN BETWEEN 2 AND 3;
------------------------------------------------------------------------------------------------------------