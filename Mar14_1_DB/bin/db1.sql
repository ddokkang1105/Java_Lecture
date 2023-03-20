-- �л� ���̺� (�̸�, Ű, ������(EX: 1������ / 2������ / 3������)) �� ���� ���� !

-- �л� ������ 10�� ���� ��� !
CREATE TABLE MAR14_STUDENT (
	S_NO NUMBER(2) PRIMARY KEY,
    S_NAME VARCHAR2(10 CHAR) NOT NULL,
    S_HEIGHT NUMBER(4, 1) NOT NULL,
    S_CLASS VARCHAR2(10 CHAR) NOT NULL
);

CREATE SEQUENCE MAR14_STUDENT_SEQ;

INSERT INTO MAR14_STUDENT VALUES(MAR14_STUDENT_SEQ.NEXTVAL, '�����', 175.2, '1 ������');
INSERT INTO MAR14_STUDENT VALUES(MAR14_STUDENT_SEQ.NEXTVAL, '�輭��', 170.3, '2 ������');
INSERT INTO MAR14_STUDENT VALUES(MAR14_STUDENT_SEQ.NEXTVAL, '�̹���', 169.1, '3 ������');
INSERT INTO MAR14_STUDENT VALUES(MAR14_STUDENT_SEQ.NEXTVAL, '����ȣ', 165.5, '1 ������');
INSERT INTO MAR14_STUDENT VALUES(MAR14_STUDENT_SEQ.NEXTVAL, '������', 162.6, '1 ������');
INSERT INTO MAR14_STUDENT VALUES(MAR14_STUDENT_SEQ.NEXTVAL, '�ڰǿ�', 180.4, '2 ������');
INSERT INTO MAR14_STUDENT VALUES(MAR14_STUDENT_SEQ.NEXTVAL, '������', 186.5, '3 ������');
INSERT INTO MAR14_STUDENT VALUES(MAR14_STUDENT_SEQ.NEXTVAL, '�����', 174.2, '3 ������');
INSERT INTO MAR14_STUDENT VALUES(MAR14_STUDENT_SEQ.NEXTVAL, '������', 181.3, '2 ������');
INSERT INTO MAR14_STUDENT VALUES(MAR14_STUDENT_SEQ.NEXTVAL, '����ȯ', 174.7, '1 ������');
------------------------------------------------------------------------------------------------------------
-- WINDOW �Լ�
-- ��� �� ������ ���踦 ���� �����ϱ� ���� ���� �Լ�
-- ������ ���α׷��� �ϳ��� �������� ���� �ذ��� �� �ִ�.
-- ��ǥ������ �츮�� ���� ��� �����ռ�, �����Լ��� �ִ�
-- �׷��� �� WINDOW �Լ��� ����, �հ�, ��� ���� ������ �� ����

-- WINDOW �Լ��� ����
SELECT �÷���, �÷���, ���� �Լ�, ... ,
	OVER ( [PARTITION BY �÷�] [ORDER BY �÷�] [WINDOWING ��] )
	FROM ���̺��;
	
	-- OVER() : ORDER BY, GROUP BY ������ ��ü�� �� �ִ� �Լ�
	-- PARTITION BY : �÷��� �������� �׷�(��Ƽ��)�� ������
	-- ORDER BY : OVER�Լ� ������ ����
	-- WINDOWING : �� ������ ������ ����
		-- �ɼ�
		-- ROWS : ������ ���� (���� ��������)
		-- RANGE : ������ ���� (���� ������ �ִ� ���� ��������)
		-- BETWEEN ~ AND : ���۰� �� ��ġ�� ����
		-- UNBOUNDED PRECEDING : ������ġ�� ù��° ��
		-- UNBOUNDED FOLLOWING : ��������ġ�� ������ ��
		-- CURRENT ROW : ���� �����
		
-- RANK : �ߺ� ������ŭ ���� ���� ���� ���� ��Ŵ
SELECT S_NAME, S_CLASS, S_HEIGHT,
	RANK() OVER (ORDER BY S_HEIGHT DESC) HEIGHT_RANK,
	RANK() OVER (PARTITION BY S_CLASS ORDER BY S_HEIGHT DESC) IN_CLASS_RANK
				-- ������ ���� �׷��� ��� Ű ������ ��
FROM MAR14_STUDENT;

-- DENSE_RANK : �ߺ� ������ �����ص� ���������� ���� ���� ���� ǥ����
SELECT S_NAME, S_CLASS, S_HEIGHT,
	RANK() OVER (ORDER BY S_HEIGHT DESC) HEIGHT_RANK,		-- 2��, 2��, 4��
	DENSE_RANK() OVER (ORDER BY S_HEIGHT DESC) DENSE_RANK	-- 2��, 2��, 3��
FROM MAR14_STUDENT;

-- LAST_VALUE : ��Ƽ�ǿ��� ���� �������� ������ ��
SELECT S_CLASS, S_NAME, S_HEIGHT,
	-- �����庰�� �׷��� ������, �� �ȿ��� �л����� Ű ������������ ����
	LAST_VALUE(S_NAME) OVER(PARTITION BY S_CLASS ORDER BY S_HEIGHT DESC
	-- �� �׷쳻�� ó������ ������ �࿡�� �������� ������ �л��� �̸����� �ҷ����ڴ�
	ROWS BETWEEN UNBOUNDED PRECEDING AND UNBOUNDED FOLLOWING)
FROM MAR14_STUDENT;

-- LAG : ���� ���� ���� ������
SELECT S_CLASS, S_NAME, S_HEIGHT,
	-- ���� ���� S_HEIGHT ���� �����ðǵ�, �����庰�� �׷��� ������, Ű �������� ����
	-- ���࿡ ���� ���� Ű ���� ���� NULL���̸� '-'���� �ٲٰ�
	DECODE(LAG(S_HEIGHT) OVER(PARTITION BY S_CLASS ORDER BY S_HEIGHT), NULL, '-',
	-- ���� ���� Ű���� ������ �� ���� �ҷ����ڴ� !
	LAG(S_HEIGHT) OVER(PARTITION BY S_CLASS ORDER BY S_HEIGHT)) LAG_HEIGHT
FROM MAR14_STUDENT;

-- LEAD : ���� ���� ���� ������
SELECT S_CLASS, S_NAME, S_HEIGHT,
	-- ���� ���� S_HEIGHT ���� �����ðǵ�, �����庰�� �׷��� ������, Ű �������� ����
	-- ���� ���� ���� ��� NULL�̸� '-'���� �ٲٰ�
	DECODE(LEAD(S_HEIGHT) OVER(PARTITION BY S_CLASS ORDER BY S_HEIGHT), NULL, '-',
	-- ���� ���� Ű ���� ������ �� ���� �ҷ����ڴ�.
	LEAD(S_HEIGHT) OVER(PARTITION BY S_CLASS ORDER BY S_HEIGHT)) LEAD_HEIGHT
FROM MAR14_STUDENT;

-- NTILE : ����� ����ڰ� ������ �׷��� ���� ������ ���
-- Ű �������� �������� 5���� �׷����� ������
SELECT S_CLASS, S_NAME, S_HEIGHT,
    NTILE(5) OVER(ORDER BY S_HEIGHT) N_TILE
FROM MAR14_STUDENT;
------------------------------------------------------------------------------------------------------------