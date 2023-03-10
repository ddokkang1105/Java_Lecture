-- SQL Developer Download
-- google - sql developer 21.2.1 - Oracle SQL Developer Downloads 21.2.1 - Windows 64-bit with JDK 8 included
-- �ƴϿ� - �� - ���� �ʷϻ� (+ ��ư) ID / PW ���� �� �׽�Ʈ -> ���� ���� �� ���� !!
-- ���� - ȯ�漳�� - �ڵ� ������ - �۲� - ���� ũ��
-- ���� - ȯ�漳�� - �ڵ� ������ - �࿩�� - �� ��ȣ ǥ��
-- ���� - ȯ�漳�� - �����ͺ��̽� - NLS - ��¥���� - 'YYYY-MM-DD HH24:MI:SS' �� �ٲٱ�
-- ���� - ȯ�漳�� - �����ͺ��̽� - ��� - �ڵ� Ŀ�� 
-- ���� - ȯ�漳�� - �ڵ� ������ - PL/SQL ���� ���� - PL/SQL �ּ� ���� ����

-- ���� ���� : CTRL + SHIFT + D
-- ���� ���� : ALT + SHIFT + D
-- ���� : Ŀ�� �������� CTRL + ENTER
-- �� ��ũ��Ʈ ���� : ALT + F10

-- ���� �� �� : sql���� ���������� ;�� ��°� ����

-------------------------------------------------------------------------------------------------------------
-- ��û�� ���������� �޾ -> DB�� ��ġ
-- CMD��� sqlplus�� �ٷﺸ�鼭 DBA���� �ϴ� ������ ��¦ ������ ! (��������, ���Ѻο�, tablespace)
-- ���̺� / �� / �� / ��Ű�� / �ν��Ͻ� / ������
-- SQL�� ��ɹ� �� ���Ǿ�(DDL)�� ���鼭 ���̺��� �����ð�
-- ���̺� ������ �ʿ��� �ڷ���(�ַ����� ����ϴ� �͸�)
--	������ : VARCHAR2 / ������ : NUMBER / ��¥ : DATE
--		������ VARCHAR2�� �뷮 �Է��� ���� CHAR�� �־ ���� ������ ���� �� �ְ� ���� !
--		������ NUMBER�� �뷮 �Է��� ���� ���е� / ���� �� �����ؼ� ������ !
--		��¥ DATE...�� ������ �� �� !!
-- ����� ������� �������� ! / NOT NULL, PRIMARY KEY / FOREIGN KEY
-- ���̺��� ������ �����ϰų�, �����غ��鼭 DDL �Ϸ� !

-- ���� ���̺��� ����ǵ�
-- ���� �̸� / ȸ�� / ���� ������ �ְ� �ʹ�
-- ���̺� �ϳ��� PK �ϳ� �־�����... ! => ��� PK�� ������ �����غ��鼭 ! 
CREATE TABLE SNACK (
    S_NAME VARCHAR2(10 CHAR) NOT NULL,
    S_COMPANY VARCHAR2(10 CHAR) PRIMARY KEY,
    S_PRICE NUMBER(5) NOT NULL
);

INSERT INTO SNACK VALUES('CHOCO PI', 'ORION', '8000');

SELECT * FROM SNACK;

TRUNCATE TABLE SNACK;

DROP TABLE SNACK CASCADE CONSTRAINT PURGE;

-- ȸ�翡�� �Ѱ��� ������ ���ڸ� ����� ���� �ƴϹǷ� PK X
-- ��ȣ���� ���� ���⿡ PK�� �ִ� �͵� �� ��� !
CREATE TABLE SNACK (
	S_NO NUMBER(4) PRIMARY KEY,
    S_NAME VARCHAR2(10 CHAR) NOT NULL,
    S_COMPANY VARCHAR2(10 CHAR) NOT NULL,
    S_PRICE NUMBER(5) NOT NULL
);
-------------------------------------------------------------------------------------------------------------
-- �׷��� ������ DML�� �ٷﺼ �� !
-- DML�� ������ ���۾�(Data Manipulation Language)��� �ϰ�,
-- ���̺� �����͸� �˻�, ����, ����, ���� �ϴµ� ����ϴ� ����
-- SELECT, INSERT, UPDATE, DELETE ���� �ְ�,
-- CRUD (CREATE, READ, UPDATE, DELETE) ��� ��
-------------------------------------------------------------------------------------------------------------
-- ���⼭ C�� (create table - X (DBA�� �۾�))
-- �����͸� ����ٴ� �ǹ��� C (insert - O)
-- ���´�
INSERT INTO ���̺��(�÷���, �÷���, ...) VALUES(��, ��, ��, ...);

