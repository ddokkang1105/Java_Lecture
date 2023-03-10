-- [�ɼ�]
-- ��������(Constraint) �̶�� �θ�
-- ������ ���Ἲ�� �����ϱ� ���� �뵵�� ����ϴµ�
-- ������ ���Ἲ : �����ͺ��̽��� ����� �������� �ϰ����� ��Ȯ���� ��Ű�� ��

-- 1. ������ ���Ἲ ��������
--		������ ����(Domain Constraint)�̶�� �ϸ�,
--		���̺� ���� Ʃ�õ��� �� �Ӽ��� �����ο� ������ ���� ������ �Ѵٴ� ����
--		������ Ÿ��(type), ��(null / not null), �⺻��(default), üũ(check) ���� Ȱ���ؼ� ����

-- 2. ��ü ���Ἲ ��������
--		�⺻Ű ����(Primary key Constraint)�̶�� �ϸ�,
--		��ü (Entity) : ���, ���, �繰, ��� ��� ���� ���������� �����ϸ鼭,
--						�����ϰ� �ĺ��� ������ ����
--		�ƹ��� ���� ��ü�� �־, ���� ���ϴ� '*������*' ��ü�� �߰��� �� �־�� �Ѵ� !
--		���̺��� �⺻Ű�� �����ϰ�, Null���� �������� �ȵǸ�, 
--			���̺� ���� ���� �ϳ��� ���� �����ؾ��Ѵٴ� ����

-- 3. ���� ���Ἲ ��������
--		�ܷ�Ű ����(Foreign key Constraint)�̶�� �ϸ�,
--		���̺� ���� ���� ���踦 �����ϴ� ��������
--		������ �޴� ���̺��� �ܷ�Ű�� �����ϴ� ���̺��� �⺻Ű�� �����ؾ� �ϸ�,
--		������ �޴� ���̺��� ���� ����� ��, �����ϴ� ���̺��� ������ �޴� ��
-------------------------------------------------------------------------------------------------------------
-- 1. Not Null : NULL�� ���� ����ִٴ� �� !
--					=> 0�̳� ���⵵ �ƴ� ������ ���� ���� ���� ����
--				NULL�� ������� �ʴ´�.
--					=> �ʼ������� �Է��ؾ� �� �÷��� �����Ѵ�.
--					=> ���� ���� ���Ǵ� ���� ���� !
--				: ���̺��� ���� �� �������̸� ���� ���� �������� ������ ! ***

-- �������Ǹ��� ���� �ο����� ���� ��� (Oracle�� �ڵ����� �ο�)
create table example1(
	col1 varchar2(10 char),
	col2 varchar2(10 char) not null
);
-- Constraint Ű���带 �̿��ؼ� �������Ǹ��� ���� �ο��ϴ� ��� (col2_notnull)
create table example2(
	col1 varchar2(10 char),
	col2 varchar2(10 char) constraint col2_notnull not null
);

-- 2. Unique : �ܾ� �� �״�� �ش� �÷��� ���� ���� ��ü ���̺��� �����ؾ� �Ѵٴ� ����
--		NOT NULL�� �Բ� ����� ����, BUT ! UNIQUE�� ���� �������� �ʴ´�.
create table example3(
	col1 varchar2(10 char) unique,
	col2 varchar2(10 char) unique not null,
	col3 varchar2(10 char),
	constraint col3_unique unique(col3)
);

-- 3. Primary Key (�⺻ Ű) : NULL�� ������� �ʰ� + �ߺ��� �����͸� ������� ����
--		(NOT NULL + UNIQUE => Primary Key)
--		�������� Ư�� ������ �˻��ϰų� ���� ���� �۾��� �� �� �⺻Ű�� �����Ѵ�.
--		ID, �ֹε�Ϲ�ȣ, ȸ�� ��ȣ, �� ��ȣ ���� �⺻Ű�� �ش��Ѵ�.
--		�Ϲ������� ���̺��� 1���� �⺻Ű�� ������ �������� ������ ! ***
create table example4(
	col1 varchar2(10 char) primary key,
	col2 varchar2(10 char) not null,
	col3 varchar2(10 char) not null
);

