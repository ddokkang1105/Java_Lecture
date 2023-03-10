-- 1. �������̺�� ī�����̺� �����
-- �������̺� : ���� �̸� / ���� / �Ǹ��ϴ� ī���� �̸�
-- ī�����̺� : ī�� �̸� / ���� / �¼� ��
-- [����] �� ���̺��� �����̸�, ī�� �̸��� ������ ���� ���´�.
CREATE TABLE DRINK(
    D_NAME VARCHAR2(10 CHAR) PRIMARY KEY,
    D_PRICE NUMBER(5) NOT NULL,
    D_CAFE VARCHAR2(10 CHAR) NOT NULL
);

CREATE TABLE CAFE(
    C_NAME VARCHAR2(10 CHAR) PRIMARY KEY,
    C_ADD VARCHAR2(10 CHAR) NOT NULL,
    C_SEAT NUMBER(3) NOT NULL
);

-- 2. ���ǿ� �´� ���̺��� ����
-- Aī��� ���￡ ��ġ�ϰ�, �¼��� 100��,
--		(�Ƹ޸�ī��, 2000��), (��, 3000��), (����, 2500��) �� �Ǹ�
-- Bī��� ������ ��ġ�ϰ�, �¼��� 80��,
--		(ȫ��, 2500��), (������, 3000��), (����������, 4000��) �� �Ǹ�
INSERT INTO CAFE VALUES('Aī��', '����', 100);
INSERT INTO CAFE VALUES('Bī��', '����', 80);
INSERT INTO DRINK VALUES('�Ƹ޸�ī��', 2000, 'Aī��');
INSERT INTO DRINK VALUES('��', 3000, 'Aī��');
INSERT INTO DRINK VALUES('����', 2500, 'Aī��');
INSERT INTO DRINK VALUES('ȫ��', 2500, 'Bī��');
INSERT INTO DRINK VALUES('������', 3000, 'Bī��');
INSERT INTO DRINK VALUES('����������', 4000, 'Bī��');

-- 3. ������ �ۼ�
--		��հ����� ��� ����� �� ���� ?
SELECT COUNT(*)
    FROM DRINK 
    WHERE D_PRICE > (
        SELECT AVG(D_PRICE)
        FROM DRINK
    );

--		���� �� ���Ḧ �Ĵ� ī���� �̸� ?
SELECT C_NAME
    FROM CAFE
    WHERE C_NAME IN (
    	SELECT D_CAFE
    	FROM DRINK
    	WHERE D_PRICE IN (
        	SELECT MIN(D_PRICE)
        	FROM DRINK
		)
    );

--		���￡ �ִ� ī�信�� ����� ������ ��հ� ?
SELECT AVG(D_PRICE)
    FROM DRINK
    WHERE D_CAFE IN (
        SELECT C_NAME
        FROM CAFE
        WHERE C_ADD = '����'
    );

--		�¼��� 90�� �̻��� ī�信�� �Ĵ� ������ �̸� ?
SELECT D_NAME
    FROM DRINK
    WHERE D_CAFE IN (
        SELECT C_NAME
        FROM CAFE
        WHERE C_SEAT >= 90
    );

--		��հ� ������ ������ �̸� ?
SELECT D_NAME
    FROM DRINK
    WHERE D_PRICE <= (
        SELECT AVG(D_PRICE)
        FROM DRINK
    );
    
--		���� ��� ���Ḧ �Ĵ� ī��� ��� �ִ��� ?
SELECT C_ADD
    FROM CAFE
    WHERE C_NAME IN (
        SELECT D_CAFE
        FROM DRINK
        WHERE D_PRICE IN (
            SELECT MAX(D_PRICE)
            FROM DRINK
        )
    );
------------------------------------------------------------------------------------------------------------