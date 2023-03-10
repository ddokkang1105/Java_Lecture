-- [옵션]
-- 제약조건(Constraint) 이라고 부름
-- 데이터 무결성을 보장하기 위한 용도로 사용하는데
-- 데이터 무결성 : 데이터베이스에 저장된 데이터의 일관성과 정확성을 지키는 것

-- 1. 도메인 무결성 제약조건
--		도메인 제약(Domain Constraint)이라고도 하며,
--		테이블 내의 튜플들이 각 속성의 도메인에 지정된 값만 가져야 한다는 조건
--		데이터 타입(type), 널(null / not null), 기본값(default), 체크(check) 등을 활용해서 지정

-- 2. 개체 무결성 제약조건
--		기본키 제약(Primary key Constraint)이라고도 하며,
--		개체 (Entity) : 사람, 장소, 사물, 사건 등과 같이 독립적으로 존재하면서,
--						고유하게 식별이 가능한 단위
--		아무리 많은 개체가 있어도, 내가 원하는 '*유일한*' 개체를 발견할 수 있어야 한다 !
--		테이블은 기본키를 지정하고, Null값을 가져서는 안되며, 
--			테이블 내에 오직 하나의 값만 존재해야한다는 조건

-- 3. 참조 무결성 제약조건
--		외래키 제약(Foreign key Constraint)이라고도 하며,
--		테이블 간의 참조 관계를 선언하는 제약조건
--		참조를 받는 테이블의 외래키는 참조하는 테이블의 기본키와 동일해야 하며,
--		참조를 받는 테이블의 값이 변경될 때, 참조하는 테이블의 제약을 받는 것
-------------------------------------------------------------------------------------------------------------
-- 1. Not Null : NULL은 값이 비어있다는 뜻 !
--					=> 0이나 띄어쓰기도 아닌 정말로 값을 넣지 않은 상태
--				NULL을 허용하지 않는다.
--					=> 필수적으로 입력해야 할 컬럼에 설정한다.
--					=> 가장 많이 사용되는 제약 조건 !
--				: 테이블을 만들 때 가급적이면 값이 들어가게 해줬으면 좋겠음 ! ***

-- 제약조건명을 따로 부여하지 않은 경우 (Oracle이 자동으로 부여)
create table example1(
	col1 varchar2(10 char),
	col2 varchar2(10 char) not null
);
-- Constraint 키워드를 이용해서 제약조건명을 따로 부여하는 경우 (col2_notnull)
create table example2(
	col1 varchar2(10 char),
	col2 varchar2(10 char) constraint col2_notnull not null
);

-- 2. Unique : 단어 뜻 그대로 해당 컬럼에 들어가는 값이 전체 테이블에서 유일해야 한다는 조건
--		NOT NULL과 함께 사용이 가능, BUT ! UNIQUE는 많이 사용되지는 않는다.
create table example3(
	col1 varchar2(10 char) unique,
	col2 varchar2(10 char) unique not null,
	col3 varchar2(10 char),
	constraint col3_unique unique(col3)
);

-- 3. Primary Key (기본 키) : NULL을 허용하지 않고 + 중복된 데이터를 허용하지 않음
--		(NOT NULL + UNIQUE => Primary Key)
--		데이터의 특정 조건을 검색하거나 수정 등의 작업을 할 때 기본키로 구분한다.
--		ID, 주민등록번호, 회원 번호, 글 번호 등이 기본키에 해당한다.
--		일반적으로 테이블에는 1개의 기본키를 무조건 가졌으면 좋겠음 ! ***
create table example4(
	col1 varchar2(10 char) primary key,
	col2 varchar2(10 char) not null,
	col3 varchar2(10 char) not null
);

-- 여러 컬럼을 묶을 때 constraint 키워드를 사용 + 하지만 PK는 가급적 하나였으면 ... !
create table example5(
	col1 varchar2(10 char),
	col2 varchar2(10 char),
	col3 varchar2(10 char),
	constraint PK_example5 primary key(col1, col2)	
);

-- *** 진짜 어려움 !!
-- 4. Foreign Key (외래 키) : 다른 테이블의 특정 컬럼을 조회해서
--							  동일한 데이터가 있는 경우에만 입력이 허용된다 !
--		참조하는 테이블은 PK나 Unique로 지정된 컬럼만을 FK로 지정할 수 있다.
--		외래키 설정을 위해서는 참조받는 컬럼이 먼저 생성되어야 하고,
--		외래키를 심을 테이블이 그 이후에 생성이 되어야 함

