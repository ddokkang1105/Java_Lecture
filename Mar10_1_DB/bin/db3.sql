-- ��ľ� ����������

-- ȫ����� �������� ȫ�浿�� ��ϰ� 100��
-- ȫ����� �������� ��浿�� ��ϰ� 80��
-- �ѽ����� �������� ȫ�浿�� ��ϰ� 150��
-- ��õ���� ��õ���� �ֱ浿�� ��ϰ� 130��
CREATE TABLE FRANCHISE(
	F_NO NUMBER(3) PRIMARY KEY,		-- �Ĵ� ��ȣ
	F_NAME VARCHAR2(10 CHAR) NOT NULL,
	F_LOCATION VARCHAR2(10 CHAR) NOT NULL,
	F_CEO NUMBER(3) NOT NULL,		-- ����� ��ȣ
	F_SEAT NUMBER(3) NOT NULL
);

CREATE SEQUENCE FRANCHISE_SEQ;

INSERT INTO FRANCHISE VALUES(FRANCHISE.NEXTVAL, 'ȫ�����', '����', 1, 100);
INSERT INTO FRANCHISE VALUES(FRANCHISE.NEXTVAL, 'ȫ�����', '����', 2, 80);
INSERT INTO FRANCHISE VALUES(FRANCHISE.NEXTVAL, '�ѽ�����', '����', 3, 150);
INSERT INTO FRANCHISE VALUES(FRANCHISE.NEXTVAL, '��õ����', '��õ', 4, 130);
------------------------------------------------------------------------------------------------------------
-- ȫ�浿, 1990-03-01�ϻ�, ����
-- ��浿, 1992-02-01�ϻ�, ����
-- ȫ�浿, 1991-12-12�ϻ�, ����
-- �ֱ浿, 1989-09-01�ϻ�, ����
CREATE TABLE CEO(
	C_NO NUMBER(3) PRIMARY KEY,		-- ����� ��ȣ
	C_NAME VARCHAR2(10 CHAR) NOT NULL,
	C_BIRTHDAY DATE NOT NULL,
	C_GENDER CHAR(2 CHAR) NOT NULL
);

CREATE SEQUENCE CEO_SEQ;

INSERT INTO CEO VALUES(CEO_SEQ.NEXTVAL, 'ȫ�浿', TO_DATE('1990-03-01', 'YYYY-MM-DD'), '����');
INSERT INTO CEO VALUES(CEO_SEQ.NEXTVAL, '��浿', TO_DATE('1992-02-01', 'YYYY-MM-DD'), '����');
INSERT INTO CEO VALUES(CEO_SEQ.NEXTVAL, 'ȫ�浿', TO_DATE('1991-12-12', 'YYYY-MM-DD'), '����');
INSERT INTO CEO VALUES(CEO_SEQ.NEXTVAL, '�ֱ浿', TO_DATE('1989-09-01', 'YYYY-MM-DD'), '����');
------------------------------------------------------------------------------------------------------------
-- ¥���, 5000��, ȫ����� ���������� �Ĵ�
-- �Ҵ߹�, 12000��, �ѽ����� ������
--		... ����� �޴� 5������ !
CREATE TABLE MENU(
	M_NO NUMBER(2) PRIMARY KEY,		-- �޴� ��ȣ
	M_NAME VARCHAR2(10 CHAR) NOT NULL,
	M_PRICE NUMBER(5) NOT NULL,
	M_F_NO NUMBER(3) NOT NULL		-- �޴��Ĵ� �Ĵ� ��ȣ
);

CREATE SEQUENCE MENU_SEQ;

