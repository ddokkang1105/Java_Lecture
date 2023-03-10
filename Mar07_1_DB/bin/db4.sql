-- 1. 노트북에 대한 테이블을 생성...
-- 노트북의 이름 / 가격 / CPU / RAM / HDD / 보증기간을 속성으로 갖게 하고 싶음
-- 조건에 부합하는 테이블을 생성하는 문장
-- [하나의 기본키(PK)를 가져야하고, 모든 값은 채워넣어야 함]

-- 2. 노트북의 사양이 좋아져서 128GB 짜리 RAM을 사용하게 되었음
-- 이 때 RAM 컬럼의 용량을 변경하는 문장

-- 3. 노트북의 크기에 대한 컬럼을 추가하는 문장 작성
-- [단위 cm, 소수점 두번째 짜리까지 나타낼 것]
-- [이 컬럼은 빈 값으로 넣을 수 없음]

-- 4. 노트북에는 앞으로 HDD대신에 SSD가 장착됨
-- HDD 컬럼의 이름을 SSD 컬럼명으로 변경하는 문장 작성

-- 5. 보증기간 컬럼을 삭제하는 문장 작성

-- 6. 노트북의 가격이 [800000 ~ 2300000] 사이의 값만 들어갈 수 있게끔
-- 해당 컬럼을 변경하는 문장 작성

-- 7. 만든 테이블을 완전히 삭제하는 문장 작성
-------------------------------------------------------------------------------------------------------------
create table laptop(
	l_name varchar2(20 char) primary key,
	l_price number(7) not null,
	l_cpu varchar2(12 char) not null,
	l_ram varchar2(4 char) default '8GB',
	l_hdd varchar2(5 char) default '100GB',
	l_repair varchar2(2 char) default '1년'
);

select * from laptop;

-- 2. 노트북의 사양이 좋아져서 128GB 짜리 RAM을 사용하게 되었음
-- 이 때 RAM 컬럼의 용량을 변경하는 문장
alter table laptop modify l_ram varchar2(5 char) default '8GB';

-- 3. 노트북의 크기에 대한 컬럼을 추가하는 문장 작성
-- [단위 cm, 소수점 두번째 짜리까지 나타낼 것]
-- [이 컬럼은 빈 값으로 넣을 수 없음]
alter table laptop add l_size number(5, 2) not null;
select * from laptop;

-- 4. 노트북에는 앞으로 HDD대신에 SSD가 장착됨
-- HDD 컬럼의 이름을 SSD 컬럼명으로 변경하는 문장 작성
alter table laptop rename column l_hdd to l_ssd;
alter table laptop modify l_ssd varchar2(4 char) default '1TB';
select * from laptop;

-- 5. 보증기간 컬럼을 삭제하는 문장 작성
alter table laptop drop column l_repair;
select * from laptop;

-- 6. 노트북의 가격이 [800000 ~ 2300000] 사이의 값만 들어갈 수 있게끔
-- 해당 컬럼을 변경하는 문장 작성
-- alter table laptop modify l_price number(7) (l_price between 800000 and 2300000);
alter table laptop modify l_price number(7) check (l_price between 800000 and 2300000);
alter table laptop modify l_price number(7) constraint l_price2 check (l_price between 800000 and 2300000);
-- 제약 조건 삭제
alter table laptop DROP CONSTRAINT l_price2 CASCADE;
-- 
select * from laptop;

-- 데이터 입력
insert into laptop values('Test Laptop', 2199999, 'RYZEN-5600X', '128GB', default, 200.11);
truncate table laptop;
select * from laptop;

-- 7. 만든 테이블을 완전히 삭제하는 문장 작성
drop table laptop cascade constraint purge;
-------------------------------------------------------------------------------------------------------------
-- 풀이 --
-- 1. 노트북에 대한 테이블을 생성...
-- 노트북의 이름 / 가격 / CPU / RAM / HDD / 보증기간을 속성으로 갖게 하고 싶음
-- 조건에 부합하는 테이블을 생성하는 문장
-- [하나의 기본키(PK)를 가져야하고, 모든 값은 채워넣어야 함]
CREATE TABLE NOTEBOOK(
    N_NAME VARCHAR2(20 CHAR) PRIMARY KEY,
    N_PRICE NUMBER(7) NOT NULL,
    N_CPU VARCHAR2(10 CHAR) NOT NULL,
    N_RAM NUMBER(2) NOT NULL,
    N_HDD NUMBER(4) NOT NULL,
    N_WARRANTY DATE NOT NULL
);

-- 2. 노트북의 사양이 좋아져서 128GB 짜리 RAM을 사용하게 되었음
-- 이 때 RAM 컬럼의 용량을 변경하는 문장
ALTER TABLE NOTEBOOK MODIFY N_RAM NUMBER(3);

-- 3. 노트북의 크기에 대한 컬럼을 추가하는 문장 작성
-- [단위 cm, 소수점 두번째 짜리까지 나타낼 것]
-- [이 컬럼은 빈 값으로 넣을 수 없음]
ALTER TABLE NOTEBOOK ADD N_INCH NUMBER(4, 2) NOT NULL;

-- 4. 노트북에는 앞으로 HDD대신에 SSD가 장착됨
-- HDD 컬럼의 이름을 SSD 컬럼명으로 변경하는 문장 작성
ALTER TABLE NOTEBOOK RENAME COLUMN N_HDD TO N_SDD;

-- 5. 보증기간 컬럼을 삭제하는 문장 작성
ALTER TABLE NOTEBOOK DROP COLUMN N_WARRANTY;

-- 6. 노트북의 가격이 [800000 ~ 2300000] 사이의 값만 들어갈 수 있게끔
-- 해당 컬럼을 변경하는 문장 작성
ALTER TABLE NOTEBOOK MODIFY N_PRICE NUMBER(7)
    CONSTRAINT N_CHECK CHECK(N_PRICE BETWEEN 800000 AND 2300000);

-- 7. 만든 테이블을 완전히 삭제하는 문장 작성
DROP TABLE NOTEBOOK CASCADE CONSTRAINT PURGE;