-- 외래키를 심을 테이블의 형식
create table 테이블명(
	컬럼명 자료형,
	constraint FK명 foreign key(컬럼명)
		references 대상테이블명(대상테이블의 기본키(OR 고유키) 컬럼명)
		on delete set null || on delete cascade
		-- 참조받는 테이블에서 행 부분을 지웠을 때
		-- 이 테이블에 연결되어 있는 행에 대해서 NULL값을 먹일지
		-- 아니면 그 행도 같이 지울지에 대한 옵션 (둘 중 하나 선택)
);

create table example6(
	ex6_id varchar2(10 char) primary key
);

insert into example6 values('10');
insert into example6 values('20');
insert into example6 values('30');
select * from example6;

create table example7(
	ex7_id varchar2(10 char),
	constraint fk_ex7 foreign key(ex7_id)
		references example6(ex6_id)
		on delete cascade
);

insert into example7 values('10');
insert into example7 values('20');
insert into example7 values('30');
insert into example7 values('40'); -- 안들어가짐 ! (example6에 '40'이라는 값이 없어서 !)
select * from example7;

-- ex6_id가 '10'dls 컬럼을 지우면 어떻게 될까?
delete from example6 where ex6_id = '10';

-- 학과 테이블과 이것을 참조하는 학생 테이블을 만들어보자 !
-- 학과 테이블 : 학과코드(4자리 숫자), 학과 이름(10글자 이내)
create table major(
	major_code number(4) primary key,
	major_name varchar2(10 char) not null
);

-- 학생 테이블 : 학생번호(3자리 숫자), 학생 이름, 학생이 소속되어있는 학과의 코드
-- 그 학과가 없어지면 이 학생의 정보도 지워지게
create table student(
	stu_no number(3) primary key,
	stu_name varchar2(6 char) not null,
	stu_code number(4),
	constraint fk_stu foreign key(stu_code)
		references major(major_code)
		on delete cascade
);
--drop table student cascade constraint purge;
insert into major values(1105, 'Math');
insert into major values(2105, 'Korean');
select * from major;

insert into student values(100, '김길동', 1105);
insert into student values(101, '최길동', 1105);
insert into student values(102, '이길동', 1105);
insert into student values(200, '박길동', 2105);
insert into student values(201, '오길동', 2105);
insert into student values(202, '정길동', 2105);
select * from student;

delete from major where major_code = '2105';

-------------------------------------------------------------------------------------------------------------
-- 풀이 --
create table major(
	m_code number(4) primary key,
	m_name varchar2(10 char) not null
);

insert into major values(1001, '컴퓨터 공학과');
insert into major values(2001, '법학과');

select * from major;

create table student(
	s_num number(3) primary key,
	s_name varchars(17 char) not null,
	s_code number(4) not null
		constraint fk_student foreign key(s_code)
			references major(m_code)
			on delete cascade
);

insert into student values(101, 'kkk', 1001);
insert into student values(102, 'lll', 1001);
insert into student values(103, 'ooo', 2001);
insert into student values(104, 'ppp', 2001);

select * from student;

delete from major where m_code = 1001;
-- major 테이블에서 1001 코드를 지우면, student 테이블에서 1001 코드를 가지고 있던
-- 모든 학생의 정보가 지워짐 !!
-------------------------------------------------------------------------------------------------------------
-- 5. Check : 데이터의 값의 범위나 조건을 설정해서 조건에 해당하는 데이터만 허용함.
create table example8(
	col1 number(3) constraint ex8_check check (col1 between 1 and 9)
);

insert into example8 values(10);	-- 1 ~ 9 사이의 숫자가 아니라서 오류 !
drop table example8 cascade constraint purge;
-------------------------------------------------------------------------------------------------------------
-- 6. default : 아무런 데이터를 입력하지 않은 경우 지정한 데이터가 자동으로 입력된다.
create table example9(
	col1 number(4) default 999
);

insert into example9 values(default);
insert into example9 values(null);
insert into example9 values(0);
insert into example9 values(11);

select * from example9;
drop table example9 cascade constraint purge;
-------------------------------------------------------------------------------------------------------------















