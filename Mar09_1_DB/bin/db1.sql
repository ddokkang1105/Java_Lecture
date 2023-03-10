-- R (Read)
SELECT [DISTINCT] [�÷���], [�÷��� AS ��Ī || �÷��� ��Ī], [������ ���], [����Լ�], ...
	FROM [���̺��]
	WHERE [���ǽ�]
	GROUP BY [�׷���]
	HAVING [�Լ� ���� ����]
	ORDER BY [���Ĵ�� ASC/DESC (�������� / ��������)]
	

-- WHERE �� (���ǽ�)
-- ��ü ������ �� ������ ���ǿ� �´� �����͸� ã���ִ� ����
-- ���ǽĿ� ����� �����ڸ� �˾ƺ��� ! (�� ������)
-- =, !=, ^=, <>, <, >, <=, >=, ...
-- �� �߿��� !=, ^=, <> �� '���� �ʴ�'�� ���̴� �������ε�... �� 3���� �ɱ�..?
-- !=, <> �� ��쿡�� ���� ǥ��ȭ�� �Ϸ��� ���� ����ϰ� �Ǿ���,
-- ^= �� ��쿡�� ��� DBMS�� ����ȭ�� �α� ���� ����ϰ� �Ǿ���

-- ������ 3000���� ������ ��� ������ ��ȸ
SELECT * FROM SNACK WHERE S_PRICE = 3000; 
-------------------------------------------------------------------------------------------------------------	
	
-- ��� ���� �̸�, ���� ��ȸ
SELECT S_NAME �̸�, S_PRICE ���� FROM SNACK;
-- ��� ���� �̸�(����) ��ȸ (EX: ��Ĩ(1800��) )
SELECT S_NAME || '(' || S_PRICE || '��)' "�̸�(����)" FROM SNACK WHERE S_PRICE = 1800;
-------------------------------------------------------------------------------------------------------------	
-- 2000�� ������ ���� �� �ּҰ����� ������ ?
SELECT MIN(S_PRICE) || '��' "�ּҰ���(2000�� ����)" FROM SNACK WHERE S_PRICE <= 2000;

-- ��� ������ ��հ��� ������ ?
SELECT ROUND(AVG(S_PRICE), 1) || '��' "��հ���" FROM SNACK;

-- ������ �̸��� ������ 30% ���ε� �ݾ�
SELECT S_NAME || '(' || S_PRICE  * 0.7 || '��)' "�̸�(30% ���� �ݾ�)" FROM SNACK;

-- 3500���� ������ ������ �� �� ?
SELECT COUNT(*) || '��' "3500�� ���� ����" FROM SNACK WHERE S_PRICE = 3500;

-- 3000�� ������ ������ �̸�, ȸ�� �̸�
SELECT S_NAME �̸�, S_COMPANY ȸ�� FROM SNACK WHERE S_PRICE <= 3000;
-------------------------------------------------------------------------------------------------------------	
-- ��� ���� �̸�, ����, ������� ��ȸ
SELECT S_NAME �̸�, S_PRICE || '��' ����, S_TIME ������� FROM SNACK;

-- ��� ���� �̸�, ����, �ΰ���(������ 10%) ��ȸ
SELECT S_NAME �̸�, S_PRICE || '��' ����, (S_PRICE * 0.1) || '��' �ΰ��� FROM SNACK;

-- ��� ���� �̸�, ����, �ǸŰ� ��ȸ(20% ����) ��ȸ
SELECT S_NAME �̸�, S_PRICE || '��' ����, (S_PRICE * 0.8) || '��' �ǸŰ� FROM SNACK;

-- 3000������ ū �ݾ��� ���ڵ��� ��հ� ��ȸ
SELECT ROUND(AVG(S_PRICE), 1) || '��' "��հ�(3000�� �̻�)" FROM SNACK WHERE S_PRICE > 3000;

-- �ְ�, ������, �� ���� ���� �� �������� ��ȸ
SELECT MAX(S_PRICE) || '��' �ְ�, MIN(S_PRICE) || '��' ������, COUNT(S_NAME) || '��' "�� ���� ����" FROM SNACK;

-- 3000�� �̻��� ������ ��ü ���� ��ȸ
SELECT * FROM SNACK WHERE S_PRICE >= 3000;

