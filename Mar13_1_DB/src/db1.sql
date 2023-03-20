SELECT * FROM FRANCHISE;

SELECT * FROM CEO;

SELECT * FROM MENU;
------------------------------------------------------------------------------------------------------------
-- ���� ��� �޴��� �̸�, ����
SELECT M_NAME, M_PRICE
    FROM MENU
    WHERE M_PRICE IN (
        SELECT MAX(M_PRICE)
        FROM MENU
    );
    
-- �ֿ����� ������� �̸�, ����
SELECT C_NAME, C_BIRTHDAY
    FROM CEO
    WHERE C_BIRTHDAY IN (
        SELECT MIN(C_BIRTHDAY)
        FROM CEO
    );
    
-- �¼� �� ���� ���� �Ĵ��� �̸�, ������, �¼���
SELECT F_NAME, F_LOCATION, F_SEAT
    FROM FRANCHISE
    WHERE F_SEAT IN (
        SELECT MIN(F_SEAT)
        FROM FRANCHISE
    );
------------------------------------------------------------------------------------------------------------
-- ȫ����� ������ ��ϴ� ����� �̸�, ����    
SELECT C_NAME, C_BIRTHDAY
    FROM CEO
    WHERE C_NO IN (
        SELECT F_CEO
        FROM FRANCHISE
        WHERE F_NAME = 'ȫ�����' AND F_LOCATION = '����'
    );

-- '¥��'�� �� ������ ��𰡸� ���� �� �ֳ��� ? (¥��� �Ĵ� �Ĵ� �̸�, ������)
SELECT F_NAME, F_LOCATION
    FROM FRANCHISE
    WHERE F_NO IN (
        SELECT M_F_NO
        FROM MENU
        WHERE M_NAME LIKE '%¥��%'
    );
    
-- �¼� �� ���� ���� �Ĵ��� ��ϴ� ����� ��� ����
SELECT *
    FROM CEO
    WHERE C_NO IN (
        SELECT F_CEO
        FROM FRANCHISE
        WHERE F_SEAT IN (
            SELECT MAX(F_SEAT)
            FROM FRANCHISE
        )
    );
------------------------------------------------------------------------------------------------------------
-- �ֿ��� ������� ��ϴ� ������ �޴� �̸�, ����
SELECT M_NAME, M_PRICE
    FROM MENU
    WHERE M_F_NO IN (
        SELECT F_NO
        FROM FRANCHISE
        WHERE F_CEO IN (
            SELECT C_NO
            FROM CEO
            WHERE C_BIRTHDAY IN (
                SELECT MAX(C_BIRTHDAY)
                FROM CEO
            )
        )
    );
------------------------------------------------------------------------------------------------------------
-- ���̺� �������� 'JOIN' ��Ų��.
--			: ���̺� �������� �ٿ��� RAM�� ��� �־���� ... !
------------------------------------------------------------------------------------------------------------
-- �̷��� ���̺��� �ٿ��� ����� ����������,
--	���̺���� �������鼭 ��Ÿ�� �� �ִ� ��~~�� ����� ������ �� ��Ÿ���� ������
SELECT * FROM FRANCHISE, CEO;
-- ���ǽ��� ����ؼ� ��¥ �����͸� ������ �;� �� !
SELECT * FROM FRANCHISE, CEO WHERE F_CEO = C_NO;

-- ��ü �Ĵ� �̸�, ������, ����� �̸�, ����� ����
SELECT F_NAME, F_LOCATION, C_NAME, C_BIRTHDAY
    FROM FRANCHISE, CEO
    WHERE F_CEO = C_NO;
    
-- ��ü �޴���, ����, �Ĵ��̸�, ������
SELECT M_NAME, M_PRICE, F_NAME, F_LOCATION
    FROM MENU, FRANCHISE
    WHERE M_F_NO = F_NO;
    
-- �¼����� 50�� �̻��� �Ĵ��� �޴���, ����, �Ĵ��̸�, ������, �¼� ��
SELECT M_NAME, M_PRICE, F_NAME, F_LOCATION, F_SEAT
    FROM MENU, FRANCHISE
    WHERE F_SEAT >= 50 AND F_NO = M_F_NO;
    
-- �Ը� ���� ū �Ĵ��� �޴���, ����, �Ĵ��̸�, ������, �¼� ��
SELECT M_NAME, M_PRICE, F_NAME, F_LOCATION, F_SEAT
    FROM MENU, FRANCHISE
    WHERE F_NO = M_F_NO AND F_SEAT IN (
        SELECT MAX(F_SEAT)
        FROM FRANCHISE
    );
    
-- �ֿ����� ����Գ� ��ü �޴���, ����, �Ĵ��̸�, ������, ����� �̸�, ����
--				�� �޴��� �����ټ� -> �޴����� ������ �Ĵ��̸� �����ټ�
SELECT M_NAME, M_PRICE, F_NAME, F_LOCATION, C_NAME, C_BIRTHDAY
    FROM MENU, FRANCHISE, CEO
    WHERE M_F_NO = F_NO AND F_CEO = C_NO AND C_BIRTHDAY IN (
        SELECT MIN(C_BIRTHDAY)
        FROM CEO
    )
    ORDER  BY M_NAME, F_NAME;
