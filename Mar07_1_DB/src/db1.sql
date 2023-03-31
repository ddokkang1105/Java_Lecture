-- ���̺� �����̽� �Ժη� ������ ���� !

-- ����...! [���̺�]�� ������ !
-- ���̺��� �⺻���� ����
create table ���̺���(
	�÷��� �ڷ��� [�ɼ�], -- �ɼ� : �ʿ��ϸ� �ִ°� / [] �ִ°� �ƴ�
	�÷��� �ڷ���,
	...
);

-- �ڷ��� (������Ÿ��)
-- ũ�� 3������ Ÿ������ ���� �� ����

-- ������
--			char(�뷮)
--			������ �� �뷮��� ����
--			�뷮�� ����ִٸ� ����� �� �뷮�� �޲�
--			ó�� �ӵ��� ������ ! (�뷮�� �Ű澲�� �ʾƵ� �Ǽ�)
--				ex> ����, �ֹι�ȣ, �ڵ�����ȣ, ...

--			varchar2(�뷮)
--			������ �뷮��ŭ �����͸� �� �־ 
--			�� �뷮 �����ؼ� ����
--			�뷮�� �����ϴ¸�ŭ ó���ӵ��� ������ !
--				ex> �̸�, �ּ�, ... (�����Ǵ� ��, �������� ���� ����)
--			�ַ����� ��� !
-------------------------------------------------------------------------------------------------------------
-- ������ �뷮 
--		varchar2(5) : 5byte
--			����, ����, ����� 1byte
--			�ѱ� �ѱ��ڴ� 3byte
--			���ڼ� ����ϱⰡ �ָ�...

--		varchar2(5 char)
--			�ѱ�/���� 5���� -> �ִ� 15byte
--	=> ������ �ڷ����� �� ���� �뷮�� char�� �־ ���� !

create table test(
	t_name varchar2(5)
);

create table test2(
	t_name varchar2(5 char)
);

-- �������� ���� ���� ���� ��������ǥ ����ؼ� ! ***
insert into test values('������');		-- �뷮�ʰ��� ���� ���� �߻� !
insert into test2 values('������');		-- ���� !
drop table test cascade constraint purge;
drop table test2 cascade constraint purge;
-------------------------------------------------------------------------------------------------------------
-- ������
--		NUMBER(P, S) : ������ ����
--			P : ���е� (Precision) / S : ���� (Scale)
--				P�� �Ҽ��� ���� ��� ��ȿ���ڸ� �ǹ��Ѵ�.
--				���� P�� ������ �ͺ��� �� ū ���ڰ��� �Է��ϸ� ������ �߻��Ѵ�.
--				S�� ����� �Ҽ��� ����, ������ �Ҽ��� �̻�(�Ҽ��� ���� ����)
--				�� ��ȿ���� �ڸ����� ��Ÿ����.
--				S�� ������ ���� �̻��� ���ڸ� �Է��ϸ�, S�� ������ ���ڷ� �ݿø� ó���Ѵ�.
--				S�� ������ �Ҽ��� ���� ���� �ڸ�����ŭ �ݿø��Ѵ�.
--				P�� S���� ũ�� S�� �Ҽ��� ���� ��ȿ���� �ڸ����� ��Ÿ����.
--			���� 123.54�ε� 
--			number(3)			-> ����? 123?		/ 124 (S���� �������� �ʾƼ� 0�̶� ���� ����, 
--															P�� 3�̶� �Ҽ��� ù�ڸ����� �ݿø�)
--			number(3, 2)		-> ����? 123.54?	/ ���� (P�� 3�ε� ��ȿ���ڰ� 5�ڸ����� ����)
--			number(5, 2)		-> 123.54
--			number(7, 1)		-> 123.5
--			number(7, -1)		-> 123? 124?		/ 120 (S�� -1�̶� �����̹Ƿ� ù°¥������ �ݿø�)


--		FLOAT(P) : NUMBER�� ����Ÿ�� + ������ ����
create table testNum(
	t_num number(5),
	t_flo float(5)
);
insert into TESTNUM values(12345, 12345);
select * from TESTNUM; -- 12345, 12000
drop table testNum cascade constraint purge;

--	float(5) ��� �ϸ�, 5�ڸ� 10������ �ƴ϶�, 5�ڸ� 2���� (ex: 10110)�� �ǹ��Ѵ�.
--	2������ 10������ ������ �Ϸ��� �� 0.3������ ���ϸ� �Ǵµ�, 
-- 	5 * 0.3 = �� 1.5�� �ȴ�.
--	�ᱹ float(5)�� ������ float(2) (1.5�� �ݿø��ؼ� 2�� �Ǿ���)
--	12345 �� ���� ���ڸ� 12�� ����� ������, �������� 0���� ä���� ����
--			=> ��ǻ� ����Ŭ������ NUMBER���� ����ص� �Ǹ�,
--				ũ�� ������ �־ P�� S�� ������ �����ϸ� �� ! ***
-------------------------------------------------------------------------------------------------------------
-- ��¥��
--		Date : ����, ��, ��, ��, ��, �ʱ��� �Է� ����
--		Timestamp : ����, ��, ��, ��, ��, ��, �и��ʱ��� �Է� ����
--	=> �ַ��� Date !
--	java.util.Date / java.sql.Date
-------------------------------------------------------------------------------------------------------------


