-- ���� �÷��� ���� �� constraint Ű���带 ��� + ������ PK�� ������ �ϳ������� ... !
create table example5(
	col1 varchar2(10 char),
	col2 varchar2(10 char),
	col3 varchar2(10 char),
	constraint PK_example5 primary key(col1, col2)	
);

-- *** ��¥ ����� !!
-- 4. Foreign Key (�ܷ� Ű) : �ٸ� ���̺��� Ư�� �÷��� ��ȸ�ؼ�
--							  ������ �����Ͱ� �ִ� ��쿡�� �Է��� ���ȴ� !
--		�����ϴ� ���̺��� PK�� Unique�� ������ �÷����� FK�� ������ �� �ִ�.
--		�ܷ�Ű ������ ���ؼ��� �����޴� �÷��� ���� �����Ǿ�� �ϰ�,
--		�ܷ�Ű�� ���� ���̺��� �� ���Ŀ� ������ �Ǿ�� ��

-- �ܷ�Ű�� ���� ���̺��� ����
create table ���̺��(
	�÷��� �ڷ���,
	constraint FK�� foreign key(�÷���)
		references ������̺��(������̺��� �⺻Ű(OR ����Ű) �÷���)
		on delete set null || on delete cascade
		-- �����޴� ���̺��� �� �κ��� ������ ��
		-- �� ���̺� ����Ǿ� �ִ� �࿡ ���ؼ� NULL���� ������
		-- �ƴϸ� �� �൵ ���� �������� ���� �ɼ� (�� �� �ϳ� ����)
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
insert into example7 values('40'); -- �ȵ��� ! (example6�� '40'�̶�� ���� ��� !)
select * from example7;

-- ex6_id�� '10'dls �÷��� ����� ��� �ɱ�?
delete from example6 where ex6_id = '10';

-- �а� ���̺�� �̰��� �����ϴ� �л� ���̺��� ������ !
-- �а� ���̺� : �а��ڵ�(4�ڸ� ����), �а� �̸�(10���� �̳�)
create table major(
	major_code number(4) primary key,
	major_name varchar2(10 char) not null
);

-- �л� ���̺� : �л���ȣ(3�ڸ� ����), �л� �̸�, �л��� �ҼӵǾ��ִ� �а��� �ڵ�
-- �� �а��� �������� �� �л��� ������ ��������
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

insert into student values(100, '��浿', 1105);
insert into student values(101, '�ֱ浿', 1105);
insert into student values(102, '�̱浿', 1105);
insert into student values(200, '�ڱ浿', 2105);
insert into student values(201, '���浿', 2105);
insert into student values(202, '���浿', 2105);
select * from student;

delete from major where major_code = '2105';

-------------------------------------------------------------------------------------------------------------
-- Ǯ�� --
create table major(
	m_code number(4) primary key,
	m_name varchar2(10 char) not null
);

insert into major values(1001, '��ǻ�� ���а�');
insert into major values(2001, '���а�');

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
-- major ���̺��� 1001 �ڵ带 �����, student ���̺��� 1001 �ڵ带 ������ �ִ�
-- ��� �л��� ������ ������ !!
-------------------------------------------------------------------------------------------------------------
-- 5. Check : �������� ���� ������ ������ �����ؼ� ���ǿ� �ش��ϴ� �����͸� �����.
create table example8(
	col1 number(3) constraint ex8_check check (col1 between 1 and 9)
);

insert into example8 values(10);	-- 1 ~ 9 ������ ���ڰ� �ƴ϶� ���� !
drop table example8 cascade constraint purge;
-------------------------------------------------------------------------------------------------------------
-- 6. default : �ƹ��� �����͸� �Է����� ���� ��� ������ �����Ͱ� �ڵ����� �Էµȴ�.
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