------------------------------------------------------------------------------------------------------------
-- �޴� �����͸� ������ ������ �������� �����ְ� ����
-- ��� �ұ� ?
-- �޴����̺� M_NO�� ���� (PRIMARY KEY)
--		SEQUENCE�� ó������
--			��.��.��.��.��.��.��. SEQUENCE�� INSERT�� �����ص� �ö�
--		�޴� ������ ������ ������
--	=> M_NO�� ��Ȯ�� 1, 2, 3, 4, ...�� �ƴ� !��
--	�׷� � ����� ������...?    
------------------------------------------------------------------------------------------------------------
-- ROWNUM (�����ʵ�) ************
-- 		SELECT�� ������ �ڵ����� �ο���
--		* ���� ���� ����� �� ����
--		ORDER BY���� ���� �ο� !
--		������ 1������ ��ȸ�ؾ� �� !
    
-- �޴� �̸��� ������ ������ �����ؼ� �޴��� ��ü ���� ��ȸ
SELECT ROWNUM, M_NO, M_NAME, M_PRICE, M_F_NO FROM MENU ORDER BY M_NAME;

-- �޴� �̸��� ������ ������ �����ؼ� MENU ���̺� ROWNUM 1 ~ 3 ���� ��ü ������ ��ȸ
SELECT ROWNUM, M_NO, M_NAME, M_PRICE, M_F_NO 
    FROM MENU 
    WHERE ROWNUM BETWEEN 1 AND 3	-- ORDER BY ���� ROWNUM�� �����Ǿ
    								-- SEQUENCE�� ���� M_NO�� ���� ���͹���
    								-- �츮�� �ǵ��� �ٴ� �̸������� ������ �ϰ�
    								-- �� ���� ��ȣ��(ROWNUM)�� �ֱ� ������ !
    ORDER BY M_NAME;
    
SELECT ROWNUM, M_NO, M_NAME, M_PRICE, M_F_NO
	FROM MENU
	ORDER BY M_NAME
	WHERE ROWNUM BETWEEN 1 AND 3;	-- �ڵ�� ������� ������ �Ϸ��� �̷��� �ϰ� ������
									-- ���� ���� !
								
SELECT ROWNUM, M_NO, M_NAME, M_PRICE	-- 2. �� ������ ROWNUM �ο�
	FROM (
		SELECT M_NO, M_NAME, M_PRICE 	-- 1. �� �κ��� ���̺�ó�� �����
										-- (������ ���� �س���)
										-- INLINE VIEW��� �� (�ζ��� ��)
		FROM MENU 
		ORDER BY M_NAME
	)
	WHERE ROWNUM >= 1 AND ROWNUM <= 3;
--	WHERE ROWNUM >= 2 AND ROWNUM <= 3;	-- 1������ ��ȸ�����ϱ� ������ !!

-- �޴� �̸��� ������ ������ �����ؼ� MENU ���̺� ROWNUM 2 ~ 4 ���� ��ü ������ ��ȸ
-- SELECT�� �ѿ� �ѹ� �� �����ָ� ... ROWNUM(RN)�� ���ڸ� �ο��س��� ȿ���� �о����
SELECT ROWNUM, RN, M_NO, M_NAME, M_PRICE -- ROWNUM�� RN �� �ٸ����� !!
	FROM (
		SELECT ROWNUM RN, M_NO, M_NAME, M_PRICE 
		FROM (
            SELECT M_NO, M_NAME, M_PRICE
            FROM MENU
            ORDER BY M_NAME
        )
    -- WHERE RN >= 2 AND RN <= 3 -- ���⿡ ������ ������ ������ �߻��� !
	)
    WHERE RN >= 2 AND RN <= 4;
 
-- ~�浿 �̸��� ���� ����Գ�
--		�޴���, ����, �Ĵ��, ������, ����� �̸�
--		���� �������� -> �޴��� �����ټ� ���� ��
--		3 ~ 8 ��° ��ȸ
SELECT RN, M_NAME, M_PRICE, F_NAME, F_LOCATION, C_NAME		-- RN, M_NAME, M_PRICE, F_NAME, F_LOCATION, C_NAME ���
															-- * �� ���� !!
    FROM(
        SELECT ROWNUM RN, M_NAME, M_PRICE, F_NAME, F_LOCATION, C_NAME
        FROM (
            SELECT M_NAME, M_PRICE, F_NAME, F_LOCATION, C_NAME
            FROM MENU, FRANCHISE, CEO
            WHERE M_F_NO = F_NO AND F_CEO = C_NO AND C_NAME LIKE '%�浿'
            ORDER BY M_PRICE DESC, M_NAME
        )
    )
    WHERE RN BETWEEN 3 AND 8;
    
-- �达 ���� ���� ����Գ� �޴���, ����, ����� �̸�, ����� ����
--	���� �������� ���� -> 2 ~ 3���� !    
SELECT *
    FROM (
        SELECT ROWNUM RN, M_NAME, M_PRICE, C_NAME, C_GENDER
        FROM (
            SELECT M_NAME, M_PRICE, C_NAME, C_GENDER
            FROM MENU, FRANCHISE, CEO
            WHERE M_F_NO = F_NO AND F_CEO = C_NO AND C_NAME LIKE '��%'
            ORDER BY M_PRICE 
        )
    )
    WHERE RN BETWEEN 2 AND 3;
------------------------------------------------------------------------------------------------------------