INSERT INTO MENU VALUES(MENU_SEQ.NEXTVAL, '¥���', 5000, 1);
INSERT INTO MENU VALUES(MENU_SEQ.NEXTVAL, '¥���', 5500, 1);
INSERT INTO MENU VALUES(MENU_SEQ.NEXTVAL, '������', 7000, 1);
INSERT INTO MENU VALUES(MENU_SEQ.NEXTVAL, '���꽽', 20000, 1);
INSERT INTO MENU VALUES(MENU_SEQ.NEXTVAL, '�ຸ��', 14000, 1);
INSERT INTO MENU VALUES(MENU_SEQ.NEXTVAL, '¥���', 6000, 2);
INSERT INTO MENU VALUES(MENU_SEQ.NEXTVAL, '«�͹�', 8000, 2);
INSERT INTO MENU VALUES(MENU_SEQ.NEXTVAL, '����«��', 10000, 2);
INSERT INTO MENU VALUES(MENU_SEQ.NEXTVAL, '������ä', 17000, 2);
INSERT INTO MENU VALUES(MENU_SEQ.NEXTVAL, '�Ｑ¥��', 13000, 2);
INSERT INTO MENU VALUES(MENU_SEQ.NEXTVAL, '�Ҵ߹�', 12000, 3);
INSERT INTO MENU VALUES(MENU_SEQ.NEXTVAL, '�����', 6000, 3);
INSERT INTO MENU VALUES(MENU_SEQ.NEXTVAL, '����', 10000, 3);
INSERT INTO MENU VALUES(MENU_SEQ.NEXTVAL, '�����', 4000, 3);
INSERT INTO MENU VALUES(MENU_SEQ.NEXTVAL, '�ع�������', 16000, 3);
INSERT INTO MENU VALUES(MENU_SEQ.NEXTVAL, '��������', 12000, 4);
INSERT INTO MENU VALUES(MENU_SEQ.NEXTVAL, '���', 10000, 4);
INSERT INTO MENU VALUES(MENU_SEQ.NEXTVAL, '��ġ��', 5000, 4);
INSERT INTO MENU VALUES(MENU_SEQ.NEXTVAL, '��¡���', 8000, 4);
INSERT INTO MENU VALUES(MENU_SEQ.NEXTVAL, '��ġ', 9000, 4);
------------------------------------------------------------------------------------------------------------
-- �¼� �� ���� ���� �Ĵ� ��ϴ� ����� ��ü ���� ��ȸ
SELECT
	FROM CEO
	WHERE C_NO IN (
		SELECT F_CEO
		FROM FRANCHISE
		WHERE F_SEAT IN (
			SELECT MAX(F_SEAT)
			FROM FRANCHISE
		)
	);

-- ���������� �޴� ��ü�� �̸�, ����
--		�� ���� �������� -> ������ ���ٸ� �޴����� ������ ���� ����
-- ������ �����ϰ� ���� ��... => ORDER BY �÷��� (ASC / DESC), �÷��� (ASC / DESC), ...
SELECT M_NAME, M_PRICE
	FROM MENU
	ORDER BY M_PRICE ASC, M_PRICE DESC;

-- ��ü ����Ե� �̸�, ���� ��ȸ
SELECT C_NAME, C_BIRTHDAY FROM CEO;

-- ���������� �Ĵ� �� �� ?
SELECT COUNT(*) FROM FRANCHISE;

-- ���������� �޴� ��ü�� ��հ� ?
SELECT AVG(M_PRICE) FROM MENU;

------------------------------------------------------------------------------------------------------------
-- ���� �Ѱ�
CREATE TABLE PEOPLE(
    P_NO NUMBER(2) PRIMARY KEY,
    P_NAME VARCHAR2(10 CHAR) NOT NULL,
    P_BIRTH DATE NOT NULL,
    P_GENDER VARCHAR2(2 CHAR) NOT NULL
);

CREATE SEQUENCE PEOPLE_SEQ;

CREATE TABLE RESTUARANT(
    R_NO NUMBER(2) NOT NULL,
    R_NAME VARCHAR2(10 CHAR) PRIMARY KEY,
    R_OWNER VARCHAR2(10 CHAR) NOT NULL,
    R_SEAT NUMBER(3) NOT NULL,
        CONSTRAINT FK_OWNER FOREIGN KEY(R_NO)
        REFERENCES PEOPLE(P_NO)
        ON DELETE CASCADE
);

CREATE TABLE MENU(
    M_NO NUMBER(2) PRIMARY KEY,
    M_NAME VARCHAR2(10 CHAR) NOT NULL,
    M_PRICE NUMBER(5) NOT NULL,
    M_RESTUARANT VARCHAR2(10 CHAR) NOT NULL,
        CONSTRAINT FK_NAME FOREIGN KEY(M_RESTUARANT)
        REFERENCES RESTUARANT(R_NAME)
        ON DELETE CASCADE
);

