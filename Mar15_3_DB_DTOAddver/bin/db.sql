-- 어떤 특정한 식당에 대한 테이블
-- 식당 지점(체인점 지역), 식당 주인, 좌석 수
create table mar15_pizzarestaurant(
    p_no number(2) primary key,
    p_location varchar2(10 char) not null,
    p_owner varchar2(10 char) not null,
    p_seat number(4) not null
);

create sequence mar15_pizzarestaurant_seq;

-- 예약 테이블 
-- 예약자 이름, 예약 시간, 예약자 전화번호, 예약 지점
create table mar15_reservation(
    r_no number(2) primary key,
    r_name varchar2(10 char) not null,
    r_time date not null,
    r_phonenum varchar2(20 char) not null,
    r_location varchar2(10 char) not null
);

create sequence mar15_reservation_seq;

-- 각각 데이터 2 ~ 3개씩 넣기

insert into mar15_reservation values(mar15_reservation_seq, '이찬영', to_date('2023-03-18 16', 'YYYY-MM-DD HH24'), '010-1111-1111', '서초점');
-- 1	이찬영	2023-03-18 16:00:00	010-1111-1111	1
-- 2	김찬수	2023-03-19 15:00:00	010-1111-2222	2
-- 3	오기수	2023-03-24 12:00:00	010-1111-3333	3
-- 4	김성민	2023-03-17 16:00:00	010-1111-4444	1
-- 5	박주한	2023-03-22 15:00:00	010-1111-5555	2
-- 6	최장덕	2023-03-23 12:00:00	010-1111-6666	3

-- 1	서초점	김만평	81
-- 2	대치점	이희주	67
-- 3	논현점	최용진	117

