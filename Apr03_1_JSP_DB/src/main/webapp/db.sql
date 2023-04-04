-- 사과 테이블
-- 지역(PK) / 색 / 맛 / 가격 / 소개 에 대한 정보가 담기게 테이블 만들기 !
-- 데이터도 2개 정도 넣기 ~

CREATE TABLE apple (
    a_loc VARCHAR2(10 CHAR) PRIMARY KEY,
    a_color VARCHAR2(10 CHAR) NOT NULL,
    a_taste VARCHAR2(10 CHAR) NOT NULL,
    a_price NUMBER(5) DEFAULT 500,
    a_intro VARCHAR2(100 CHAR) NOT NULL
);

INSERT INTO APPLE VALUES('충주', '빨강', '단맛', 4000, '충주는 사과가 맛있어~');
INSERT INTO APPLE VALUES('보령', '빨강', '단맛', 3800, '보령은 사과가 특산품~');
SELECT * FROM APPLE;

INSERT INTO APPLE VALUES('NEWYORK', 'RED', 'SWEET', 4000, 'NewYork Apple ~ ');
INSERT INTO APPLE VALUES('MIAMI', 'RED', 'SWEET', 3800, 'Miami Apple ~ ');
INSERT INTO APPLE VALUES('CALIFORNIA', 'BLACK', 'SOUR', 4500, 'Califonia Apple ~ ');
INSERT INTO APPLE VALUES('GEORGIA', 'YELLOW', 'SALTY', 2700, 'Georgia Apple ~ ');
INSERT INTO APPLE VALUES('HAWAII', 'WHITE', 'SAVORY', 2500, 'Hawaii Apple ~ ');
INSERT INTO APPLE VALUES('FLORIDA', 'GREEN', 'NO', 3400, 'Florida Apple ~ ');
INSERT INTO APPLE VALUES('KENTUCKY', 'RED', 'SWEET', 3100, 'Kentucky Apple ~ ');
INSERT INTO APPLE VALUES('OHIO', 'YELLOW', 'SWEET', 4400, 'Ohio Apple ~ ');
INSERT INTO APPLE VALUES('TEXAS', 'GREEN', 'SOUR', 3600, 'Texas Apple ~ ');
INSERT INTO APPLE VALUES('ARIZONA', 'WHITE', 'SALTY', 2900, 'Arizona Apple ~ ');

-- 버튼 눌렀을 때 파라미터 값을 받아서 그 파라미터 값 별로 데이터를 나누어서 그에 상응하는 데이터 출력
-- 초기화면은 파라미터의 초기값