-- 3000�� �̸��� ������ �̸�, ����, �ǸŰ�(20% ����)
SELECT S_NAME "�̸�(3000�� �̸�)", S_PRICE || '��' ����, (S_PRICE * 0.8) || '��' �ǸŰ� FROM SNACK WHERE S_PRICE < 3000;

-- ��Ϲ���Ĩ�� ���� ��ȸ
SELECT S_PRICE || '��' "��Ϲ���Ĩ ����" FROM SNACK WHERE S_NAME = '��Ϲ���Ĩ';

-- ũ��� ȸ���� ���� ���� ���� ��ȸ
SELECT SUM(S_PRICE) || '��' "ũ��� ȸ�� ���� ����" FROM SNACK WHERE S_COMPANY = 'ũ���';

-- 7�� ������ �Ծ�� �ϴ� ���� �̸�, ����, ������� ��ȸ
SELECT S_NAME �̸�, S_PRICE || '��' ����, S_TIME "�������(���� 7��)" FROM SNACK WHERE S_TIME < '2023-07-31 23';
SELECT S_NAME �̸�, S_PRICE || '��' ����, S_TIME "�������(���� 7��)" FROM SNACK WHERE S_TIME < '2023-08-01';
-- DATE Ÿ�԰� ���ϴ°� �� ��Ȯ�� �ڵ� !!
SELECT S_NAME �̸�, S_PRICE || '��' ����, S_TIME "�������(���� 7��)" FROM SNACK 
	WHERE S_TIME < TO_DATE('2023-08-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS');
-------------------------------------------------------------------------------------------------------------	
-- ���� ������ 
-- NOT, AND, OR, BETWEEN, IN

-- AND, BETWEEN ������
-- ������ 1000�� �̻� 3000�� ������ ������ ��ü������ ��ȸ 
-- AND�� �̿��ؼ�
-- ������ ���� �ʴ� �ڵ� !! 
-- SELECT * FROM SNACK WHERE 1000 <= S_PRICE <= 3000;
SELECT * FROM SNACK WHERE S_PRICE >= 1000 AND S_PRICE <= 3000;
-- BETWEEN�� �̿��ؼ� 
SELECT * FROM SNACK WHERE S_PRICE BETWEEN 1000 AND 3000;

-- ���� �ٸ����� ? �׳� BETWEEN ���°� �� ������ �ƴѰ��� ?!
-- BETWEEN�� �̻�/���Ϸ� ���� ������ ���ϱ� ������
-- 1000�� �ʰ� 3000�� �̸��� ���ڸ� ��ȸ�� ������ ... ��_��

-- ������ 1000��, 2000��, 3000���� ������ ��ü ������ ��ȸ

-- OR ������
SELECT * FROM SNACK WHERE S_PRICE = 1000 OR S_PRICE = 2000 OR S_PRICE = 3000;
-- �����̾� �̷��� Ǯ �� �ְ�����, ���� OR�� ����ϴ� ������ �������ٸ� ... ? ������ !!
-- ���� ��ȿ�����̰�, �����ϰ�, ��������,,, ��� ���ϰ� ����??

-- IN ������
SELECT * FROM SNACK WHERE S_PRICE IN (1000, 2000, 3000);
-- S_PRICE(����)�� 1000�� OR 2000�� OR 3000�� �� ��Ÿ���ִ� ������ !!
-- ���� ��������, ȿ�����̿��� !! �ŷµ�� \>_</
-- ���ӵ��� ���� ������ �޾ƿ��� ���� �� -> IN�� ������� !!

-- NOT ������
-- �׷� �� ����� �ݴ�Ǵ� ������� �޾ƿ��� �ʹٸ� ? -> NOT ������ !!
SELECT * FROM SNACK WHERE S_PRICE NOT IN (1000, 2000, 3000);
-- IN ������ �տ��ٰ� NOT�� �ٿ��� ����ϸ� �ȴ� ~
------------------------------------------------------------------------------------------------------------
-- ���� ������
--	���ڿ��� �����ϴ� �˻� : LIKE '����' �� ���� 
--	�� �� ���Ͽ��� [%] �� �ִµ� ���� ���� �𸥴ٴ� �� !
--		LIKE '%��' : ���� ������ ��
--		LIKE '��%' : ���� �����ϴ� ��
--		LIKE '%��%' : ���� ����
-- �׷� LIKE ��ſ� ( = '��%' ) �� �ȵǳ��� ?
--		=> ��ȣ�� �Ἥ ���� ǥ���ϸ� �������� �ν��ϴ°� �ƴ϶� '��%'��� ���ڷ� �ν��Ѵ�.
--		=> �׷��� LIKE�� '��%' �̷� ������ ���� ã�ƶ� ~ ��� ǥ������

