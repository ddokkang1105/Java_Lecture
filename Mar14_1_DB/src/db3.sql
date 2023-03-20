-- ����, 3000G, 10000��, Ȩ�÷���, ������, 1000��, ������ 500��
-- ��, 500G, 5000��, Ȩ�÷���, ������, 500��, ������ 300��
-- ����, 2000G, 5000��, �̸�Ʈ, ������, 800��, ������ 800��
------------------------------------------------------------------------------------------------------------
CREATE TABLE MAR14_MARKET(
    M_NO NUMBER(2) PRIMARY KEY,
    M_NAME VARCHAR2(10 CHAR) NOT  NULL,
    M_LOCATION VARCHAR2(10 CHAR) NOT NULL,
    M_AREA NUMBER(4) NOT NULL,
    M_PARKING NUMBER(4) NOT NULL
);

CREATE SEQUENCE MAR14_MARKET_SEQ;

INSERT INTO MAR14_MARKET VALUES(MAR14_MARKET_SEQ.NEXTVAL, 'Ȩ�÷���', '������', 1000, 500);
INSERT INTO MAR14_MARKET VALUES(MAR14_MARKET_SEQ.NEXTVAL, 'Ȩ�÷���', '������', 500, 300);
INSERT INTO MAR14_MARKET VALUES(MAR14_MARKET_SEQ.NEXTVAL, '�̸�Ʈ', '������', 800, 800);
------------------------------------------------------------------------------------------------------------
CREATE TABLE MAR14_PRODUCT(
    P_NO NUMBER(2) PRIMARY KEY,
    P_NAME VARCHAR2(10 CHAR) NOT NULL,
    P_WEIGHT NUMBER(4) NOT NULL,
    P_PRICE NUMBER(5) NOT NULL,
    P_M_NO NUMBER(2) NOT NULL,
        CONSTRAINT FK_MAR14_PRODUCT FOREIGN KEY(P_M_NO)
        REFERENCES MAR14_MARKET(M_NO)
        ON DELETE CASCADE
);

CREATE SEQUENCE MAR14_PRODUCT_SEQ;

INSERT INTO MAR14_PRODUCT VALUES(MAR14_PRODUCT_SEQ.NEXTVAL, '����', 3000, 10000, 1);
INSERT INTO MAR14_PRODUCT VALUES(MAR14_PRODUCT_SEQ.NEXTVAL, '��', 5000, 5000, 2);
INSERT INTO MAR14_PRODUCT VALUES(MAR14_PRODUCT_SEQ.NEXTVAL, '����', 2000, 5000, 3);
------------------------------------------------------------------------------------------------------------
-- CREATE TABLE - DBA
-- DROP TABLE - DBA
-- CREATE SEQUENCE - DBA
-- ���� �ϳ��� ������ ��� ����
-- ȸ�簡�� �����ڿ� ������ �˷��� => ���� �۾��� ������ ���� ��..?
------------------------------------------------------------------------------------------------------------
-- C - INSERT
--			SEQUENCE ���, ��¥ ����ְ�, ...
-- R - SELECT
--			���� ��κ��� �ð��� �Ҿ���
-- U - UPDATE
UPDATE ���̺��
	SET �÷��� = ��, �÷��� = ��, ... -- ������ ����
	WHERE ����;
	
-- ���� ��¥��
UPDATE MAR14_PRODUCT
    SET P_PRICE = 0
    WHERE P_NAME = '��';

-- ���߸� �������߷� �̸� ����
UPDATE MAR14_PRODUCT
    SET P_NAME = '��������'
    WHERE P_NAME IN '����';

-- ��� ��Ʈ�� ������ 30% ���̱�
UPDATE MAR14_MARKET
    SET M_PARKING = M_PARKING * 0.7;

-- Ȩ�÷��� �������� ��ǰ���� 10% ����
UPDATE MAR14_PRODUCT
    SET P_PRICE = P_PRICE * 0.9
    WHERE P_M_NO IN (
        SELECT M_NO
        FROM MAR14_MARKET
        WHERE M_NAME = 'Ȩ�÷���' AND M_LOCATION = '������'
    );
	
-- ���� ��� ��ǰ 10% ����
UPDATE MAR14_PRODUCT
    SET P_PRICE = P_PRICE * 0.9
    WHERE P_PRICE IN (
        SELECT MAX(P_PRICE)
        FROM MAR14_PRODUCT
    );
------------------------------------------------------------------------------------------------------------
-- D - DELETE
DELETE FROM ���̺��
	WHERE ���ǽ�;
	
-- �� ����
DELETE MAR14_PRODUCT
    WHERE P_NAME = '��';
	
-- ���� ���� ������ ��ǰ �� ����
DELETE MAR14_PRODUCT
    WHERE P_M_NO IN (
        SELECT M_NO
        FROM MAR14_MARKET
        WHERE M_AREA IN (
            SELECT MIN(M_AREA)
            FROM MAR14_MARKET
        )
    );
------------------------------------------------------------------------------------------------------------
-- Ȩ�÷��� �������� ����
DELETE FROM MAR14_MARKET
	WHERE M_NAME = 'Ȩ�÷���' AND M_LOCATION = '������';
-- Ȩ�÷��� �������� �������µ�, �� �ȿ� �ִ� ��ǰ���� ��� ����..?
-- �׳� �ΰų� / ���� ���� / ����ΰų� ...
-- ������ ���.. ���߿� ������Ʈ�� �����鳢�� �� �����ؾ� !!!
------------------------------------------------------------------------------------------------------------