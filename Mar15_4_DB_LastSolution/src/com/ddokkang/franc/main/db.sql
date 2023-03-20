-- 어떤 특정한 식당에 대한 테이블
-- 식당 지점(체인점 지역), 식당 주인, 좌석 수
-- 각각 데이터 2 ~ 3개씩 넣기

create table mar16_restaurant(
    r_location varchar2(10 char) primary key,
    r_owner varchar2(10 char) not null,
    r_seat number(3) not null
);

insert into mar16_restaurant values('강남', '홍길동', 100);
insert into mar16_restaurant values('강서', '김길동', 80);

-- 예약 테이블 
-- 예약자 이름, 예약 시간, 예약자 전화번호, 예약 지점
-- 각각 데이터 2 ~ 3개씩 넣기

create table mar16_reservation(
    r_no number(3) primary key,
    r_name varchar2(10 char) not null,
    r_time date not null,
    r_phonenum varchar2(20 char) not null,
    r_location varchar2(10 char) not null
);

create sequence mar16_reservation_seq;

insert into mar16_reservation values(mar16_reservation_seq.nextval, '최길동',
	to_date('2023-03-17 18:00', 'YYYY-MM-DD HH24:MI'), '010-1111-2222', '강남');
insert into mar16_reservation values(mar16_reservation_seq.nextval, '이길동',
	to_date('2023-03-17 14:00', 'YYYY-MM-DD HH24:MI'), '010-2222-3333', '강남');
insert into mar16_reservation values(mar16_reservation_seq.nextval, '이길동',
	to_date('2023-03-19 17:00', 'YYYY-MM-DD HH24:MI'), '010-3333-4444', '강서');