INSERT INTO SNACK(S_NO, S_NAME, S_COMPANY, S_PRICE) VALUES(1, '��������', '������', 5000);

-- �÷� ���� �ٲٱ� - ?! �� !!
INSERT INTO SNACK(S_PRICE, S_NO, S_NAME, S_COMPANY) VALUES(5000, 2, '��������', '������');

-- �÷��� �� �ȳֱ� - ?! ���� !! NOT NULL !!
-- NOT NULL�� �����ٸ�, ���� ���������� ���� ���̰�, ���������� ���� �÷��� ���ؼ��� NULL �� !!
-- �׷��� �������̸� ������ �� ���־����� ������ ... !
INSERT INTO SNACK(S_NO, S_NAME, S_COMPANY) VALUES(3, '��������', '������');

-- (�÷���, �÷���, ...) �����ϰ� �÷� ������� �ִ� ����� !
INSERT INTO SNACK VALUES(4, '��������', '������', 5000);
-------------------------------------------------------------------------------------------------------------
-- ���̺� �����
-- �ٽ� ���̺� �����ؼ� �� 5�������� �־�� !
INSERT INTO SNACK VALUES(1, '�����', '���', 3000);
INSERT INTO SNACK VALUES(2, '��������', '������', 6000);
INSERT INTO SNACK VALUES(3, 'Ȩ����', '����', 3000);
INSERT INTO SNACK VALUES(4, '��īĨ', '������', 3000);
INSERT INTO SNACK VALUES(5, '��������', '�Ե�', 6000);

SELECT * FROM SNACK;

-- �׷���... �����̾� 5�� �־ ���� ���ڵ� ��ȣ���� �ָ� �ƴµ�
-- ������ ������ ��û ���� �ִ� ...
-- ���� �����͸� ��� �ִٰ� ���߿� ���� ��ȣ�� �ؾ������..?
-- �����͸� ���鶧���� ������ ��ȣ�� �ڵ����� ����� �Ǿ����� ���ڴ� ! \��0��/ !

-- FACTORY PATTERN !! ����ȭ �ý��� !
-- MYSQL : Autoincrement �ɼ�
-- ���� �츮�� ����ϰ� �ִ� OracleDB : Sequence��� ���� ����
--	��ȣ�� ������ �°� �ڵ����� �������ִ°ǵ�
--	���̺���� �����ϰ�, �������δ� INSERT�� �����ص� sequence ���� ������ �ö�
--	�׸���, ������ ���� �ٽ� ���� ���� ����.

-- sequence ����
CREATE SEQUENCE ��������;		-- ������ ������

-- ���̺�� �ڿ� _SEQ�� �ٿ��ִ� ��ȭ�� ����
CREATE SEQUENCE SNACK_SEQ;

-- ��ü���� ������
CREATE SEQUENCE ��������
	INCREMENT BY 1			-- ������ (1�� ����)
	START WITH 1			-- ���۰�
	MINVALUE 1				-- �ּҰ�
	MAXVALUE 999			-- �ִ밪
	NOCYCLE / CYCLE			-- �ִ밪�� �����ϸ� ���۰����� �ٽ� �ݺ����� ����
	NOCASHE / CASH			-- �������� �̸� �������� �޸𸮿��� ������ ���� ����
	NOORDER / ORDER;		-- ��û������� ���� ������ �� ���� 

-- sequence ����
DROP SEQUENCE ��������;

