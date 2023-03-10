-- 커피 테이블
-- 커피 이름 / 가격 / 칼로리 / 제조일자
create table coffee(
	c_name varchar2(15 char) primary key,
	c_price number(5) default 5000,
	c_kcal number(4, 1) not null,
	c_start date not null
);

insert into coffee values('아메리카노', 3000, 20.1, sysdate);
select * from coffee;

-- DDL에서 Create 문을 다룰 수 있게 되었음 !
-- 이제 비교적 쉬운 ALTER / DROP / TRUNCATE를 보자 ~

-------------------------------------------------------------------------------------------------------------
-- ALTER --
-- 데이터 타입 변경 / 컬럼의 크기(용량) 변경
alter table [테이블명] modify [컬럼명] [데이터타입(용량)];

-- 값이 있는 상태에서 데이터타입을 변경하면 에러 !
alter table coffee modify c_name number(3);

-- 값이 있는 상태에서 용량을 적게 변경하면 에러 !
alter table coffee modify c_name varchar2(2 char);

-- 주의 사항 : 데이터타입을 변경할 때는 해당 컬럼의 값을 모두 지워야 변경이 가능하다 !
--		그렇지 않으면 오류가 발생 !
--		컬럼의 용량을 줄일 경우 해당 컬럼의 용량을 조회해서 변경할 길이보다
--		큰 값이 있는지 확인하고 => 그 값을 변경

-- dec coffee;

-- 컬럼명 변경
alter table [테이블명] rename column [기존 컬럼명] to [바꿀 컬럼명];
alter table coffee rename column c_name to c_name2;

-- 컬럼 추가
alter table [테이블명] add [컬럼명] [데이터타입] [제약조건(생략가능)];

-- 기존에 데이터가 없어야 not null 가능 O
alter table coffee add c_taste varchar2(20 char) not null;

-- 컬럼 삭제
alter table [테이블명] drop column [컬럼명];
alter table coffee drop column c_taste;
-------------------------------------------------------------------------------------------------------------
-- TRUNCATE -- DROP -- ETC --
-- 테이블 내의 내용을 지우기
truncate table [테이블명];
truncate table coffee;
select * from coffee;
-- 테이블에 있는 데이터를 삭제하지만, 테이블의 구조 자체는 삭제하지 않음 !

-- 테이블 삭제 (휴지통에 넣기)
drop table [테이블명] cascade constraint;
drop table coffee cascade constraint;
select * from coffee;

-- 테이블 복원 (휴지통에서 복원)
flashback table [테이블명] to before drop;
flashback table coffee to before drop;
select * from coffee;

-- 휴지통 비우기
purge recyclebin;

-- 휴지통에 넣기 + 비우기 => 테이블 완전 삭제 (SHIFT + DELETE)
drop table [테이블명] cascade constraint purge;
drop table coffee cascade constraint purge;
select * from coffee;
-------------------------------------------------------------------------------------------------------------
-- DDL : 사실상 신입한테 맡기지 않음 !
-- 경력있는 DBA들이 테이블을 만들어서 CRUD정도만 하게끔 할 것 !!


















