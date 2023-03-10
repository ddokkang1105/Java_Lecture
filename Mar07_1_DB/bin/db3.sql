-- Ŀ�� ���̺�
-- Ŀ�� �̸� / ���� / Į�θ� / ��������
create table coffee(
	c_name varchar2(15 char) primary key,
	c_price number(5) default 5000,
	c_kcal number(4, 1) not null,
	c_start date not null
);

insert into coffee values('�Ƹ޸�ī��', 3000, 20.1, sysdate);
select * from coffee;

-- DDL���� Create ���� �ٷ� �� �ְ� �Ǿ��� !
-- ���� ���� ���� ALTER / DROP / TRUNCATE�� ���� ~

-------------------------------------------------------------------------------------------------------------
-- ALTER --
-- ������ Ÿ�� ���� / �÷��� ũ��(�뷮) ����
alter table [���̺��] modify [�÷���] [������Ÿ��(�뷮)];

-- ���� �ִ� ���¿��� ������Ÿ���� �����ϸ� ���� !
alter table coffee modify c_name number(3);

-- ���� �ִ� ���¿��� �뷮�� ���� �����ϸ� ���� !
alter table coffee modify c_name varchar2(2 char);

-- ���� ���� : ������Ÿ���� ������ ���� �ش� �÷��� ���� ��� ������ ������ �����ϴ� !
--		�׷��� ������ ������ �߻� !
--		�÷��� �뷮�� ���� ��� �ش� �÷��� �뷮�� ��ȸ�ؼ� ������ ���̺���
--		ū ���� �ִ��� Ȯ���ϰ� => �� ���� ����

-- dec coffee;

-- �÷��� ����
alter table [���̺��] rename column [���� �÷���] to [�ٲ� �÷���];
alter table coffee rename column c_name to c_name2;

-- �÷� �߰�
alter table [���̺��] add [�÷���] [������Ÿ��] [��������(��������)];

-- ������ �����Ͱ� ����� not null ���� O
alter table coffee add c_taste varchar2(20 char) not null;

-- �÷� ����
alter table [���̺��] drop column [�÷���];
alter table coffee drop column c_taste;
-------------------------------------------------------------------------------------------------------------
-- TRUNCATE -- DROP -- ETC --
-- ���̺� ���� ������ �����
truncate table [���̺��];
truncate table coffee;
select * from coffee;
-- ���̺� �ִ� �����͸� ����������, ���̺��� ���� ��ü�� �������� ���� !

-- ���̺� ���� (�����뿡 �ֱ�)
drop table [���̺��] cascade constraint;
drop table coffee cascade constraint;
select * from coffee;

-- ���̺� ���� (�����뿡�� ����)
flashback table [���̺��] to before drop;
flashback table coffee to before drop;
select * from coffee;

-- ������ ����
purge recyclebin;

-- �����뿡 �ֱ� + ���� => ���̺� ���� ���� (SHIFT + DELETE)
drop table [���̺��] cascade constraint purge;
drop table coffee cascade constraint purge;
select * from coffee;
-------------------------------------------------------------------------------------------------------------
-- DDL : ��ǻ� �������� �ñ��� ���� !
-- ����ִ� DBA���� ���̺��� ���� CRUD������ �ϰԲ� �� �� !!


