-- sequence ��� : ��������.NEXTVAL
-- ������ �ִ� ���̺� ���� �� �ٽ� ���� ���� �־�ô� !
INSERT INTO SNACK VALUES(SNACK_SEQ.nextval, '�����', '���', 3000);
INSERT INTO SNACK VALUES(SNACK_SEQ.nextval, '��������', '������', 6000);
INSERT INTO SNACK VALUES(SNACK_SEQ.nextval, 'Ȩ����', '����', 3000);
INSERT INTO SNACK VALUES(SNACK_SEQ.nextval, '��īĨ', '������', 3000);
INSERT INTO SNACK VALUES(SNACK_SEQ.nextval, '��������', '�Ե�', 6000);

-- ���� �ٽ� ���̺��̶� ������ �����ְ�, ���̺� �ٽ� ���� �� �Ӽ� �߰� ! (������� Date)
CREATE TABLE SNACK (
	S_NO NUMBER(4) PRIMARY KEY,
    S_NAME VARCHAR2(10 CHAR) NOT NULL,
    S_COMPANY VARCHAR2(10 CHAR) NOT NULL,
    S_PRICE NUMBER(5) NOT NULL,
    S_TIME DATE NOT NULL
);

CREATE SEQUENCE SNACK_SEQ;

-- dual ���̺� : ������ ! �������̺�
SELECT SYSDATE FROM DUAL;

INSERT INTO SNACK VALUES(SNACK_SEQ.nextval, '���޴���', 'ũ���', 500, SYSDATE);

-- Ư���ð� / ��¥
--		�����Լ� - TO_DATE('��', '����')
--		����(�빮��!!!) - YYYY.MM.DD, AM/PM, HH(12�ð�), HH24(��õ), MI(��), SS(��)
INSERT INTO SNACK VALUES(SNACK_SEQ.nextval, '������', '�Ե�', 500, TO_DATE('2023-03-14 14', 'YYYY-MM-DD HH24'));

-- 15 ~ 20��
INSERT INTO SNACK VALUES(SNACK_SEQ.nextval, '������', '�Ե�', 500, TO_DATE('2023-03-14 14', 'YYYY-MM-DD HH24'));
INSERT INTO SNACK VALUES(SNACK_SEQ.nextval, '�����', '���', 3200, TO_DATE('2023-04-17 16', 'YYYY-MM-DD HH24'));
INSERT INTO SNACK VALUES(SNACK_SEQ.nextval, '��������', '������', 6100, TO_DATE('2023-11-10 04', 'YYYY-MM-DD HH24'));
INSERT INTO SNACK VALUES(SNACK_SEQ.nextval, 'Ȩ����', '����', 3800, TO_DATE('2023-08-16 08', 'YYYY-MM-DD HH24'));
INSERT INTO SNACK VALUES(SNACK_SEQ.nextval, '��īĨ', '������', 3500, TO_DATE('2023-10-12 11', 'YYYY-MM-DD HH24'));
INSERT INTO SNACK VALUES(SNACK_SEQ.nextval, '��������', '�Ե�', 5700, TO_DATE('2023-12-15 12', 'YYYY-MM-DD HH24'));
INSERT INTO SNACK VALUES(SNACK_SEQ.nextval, '�����۽� ', '�̷α�', 4500, TO_DATE('2024-01-10 16', 'YYYY-MM-DD HH24'));
INSERT INTO SNACK VALUES(SNACK_SEQ.nextval, '������', '����', 2300, TO_DATE('2023-05-11 14', 'YYYY-MM-DD HH24'));
INSERT INTO SNACK VALUES(SNACK_SEQ.nextval, '��¡���', '������', 1500, TO_DATE('2023-04-16 11', 'YYYY-MM-DD HH24'));
INSERT INTO SNACK VALUES(SNACK_SEQ.nextval, '���̽�', '����',1800, TO_DATE('2023-08-12 17', 'YYYY-MM-DD HH24'));
INSERT INTO SNACK VALUES(SNACK_SEQ.nextval, '����Ĩ', '������', 2500, TO_DATE('2023-09-13 15', 'YYYY-MM-DD HH24'));
INSERT INTO SNACK VALUES(SNACK_SEQ.nextval, '������', '����', 5500, TO_DATE('2023-10-19 13', 'YYYY-MM-DD HH24'));
INSERT INTO SNACK VALUES(SNACK_SEQ.nextval, '����', '�Ե�', 4900, TO_DATE('2023-11-14 17', 'YYYY-MM-DD HH24'));
INSERT INTO SNACK VALUES(SNACK_SEQ.nextval, 'ī��Ÿ��', '�Ե�', 4700, TO_DATE('2023-11-16 18', 'YYYY-MM-DD HH24'));
INSERT INTO SNACK VALUES(SNACK_SEQ.nextval, '��Ϲ���Ĩ', '����', 2400, TO_DATE('2023-06-13 15', 'YYYY-MM-DD HH24'));
INSERT INTO SNACK VALUES(SNACK_SEQ.nextval, '��Ĩ', '������', 2800, TO_DATE('2023-06-14 19', 'YYYY-MM-DD HH24'));
INSERT INTO SNACK VALUES(SNACK_SEQ.nextval, '������', '�Ե�', 1300, TO_DATE('2023-07-15 17', 'YYYY-MM-DD HH24'));
INSERT INTO SNACK VALUES(SNACK_SEQ.nextval, '��Ĩ', 'ũ���', 3100, TO_DATE('2023-08-19 16', 'YYYY-MM-DD HH24'));
INSERT INTO SNACK VALUES(SNACK_SEQ.nextval, '������Ʈ', '�Ե�', 5200, TO_DATE('2023-12-19 05', 'YYYY-MM-DD HH24'));
-------------------------------------------------------------------------------------------------------------
-- R(Read) ****
SELECT [DISTINCT] [�÷���], [�÷��� AS ��Ī || �÷��� ��Ī], [������ ���], [����Լ�], ...
	FROM [���̺��]
	WHERE [���ǽ�]
	GROUP BY [�׷���]
	HAVING [�Լ� ���� ����]
	ORDER BY [���Ĵ�� ASC/DESC (�������� / ��������)] -- �⺻���� �������� !