-- '��'�� ���� ȸ�翡�� ���� ���� �̸� ��ȸ
SELECT S_NAME FROM SNACK WHERE S_COMPANY LIKE '%��%';

-- '��'�� ���� ���ڵ��� ��հ��� ��ȸ
SELECT AVG(S_PRICE) || '��' ��հ� FROM SNACK WHERE S_NAME LIKE '%��%';

-- ������ ���ڰų�, ���� ~ �ΰ� �̸�, ������, ���� ��ȸ
SELECT S_NAME, S_COMPANY, S_PRICE FROM SNACK WHERE S_COMPANY = '������' OR S_NAME LIKE '����%';

-- ������ �̸��� '��������'�� �����ϰų�, '����'�� �����ϴ� ������ �̸�, ������, ���� ��ȸ
SELECT S_NAME, S_COMPANY, S_PRICE FROM SNACK WHERE S_NAME LIKE '%��������%' OR S_NAME LIKE '%����%';

-- LIKE ~ IN ������ �ƿ� ���� !!
-- SELECT S_NAME, S_COMPANY, S_PRICE FROM SNACK WHERE S_NAME LIKE IN ('%��������%', '%����%');

-- REGEXP_LIKE(�÷���, ����1|����2|...)
-- �������� ������ ã�� �ʹٸ� |(������)�� �־ ������ �߰��ϸ� ��
-- ���Խ�(REGEX)�� �̿��ؼ� ���ڸ� ã�� ����ε�...
-- ���� �տ� ^�� ������ : ���ϰ����� �����ϴ� ���ڿ� ã��
-- ���� �ڿ� $�� ������ : ���ϰ����� ������ ���ڿ� ã��

-- ������ �̸��� '��������'�� �����ϰų�, '��'�� ������ ������ �̸�, ������, ���� ��ȸ
SELECT S_NAME, S_COMPANY, S_PRICE FROM SNACK WHERE REGEXP_LIKE(S_NAME, '^�������� | ��$');
------------------------------------------------------------------------------------------------------------
-- ���� ������
--	������
--		UNION		: �ߺ��Ǵ� ���� �����ϰ� ���
SELECT 1 ID, '����' SUBJECT, 90 SCORE FROM DUAL
	UNION

SELECT 1 ID, '����' SUBJECT, 90 SCORE FROM DUAL
	UNION
	
SELECT 1 ID, '����' SUBJECT, 90 SCORE FROM DUAL;

-- 		UNION ALL	: �ߺ��Ǵ��� ��� ���
SELECT 1 ID, '����' SUBJECT, 90 SCORE FROM DUAL
	UNION ALL

SELECT 1 ID, '����' SUBJECT, 90 SCORE FROM DUAL
	UNION ALL
	
SELECT 1 ID, '����' SUBJECT, 90 SCORE FROM DUAL;

--	������
--		INTERSECT : �� ���̺��� ���� �� ����Ǵ� �� ���	
SELECT 1 ID, '����' SUBJECT, 90 SCORE FROM DUAL
	UNION
SELECT 2 ID, '����' SUBJECT, 80 SCORE FROM DUAL
	INTERSECT
SELECT 1 ID, '����' SUBJECT, 90 SCORE FROM DUAL;
	
--	������
--		MINUS : ù��° SELECT�� �߿��� �ι�° SELECT������ ���� ���� ���
SELECT 1 ID, '����' SUBJECT, 90 SCORE FROM DUAL
	MINUS
SELECT 1 ID, '����' SUBJECT, 80 SCORE FROM DUAL -- ��������� ù��° SELECT ���� ���
	MINUS
