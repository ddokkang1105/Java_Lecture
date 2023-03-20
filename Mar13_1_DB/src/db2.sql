-- JOIN
-- �ϳ��� ��ɹ��� ���� ���� ���̺� ����� �����͸� �ѹ��� ��ȸ�� �� �ִ� ���
-- ��ġ �ϳ��� ���̺��� ��ó�� ������

CREATE TABLE TB1 (NAME VARCHAR2(10 CHAR), AGE NUMBER(3));
CREATE TABLE TB2 (NAME VARCHAR2(10 CHAR), AGE NUMBER(3));

INSERT INTO TB1 VALUES('����', 30);
INSERT INTO TB1 VALUES('�ں��', 35);
INSERT INTO TB1 VALUES('�ֺ��', 40);
INSERT INTO TB1 VALUES('�����', 40);

INSERT INTO TB2 VALUES('����', 30);
INSERT INTO TB2 VALUES('�����', 50);
INSERT INTO TB2 VALUES('�̺��', 55);
------------------------------------------------------------------------------------------------------------
-- CROSS JOIN : ������ ���� ���� �� ���̺��� ������ ��� ����� ��ȸ(��� ����� ��)
-- ��ǻ� �Ⱦ� ��_��
SELECT * FROM TB1, TB2;
SELECT * FROM TB1 CROSS JOIN TB2;

-- INNER JOIN : ���ǿ� �ش��ϴ� ���� ����
SELECT * FROM TB1 INNER JOIN TB2 ON TB1.NAME = TB2.NAME;
SELECT * FROM TB1 A, TB2 B WHERE A.NAME = B.NAME;		-- EQUI ���� (���� ����)
SELECT * FROM TB1 JOIN TB2 USING (NAME);				-- EQUI ���� JOIN ~ USING (���δ���÷���)
SELECT * FROM TB1 NATURAL JOIN TB2;						-- �ڿ�����
													-- ������ ���� ���ʿ� ���� �̸��� ����
													-- ������ �÷����� ��ȸ
-- OUTER JOIN : OUTER JOIN�� ����ϴ� ������ ���� ���̺��� �����Ͱ� ��� ��ȸ(��������) �ǰ�,
--				��� ���̺� �����Ͱ� �ִ� ��� �ش� �÷��� ���� �������� ���ؼ� !
-- (+) �� �̿��� OUTER JOIN : NULL�� ��µǴ� ���̺��� �÷� (+) ��ȣ �߰�

-- LEFT OUTER JOIN : ���� ���̺� ���� ���� �� ������ ���̺��� ���ǿ� ���� �ʾƵ� ����
--						(���ǿ� ���� ������ NULL�� �޲۴� !)
--				RIGHT ���ٴ� LEFT �� �� ���� �� !! ( ���� ���̺��� �������� �δ� ���� O )
SELECT * FROM TB1 LEFT OUTER JOIN TB2 ON TB1.NAME = TB2.NAME;
SELECT * FROM TB1, TB2 WHERE TB1.NAME = TB2.NAME (+);

-- RIGHT OUTER JOIN : ������ ���̺� ���� ���� �� ���� ���̺��� ���ǿ� ���� �ʾƵ� ����
--						(���ǿ� ���� ������ NULL�� �޲۴� !)
SELECT * FROM TB1 RIGHT OUTER JOIN TB2 ON TB1.NAME = TB2.NAME;
SELECT * FROM TB1, TB2 WHERE TB1.NAME (+)= TB2.NAME;

-- FULL OUTER JOIN : ���� ���̺� ���� ���� ��, �ٸ� �� ���ǿ� ���� �ʾƵ� ����
SELECT * FROM TB1 FULL OUTER JOIN TB2 ON TB1.NAME = TB2.NAME;

-- SELF JOIN *** �򰥸�
-- �ϳ��� ���̺� ���� �ִ� �÷����� �����ϴ� ������ �ʿ��� ���
-- �ܾ� �״���� ��ó�� ������ JOIN�Ѵٴ� �� !

-- �� ����Ʈ�� ȸ���� 5���� �ְ�, �����ڰ� 2���� �ִ�.
-- ȸ���� �̸��� ���� ȸ�� 1 ~ 5, �������� �̸��� ������ 1, 2
-- ȸ���� ID�� ���� MEMBER 1 ~ 5, �������� ID�� MANAGER 1, 2
-- ȸ�� 1 ~ 3 ���� ������ 1�� ���� / ������ ȸ���� ������ 2�� ����
CREATE TABLE MEMBER(
	M_ID VARCHAR2(10 CHAR) PRIMARY KEY,
	M_NAME VARCHAR2(10 CHAR) NOT NULL,
	M_MANAGER VARCHAR2(10 CHAR)		-- �����ڵ��� ������ �� ������ ���� ���� X
);

INSERT INTO MEMBER VALUES('MEMBER 1', 'ȸ�� 1', 'MANAGER 1');
INSERT INTO MEMBER VALUES('MEMBER 2', 'ȸ�� 2', 'MANAGER 2');
INSERT INTO MEMBER VALUES('MEMBER 3', 'ȸ�� 3', 'MANAGER 3');
INSERT INTO MEMBER VALUES('MEMBER 4', 'ȸ�� 4', 'MANAGER 4');
INSERT INTO MEMBER VALUES('MEMBER 5', 'ȸ�� 5', 'MANAGER 5');
INSERT INTO MEMBER VALUES('MANAGER 1', '������ 1', NULL);
INSERT INTO MEMBER VALUES('MANAGER 2', '������ 2', NULL);

-- �� �����ڰ� � ȸ���� �����ϴ��� �˰� ����
--		������ ID, ������ �̸�, ȸ�� ID ���

SELECT *
	FROM MEMBERS A JOIN MEMBERS B ON A.M_ID = B.M_ID;

SELECT A.M_IDM, A.M_NAME, B.M_ID
	FROM MEMBERS A JOIN MEMBERS B 		-- ���� ���̺������� ���������� �ϱ� ����
										-- ���̺� ��Ī�� �־ ��������
	ON A.M_ID = B.M_MANAGER;			-- ���� ID�� ������ ������ ���� ������ �����ؼ�
										-- �����ϴ� ȸ�� ID���� ������ �� �ְ� !
------------------------------------------------------------------------------------------------------------