-- �� ���� !

-- �������̺� ��ü ��ȸ
-- '*' : ���̺� ���� ��� �÷��� �����´�.
SELECT * FROM SNACK;

-- DISTINCT : �ߺ�����
SELECT S_COMPANY FROM SNACK;			-- ���ں��� ȸ�簡 ����
SELECT DISTINCT S_COMPANY FROM SNACK;	-- �ߺ� ���ŵǰ� �ѹ����� ����

-- �÷����� �״�� �÷����� ���� �ǰ�
-- ��Ī ���� ��쿡��.. SELECT�� �ȿ����� ���� ����� �����ѵ�(+, -, *, /)
SELECT S_PRICE / 100 FROM SNACK;
-- �÷��� ��ü�� S_PRICE / 100 ���� ��µ� !
-- ���� ���α׷��� ���� �����ϴٺ��� �÷����� �̿��ؼ� ���� �ҷ����� ��찡 �ִµ�,
-- ��Ī�̶�� ���� �Ἥ �򰥸��� �����ϴ� �뵵�� ���

-- AS�� �Ἥ �ϴ� ��
SELECT S_PRICE / 100 AS S_PRICE FROM SNACK;
-- AS�Ⱦ��� ��Ī���� �� ( V )
SELECT S_PRICE / 100 S_PRICE FROM SNACK;

-- ������ ! (���������)
-- Dual ���̺�
-- 1. ����Ŭ ��ü���� �������ִ� �������̺�
-- 2. �����ϰ� �Լ��� �̿��ؼ� ��� ������� Ȯ���� �� ����ϴ� ���̺�

-- � ���� ���ñ� ?! 
SELECT 1 + '3' FROM DUAL;
-- 4�� ���� !
-- ��κ� �ٸ� ���� ���� ��쿡�� '���� �켱' => 13�̶�� ����� �����µ�
-- ����Ŭ������ �ݴ�� '���� �켱'
-- ����Ŭ �������� �����ڰ� ���ڸ� ���� ����

SELECT 1 + 'a' FROM DUAL;	-- ���� ! (���ڷ� �ٲܼ� ���ٴ� ���� 'invalid number')

-- ���ڸ� �����ֱ� ���� �����ڰ� ���� �ִµ�
-- �ٷ� ' || '
SELECT 1 || 'a' FROM DUAL;




































