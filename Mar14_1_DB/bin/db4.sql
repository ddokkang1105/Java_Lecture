-- 1. ORACLEDB ������ ���� �����͸� ǥ���� �� �ִ� DB�ڷᱸ���� ����� SQL���� �ۼ����ּ���

--		- ��ǻ�� �̸� : ��ǻ��1
--		- � ü�� : WINDOWS 10 PRO
--		- ���� ��¥ : 2023-02-14
--		- ���� : 5.12KG
--		- CPU : I5-1234

--		- ��ǻ�� �̸� : ��ǻ��2
--		- � ü�� : WINDOWS 11 PRO
--		- ���� ��¥ : 2023-03-01
--		- ���� : 5.23KG
--		- CPU : I7-5678
CREATE TABLE MAR14_COMPUTER (
    C_NO NUMBER(2) PRIMARY KEY,
    C_NAME VARCHAR2(10 CHAR) NOT NULL,
    C_OS VARCHAR2(20 CHAR) NOT NULL,
    C_FORMAT DATE NOT NULL,
    C_WEIGHT NUMBER(4, 2) NOT NULL,
    C_CPU VARCHAR2(10 CHAR) NOT NULL
);

CREATE SEQUENCE MAR14_COMPUTER_SEQ;

-- 2. 1������ ���� ���̺� ���� �����͸� �߰��ϴ� SQL���� �ۼ����ּ���
--		(1���� ���⿡ �ִ� �����͵� �߰��� �� ( �� 3���� ������ ) )

--		- ��ǻ�� �̸� : ��ǻ��3
--		- � ü�� : WINDOWS 10 PRO
--		- ���� ��¥ : 2023-02-22
--		- ���� : 3.22KG
--		- CPU : I7-1234
INSERT INTO MAR14_COMPUTER VALUES(MAR14_COMPUTER_SEQ.NEXTVAL, '��ǻ��1', 'WINDOWS 10 PRO',
    TO_DATE('2023-02-14', 'YYYY-MM-DD'), 5.12, 'I5-1234');

INSERT INTO MAR14_COMPUTER VALUES(MAR14_COMPUTER_SEQ.NEXTVAL, '��ǻ��2', 'WINDOWS 11 PRO',
    TO_DATE('2023-03-01', 'YYYY-MM-DD'), 5.23, 'I7-5678');

    INSERT INTO MAR14_COMPUTER VALUES(MAR14_COMPUTER_SEQ.NEXTVAL, '��ǻ��3', 'WINDOWS 10 PRO',
    TO_DATE('2023-02-22', 'YYYY-MM-DD'), 3.22, 'I7-1234');

-- 3. 1������ ���� ���̺���, �������� ���� ������ ��ǻ���� ��¥��
--		�� ��ǻ�� ���� ��ȸ�ϴ� SQL���� �ۼ����ּ���
SELECT MIN(C_FORMAT), COUNT(*) FROM MAR14_COMPUTER;

-- 4. 1������ ���� ���̺���, ���� �ֱٿ� ������ ��ǻ���� �̸��� ��ȸ�ϴ� SQL���� �ۼ����ּ���
SELECT C_NAME
    FROM MAR14_COMPUTER
    WHERE C_FORMAT IN (
        SELECT MAX(C_FORMAT)
        FROM MAR14_COMPUTER
    );

-- 5. 1������ ���� ���̺���, 2��°�� ������ ��ǻ�� ~ 3��°�� ������ ��ǻ����
--		��ü ������ ��ȸ�ϴ� SQL���� �ۼ����ּ���
SELECT *
    FROM (
        SELECT ROWNUM RN, C_NO, C_NAME, C_OS, C_FORMAT, C_WEIGHT, C_CPU
        FROM (
            SELECT C_NO, C_NAME, C_OS, C_FORMAT, C_WEIGHT, C_CPU
            FROM MAR14_COMPUTER
            ORDER BY C_WEIGHT
        )
    )
    WHERE RN BETWEEN 2 AND 3;
------------------------------------------------------------------------------------------------------------