SELECT 1 ID, '����' SUBJECT, 90 SCORE FROM DUAL; -- ����� ���� �����Ƿ� ��ȯ���� ����
------------------------------------------------------------------------------------------------------------
-- ���� ������ �߿��� ȸ�簡 �������̰�, ������ 1000�� �����̰ų� 3000�� �̻��� ���� ��ü ��ȸ
-- ������ �켱 ���� (�������� �ֿ켱����)
-- OR > AND > NOT > �񱳿����� > ��ȣ
SELECT * FROM SNACK WHERE S_COMPANY = '������' AND (S_PRICE <= 1000 OR S_PRICE >= 3000);	

SELECT * FROM SNACK WHERE S_COMPANY = '������' 
    INTERSECT
SELECT * FROM SNACK WHERE S_PRICE <= 1000 OR S_PRICE >= 3000;	
------------------------------------------------------------------------------------------------------------
-- GROUP BY : �׷����� ���� �����ؼ� �ϳ��� ����� ��Ÿ���� ��
-- ȸ�纰 ���� ��� ����, �ּ� ����, �ִ� ����
-- GROUP BY �ϱ� ���� �ְ�, �ּҰ�, ��հ� ������ �� -> ���� ������ ���
-- GROUP BY �� �Ŀ� ȸ�纰�� �׷��� ��� ���� ��Ÿ�� 
SELECT S_COMPANY, AVG(S_PRICE), MIN(S_PRICE), MAX(S_PRICE) FROM SNACK GROUP BY S_COMPANY;

-- ROLLUP ������
-- GROUP BY ROLLUP(�׷� ���)
-- �÷��� ���� �Ұ�(SUBTOTAL)�� ����� ��
-- GROUP BY ���� �÷��� ������ N�����, ROLLUP�� ���� ���� N+1��

-- ȸ�� �̸�, ȸ�纰 ���� �� ���� �հ�� ��� ���ڵ��� ���� �հ�
SELECT S_COMPANY, SUM(S_PRICE)
	FROM SNACK
	GROUP BY ROLLUP(S_COMPANY);

-- S_COMPANY�� NULL���̸� '��ü', �װ� �ƴϸ� S_COMPANY ��
SELECT NVL2(S_COMPANY, S_COMPANY, '��ü') S_COMPANY, SUM(S_PRICE)
	FROM SNACK
	GROUP BY ROLLUP(S_COMPANY);

-- DECODE(�÷���, ����, ���ǿ� �´� �����, ���ǿ� ���� ���� �� �����)
-- DECODE ���� : ���� �ڸ����� �񱳿����� (X), ��������� (O)
SELECT DECODE(S_COMPANY, NULL, '��ü', S_COMPANY) S_COMPANY, SUM(S_PRICE)
	FROM SNACK
	GROUP BY ROLLUP(S_COMPANY);
------------------------------------------------------------------------------------------------------------
-- HAVING : GROUP BY���� ���ؼ� ������ ��� �߿��ϴ� ���ǿ� �����ϴ� �ڷḸ ã���� �� �� ���
-- HAVING�� WHERE ��� ������ �̿��ؼ� ���ϴ� ���ǿ� �´� �����͸� �̾ƿ´ٴ� ������
-- HAVING : �׷��� ����� ����
--		VS
-- WHERE : ��ü�� ���� ����� ����
	
-- ȸ�纰 ���� ��� ������ 2000�� �̻��� ȸ���� �̸��� ���� ��� ������ ��ȸ
SELECT S_COMPANY, ROUND(AVG(S_PRICE), 1)
    FROM SNACK
    GROUP BY S_COMPANY
   	HAVING AVG(S_PRICE) >= 2000;
   	
-- ORDER BY : ���� ! �⺻���� �������� ASC, �������� ������ DESC
ORDER BY [���Ĵ�� ASC(��������)/DESC]

-- �Ե� �Ǵ� ���� ȸ���� ���� ��� ������ 1800�� �̻��� �� �� ȸ���� ��� ���� �������� ����
SELECT S_COMPANY, ROUND(AVG(S_PRICE), 1)
    FROM SNACK
    WHERE S_COMPANY IN ('�Ե�', '����')
    GROUP BY S_COMPANY
    HAVING AVG(S_PRICE) >= 1800 
    ORDER BY AVG(S_PRICE) DESC;
------------------------------------------------------------------------------------------------------------