CREATE SEQUENCE MENU_SEQ;

INSERT INTO PEOPLE VALUES(PEOPLE_SEQ.NEXTVAL, 'ȫ�浿', TO_DATE('1990-03-01', 'YYYY-MM-DD'), '����');
INSERT INTO PEOPLE VALUES(PEOPLE_SEQ.NEXTVAL, '��浿', TO_DATE('1992-02-01', 'YYYY-MM-DD'), '����');
INSERT INTO PEOPLE VALUES(PEOPLE_SEQ.NEXTVAL, 'ȫ�浿', TO_DATE('1991-12-12', 'YYYY-MM-DD'), '����');
INSERT INTO PEOPLE VALUES(PEOPLE_SEQ.NEXTVAL, '�ֱ浿', TO_DATE('1989-09-01', 'YYYY-MM-DD'), '����');
SELECT * FROM PEOPLE;

INSERT INTO RESTUARANT VALUES(1, 'ȫ����� ������', 'ȫ�浿', 100);
INSERT INTO RESTUARANT VALUES(2, 'ȫ����� ������', '��浿', 80);
INSERT INTO RESTUARANT VALUES(3, '�ѽ����� ������', 'ȫ�浿', 150);
INSERT INTO RESTUARANT VALUES(4, '��õ���� ��õ��', '�ֱ浿', 130);
SELECT * FROM RESTUARANT;

INSERT INTO MENU VALUES(MENU_SEQ.NEXTVAL, '¥���', 5000, 'ȫ����� ������');
INSERT INTO MENU VALUES(MENU_SEQ.NEXTVAL, '«��', 6000, 'ȫ����� ������');
INSERT INTO MENU VALUES(MENU_SEQ.NEXTVAL, '���¥��', 10000, 'ȫ����� ������');
INSERT INTO MENU VALUES(MENU_SEQ.NEXTVAL, '������', 5000, 'ȫ����� ������');
INSERT INTO MENU VALUES(MENU_SEQ.NEXTVAL, '«�͹�', 6000, 'ȫ����� ������');

INSERT INTO MENU VALUES(MENU_SEQ.NEXTVAL, '¥���', 5500, 'ȫ����� ������');
INSERT INTO MENU VALUES(MENU_SEQ.NEXTVAL, '«��', 6500, 'ȫ����� ������');
INSERT INTO MENU VALUES(MENU_SEQ.NEXTVAL, '���¥��', 9500, 'ȫ����� ������');
INSERT INTO MENU VALUES(MENU_SEQ.NEXTVAL, '������', 5500, 'ȫ����� ������');
INSERT INTO MENU VALUES(MENU_SEQ.NEXTVAL, '«�͹�', 6000, 'ȫ����� ������');

INSERT INTO MENU VALUES(MENU_SEQ.NEXTVAL, '�ſ������', 6000, '�ѽ����� ������');
INSERT INTO MENU VALUES(MENU_SEQ.NEXTVAL, '��ġ��Ҵ�', 5000, '�ѽ����� ������');
INSERT INTO MENU VALUES(MENU_SEQ.NEXTVAL, '�����߳����ö���', 8000, '�ѽ����� ������');
INSERT INTO MENU VALUES(MENU_SEQ.NEXTVAL, '����� �Ҹ�', 6500, '�ѽ����� ������');
INSERT INTO MENU VALUES(MENU_SEQ.NEXTVAL, '���', 5500, '�ѽ����� ������');

INSERT INTO MENU VALUES(MENU_SEQ.NEXTVAL, '�ſ������', 6500, '��õ���� ��õ��');
INSERT INTO MENU VALUES(MENU_SEQ.NEXTVAL, '��ġ��Ҵ�', 4500, '��õ���� ��õ��');
INSERT INTO MENU VALUES(MENU_SEQ.NEXTVAL, '�����߳����ö���', 9000, '��õ���� ��õ��');
INSERT INTO MENU VALUES(MENU_SEQ.NEXTVAL, '����� �Ҹ�', 5500, '��õ���� ��õ��');
INSERT INTO MENU VALUES(MENU_SEQ.NEXTVAL, '���', 6500, '��õ���� ��õ��');
------------------------------------------------------------------------------------------------------------